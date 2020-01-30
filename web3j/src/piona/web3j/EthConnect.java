package piona.web3j;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.ipc.UnixIpcService;

public class EthConnect {
    public static Web3j build() {
        return Web3j.build(
                new UnixIpcService("../eth/geth.ipc"));
    }

    public static void main(String[] args) {
        Web3j web3j = build();

        web3j.shutdown();
    }
}
