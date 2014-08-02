import external.MarketService;


public class ApplicationScope
{
	private String[] args;
	
	private Provider<MarketClient> marketClient;
	
	public ApplicationScope(String[] args)
	{
		this.args = args;
		setMarketClientProvider(() -> new MarketClient(MarketService.fetchPrices()));
	}
	
	public ApplicationScope(String[] args, Provider<MarketClient> marketClient)
	{
		this.args = args;
		setMarketClientProvider(marketClient);
	}

	public String[] getArgs()
	{
		return args;
	}
	
	public MarketClient getMarketClient()
	{
		return marketClient.get();
	}
	
	//Lazily instantiates the MarketClient
	//It sets the field to a special provider that doesn't instantiate the
	// MarketClient until it's needed, then caches that instance so we don't need
	// to do it over and over again, and removes redundant null checks.
	private void setMarketClientProvider(Provider<MarketClient> mcp)
	{
		marketClient = new Provider<MarketClient>() {
				public MarketClient get()
				{
					MarketClient mc = mcp.get();
					marketClient = Provider.of(mc);
					return mc;
				}
			};
	}
}
