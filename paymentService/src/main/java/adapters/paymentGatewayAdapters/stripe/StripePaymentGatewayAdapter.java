package adapters.paymentGatewayAdapters.stripe;

import adapters.paymentGatewayAdapters.PaymentGatewayAdapter;
import com.stripe.StripeClient;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGatewayAdapter implements PaymentGatewayAdapter {
    private final StripeClient stripeClient;

    public StripePaymentGatewayAdapter(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @Override
    public String createPaymentLink(Long price) throws Exception {

    /*ProductCreateParams params =
            ProductCreateParams.builder()
                    .setDescription("(created by Stripe Shell)")
                    .setName("Product1")
                    .setActive(true)
                    .setDefaultPriceData(
                            ProductCreateParams.DefaultPriceData.builder()
                                    .setCurrency("inr")
                                    .setUnitAmount(9999L)
                                    .build()
                    )
                    .build();

    Product product = Product.create(params);

    PriceCreateParams params =
            PriceCreateParams.builder()
                    .setCurrency("inr")
                    .setProduct("prod_RNTaggAtgMMtWq")
                    .setUnitAmount(999999L)
                    .build();

    Price price = Price.create(params);
*/
        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .setCurrency("inr")
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice("price_1QUirRCcI02YVaXfaKyoxRwT")
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl("https://scaler.com")
                                                        .build()
                                        )
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);
        return paymentLink.getUrl();
    }
}
