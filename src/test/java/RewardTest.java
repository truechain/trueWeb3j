import com.trueweb3j.sample.CommitteeUsage;
import com.trueweb3j.sample.RewardUsage;
import org.junit.Before;
import org.junit.Test;

public class RewardTest extends TrueWeb3jRequestTest {
    private RewardUsage rewardUsage;

    @Before
    public void init() {
        rewardUsage = new RewardUsage();
    }

    @Test
    public void testGetSnailBalanceChange() {
        rewardUsage.getSnailBalanceChange();
    }

    @Test
    public void testGetSnailRewardContent() {
        rewardUsage.getSnailRewardContent();
    }

    @Test
    public void testGetAddressesSnailReward() {
        rewardUsage.getAddressesSnailReward();
    }


}
