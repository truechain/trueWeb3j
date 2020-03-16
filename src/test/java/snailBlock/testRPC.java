package snailBlock;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

public class testRPC {

    //代付者签名交易实例
    public static void main(String[] args) {
        try {
            String url = "http://47.108.131.16:8545";

            Web3j web3jt = Web3j.build(new HttpService(url));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
