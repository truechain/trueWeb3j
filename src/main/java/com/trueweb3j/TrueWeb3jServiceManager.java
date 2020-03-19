package com.trueweb3j;

import org.web3j.protocol.Web3jService;
import org.web3j.protocol.http.HttpService;

public class TrueWeb3jServiceManager {

    public static Web3jService web3jService = null;

    private TrueWeb3jServiceManager() {

    }

    public TrueWeb3jServiceManager(String rpcUrl) {
        web3jService = new HttpService(rpcUrl);
    }
}
