package ethereum.javaethereum.wrapper;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
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
 * <p>Generated with web3j version 1.4.2.
 */
@SuppressWarnings("rawtypes")
public class DevFaucet extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b506040516108a53803806108a583398101604081905261002f916101a4565b61003833610138565b600380546001600160a01b0384166001600160a01b0319918216811790925560058054821683179055600680549091168217905560408051638da5cb5b60e01b81529051339291638da5cb5b9160048083019260209291908290030181865afa1580156100a9573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906100cd91906101d0565b6001600160a01b03161461011c5760405162461bcd60e51b81526020600482015260126024820152713737ba1037bbb732b91037b3103a37b5b2b760711b604482015260640160405180910390fd5b600455506000805460ff60a01b1916600160a01b1790556101f2565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b80516001600160a01b038116811461019f57600080fd5b919050565b600080604083850312156101b757600080fd5b6101c083610188565b9150602083015190509250929050565b6000602082840312156101e257600080fd5b6101eb82610188565b9392505050565b6106a4806102016000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c8063a933831f11610066578063a933831f1461013c578063b69ef8a814610144578063e4fc6b6d1461014d578063f2fde38b14610155578063fc0c546a1461016857600080fd5b80634bf365df146100a3578063582fa4b5146100cc578063715018a6146100fa5780638da5cb5b146101045780639d76ea5814610129575b600080fd5b6000546100b790600160a01b900460ff1681565b60405190151581526020015b60405180910390f35b6100ec6100da3660046105c1565b60016020526000908152604090205481565b6040519081526020016100c3565b61010261017b565b005b6000546001600160a01b03165b6040516001600160a01b0390911681526020016100c3565b600354610111906001600160a01b031681565b61010261018f565b6100ec60025481565b6101026101b8565b6101026101633660046105c1565b61049e565b600554610111906001600160a01b031681565b610183610517565b61018d6000610571565b565b610197610517565b6000805460ff60a01b198116600160a01b9182900460ff1615909102179055565b600054600160a01b900460ff16151560011461021b5760405162461bcd60e51b815260206004820152601860248201527f756e61626c6520746f206d696e74207269676874206e6f77000000000000000060448201526064015b60405180910390fd5b6005546040516370a0823160e01b81523060048201526001600160a01b03909116906370a0823190602401602060405180830381865afa158015610263573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061028791906105f1565b600255600454336000908152600160205260409020546102a79190610620565b4210156103025760405162461bcd60e51b815260206004820152602360248201527f43616e6e6f74206d696e74207965742c207374696c6c206f6e20636f6f6c646f6044820152623bb71760e91b6064820152608401610212565b336103445760405162461bcd60e51b8152602060048201526012602482015271061646472657373206e6f74206265203078360741b6044820152606401610212565b60055460405163095ea7b360e01b8152336004820152683635c9adc5dea0000060248201819052916001600160a01b03169063095ea7b3906044016020604051808303816000875af115801561039e573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906103c29190610639565b5060055460405163a9059cbb60e01b8152336004820152602481018390526001600160a01b039091169063a9059cbb906044016020604051808303816000875af1158015610414573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906104389190610639565b50806002600082825461044b919061065b565b909155505033600081815260016020908152604091829020429055815192835282018390527f50febc49bead4837d411278852c281f9e521d4aee3ef162aabf9f4527bd7941d910160405180910390a150565b6104a6610517565b6001600160a01b03811661050b5760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b6064820152608401610212565b61051481610571565b50565b6000546001600160a01b0316331461018d5760405162461bcd60e51b815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65726044820152606401610212565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b6000602082840312156105d357600080fd5b81356001600160a01b03811681146105ea57600080fd5b9392505050565b60006020828403121561060357600080fd5b5051919050565b634e487b7160e01b600052601160045260246000fd5b808201808211156106335761063361060a565b92915050565b60006020828403121561064b57600080fd5b815180151581146105ea57600080fd5b818103818111156106335761063361060a56fea2646970667358221220ee31485f4c8ddb210e6f284e6a65b75cdbfc531f8d58cce8c8d553a70b8cc79e64736f6c63430008130033";

    public static final String FUNC_BALANCE = "balance";

    public static final String FUNC_MINTABLE = "mintable";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_TIMESTAMPOFLASTMINT = "timestampOfLastMint";

    public static final String FUNC_TOKEN = "token";

    public static final String FUNC_TOKENADDRESS = "tokenAddress";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_DISTRIBUTE = "distribute";

    public static final String FUNC_TOGGLEFAUCETMINTABLE = "toggleFaucetMintable";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event SUPPLYCHANGE_EVENT = new Event("SupplyChange", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1684630313128", "0xB51CDE7163f8198eA95873c9FaE061479aD0e970");
        _addresses.put("1684552462238", "0xA90ceE8570f1035Abd399B23243e3392C03b8e79");
        _addresses.put("1684634015752", "0x11f1bA109B43a33F935A056D1e31616da0BEa15F");
        _addresses.put("1683813513105", "0xcAB38331652a3B3281FF3aCaAcB3aAd83AF4D1FE");
        _addresses.put("11155111", "0xf8688B7DbDD2EBcd4d126910826789647f6d38fD");
    }

    @Deprecated
    protected DevFaucet(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DevFaucet(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DevFaucet(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DevFaucet(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public static List<SupplyChangeEventResponse> getSupplyChangeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SUPPLYCHANGE_EVENT, transactionReceipt);
        ArrayList<SupplyChangeEventResponse> responses = new ArrayList<SupplyChangeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SupplyChangeEventResponse typedResponse = new SupplyChangeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.mintedToAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SupplyChangeEventResponse> supplyChangeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SupplyChangeEventResponse>() {
            @Override
            public SupplyChangeEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SUPPLYCHANGE_EVENT, log);
                SupplyChangeEventResponse typedResponse = new SupplyChangeEventResponse();
                typedResponse.log = log;
                typedResponse.mintedToAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SupplyChangeEventResponse> supplyChangeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SUPPLYCHANGE_EVENT));
        return supplyChangeEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> balance() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> mintable() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MINTABLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> timestampOfLastMint(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TIMESTAMPOFLASTMINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> token() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> tokenAddress() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOKENADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> distribute() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DISTRIBUTE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> toggleFaucetMintable() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TOGGLEFAUCETMINTABLE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static DevFaucet load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DevFaucet(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DevFaucet load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DevFaucet(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DevFaucet load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DevFaucet(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DevFaucet load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DevFaucet(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DevFaucet> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _tokenAddress, BigInteger mintTimer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_tokenAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(mintTimer)));
        return deployRemoteCall(DevFaucet.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<DevFaucet> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _tokenAddress, BigInteger mintTimer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_tokenAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(mintTimer)));
        return deployRemoteCall(DevFaucet.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DevFaucet> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _tokenAddress, BigInteger mintTimer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_tokenAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(mintTimer)));
        return deployRemoteCall(DevFaucet.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DevFaucet> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _tokenAddress, BigInteger mintTimer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_tokenAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(mintTimer)));
        return deployRemoteCall(DevFaucet.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class SupplyChangeEventResponse extends BaseEventResponse {
        public String mintedToAddress;

        public BigInteger amount;
    }
}
