import com.trueweb3j.response.committee.CommitteeInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class CommitteeTest extends TrueWeb3jRequestTest {
    private static final Logger logger = LoggerFactory.getLogger(CommitteeTest.class);

    @Test
    public void testGetCommitteeByNumber() {
        BigInteger committeeNumber = new BigInteger("100");
        CommitteeInfo committeeInfo = trueWeb3jRequest.getCommitteeByNumber(committeeNumber);
        logger.info("committeeInfo=[{}]", committeeInfo);
    }

    @Test
    public void testGetCurrentCommitteeNumber() {
        Integer currentCommitteeNumber = trueWeb3jRequest.getCurrentCommitteeNumber();
        logger.info("current committee number=[{}]", currentCommitteeNumber);
    }
}
