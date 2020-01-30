package piona.web3j;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthCoinbase;

public class Coinbase {
    public static void main(String[] args) throws Exception {
        Web3j web3j = EthConnect.build();

        EthCoinbase coinbase = web3j.ethCoinbase().send();

        System.out.println("Coinbase address: " +
                coinbase.getAddress());
        System.out.println("Coinbase balance: " +
                web3j.ethGetBalance(coinbase.getAddress(),
                        DefaultBlockParameterName.LATEST).send().getBalance());

        web3j.shutdown();
    }
}
