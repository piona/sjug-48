package piona.web3j.poe;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;
import piona.web3j.Account;
import piona.web3j.EthConnect;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Register {
    public static BigInteger toPositive(BigInteger n, int size) {
        return n.andNot(BigInteger.valueOf(-1).shiftLeft(size * 8));
    }

    public static void main(String[] args) throws Exception {
        Web3j web3j = EthConnect.build();

        Credentials credentials = Account.loadCredentials();

        DocumentRegistry documentRegistry =
                DocumentRegistry.load(
                        Deploy.DOCUMENT_REGISTRY_ADDRESS,
                        web3j, credentials, new DefaultGasProvider());

        System.out.println("DocumentRegistry at: " +
                documentRegistry.getContractAddress());

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] documentHash = digest.digest(
                "Małopolskie lubi śląskie!".getBytes(StandardCharsets.UTF_8));

        String gas = documentRegistry.registerDocument(
                BigInteger.valueOf(1),
                toPositive(new BigInteger(documentHash), 32)).send().getGasUsedRaw();

        System.out.println("Gas used: " + gas);

        web3j.shutdown();
    }
}
