package piona.web3j;

import org.reactivestreams.Subscription;
import org.web3j.protocol.Web3j;

import java.time.Instant;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

public class Monitor {
    public static void main(String[] args) throws Exception {
        Web3j web3j = EthConnect.build();

        Subscription subscription = (Subscription) web3j.blockFlowable(false).subscribe(block -> {
            System.out.println("Mined block: " + block.getBlock().getNumber());
            System.out.println("Number of tx: " + block.getBlock().getTransactions().size());
            System.out.println("Time: " + Instant.ofEpochSecond(block.getBlock().getTimestamp().longValueExact()).atZone(ZoneId.of("UTC+1")).toLocalDateTime());
        });

        TimeUnit.MINUTES.sleep(1);

        subscription.cancel();

        web3j.shutdown();
    }
}
