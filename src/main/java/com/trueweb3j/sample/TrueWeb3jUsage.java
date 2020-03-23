package com.trueweb3j.sample;

import com.trueweb3j.TrueWeb3jRequest;
import com.trueweb3j.common.AddressConstant;
import com.trueweb3j.common.Constant;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class TrueWeb3jUsage {

    public TrueWeb3jRequest trueWeb3jRequest = new TrueWeb3jRequest(Constant.RPC_TESTNET_URL);

    public Web3j web3j = Web3j.build(new HttpService(Constant.RPC_TESTNET_URL));


    //发送者账户
    String fromPrivatekey = AddressConstant.fromPrivateKey;
    String fromAddress = AddressConstant.fromAddress;
    String to = AddressConstant.toAddress;

    String paymentPrivateKey = AddressConstant.paymentPrivatekey;
    String paymentAddress = AddressConstant.paymentAddress;

}

