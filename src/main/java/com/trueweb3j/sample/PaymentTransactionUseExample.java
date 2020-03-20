package com.trueweb3j.sample;

import com.trueweb3j.TrueWeb3jRequest;
import com.trueweb3j.common.Constant;
import com.trueweb3j.response.EtrueSendTransaction;
import com.trueweb3j.response.transaction.TrueRawTransaction;
import com.trueweb3j.response.transaction.TrueTransactionEncoder;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Hash;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.math.BigInteger;

public class PaymentTransactionUseExample {

    public void sendPaymentTransaction() {
        try {
            TrueWeb3jRequest trueWeb3jRequest = new TrueWeb3jRequest(Constant.RPC_MAINNET_URL);
            Web3j web3jt = Web3j.build(new HttpService("https://rpc.truescan.net/testnet"));
            //发送者账户
            String fromAddress = "0xa23Bd55b0f3559a92823b5b50b5f02ed6E58364B";
            Credentials credentials_from = Credentials.create("0xA7EDEABF6E01370721CBA7B0FF885C0B05AEF818CE93869A445FE0EA185F5662");

            String payment = "0xa23Bd55b0f3559a92823b5b50b5f02ed6E58364B";
            Credentials credentials_payment = Credentials.create("0xA7EDEABF6E01370721CBA7B0FF885C0B05AEF818CE93869A445FE0EA185F5662");

            String to = "0x04d2252a3e0ca7c2aa81247ca33060855a34a808";

            BigInteger value = Convert.toWei("1", Convert.Unit.ETHER).toBigInteger();
            //发送者的扣费数量 可为空
            BigInteger fee = Convert.toWei("1", Convert.Unit.ETHER).toBigInteger();
            BigInteger gaslimit = Convert.toWei("210000", Convert.Unit.WEI).toBigInteger();
            BigInteger gasprice = Convert.toWei("1", Convert.Unit.GWEI).toBigInteger();

            EthGetTransactionCount ethGetTransactionCount = web3jt
                    .ethGetTransactionCount(fromAddress, DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger nonce = ethGetTransactionCount.getTransactionCount();
            long chainId = 18928;

            TrueRawTransaction trueRawTransaction = TrueRawTransaction.createTransaction(
                    nonce,
                    gasprice,
                    gaslimit,
                    to,
                    value,
                    "",
                    fee,
                    payment);

            byte[] signedMessage = TrueTransactionEncoder.signMessage_fromAndPayment(trueRawTransaction, chainId, credentials_from, credentials_payment);
            String hexValue = Numeric.toHexString(signedMessage);

            EtrueSendTransaction etrueSendTransaction = trueWeb3jRequest.etrueSendRawTransaction(hexValue);
            if (etrueSendTransaction != null && !etrueSendTransaction.hasError()) {
                String txHashLocal = Hash.sha3(hexValue);
                String txHashRemote = etrueSendTransaction.getTrueTransactionHash();

                System.out.println(" txHashLocal--->" + txHashLocal);
                System.out.println("txHashRemote--->" + txHashRemote);
                //......
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
