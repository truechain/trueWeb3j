import com.trueweb3j.response.fast.FastBlock;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class FastBlockTest extends  TrueWeb3jRequestTest{
    private static final Logger logger = LoggerFactory.getLogger(FastBlockTest.class);

    @Test
    public void testGetFastBlockByNumber() {
        BigInteger fastNumber = new BigInteger("100");
        FastBlock fastBlock = trueWeb3jRequest.getFastBlockByNumber(fastNumber, true);
        logger.info("fast number=[{}]", fastBlock.getNumber());
    }

    @Test
    public void testGetCurrentFastNumber() {
        BigInteger currentFastNumber = trueWeb3jRequest.getCurrentFastNumber();
        logger.info("current fast number=[{}]", currentFastNumber);
    }
}
