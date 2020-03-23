package com.trueweb3j.sample;

import com.trueweb3j.response.committee.CommitteeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class CommitteeUsage extends TrueWeb3jTestNet {
    private static final Logger logger = LoggerFactory.getLogger(CommitteeUsage.class);

    public void getCommitteeByNumber() {
        BigInteger committeeNumber = new BigInteger("100");
        CommitteeInfo committeeInfo = trueWeb3jRequest.getCommitteeByNumber(committeeNumber);
        logger.info("committeeInfo=[{}]", committeeInfo);
    }

    public void testGetCurrentCommitteeNumber() {
        Integer currentCommitteeNumber = trueWeb3jRequest.getCurrentCommitteeNumber();
        logger.info("current committee number=[{}]", currentCommitteeNumber);
    }

}
