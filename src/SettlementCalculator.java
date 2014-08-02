import java.math.BigDecimal;

public class SettlementCalculator
{
	private final Provider<BigDecimal> price;
	private final BigDecimal quantity;
	private final BigDecimal commission;
	
	SettlementCalculator(Provider<BigDecimal> price, BigDecimal quantity, BigDecimal commmission)
	{
		this.price = price;
		this.quantity = quantity;
		this.commission = commmission;
	}
	
	public BigDecimal getSettlementAmount()
	{
		BigDecimal marketValue = price.get().multiply(quantity);
		BigDecimal settlementAmount = marketValue.add(commission);
		return settlementAmount;
	}
}
