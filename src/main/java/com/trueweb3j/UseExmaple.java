package com.trueweb3j;

import com.trueweb3j.common.Constant;
import com.trueweb3j.response.Reward.RewardInfo;
import com.trueweb3j.response.Reward.SARewardInfos;
import com.trueweb3j.response.fast.EthBlock;
import com.trueweb3j.response.Reward.ChainRewardContent;
import com.trueweb3j.response.snail.SnailRewardContenet;
import com.trueweb3j.response.staking.AllStakingAccount;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class UseExmaple {

    public static void main(String[] args) {

        Web3j web3jt = Web3j.build(new HttpService(Constant.RPC_MAINNET_URL));
        try {
            EthBlockNumber ethBlockNumber = web3jt.ethBlockNumber().send();
            BigInteger blockNumber = ethBlockNumber.getBlockNumber();
            System.out.println("fast blockNumber=" + blockNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }


        TrueWeb3jRequest trueWeb3jRequest = new TrueWeb3jRequest(Constant.RPC_MAINNET_URL);

        //通过fastNumbe获取奖励的慢链高度snailNumber
        BigInteger requestFastNumber = new BigInteger("4760234");
        EthBlock.Block fastBlock = trueWeb3jRequest.getFastBlockByNumber(requestFastNumber, false);
        /**
         * fastBlock的snailNumber为空,说明没有奖励慢链
         * 不为空，奖励的高度为snailNumber值
         */
        if (fastBlock.getSnailNumber().compareTo(BigInteger.ZERO) == 1) {
            System.out.println("get snailRewardBlock number=" + fastBlock.getSnailNumber());
        }

        //通过snailNumbe获取慢链奖励的所有地址
        BigInteger requestSnailNumber = new BigInteger("39748");
        Map<String, BigInteger> addressSnailReward = trueWeb3jRequest.getAddressesSnailReward(requestSnailNumber);
        System.out.println("addressSnailReward size=" + addressSnailReward.size());
        for (Map.Entry<String, BigInteger> entry : addressSnailReward.entrySet()) {
            System.out.println("address=" + entry.getKey() + "rewardBalance=" + entry.getKey());
        }


        //通过指定质押地址获取该质押地址下的所有委托地址的收益
        String stakingAddress = "0x400abb159dc64f7d8b13fce3d0fd5c6a4559cb80";
        ChainRewardContent chainRewardContent = trueWeb3jRequest.getChainRewardContent(requestSnailNumber, stakingAddress);

        if (chainRewardContent == null) {
            System.out.println("get chainRewardContent null,snailNumber=" + requestSnailNumber + "stakingAddress=" + stakingAddress);
            return;
        }
        BigInteger snailNumber = chainRewardContent.getNumber();
        BigInteger timeStamp = chainRewardContent.getTime();
        System.out.println("snailNumber=" + snailNumber + ",timeStamp=" + timeStamp);
        List<RewardInfo> rewardInfos = chainRewardContent.getStakingReward();
        for (RewardInfo rewardInfo : rewardInfos) {
            System.out.println(rewardInfo.toString());
        }


//        testSnailBalance(trueWeb3jRequest);
//        testSnailReward(trueWeb3jRequest);
//        testStakingAccount(trueWeb3jRequest);
//        getAllStakingAccount(trueWeb3jRequest);
//        getChainRewardContent(trueWeb3jRequest);
    }

    public static void testStakingAccount(TrueWeb3jRequest trueWeb3jRequest) {
        BigInteger snailNumber = new BigInteger("2");
        SnailRewardContenet snailRewardContenet = trueWeb3jRequest.getSnailRewardContent(snailNumber);
        Map<String, BigInteger> addressSnailReward = trueWeb3jRequest.getAddressesSnailReward(snailNumber);
        System.out.println("size=" + snailRewardContenet.getFruitminer());
    }

    public static void getChainRewardContent(TrueWeb3jRequest trueWeb3jRequest) {

//        String stakingAddress = "0xdaa07f97034916517afff28b672a61b0027346a2";
        BigInteger requestSnailNumber = new BigInteger("39748");
        String stakingAddress = "0x400abb159dc64f7d8b13fce3d0fd5c6a4559cb80";
//        String stakingAddress = "0x0000000000000000000000000000000000000000";
        ChainRewardContent chainRewardContent = trueWeb3jRequest.getChainRewardContent(
                requestSnailNumber, stakingAddress);
        List<SARewardInfos> saRewardInfos = chainRewardContent.getCommitteReward();
        System.out.println("addr=" + saRewardInfos.get(0).Items.get(0).getAddress());
//        System.out.println("stakingAddress=" + chainRewardContent.getStakingReward().size());
    }

    public static void getAllStakingAccount(TrueWeb3jRequest trueWeb3jRequest) {
        BigInteger snailNumber = new BigInteger("-2");
        AllStakingAccount allStakingAccount = trueWeb3jRequest.getAllStakingAccount(
                DefaultBlockParameter.valueOf(snailNumber));
        System.out.println("count=" + allStakingAccount.getDelegateCount());
    }
    //

    public static void testSnailReward(TrueWeb3jRequest trueWeb3jRequest) {
        BigInteger snailNumber = new BigInteger("2");
        SnailRewardContenet snailRewardContenet = trueWeb3jRequest.getSnailRewardContent(snailNumber);
        Map<String, BigInteger> addressSnailReward = trueWeb3jRequest.getAddressesSnailReward(snailNumber);
        System.out.println("size=" + snailRewardContenet.getFruitminer());
    }

    public static void testSnailBalance(TrueWeb3jRequest trueWeb3jRequest) {
        trueWeb3jRequest.getSnailBalanceChange(new BigInteger("2"));
        EthBlock.Block fastBlock = trueWeb3jRequest.getFastBlockByNumber(new BigInteger("2"), false);
        System.out.println("snailNumber=" + fastBlock.getSnailNumber());

        EthBlock.Block fastBlock2 = trueWeb3jRequest.getFastBlockByNumber(new BigInteger("2311"), false);
        System.out.println("snailNumber=" + fastBlock2.getSnailNumber());

        Map<String, String> addrWithBalance = trueWeb3jRequest.getSnailBalanceChange(new BigInteger("2"));
    }

}
