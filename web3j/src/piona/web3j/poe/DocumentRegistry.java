package piona.web3j.poe;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.14.
 */
@SuppressWarnings("rawtypes")
public class DocumentRegistry extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610332806100206000396000f30060806040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630b4ad251146100725780630bcf963b146100b75780634d32a117146100e25780635cb0fc6814610123578063c2ed2b051461015a575b600080fd5b34801561007e57600080fd5b5061009d600480360381019080803590602001909291905050506101a2565b604051808215151515815260200191505060405180910390f35b3480156100c357600080fd5b506100cc6101c5565b6040518082815260200191505060405180910390f35b3480156100ee57600080fd5b5061010d600480360381019080803590602001909291905050506101d1565b6040518082815260200191505060405180910390f35b34801561012f57600080fd5b5061015860048036038101908080359060200190929190803590602001909291905050506101f4565b005b34801561016657600080fd5b50610185600480360381019080803590602001909291905050506102e2565b604051808381526020018281526020019250505060405180910390f35b600080600160008481526020019081526020016000206001015414159050919050565b60008080549050905090565b6000818154811015156101e057fe5b906000526020600020016000915090505481565b6101fd826101a2565b15151561020957600080fd5b60008290806001815401808255809150509060018203906000526020600020016000909192909190915055508060016000848152602001908152602001600020600001819055504260016000848152602001908152602001600020600101819055507f9d7d5a35ffea9b5ba4d5f2ac69de4b04c405fd15f7675a66c6e047b06f1525ca338383604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001935050505060405180910390a15050565b600160205280600052604060002060009150905080600001549080600101549050825600a165627a7a723058207e6d1cd4acfcf66df61f9000e588f99c8b7abafa23303f2e0d1bb83fec4299e10029";

    public static final String FUNC_ISDOCUMENTEXISTS = "isDocumentExists";

    public static final String FUNC_GETDOCUMENTSCOUNT = "getDocumentsCount";

    public static final String FUNC_DOCUMENTSIDS = "documentsIds";

    public static final String FUNC_REGISTERDOCUMENT = "registerDocument";

    public static final String FUNC_DOCUMENTS = "documents";

    public static final Event DOCUMENTREGISTRATION_EVENT = new Event("DocumentRegistration", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected DocumentRegistry(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DocumentRegistry(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DocumentRegistry(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DocumentRegistry(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> isDocumentExists(BigInteger _id) {
        final Function function = new Function(FUNC_ISDOCUMENTEXISTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> getDocumentsCount() {
        final Function function = new Function(FUNC_GETDOCUMENTSCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> documentsIds(BigInteger param0) {
        final Function function = new Function(FUNC_DOCUMENTSIDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> registerDocument(BigInteger _id, BigInteger _hash) {
        final Function function = new Function(
                FUNC_REGISTERDOCUMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id), 
                new org.web3j.abi.datatypes.generated.Uint256(_hash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple2<BigInteger, BigInteger>> documents(BigInteger param0) {
        final Function function = new Function(FUNC_DOCUMENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<BigInteger, BigInteger>>(function,
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public List<DocumentRegistrationEventResponse> getDocumentRegistrationEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DOCUMENTREGISTRATION_EVENT, transactionReceipt);
        ArrayList<DocumentRegistrationEventResponse> responses = new ArrayList<DocumentRegistrationEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DocumentRegistrationEventResponse typedResponse = new DocumentRegistrationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._who = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._id = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._hash = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DocumentRegistrationEventResponse> documentRegistrationEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, DocumentRegistrationEventResponse>() {
            @Override
            public DocumentRegistrationEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DOCUMENTREGISTRATION_EVENT, log);
                DocumentRegistrationEventResponse typedResponse = new DocumentRegistrationEventResponse();
                typedResponse.log = log;
                typedResponse._who = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._id = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._hash = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DocumentRegistrationEventResponse> documentRegistrationEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DOCUMENTREGISTRATION_EVENT));
        return documentRegistrationEventFlowable(filter);
    }

    @Deprecated
    public static DocumentRegistry load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DocumentRegistry(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DocumentRegistry load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DocumentRegistry(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DocumentRegistry load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DocumentRegistry(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DocumentRegistry load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DocumentRegistry(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DocumentRegistry> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DocumentRegistry.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DocumentRegistry> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DocumentRegistry.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DocumentRegistry> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DocumentRegistry.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DocumentRegistry> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DocumentRegistry.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class DocumentRegistrationEventResponse extends BaseEventResponse {
        public String _who;

        public BigInteger _id;

        public BigInteger _hash;
    }
}
