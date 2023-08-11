import java.math.BigDecimal;
import java.math.RoundingMode;

public class FXConverter {
    private final RemoteFXRateService remoteFXRateService;

    public FXConverter(RemoteFXRateService remoteFXRateService) {
        this.remoteFXRateService = remoteFXRateService;
    }

    public BigDecimal convert(String source, String target, String input) {
        try {
            String response = remoteFXRateService.getRate(source, target);
            BigDecimal rate = new BigDecimal(response);
            BigDecimal amount = new BigDecimal(input);

            return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
        } catch (IllegalStateException | IllegalArgumentException exception) {
            return new BigDecimal("-1.00");
        }
    }
}
