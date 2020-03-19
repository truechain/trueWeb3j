package com.trueweb3j.response.snail;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class SnailRewardContenet {

    private Map<String, BigInteger> blockminer;
    private List<Map<String, BigInteger>> fruitminer;
    private Map<String, BigInteger> committeReward;
    private Map<String, BigInteger> foundationReward;


    public Map<String, BigInteger> getBlockminer() {
        return blockminer;
    }

    public void setBlockminer(Map<String, BigInteger> blockminer) {
        this.blockminer = blockminer;
    }

    public List<Map<String, BigInteger>> getFruitminer() {
        return fruitminer;
    }

    public void setFruitminer(List<Map<String, BigInteger>> fruitminer) {
        this.fruitminer = fruitminer;
    }

    public Map<String, BigInteger> getCommitteReward() {
        return committeReward;
    }

    public void setCommitteReward(Map<String, BigInteger> committeReward) {
        this.committeReward = committeReward;
    }

    public Map<String, BigInteger> getFoundationReward() {
        return foundationReward;
    }

    public void setFoundationReward(Map<String, BigInteger> foundationReward) {
        this.foundationReward = foundationReward;
    }
}
