package com.trueweb3j;

import com.trueweb3j.common.Constant;
import com.trueweb3j.response.EthBlock;

import java.math.BigInteger;

public class UseExmaple {

    public static void main(String[] args) {
        TrueWeb3jRequest trueWeb3jRequest = new TrueWeb3jRequest(Constant.RPC_TESTNET_URL);
        trueWeb3jRequest.getSnailBalanceChange(new BigInteger("2"));
        EthBlock.Block fastBlock = trueWeb3jRequest.getFastBlockByNumber(new BigInteger("2"), false);
        System.out.println("snailNumber=" + fastBlock.getSnailNumberFinal());

        EthBlock.Block fastBlock2 = trueWeb3jRequest.getFastBlockByNumber(new BigInteger("2311"), false);
        System.out.println("snailNumber=" + fastBlock2.getSnailNumberFinal());
    }

}
