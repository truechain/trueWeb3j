package com.trueweb3j.sample;

import com.trueweb3j.TrueWeb3jRequest;
import com.trueweb3j.common.AddressConstant;
import com.trueweb3j.common.Constant;
import com.trueweb3j.response.EtrueSendTransaction;
import com.trueweb3j.response.transaction.TrueRawTransaction;
import com.trueweb3j.response.transaction.TrueTransactionEncoder;
import com.trueweb3j.response.transaction.TrueTransactionManager;
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
    //发送者账户
    String fromPrivatekey = AddressConstant.fromPrivateKey;
    String fromAddress = AddressConstant.fromAddress;

    String paymentPrivateKey = AddressConstant.paymentPrivatekey;
    String paymentAddress = AddressConstant.paymentAddress;
    String to = AddressConstant.toAddress;


    public String sendPaymentTxWithFrom() {
        String fromSignedTxStr = null;

        TrueWeb3jRequest trueWeb3jRequest = new TrueWeb3jRequest(Constant.RPC_TESTNET_URL);
        TrueTransactionManager trueTransactionManager = new TrueTransactionManager(trueWeb3jRequest,
                Constant.CHAINID_TESTNET);

        Web3j web3jt = Web3j.build(new HttpService(Constant.RPC_TESTNET_URL));
        try {
            //get nonce of from address
            EthGetTransactionCount ethGetTransactionCount = web3jt
                    .ethGetTransactionCount(fromAddress, DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger nonce = ethGetTransactionCount.getTransactionCount();
            TrueRawTransaction trueRawTransaction = TrueRawTransaction.createTruePaymentTransaction(nonce, Constant.DEFAULT_GASPRICE,
                    Constant.DEFAULT_GASLIMIT, to, Constant.DEFAULT_VALUE, null, paymentAddress);
            fromSignedTxStr = trueTransactionManager.signWithFromPrivateKey(trueRawTransaction, fromPrivatekey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fromSignedTxStr;
    }

    public String sendPaymentTxWithSigned(String signedTxWithFrom) {
        String txHash = null;
        try {
            TrueWeb3jRequest trueWeb3jRequest = new TrueWeb3jRequest(Constant.RPC_TESTNET_URL);
            TrueTransactionManager trueTransactionManager = new TrueTransactionManager(trueWeb3jRequest,
                    Constant.CHAINID_TESTNET);

            //代付私钥
            EtrueSendTransaction etrueSendTransaction = trueTransactionManager.signWithPaymentAndSend(signedTxWithFrom, paymentPrivateKey);
            if (etrueSendTransaction != null && etrueSendTransaction.hasError()) {
                System.out.println("sendPaymentTransactionWithSigned error " + etrueSendTransaction.getError().getMessage());
            }
            txHash = etrueSendTransaction.getTrueTransactionHash();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return txHash;
    }

    public String sendPaymentTx() {
        String txHash = null;
        try {
            TrueWeb3jRequest trueWeb3jRequest = new TrueWeb3jRequest(Constant.RPC_TESTNET_URL);
            Web3j web3jt = Web3j.build(new HttpService("https://rpc.truescan.net/testnet"));


            //get nonce of from address
            EthGetTransactionCount ethGetTransactionCount = web3jt
                    .ethGetTransactionCount(fromAddress, DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger nonce = ethGetTransactionCount.getTransactionCount();

            //create trueRawTransaction
            TrueRawTransaction trueRawTransaction = TrueRawTransaction.createTruePaymentTransaction(nonce, Constant.DEFAULT_GASPRICE,
                    Constant.DEFAULT_GASLIMIT, to, Constant.DEFAULT_VALUE, null, paymentAddress);

            TrueTransactionManager trueTransactionManager = new TrueTransactionManager(trueWeb3jRequest,
                    Constant.CHAINID_TESTNET);
            EtrueSendTransaction etrueSendTransaction = trueTransactionManager.signWithFromPaymentAndSend(
                    trueRawTransaction, fromPrivatekey, paymentPrivateKey);
            if (etrueSendTransaction != null && etrueSendTransaction.hasError()) {
                System.out.println("sendPaymentTransactionWithSigned error " + etrueSendTransaction.getError().getMessage());
            }
            txHash = etrueSendTransaction.getTrueTransactionHash();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return txHash;
    }
}
