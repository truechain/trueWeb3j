package com.trueweb3j;

import com.trueweb3j.response.*;
import com.trueweb3j.response.Reward.ChainRewardContent;
import com.trueweb3j.response.fast.EthBlock;
import com.trueweb3j.response.snail.BalanceChange;
import com.trueweb3j.response.snail.EtrueSnailBlockNumber;
import com.trueweb3j.response.snail.SnailRewardContenet;
import com.trueweb3j.response.staking.AllStakingAccount;
import com.trueweb3j.response.staking.StakingAccountInfo;
import org.apache.commons.lang3.StringUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.http.HttpService;
import com.trueweb3j.common.Constant;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrueWeb3jRequest {
    public static Web3jService web3jService = null;

    private TrueWeb3jRequest() {

    }

    public TrueWeb3jRequest(String rpcUrl) {
        web3jService = new HttpService(rpcUrl);
    }

    public Map<String, String> getSnailBalanceChange(BigInteger snailBlockNumber) {
        Map<String, String> addrWithBalance = new HashMap<String, String>();
        try {
            EtrueBalanceChange etrueBalanceChange = new Request<>(
                    Constant.SNAIL_REWARD_RPC,
                    Arrays.asList(DefaultBlockParameter.valueOf(snailBlockNumber).getValue()),
                    web3jService,
                    EtrueBalanceChange.class).send();
            BalanceChange balanceChange = etrueBalanceChange.getBalanceChange();
            if (balanceChange != null) {
                addrWithBalance = balanceChange.getAddrWithBalance();
                for (Map.Entry<String, String> entry : addrWithBalance.entrySet()) {
                    System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addrWithBalance;
    }

    /**
     * @param fastBlockNumber
     * @param returnFullTransactionObjects
     * @return
     */
    public EthBlock.Block getFastBlockByNumber(BigInteger fastBlockNumber, boolean returnFullTransactionObjects) {
        System.out.println("go into getFastBlockByNumber");
        EthBlock.Block fastBlock = null;
        try {
            EthBlock ethBlock = new Request<>(
                    Constant.GETBLOCK_BYNUMBER,
                    Arrays.asList(DefaultBlockParameter.valueOf(fastBlockNumber).getValue(), returnFullTransactionObjects),
                    web3jService,
                    EthBlock.class).send();
            fastBlock = ethBlock.getBlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fastBlock;
    }

    public SnailRewardContenet getSnailRewardContent(BigInteger snailNumber) {
        System.out.println("go into getSnailRewardContent");
        SnailRewardContenet snailRewardContenet = null;
        try {
            EtrueSnailRewardContent etrueSnailRewardContent = new Request<>(
                    Constant.GETSNAIL_REWARD_CONTENT,
                    Arrays.asList(DefaultBlockParameter.valueOf(snailNumber).getValue()),
                    web3jService,
                    EtrueSnailRewardContent.class).send();
            snailRewardContenet = etrueSnailRewardContent.getSnailRewardContenet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return snailRewardContenet;
    }

    public Map<String, BigInteger> getAddressesSnailReward(BigInteger snailNumber) {
        //慢链奖励中涉及所有的地址
        Map<String, BigInteger> snailRewardWithAddr = new HashMap<String, BigInteger>();
        SnailRewardContenet snailRewardContent = getSnailRewardContent(snailNumber);
        if (snailRewardContent == null) {
            return snailRewardWithAddr;
        }

        Map<String, BigInteger> blockReward = snailRewardContent.getBlockminer();
        gatherAddressBalance(snailRewardWithAddr, blockReward);

        Map<String, BigInteger> committeReward = snailRewardContent.getCommitteReward();
        gatherAddressBalance(snailRewardWithAddr, committeReward);

        Map<String, BigInteger> foundationReward = snailRewardContent.getFoundationReward();
        gatherAddressBalance(snailRewardWithAddr, foundationReward);

        List<Map<String, BigInteger>> fruitMinerList = snailRewardContent.getFruitminer();
        for (Map<String, BigInteger> fruitMiner : fruitMinerList) {
            gatherAddressBalance(snailRewardWithAddr, fruitMiner);
        }
        return snailRewardWithAddr;
    }

    private Map<String, BigInteger> gatherAddressBalance(Map<String, BigInteger> snailRewardWithAddr, Map<String, BigInteger> rewardMap) {
        if (rewardMap == null) {
            return snailRewardWithAddr;
        }
        for (Map.Entry<String, BigInteger> entry : rewardMap.entrySet()) {
            if (snailRewardWithAddr.get(entry.getKey()) != null) {
                BigInteger balance = snailRewardWithAddr.get(entry.getKey());
                balance = balance.add(entry.getValue());
                snailRewardWithAddr.put(entry.getKey(), balance);
            } else {
                snailRewardWithAddr.put(entry.getKey(), entry.getValue());
            }
        }
        return snailRewardWithAddr;
    }

    public StakingAccountInfo getStakingAccountInfo(BigInteger epochid, String account) {
        System.out.println("go into getSnailRewardContent");
        StakingAccountInfo stakingAccountInfo = null;
        try {
            EtrueStakingAccountInfo etrueStakingAccountInfo = new Request<>(
                    Constant.GET_STAKING_ACCOUNT,
                    Arrays.asList(
                            Numeric.encodeQuantity(epochid),
                            account),
                    web3jService,
                    EtrueStakingAccountInfo.class).send();
            stakingAccountInfo = etrueStakingAccountInfo.getStakingAccountInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stakingAccountInfo;
    }

    public AllStakingAccount getAllStakingAccount(DefaultBlockParameter defaultBlockParameter) {
        System.out.println("go into getAllStakingAccount");
        AllStakingAccount allStakingAccount = null;
        try {
            EtrueAllStakingAccountInfo etrueAllStakingAccountInfo = new Request<>(
                    Constant.GET_ALLSTAKING_ACCOUNT,
                    Arrays.asList(DefaultBlockParameterName.LATEST),
                    web3jService,
                    EtrueAllStakingAccountInfo.class).send();
            allStakingAccount = etrueAllStakingAccountInfo.getAllStakingAccount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allStakingAccount;
    }

    public ChainRewardContent getChainRewardContent(BigInteger snailNumber, String stakingAddress) {
        ChainRewardContent chainRewardContent = null;

        if (snailNumber == null || StringUtils.isBlank(stakingAddress)) {
            return null;
        }
        DefaultBlockParameter blockParameter = DefaultBlockParameter.valueOf(snailNumber);
        try {
            EtrueChainRewardContent etrueChainRewardContent = new Request<>(
                    Constant.GET_CHAIN_REWARD_CONTENT,
                    Arrays.asList(blockParameter.getValue(), stakingAddress),
                    web3jService,
                    EtrueChainRewardContent.class).send();
            chainRewardContent = etrueChainRewardContent.getChainRewardContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chainRewardContent;
    }

    public ChainRewardContent getChainRewardContent(String stakingAddress) {
        ChainRewardContent chainRewardContent = null;
        if (StringUtils.isBlank(stakingAddress)) {
            return null;
        }
//        BigInteger snailNumber = getCurrentSnailNumber();
        BigInteger snailNumber = new BigInteger("39748");
        System.out.println("currentSnailNumber=" + snailNumber);
        DefaultBlockParameter blockParameter = DefaultBlockParameter.valueOf(snailNumber);
        try {
            EtrueChainRewardContent etrueChainRewardContent = new Request<>(
                    Constant.GET_CHAIN_REWARD_CONTENT,
                    Arrays.asList(blockParameter.getValue(), stakingAddress),
                    web3jService,
                    EtrueChainRewardContent.class).send();
            chainRewardContent = etrueChainRewardContent.getChainRewardContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chainRewardContent;
    }

    public BigInteger getCurrentSnailNumber() {
        BigInteger snailNumber = null;
        try {
            EtrueSnailBlockNumber etrueSnailBlockNumber = new Request<>(
                    "etrue_snailBlockNumber",
                    Arrays.asList(),
                    web3jService,
                    EtrueSnailBlockNumber.class).send();
            snailNumber = etrueSnailBlockNumber.getTrueBlockNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return snailNumber;
    }

}
