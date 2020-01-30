package piona.web3j.poe;

import org.reactivestreams.Subscription;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;
import piona.web3j.Account;
import piona.web3j.EthConnect;

import java.util.concurrent.TimeUnit;

public class Events {
    public static void main(String[] args) throws Exception {
        Web3j web3j = EthConnect.build();

        Credentials credentials = Account.loadCredentials();

        DocumentRegistry documentRegistry =
                DocumentRegistry.load(
                        Deploy.DOCUMENT_REGISTRY_ADDRESS,
                        web3j, credentials, new DefaultGasProvider());

        Subscription subscription = (Subscription) documentRegistry.
                documentRegistrationEventFlowable(null).subscribe(event -> {
                    System.out.println(event._who + " registered " +
                        event._id.intValue() + " -> " +
                        event._hash.toString(16));
        });

        TimeUnit.MINUTES.sleep(3);

        subscription.cancel();

        web3j.shutdown();
    }
}
