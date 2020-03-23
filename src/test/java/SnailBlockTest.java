import com.trueweb3j.response.Reward.ChainRewardContent;
import com.trueweb3j.response.snail.SnailBlock;
import com.trueweb3j.sample.FastBlockUsage;
import com.trueweb3j.sample.SnailBlockUsage;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Map;

public class SnailBlockTest extends TrueWeb3jRequestTest {

    private SnailBlockUsage snailBlockUsage;

    @Before
    public void init() {
        snailBlockUsage = new SnailBlockUsage();
    }

    @Test
    public void testGetSnailBlockByNumber() {
        snailBlockUsage.getSnailBlockByNumber();
    }

    @Test
    public void testGetSnailBlockByHash() {
        snailBlockUsage.getSnailBlockByHash();
    }

    @Test
    public void testGetCurrentSnailNumber() {
        snailBlockUsage.getCurrentSnailNumber();
    }


    @Test
    public void testGetSnailHashByNumber() {
        snailBlockUsage.getSnailHashByNumber();
    }


    @Test
    public void testGetSnailBalanceChange() {
        snailBlockUsage.getSnailBalanceChange();
    }

    @Test
    public void testGetSnailRewardContent() {
        snailBlockUsage.getSnailRewardContent();
    }


}
