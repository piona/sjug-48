package piona.web3j.poe;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.gas.DefaultGasProvider;
import piona.web3j.Account;
import piona.web3j.EthConnect;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;
import java.time.ZoneId;

public class Check {
    public static void main(String[] args) throws Exception {
        Web3j web3j = EthConnect.build();

        Credentials credentials = Account.loadCredentials();

        DocumentRegistry documentRegistry =
                DocumentRegistry.load(
                        Deploy.DOCUMENT_REGISTRY_ADDRESS,
                        web3j, credentials, new DefaultGasProvider());

        System.out.println("DocumentRegistry at: " +
                documentRegistry.getContractAddress());

        BigInteger documentsCount = documentRegistry.getDocumentsCount().send();

        for (int i = 0; i < documentsCount.intValue(); i++) {
            BigInteger documentId = documentRegistry.documentsIds(BigInteger.valueOf(i)).send();
            Tuple2<BigInteger, BigInteger> document =
                    documentRegistry.documents(documentId).send();

            System.out.println(documentId +
                    " (" + Instant.ofEpochSecond(document.component2().longValueExact()).atZone(ZoneId.of("UTC+1")).toLocalDateTime() + ")" +
                    " -> " + document.component1().toString(16));
        }

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] documentHash = digest.digest(
                "Małopolskie lubi śląskie!".getBytes(StandardCharsets.UTF_8));

        System.out.println("Document hash: " + Register.toPositive(new BigInteger(documentHash), 32).toString(16));

        web3j.shutdown();
    }
}
