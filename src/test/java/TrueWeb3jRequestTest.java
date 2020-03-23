import com.trueweb3j.TrueWeb3jRequest;
import com.trueweb3j.common.AddressConstant;
import com.trueweb3j.common.Constant;
import com.trueweb3j.response.fast.FastBlock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

public class TrueWeb3jRequestTest {

    public TrueWeb3jRequest trueWeb3jRequest = null;

    public Web3j web3j = null;

    //发送者账户
    String fromPrivatekey = AddressConstant.fromPrivateKey;
    String fromAddress = AddressConstant.fromAddress;
    String to = AddressConstant.toAddress;

    String paymentPrivateKey = AddressConstant.paymentPrivatekey;
    String paymentAddress = AddressConstant.paymentAddress;

    @Before
    public void init() {
        trueWeb3jRequest = new TrueWeb3jRequest(Constant.RPC_TESTNET_URL);
        web3j = Web3j.build(new HttpService(Constant.RPC_TESTNET_URL));
    }

}

