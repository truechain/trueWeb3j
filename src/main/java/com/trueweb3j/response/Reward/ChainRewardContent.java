package com.trueweb3j.response.Reward;

import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.List;

/**
 * 某个慢链块的收益
 */
public class ChainRewardContent {
    public String Number;

    public String time;

    //某个质押节点下所有地址的委托收益
    public List<RewardInfo> stakingReward;

    /**
     * 当传入空地址，获取的是所有的收益
     */
    public RewardInfo foundationReward;

    public RewardInfo blockminer;

    public List<RewardInfo> fruitminer;

    public List<SARewardInfos> committeReward;

    public ChainRewardContent() {
    }


    public ChainRewardContent(String number, String time, List<RewardInfo> stakingReward, RewardInfo foundationReward, RewardInfo blockminer, List<RewardInfo> fruitminer, List<SARewardInfos> committeReward) {
        Number = number;
        this.time = time;
        this.stakingReward = stakingReward;
        this.foundationReward = foundationReward;
        this.blockminer = blockminer;
        this.fruitminer = fruitminer;
        this.committeReward = committeReward;
    }

    public  BigInteger getNumber() {
        return Numeric.decodeQuantity(Number);
    }

    public String getNumberRaw(){
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public BigInteger getTime() {
        return Numeric.decodeQuantity(time);
    }

    public String getTimeRaw() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<RewardInfo> getStakingReward() {
        return stakingReward;
    }

    public void setStakingReward(List<RewardInfo> stakingReward) {
        this.stakingReward = stakingReward;
    }

    public RewardInfo getFoundationReward() {
        return foundationReward;
    }

    public void setFoundationReward(RewardInfo foundationReward) {
        this.foundationReward = foundationReward;
    }

    public RewardInfo getBlockminer() {
        return blockminer;
    }

    public void setBlockminer(RewardInfo blockminer) {
        this.blockminer = blockminer;
    }

    public List<RewardInfo> getFruitminer() {
        return fruitminer;
    }

    public void setFruitminer(List<RewardInfo> fruitminer) {
        this.fruitminer = fruitminer;
    }

    public List<SARewardInfos> getCommitteReward() {
        return committeReward;
    }

    public void setCommitteReward(List<SARewardInfos> committeReward) {
        this.committeReward = committeReward;
    }

    @Override
    public String toString() {
        return "ChainRewardContent{" +
                "Number='" + Number + '\'' +
                ", time='" + time + '\'' +
                ", stakingReward=" + stakingReward +
                ", foundationReward=" + foundationReward +
                ", blockminer=" + blockminer +
                ", fruitminer=" + fruitminer +
                ", committeReward=" + committeReward +
                '}';
    }
}
