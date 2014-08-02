import java.math.BigDecimal;

public class SettlementCalculator
{
	private final BigDecimal price;
	private final BigDecimal quantity;
	private final BigDecimal commission;
	
	SettlementCalculator(BigDecimal price, BigDecimal quantity, BigDecimal commmission)
	{
		this.price = price;
		this.quantity = quantity;
		this.commission = commmission;
	}
	
	public BigDecimal getSettlementAmount()
	{
		BigDecimal marketValue = price.multiply(quantity);
		BigDecimal settlementAmount = marketValue.add(commission);
		return settlementAmount;
	}
}
