package piona.web3j.poe;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;
import piona.web3j.Account;
import piona.web3j.EthConnect;

public class Deploy {
    final public static String DOCUMENT_REGISTRY_ADDRESS =
            "0x";

    public static void main(String[] args) throws Exception {
        Web3j web3j = EthConnect.build();

        Credentials credentials = Account.loadCredentials();

        DocumentRegistry documentRegistry =
                DocumentRegistry.deploy(web3j, credentials,
                new DefaultGasProvider()).send();

        System.out.println("DocumentRegistry at: " +
                documentRegistry.getContractAddress());

        web3j.shutdown();
    }
}
