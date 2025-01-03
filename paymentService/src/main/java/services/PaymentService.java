package services;

import adapters.paymentGatewayAdapters.PaymentGatewayAdapter;
import adapters.paymentGatewayAdapters.PaymentGatewayStrategy;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public final PaymentGatewayStrategy paymentGatewayStrategy;

    public PaymentService(PaymentGatewayStrategy paymentGatewayStrategy) {
        this.paymentGatewayStrategy = paymentGatewayStrategy;
    }

    public String createPaymentLink(Long orderId) {
        // 1. Get the order details from the order service

        Long price = 123L;
        // 2. Get a payment Gateway based upon a 'strategy'

        // PaymentGatewayAdapter paymentGatewayAdapter = PaymentGatewayStrategy.getPaymentGateway();
        PaymentGatewayAdapter paymentGatewayAdapter = paymentGatewayStrategy.getPaymentGateway();

        String url = "";
        // 3. Call the payment Gateway to create the payment link

        try {
            url = paymentGatewayAdapter.createPaymentLink(price);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 4. Return the payment Link
        return url;
    }
}
