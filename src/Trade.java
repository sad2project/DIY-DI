import java.math.BigDecimal;


public final class Trade
{
	private final String symbol;
	private final BigDecimal quantity;
	
	public Trade(String symbol, BigDecimal quantity)
	{
		this.symbol = symbol;
		this.quantity = quantity;
	}
	
	public String getSymbol()
	{
		return symbol;
	}
	
	public BigDecimal getQuantity()
	{
		return quantity;
	}
}
