package com.trueweb3j.sample;

import com.trueweb3j.response.Reward.ChainRewardContent;
import com.trueweb3j.response.snail.SnailBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Map;

public class SnailBlockUsage extends TrueWeb3jTestNet {
    private static final Logger logger = LoggerFactory.getLogger(SnailBlockUsage.class);

    public void getSnailBlockByNumber() {
        BigInteger snailNumber = new BigInteger("100");
        SnailBlock snailBlock = trueWeb3jRequest.getSnailBlockByNumber(snailNumber, true);
        logger.info("snailBlock=[{}]", snailBlock);
    }

    public void getSnailBlockByHash() {
        String snailHash = "0x060e8090d3a2babe117eac6cf5be681850cbd4076f4fe465c8d626e051a49dc9";
        SnailBlock snailBlock = trueWeb3jRequest.getSnailBlockByHash(snailHash, true);
        logger.info("snailBlock=[{}]", snailBlock);
    }

    public void getSnailHashByNumber() {
        BigInteger snailNumber = new BigInteger("100");
        String snailHash = trueWeb3jRequest.getSnailHashByNumber(snailNumber);
        logger.info("snailHash=[{}]", snailHash);
    }

    public void getCurrentSnailNumber() {
        BigInteger currentSnailNumber = trueWeb3jRequest.getCurrentSnailNumber();
        logger.info("currentSnailNumber=[{}]", currentSnailNumber);
    }

    public void getSnailBalanceChange() {
        BigInteger snailNumber = new BigInteger("100");
        Map<String, String> addrWithBalance = trueWeb3jRequest.getSnailBalanceChange(snailNumber);
        logger.info("addrWithBalance=[{}]", addrWithBalance.toString());
    }

    public void getSnailRewardContent() {
        BigInteger snailNumber = new BigInteger("100");
        ChainRewardContent chainRewardContent = trueWeb3jRequest.getSnailRewardContent(snailNumber);
        logger.info("chainRewardContent=[{}]", chainRewardContent);
    }
}
