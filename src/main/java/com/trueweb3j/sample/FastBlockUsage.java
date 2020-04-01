package com.trueweb3j.sample;

import com.trueweb3j.response.fast.FastBlock;
import com.trueweb3j.response.snail.BalanceChange;
import com.trueweb3j.response.snail.FastBalanceChange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class FastBlockUsage extends TrueWeb3jTestNet {
    private static final Logger logger = LoggerFactory.getLogger(FastBlockUsage.class);

    public void getFastBlockByNumber() {
        BigInteger fastNumber = new BigInteger("4962524");
        FastBlock fastBlock = trueWeb3jRequest.getFastBlockByNumber(fastNumber, true);
        logger.info("fast block=[{}]", fastBlock.toString());
    }

    public void getFastBlockByHash() {
        String fastHash = "0x3d85286e8492eb22911ae004de6e29745f8eb68cf8ea740f4301587bc2e131a4";
        FastBlock fastBlock = trueWeb3jRequest.getFastBlockByHash(fastHash, true);
        logger.info("fast block=[{}]", fastBlock);
    }

    public void getCurrentFastNumber() {
        BigInteger currentFastNumber = trueWeb3jRequest.getCurrentFastNumber();
        logger.info("current fast number=[{}]", currentFastNumber);
    }

    /**
     * useage:
     * get balance with address which has changed
     */
    public void getStateChangeByFastNumber() {
        BigInteger fastNumber = new BigInteger("1011");
        FastBalanceChange fastBalanceChange = trueWeb3jRequest.getStateChangeByFastNumber(fastNumber);
//        logger.info("balanceChange=[{}]", balanceChange);
        System.out.println("balanceChange="+fastBalanceChange.toString());
    }

}
