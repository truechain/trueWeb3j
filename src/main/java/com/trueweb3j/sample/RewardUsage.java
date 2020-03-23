package com.trueweb3j.sample;

import com.trueweb3j.TrueWeb3jRequest;
import com.trueweb3j.response.Reward.ChainRewardContent;
import com.trueweb3j.response.fast.FastBlock;
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


    public void getSnailRewardContent() {
        BigInteger snailNumber = new BigInteger("2");
        ChainRewardContent snailChainRewardContent = trueWeb3jRequest.getSnailRewardContent(snailNumber);
        logger.info("snailChainRewardContent=[{}]", snailChainRewardContent);
    }

    public void getAddressesSnailReward() {
        BigInteger snailNumber = new BigInteger("2");
        Map<String, BigInteger> addressSnailReward = trueWeb3jRequest.getAddressesSnailReward(snailNumber);
        logger.info("addressSnailReward=[{}]", addressSnailReward);
    }

}
