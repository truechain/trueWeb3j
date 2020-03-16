package trueweb3j;

import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.http.HttpService;
import trueweb3j.common.Constant;
import trueweb3j.response.BalanceChange;
import trueweb3j.response.EthBlock;
import trueweb3j.response.EtrueBalanceChange;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrueWeb3jRequest {
    public static Web3jService web3jService = null;

    private TrueWeb3jRequest() {

    }

    public TrueWeb3jRequest(String rpcUrl) {
        web3jService = new HttpService(rpcUrl);
    }

    public static Map<String, String> getSnailBalanceChange(BigInteger snailBlockNumber) {
        Map<String, String> addrWithBalance = new HashMap<String, String>();
        try {
            EtrueBalanceChange etrueBalanceChange = new Request<>(
                    Constant.SNAIL_REWARD_RPC,
                    Arrays.asList(DefaultBlockParameter.valueOf(snailBlockNumber).getValue()),
                    web3jService,
                    EtrueBalanceChange.class).send();
            BalanceChange balanceChange = etrueBalanceChange.getBalanceChange();
            if (balanceChange != null) {
                addrWithBalance = balanceChange.getAddrWithBalance();
                for (Map.Entry<String, String> entry : addrWithBalance.entrySet()) {
                    System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addrWithBalance;
    }

    public static EthBlock.Block getFastBlockByNumber(BigInteger fastBlockNumber, boolean returnFullTransactionObjects) {
        System.out.println("go into getFastBlockByNumber");
        EthBlock.Block fastBlock = null;
        try {
            EthBlock ethBlock = new Request<>(
                    Constant.GETBLOCK_BYNUMBER,
                    Arrays.asList(DefaultBlockParameter.valueOf(fastBlockNumber).getValue(), returnFullTransactionObjects),
                    web3jService,
                    EthBlock.class).send();
            fastBlock = ethBlock.getBlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fastBlock;
    }
}
