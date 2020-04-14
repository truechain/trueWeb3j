package com.trueweb3j.sample;

import com.trueweb3j.TrueWeb3jRequest;
import com.trueweb3j.response.Reward.ChainRewardContent;
import com.trueweb3j.response.fast.FastBlock;
import com.trueweb3j.response.snail.SnailRewardContenet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Map;

public class RewardUsage extends TrueWeb3jTestNet {
    private static final Logger logger = LoggerFactory.getLogger(RewardUsage.class);

    /**
     * get snail reward address and the balance of the address
     */
    public void getSnailBalanceChange() {
        BigInteger snailNumber = new BigInteger("2");
        Map<String, String> addrWithBalance = trueWeb3jRequest.getSnailBalanceChange(snailNumber);
        logger.info("addrWithBalance=[{}]", addrWithBalance);
    }


    /**
     * get snailReward content  by snailNumber
     * call etrue_getChainRewardContent by empty address
     */
    public void getSnailRewardContent() {
        BigInteger snailNumber = new BigInteger("55000");
        ChainRewardContent snailChainRewardContent = trueWeb3jRequest.getSnailRewardContent(snailNumber);
        System.out.println("snailChainRewardContent=" + snailChainRewardContent.toString());
    }

    public void getSnailRewardContent_Old() {
        BigInteger snailNumber = new BigInteger("55000");
        SnailRewardContenet snailRewardContenet = trueWeb3jRequest.getSnailRewardContent_Old(snailNumber);
        System.out.println("snailRewardContenet=" + snailRewardContenet.toString());
    }


    public void getAddressesSnailReward() {
        BigInteger snailNumber = new BigInteger("2");
        Map<String, BigInteger> addressSnailReward = trueWeb3jRequest.getAddressesSnailReward(snailNumber);
        logger.info("addressSnailReward=[{}]", addressSnailReward);
    }

}
