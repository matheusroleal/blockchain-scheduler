package br.pucrio.inf.lac.Blockchain.smartcontract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class StoreData extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506108c1806100206000396000f3fe6080604052600436106100345760003560e01c806319a2887d146100395780637a64f113146100b6578063ae55c8881461015e575b600080fd5b610041610211565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561007b578181015183820152602001610063565b50505050905090810190601f1680156100a85780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61015c600480360360208110156100cc57600080fd5b8101906020810181356401000000008111156100e757600080fd5b8201836020820111156100f957600080fd5b8035906020019184600183028401116401000000008311171561011b57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506102a5945050505050565b005b34801561016a57600080fd5b506100416004803603602081101561018157600080fd5b81019060208101813564010000000081111561019c57600080fd5b8201836020820111156101ae57600080fd5b803590602001918460018302840111640100000000831117156101d057600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506104bb945050505050565b60028054604080516020601f600019610100600187161502019094168590049384018190048102820181019092528281526060939092909183018282801561029a5780601f1061026f5761010080835404028352916020019161029a565b820191906000526020600020905b81548152906001019060200180831161027d57829003601f168201915b505050505090505b90565b60606102b033610656565b90506060816102bd6106d7565b6040516020018083805190602001908083835b602083106102ef5780518252601f1990920191602091820191016102d0565b51815160209384036101000a60001901801990921691161790529201938452506040805180850381529382019081905283519395506001945060009386935090918291908401908083835b602083106103595780518252601f19909201916020918201910161033a565b51815160209384036101000a60001901801990921691161790529201948552506040519384900381018420805460ff191695151595909517909455505082518592600192859290918291908401908083835b602083106103ca5780518252601f1990920191602091820191016103ab565b51815160209384036101000a6000190180199092169116179052920194855250604051938490038101909320845161040b95919491909101925090506107d2565b5060028054604080516020601f600019610100600187161502019094168590049384018190048102820181019092528281526104a193909290918301828280156104965780601f1061046b57610100808354040283529160200191610496565b820191906000526020600020905b81548152906001019060200180831161047957829003601f168201915b5050505050826106db565b80516104b5916002916020909101906107d2565b50505050565b60606000826040518082805190602001908083835b602083106104ef5780518252601f1990920191602091820191016104d0565b51815160001960209485036101000a0190811690199190911617905292019485525060405193849003019092205460ff161515600114915061056490505760405162461bcd60e51b815260040180806020018281038252602281526020018061086b6022913960400191505060405180910390fd5b6001826040518082805190602001908083835b602083106105965780518252601f199092019160209182019101610577565b518151600019602094850361010090810a820192831692199390931691909117909252949092019687526040805197889003820188208054601f600260018316159098029095011695909504928301829004820288018201905281875292945092505083018282801561064a5780601f1061061f5761010080835404028352916020019161064a565b820191906000526020600020905b81548152906001019060200180831161062d57829003601f168201915b50505050509050919050565b60408051601480825281830190925260609182919060208201818038833901905050905060005b60148110156106d0578060130360080260020a846001600160a01b0316816106a157fe5b0460f81b8282815181106106b157fe5b60200101906001600160f81b031916908160001a90535060010161067d565b5092915050565b4290565b6060808390506060839050606081518351016040519080825280601f01601f191660200182016040528015610717576020820181803883390190505b509050806000805b85518110156107705785818151811061073457fe5b602001015160f81c60f81b83838060010194508151811061075157fe5b60200101906001600160f81b031916908160001a90535060010161071f565b5060005b84518110156107c55784818151811061078957fe5b602001015160f81c60f81b8383806001019450815181106107a657fe5b60200101906001600160f81b031916908160001a905350600101610774565b5090979650505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061081357805160ff1916838001178555610840565b82800160010185558215610840579182015b82811115610840578251825591602001919060010190610825565b5061084c929150610850565b5090565b6102a291905b8082111561084c576000815560010161085656fe4e6f204461746120466f756e6420466f722054686973205472616e73616374696f6ea265627a7a72315820a3cd64481bc42b1456e171915838f7e1b129356337465dbe9de1fe623a9aa3a964736f6c634300050c0032";

    public static final String FUNC_GETDATA = "getData";

    public static final String FUNC_GETTRANSCTIONS = "getTransctions";

    public static final String FUNC_SETTRANSACTION = "setTransaction";

    @Deprecated
    protected StoreData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected StoreData(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected StoreData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected StoreData(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> getData(String tran_id) {
        final Function function = new Function(
                FUNC_GETDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(tran_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> getTransctions(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_GETTRANSCTIONS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> setTransaction(String data_to_send, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SETTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(data_to_send)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    @Deprecated
    public static StoreData load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new StoreData(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static StoreData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new StoreData(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static StoreData load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new StoreData(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static StoreData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new StoreData(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<StoreData> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(StoreData.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<StoreData> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(StoreData.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<StoreData> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(StoreData.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<StoreData> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(StoreData.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
