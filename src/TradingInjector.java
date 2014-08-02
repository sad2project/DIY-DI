import java.math.BigDecimal;
import external.Account;

public class TradingInjector
{
	public static BookingService injectBookingService(String[] args)
	{
		return new BookingService(
						injectFirmAccount(),
						injectCustomerAccount(args),
						injectTrade(args),
						injectSettlementAmount(args));
	}
	
	public static TradingArgs injectTradingArgs(String[] args)
	{
		return new TradingArgs(args);
	}
	
	public static String injectSymbol(String[] args)
	{
		return injectTradingArgs(args).getSymbol();
	}
	
	public static BigDecimal injectQuantity(String[] args)
	{
		return injectTradingArgs(args).getQuantity();
	}
	
	public static BigDecimal injectCommission(String[] args)
	{
		return injectTradingArgs(args).getCommission();
	}
	
	public static String injectAccountKey(String[] args)
	{
		return injectTradingArgs(args).getAccountKey();
	}
	
	public static Trade injectTrade(String[] args)
	{
		return new Trade(injectSymbol(args), injectQuantity(args));
	}
	
	public static Account injectCustomerAccount(String[] args)
	{
		return Account.getCustomerAccount(injectAccountKey(args));
	}
	
	public static Account injectFirmAccount()
	{
		return Account.getFirmAccount();
	}
	
	public static MarketClient injectMarketClient()
	{
		return MarketClient.getInstance();
	}
	
	public static BigDecimal injectSettlementAmount(String[] args)
	{
		return injectSettlementCalculator(args).getSettlementAmount();
	}
	
	public static SettlementCalculator injectSettlementCalculator(String[] args)
	{
		return new SettlementCalculator(injectPrice(args), injectQuantity(args), injectCommission(args));
	}
	
	public static BigDecimal injectPrice(String[] args)
	{
		return injectMarketClient().getPrice(injectSymbol(args));
	}
}
