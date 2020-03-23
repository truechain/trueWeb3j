package com.trueweb3j.sample;

import com.trueweb3j.TrueWeb3jRequest;
import com.trueweb3j.common.AddressConstant;
import com.trueweb3j.common.Constant;
import com.trueweb3j.response.Reward.ChainRewardContent;
import com.trueweb3j.response.Reward.RewardInfo;
import com.trueweb3j.response.Reward.SARewardInfos;
import com.trueweb3j.response.fast.FastBlock;
import com.trueweb3j.response.staking.AllStakingAccount;
import com.trueweb3j.response.staking.StakingAccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.core.DefaultBlockParameter;

import java.math.BigInteger;
import java.util.List;

public class StakingUsage extends TrueWeb3jTestNet {
    private static final Logger logger = LoggerFactory.getLogger(StakingUsage.class);

    public void getChainRewardContentByAddress() {
        BigInteger snailNumber = new BigInteger("39748");
        String stakingAddress = "0x01504af31ce7c2e922a4d44f4c46349ff6bc589c";

        ChainRewardContent chainRewardContent = trueWeb3jRequest.getChainRewardContent(
                snailNumber, stakingAddress);
        logger.info("chainRewardContent=[{}]", chainRewardContent);

        BigInteger receviedSnailNumber = chainRewardContent.getNumber();
        BigInteger timeStamp = chainRewardContent.getTime();
        logger.info("snailNumber=[{}],receviedSnailNumber=[{}]", receviedSnailNumber, timeStamp);

        //gets the income of all the entrusted nodes under the pledge node
        List<RewardInfo> rewardInfos = chainRewardContent.getStakingReward();
        for (RewardInfo rewardInfo : rewardInfos) {
            logger.info(rewardInfo.toString());
        }
    }

    public void getChainRewardContent() {
        BigInteger snailNumber = new BigInteger("39748");
        String stakingAddress = AddressConstant.EMPTY_ADDRESS;
        ChainRewardContent chainRewardContent = trueWeb3jRequest.getChainRewardContent(
                snailNumber, stakingAddress);
        if (chainRewardContent == null) {
            logger.error("chainRewardContent is null");
        }
        logger.info("chainRewardContent=[{}]", chainRewardContent);

        BigInteger receviedSnailNumber = chainRewardContent.getNumber();
        BigInteger timeStamp = chainRewardContent.getTime();
        logger.info("snailNumber=[{}],receviedSnailNumber=[{}]", receviedSnailNumber, timeStamp);

        //get all pledge nodes reward
        List<SARewardInfos> saRewardInfoList = chainRewardContent.getCommitteReward();
        if (saRewardInfoList != null) {
            for (SARewardInfos saRewardInfo : saRewardInfoList) {
                List<RewardInfo> rewardInfoList = saRewardInfo.getItems();
                for (RewardInfo rewardInfo : rewardInfoList) {
                    logger.info("rewardInfo={}", rewardInfo);
                }
            }
        }

        //get snail block miner reward
        RewardInfo minerRewardInfo = chainRewardContent.getBlockminer();
        //get fruits miner reward
        List<RewardInfo> fruitRewardInfos = chainRewardContent.getFruitminer();
        //get foundation reward
        RewardInfo foundationRewardInfo = chainRewardContent.getFoundationReward();
    }


    /**
     * get pledge infos of all nodes and addresses
     */
    public void getAllStakingAccount() {
        BigInteger snailNumber = new BigInteger("2");
        AllStakingAccount allStakingAccount = trueWeb3jRequest.getAllStakingAccount(
                DefaultBlockParameter.valueOf(snailNumber));
        logger.info("allStakingAccount=[{}]", allStakingAccount);

    }

    /**
     * get pledge infos of all nodes and addresses
     */
    public void getStakingAccountInfo() {
        BigInteger snailNumber = new BigInteger("2");
        String stakingAddress = "0x400abb159dc64f7d8b13fce3d0fd5c6a4559cb80";
        BigInteger epochid = new BigInteger("10");
        StakingAccountInfo stakingAccountInfo = trueWeb3jRequest.getStakingAccountInfo(
                epochid, stakingAddress);
        logger.info("stakingAccountInfo=[{}]", stakingAccountInfo);

    }
}
