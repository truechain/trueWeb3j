import com.trueweb3j.response.committee.CommitteeInfo;
import com.trueweb3j.sample.CommitteeUsage;
import com.trueweb3j.sample.FastBlockUsage;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class CommitteeTest extends TrueWeb3jRequestTest {
    private CommitteeUsage committeeUsage;

    @Before
    public void init() {
        committeeUsage = new CommitteeUsage();
    }

    @Test
    public void testGetCommitteeByNumber() {
        committeeUsage.getCommitteeByNumber();
    }

    @Test
    public void testGetCurrentCommitteeNumber() {
        committeeUsage.testGetCurrentCommitteeNumber();
    }
}
