import com.trueweb3j.common.AddressConstant;
import com.trueweb3j.common.Constant;
import com.trueweb3j.sample.StakingUsage;
import com.trueweb3j.sample.erc20.TokenClientUsage;
import org.junit.Before;
import org.junit.Test;

public class TokenClientTest {
    private TokenClientUsage tokenClientUsage;

    @Before
    public void init() {
        tokenClientUsage = new TokenClientUsage();
    }


    @Test
    public void testGetTokenBalance() {
        tokenClientUsage.getTokenBalance(AddressConstant.fromAddress, AddressConstant.contractAddress);
    }

    @Test
    public void testGetTokenName() {
        tokenClientUsage.getTokenName(AddressConstant.contractAddress);
    }

    @Test
    public void testGetTokenDecimals() {
        tokenClientUsage.getTokenDecimals(AddressConstant.contractAddress);
    }

    @Test
    public void testGetTokenSymbol() {
        tokenClientUsage.getTokenSymbol(AddressConstant.contractAddress);
    }


    @Test
    public void testGetTokenTotalSupply() {
        tokenClientUsage.getTokenTotalSupply(AddressConstant.contractAddress);
    }


}
