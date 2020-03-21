package com.trueweb3j;

import com.trueweb3j.response.*;
import com.trueweb3j.response.Reward.ChainRewardContent;
import com.trueweb3j.response.committee.CommitteeInfo;
import com.trueweb3j.response.fast.FastBlock;
import com.trueweb3j.response.snail.BalanceChange;
import com.trueweb3j.response.snail.SnailBlock;
import com.trueweb3j.response.snail.SnailRewardContenet;
import com.trueweb3j.response.staking.AllStakingAccount;
import com.trueweb3j.response.staking.StakingAccountInfo;
import org.apache.commons.lang3.StringUtils;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.http.HttpService;
import com.trueweb3j.common.Constant;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.*;

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
                    Constant.BALANCE_CHANGE_BY_SNAIL_NUMBER,
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

    public FastBlock getFastBlockByNumber(BigInteger fastBlockNumber, boolean returnFullTransactionObjects) {
        FastBlock fastBlock = null;
        try {
            EtrueFastBlock etrueFastBlock = new Request<>(
                    Constant.BLOCK_BYNUMBER,
                    Arrays.asList(DefaultBlockParameter.valueOf(fastBlockNumber).getValue(), returnFullTransactionObjects),
                    web3jService,
                    EtrueFastBlock.class).send();
            fastBlock = etrueFastBlock.getFastBlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fastBlock;
    }

    public BigInteger getCurrentFastNumber(BigInteger fastBlockNumber, boolean returnFullTransactionObjects) {
        BigInteger fastNumber = null;
        try {
            EtrueFastBlockNumber etrueFastBlockNumber = new Request<>(
                    Constant.CURRENT_BLOCK_NUMBER,
                    Arrays.asList(DefaultBlockParameter.valueOf(fastBlockNumber).getValue(), returnFullTransactionObjects),
                    web3jService,
                    EtrueFastBlockNumber.class).send();
            fastNumber = etrueFastBlockNumber.getBlockNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fastNumber;
    }


    public SnailRewardContenet getSnailRewardContent(BigInteger snailNumber) {
        System.out.println("go into getSnailRewardContent");
        SnailRewardContenet snailRewardContenet = null;
        try {
            EtrueSnailRewardContent etrueSnailRewardContent = new Request<>(
                    Constant.SNAIL_REWARD_CONTENT,
                    Arrays.asList(DefaultBlockParameter.valueOf(snailNumber).getValue()),
                    web3jService,
                    EtrueSnailRewardContent.class).send();
            snailRewardContenet = etrueSnailRewardContent.getSnailRewardContenet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return snailRewardContenet;
    }


    /**
     * getSnailBlock by snailNumber
     *
     * @param snailNumber
     * @param inclFruit   whether include fruits info
     * @return
     */
    public SnailBlock getSnailBlockByNumber(BigInteger snailNumber, boolean inclFruit) {
        System.out.println("go into getSnailBlockByNumber");
        SnailBlock snailBlock = null;
        try {
            EtrueSnailBlock etrueSnailBlock = new Request<>(
                    "etrue_getSnailBlockByNumber",
                    Arrays.asList(DefaultBlockParameter.valueOf(snailNumber).getValue(), inclFruit),
                    web3jService,
                    EtrueSnailBlock.class).send();
            snailBlock = etrueSnailBlock.getSnailBlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return snailBlock;
    }

    /**
     * get snailHash by snailNumber
     *
     * @param snailNumber
     * @return if return null, donnot have generate the snailNumber
     */
    public String GetSnailHashByNumber(BigInteger snailNumber) {
        System.out.println("go into GetSnailHashByNumber");
        String snailHash = null;
        try {
            EtrueSnailHash etrueSnailHash = new Request<>(
                    Constant.SNAIL_HASH_BY_NUMBER,
                    Arrays.asList(DefaultBlockParameter.valueOf(snailNumber).getValue()),
                    web3jService,
                    EtrueSnailHash.class).send();
            snailHash = etrueSnailHash.getSnailHash();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return snailHash;
    }

    /**
     * get current snail block number
     *
     * @return
     */
    public BigInteger getCurrentSnailNumber() {
        System.out.println("go into GetSnailHashByNumber");
        BigInteger snailNumber = null;
        try {
            EtrueSnailBlockNumber etrueSnailBlockNumber = new Request<>(
                    Constant.SNAIL_BLOCK_NUMBER,
                    Arrays.asList(),
                    web3jService,
                    EtrueSnailBlockNumber.class).send();
            snailNumber = etrueSnailBlockNumber.getSnailBlockNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return snailNumber;
    }


    /**
     * get snailBlock by snailHash
     *
     * @param snailHash
     * @param inclFruit whether include fruits info
     * @return
     */
    public SnailBlock getSnailBlockByHash(String snailHash, boolean inclFruit) {
        System.out.println("go into getSnailBlockByHash");
        SnailBlock snailBlock = null;
        try {
            EtrueSnailBlock etrueSnailBlock = new Request<>(
                    Constant.SNAIL_BLOCK_BY_HASH,
                    Arrays.asList(snailHash, inclFruit),
                    web3jService,
                    EtrueSnailBlock.class).send();
            snailBlock = etrueSnailBlock.getSnailBlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return snailBlock;
    }

    /**
     * get committeeInfo by committeeNumber
     *
     * @param committeeNumber
     * @return
     */
    public CommitteeInfo getCommitteeByNumber(BigInteger committeeNumber) {
        System.out.println("go into getCommitteeByNumber");
        CommitteeInfo committeeInfo = null;
        try {
            EtrueCommittee etrueCommittee = new Request<>(
                    Constant.COMMITTEE_BY_NUMBER,
                    Arrays.asList(DefaultBlockParameter.valueOf(committeeNumber).getValue()),
                    web3jService,
                    EtrueCommittee.class).send();
            committeeInfo = etrueCommittee.getCommittee();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return committeeInfo;
    }

    public Integer getCurrentCommitteeNumber() {
        System.out.println("go into getCurrentCommitteeNumber");
        Integer currentCommitteeNumber = null;
        try {
            EtrueCommitteeNumber etrueCommitteeNumber = new Request<>(
                    Constant.CURRENT_COMMITTEE_NUMBER,
                    Arrays.asList(),
                    web3jService,
                    EtrueCommitteeNumber.class).send();
            currentCommitteeNumber = etrueCommitteeNumber.getCommitteeNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentCommitteeNumber;
    }

    /*public String etrueSendTrueRawTransaction(String signedTransactionData) {
        System.out.println("go into sendTrueRawTransaction");
        String trueTransactionhash = null;
        try {
            EtrueSendTrueTransaction etrueSendTrueTransaction = new Request<>(
                    Constant.SEND_TRUE_RAW_TRANSACTION,
                    Arrays.asList(signedTransactionData),
                    web3jService,
                    EtrueSendTrueTransaction.class).send();
            trueTransactionhash = etrueSendTrueTransaction.getTrueTransactionHash();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trueTransactionhash;
    }*/

    public EtrueSendTransaction etrueSendRawTransaction(String signedTransactionData) {
        System.out.println("go into etrueSendTrueRawTransaction");
        EtrueSendTransaction etrueSendTrueTransaction = null;
        try {
            etrueSendTrueTransaction = new Request<>(
                    Constant.SEND_TRUE_RAW_TRANSACTION,
                    Arrays.asList(signedTransactionData),
                    web3jService,
                    EtrueSendTransaction.class).send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return etrueSendTrueTransaction;
    }

    /**
     * get balance change with addresses by fast number
     *
     * @param fastNumber
     * @return
     */
    public BalanceChange getStateChangeByFastNumber(BigInteger fastNumber) {
        System.out.println("go into getStateChangeByFastNumber");
        BalanceChange balanceChange = null;
        try {
            EtrueBalanceChange etrueBalanceChange = new Request<>(
                    Constant.STATE_CHANGE_BY_FAST_NUMBER,
                    Arrays.asList(DefaultBlockParameter.valueOf(fastNumber).getValue()),
                    web3jService,
                    EtrueBalanceChange.class).send();
            balanceChange = etrueBalanceChange.getBalanceChange();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balanceChange;
    }


    /////////////////////////


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
        StakingAccountInfo stakingAccountInfo = null;
        try {
            EtrueStakingAccountInfo etrueStakingAccountInfo = new Request<>(
                    Constant.STAKING_ACCOUNT,
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
        AllStakingAccount allStakingAccount = null;
        try {
            EtrueAllStakingAccountInfo etrueAllStakingAccountInfo = new Request<>(
                    Constant.ALLSTAKING_ACCOUNT,
                    Arrays.asList(DefaultBlockParameterName.LATEST),
                    web3jService,
                    EtrueAllStakingAccountInfo.class).send();
            allStakingAccount = etrueAllStakingAccountInfo.getAllStakingAccount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allStakingAccount;
    }

    /**
     * 获取某个质押节点下所有委托地址的收益
     *
     * @param snailNumber
     * @param stakingAddress
     * @return
     */
    public ChainRewardContent getChainRewardContent(BigInteger snailNumber, String stakingAddress) {
        ChainRewardContent chainRewardContent = null;

        if (snailNumber == null || StringUtils.isBlank(stakingAddress)) {
            return null;
        }
        DefaultBlockParameter blockParameter = DefaultBlockParameter.valueOf(snailNumber);
        try {
            EtrueChainRewardContent etrueChainRewardContent = new Request<>(
                    Constant.CHAIN_REWARD_CONTENT,
                    Arrays.asList(blockParameter.getValue(), stakingAddress),
                    web3jService,
                    EtrueChainRewardContent.class).send();
            chainRewardContent = etrueChainRewardContent.getChainRewardContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chainRewardContent;
    }


}
