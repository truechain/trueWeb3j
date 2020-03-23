package com.trueweb3j.sample;

import com.trueweb3j.TrueWeb3jRequest;
import com.trueweb3j.common.AddressConstant;
import com.trueweb3j.common.Constant;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class TrueWeb3jTestNet {

    public TrueWeb3jRequest trueWeb3jRequest = new TrueWeb3jRequest(Constant.RPC_TESTNET_URL);

    public Web3j web3j = Web3j.build(new HttpService(Constant.RPC_TESTNET_URL));

    public static int chainId = Constant.CHAINID_TESTNET;

    //发送者账户
    public static String fromPrivatekey = AddressConstant.fromPrivateKey;
    public static String fromAddress = AddressConstant.fromAddress;
    public static String toAddress = AddressConstant.toAddress;

    public static String paymentPrivateKey = AddressConstant.paymentPrivatekey;
    public static String paymentAddress = AddressConstant.paymentAddress;

}

