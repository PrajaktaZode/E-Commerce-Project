package adapters.paymentGatewayAdapters;

import adapters.paymentGatewayAdapters.razorpay.RazorpayPaymentGatewayAdapter;
import adapters.paymentGatewayAdapters.stripe.StripePaymentGatewayAdapter;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class PaymentGatewayStrategy {
    private static Random random = new Random();
    private final StripePaymentGatewayAdapter stripePaymentGatewayAdapter;

    public PaymentGatewayStrategy(StripePaymentGatewayAdapter stripePaymentGatewayAdapter) {
        this.stripePaymentGatewayAdapter = stripePaymentGatewayAdapter;
    }

    public  PaymentGatewayAdapter getPaymentGateway() {
        //int isEven = random.nextInt(100);

        /*if (isEven % 2 == 0) {
            return new RazorpayPaymentGatewayAdapter();
        } else {
            return new StripePaymentGatewayAdapter();
        }*/
        return stripePaymentGatewayAdapter;
    }
}
