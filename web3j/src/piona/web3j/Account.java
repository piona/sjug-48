package piona.web3j;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

public class Account {
    public static Credentials loadCredentials() throws Exception {
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "",
                        "../eth/keystore/");

        return credentials;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Address: " + loadCredentials().getAddress());
    }
}
