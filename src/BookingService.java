import java.math.BigDecimal;
import external.Account;


public class BookingService
{
	private final MarketClient market;
	private final Account firmAccount;
	private final Account customerAccount;
	private final Trade trade;
	private final BigDecimal commision;
	
	BookingService(MarketClient market, Account firmAccount, Account customerAccount, Trade trade, BigDecimal commision)
	{
		this.market = market;
		this.firmAccount = firmAccount;
		this.customerAccount = customerAccount;
		this.trade = trade;
		this.commision = commision;
	}
	
	public BookingService(String[] args)
	{
		this(MarketClient.getInstance(), 
			  Account.getFirmAccount(), 
			  Account.getCustomerAccount(new TradingArgs(args).getAccountKey()),
			  new Trade(new TradingArgs(args).getSymbol(), new TradingArgs(args).getQuantity()),
			  new TradingArgs(args).getCommision() );
	}
	
	public void buy(Account customerAccount, Trade trade, BigDecimal commission)
	{
		BigDecimal price = market.getPrice(trade.getSymbol());
		BigDecimal marketValue = price.multiply(trade.getQuantity());
		BigDecimal settlementAmount = marketValue.add(commission);
		customerAccount.transferCash(settlementAmount, firmAccount);
		firmAccount.transferSecurity(trade.getSymbol(), trade.getQuantity(), customerAccount);
	}
}
