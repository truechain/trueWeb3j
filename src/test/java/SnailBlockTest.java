import com.trueweb3j.response.Reward.ChainRewardContent;
import com.trueweb3j.response.snail.SnailBlock;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Map;

public class SnailBlockTest extends TrueWeb3jRequestTest {
    private static final Logger logger = LoggerFactory.getLogger(SnailBlockTest.class);


    @Test
    public void testGetSnailBlockByNumber() {
        BigInteger snailNumber = new BigInteger("100");
        SnailBlock snailBlock = trueWeb3jRequest.getSnailBlockByNumber(snailNumber, true);
        logger.info("snailBlock=[{}]", snailBlock);
    }

    @Test
    public void testGetSnailBlockByHash() {
        String snailHash = "0x060e8090d3a2babe117eac6cf5be681850cbd4076f4fe465c8d626e051a49dc9";
        SnailBlock snailBlock = trueWeb3jRequest.getSnailBlockByHash(snailHash, true);
        logger.info("snailBlock=[{}]", snailBlock);
    }

    @Test
    public void testGetCurrentSnailNumber() {
        BigInteger currentSnailNumber = trueWeb3jRequest.getCurrentSnailNumber();
        logger.info("currentSnailNumber=[{}]", currentSnailNumber);
    }


    @Test
    public void testGetSnailHashByNumber() {
        BigInteger snailNumber = new BigInteger("100");
        String snailHash = trueWeb3jRequest.getSnailHashByNumber(snailNumber);
        logger.info("snailHash=[{}]", snailHash);
    }


    @Test
    public void testGetSnailBalanceChange() {
        BigInteger snailNumber = new BigInteger("100");
        Map<String, String> addrWithBalance = trueWeb3jRequest.getSnailBalanceChange(snailNumber);
        logger.info("addrWithBalance=[{}]", addrWithBalance.toString());
    }

    @Test
    public void testGetSnailRewardContent() {
        BigInteger snailNumber = new BigInteger("100");
        ChainRewardContent chainRewardContent = trueWeb3jRequest.getSnailRewardContent(snailNumber);
        logger.info("chainRewardContent=[{}]", chainRewardContent);
    }


}
