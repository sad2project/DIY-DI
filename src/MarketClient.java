import java.math.BigDecimal;
import java.util.Map;
import external.MarketService;


public class MarketClient
{
	private static MarketClient instance = null;

	public static MarketClient getInstance()
	{
		if(instance == null)
		{
			instance = new MarketClient();
		}
		return instance;
	}
	
	private final Map<String, BigDecimal> cachedPrices;
	
	private MarketClient()
	{
		this(MarketService.fetchPrices());
	}
	
	/**
	 * This one is provided so that tests can inject a cache to test against
	 */
	MarketClient(Map<String, BigDecimal> cachedPrices)
	{
		this.cachedPrices = cachedPrices;
	}

	public BigDecimal getPrice(String symbol)
	{
		return cachedPrices.get(symbol);
	}
	
}
