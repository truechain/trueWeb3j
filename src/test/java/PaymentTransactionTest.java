import com.trueweb3j.sample.PaymentTransactionUsage;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentTransactionTest extends TrueWeb3jRequestTest {
    private PaymentTransactionUsage paymentTransactionUsage;

    @Before
    public void init() {
        paymentTransactionUsage = new PaymentTransactionUsage();
    }

    @Test
    public void TestSignPaymentTxWithFrom(){
       paymentTransactionUsage.signPaymentTxWithFrom();
    }


    @Test
    public void TestSignPaymentTxWithPaymentAndSend(){
        String fromSignedTxStr = paymentTransactionUsage.signPaymentTxWithFrom();
        paymentTransactionUsage.signPaymentTxWithPaymentAndSend(fromSignedTxStr);
    }

    @Test
    public void TestSendPaymentTx(){
        paymentTransactionUsage.sendPaymentTx();
    }




}
