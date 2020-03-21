package com.trueweb3j.response.Reward;

import org.web3j.utils.Numeric;

import java.math.BigInteger;

public class RewardInfo {
    public String Address;

    public String Amount;

    public String Staking;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public BigInteger getAmount() {
        return Numeric.decodeQuantity(Amount);
    }

    public String getAmountRaw() {
        return Amount;
    }


    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getStaking() {
        return Staking;
    }

    public void setStaking(String staking) {
        Staking = staking;
    }

    @Override
    public String toString() {
        return "RewardInfo{" +
                "Address='" + Address + '\'' +
                ", Amount='" + Amount + '\'' +
                ", Staking='" + Staking + '\'' +
                '}';
    }
}
