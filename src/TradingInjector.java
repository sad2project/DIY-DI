import java.math.BigDecimal;
import external.Account;

public class TradingInjector
{
	public static BookingService injectBookingService(ApplicationScope appScope)
	{
		return new BookingService(
						injectFirmAccount(),
						injectCustomerAccount(appScope),
						injectTrade(appScope),
						injectSettlementAmount(appScope));
	}
	
	public static TradingArgs injectTradingArgs(ApplicationScope appScope)
	{
		return new TradingArgs(injectArgs(appScope));
	}
	
	public static String[] injectArgs(ApplicationScope appScope)
	{
		return appScope.getArgs();
	}
	
	public static String injectSymbol(ApplicationScope appScope)
	{
		return injectTradingArgs(appScope).getSymbol();
	}
	
	public static BigDecimal injectQuantity(ApplicationScope appScope)
	{
		return injectTradingArgs(appScope).getQuantity();
	}
	
	public static BigDecimal injectCommission(ApplicationScope appScope)
	{
		return injectTradingArgs(appScope).getCommission();
	}
	
	public static String injectAccountKey(ApplicationScope appScope)
	{
		return injectTradingArgs(appScope).getAccountKey();
	}
	
	public static Trade injectTrade(ApplicationScope appScope)
	{
		return new Trade(injectSymbol(appScope), injectQuantity(appScope));
	}
	
	public static Account injectCustomerAccount(ApplicationScope appScope)
	{
		return Account.getCustomerAccount(injectAccountKey(appScope));
	}
	
	public static Account injectFirmAccount()
	{
		return Account.getFirmAccount();
	}
	
	public static MarketClient injectMarketClient()
	{
		return new MarketClient();
	}
	
	public static BigDecimal injectSettlementAmount(ApplicationScope appScope)
	{
		return injectSettlementCalculator(appScope).getSettlementAmount();
	}
	
	public static SettlementCalculator injectSettlementCalculator(ApplicationScope appScope)
	{
		return new SettlementCalculator(
							injectPriceProvider(appScope), 
							injectQuantity(appScope),
							injectCommission(appScope));
	}
	
	public static BigDecimal injectPrice(ApplicationScope appScope)
	{
		return injectMarketClient().getPrice(injectSymbol(appScope));
	}
	
	public static Provider<BigDecimal> injectPriceProvider(ApplicationScope appScope)
	{
		return () -> injectPrice(appScope);
	}
}
