import com.trueweb3j.sample.CommitteeUsage;
import com.trueweb3j.sample.StakingUsage;
import org.junit.Before;
import org.junit.Test;

public class StakingTest extends TrueWeb3jRequestTest {
    private StakingUsage stakingUsage;

    @Before
    public void init() {
        stakingUsage = new StakingUsage();
    }

    @Test
    public void testGetChainRewardContentByAddress() {
        stakingUsage.getChainRewardContentByAddress();
    }

    @Test
    public void testGetAllStakingAccount() {
        stakingUsage.getAllStakingAccount();
    }
}
