package piona.web3j;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;

public class EthTransfer {
    public static void main(String[] args) throws Exception {
        Web3j web3j = EthConnect.build();

        Credentials credentials = Account.loadCredentials();

        EthAccounts accounts = web3j.ethAccounts().sendAsync().get();

        System.out.println("Balance: " +
                web3j.ethGetBalance(accounts.getAccounts().get(1),
                        DefaultBlockParameterName.LATEST).send().getBalance());

        TransactionReceipt transactionReceipt = Transfer.sendFunds(web3j,
                credentials, accounts.getAccounts().get(1),
                BigDecimal.valueOf(1.0), Convert.Unit.ETHER).send();

        System.out.println("From: " + transactionReceipt.getFrom());
        System.out.println("To: " + transactionReceipt.getTo());
        System.out.println("Block: " + transactionReceipt.getBlockNumber());
        System.out.println("Gas used: " + transactionReceipt.getCumulativeGasUsed());

        System.out.println("Balance: " +
                web3j.ethGetBalance(accounts.getAccounts().get(1),
                        DefaultBlockParameterName.LATEST).send().getBalance());

        web3j.shutdown();
    }
}
