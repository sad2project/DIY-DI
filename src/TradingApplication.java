import java.math.BigDecimal;
import external.Account;
import external.ApplicationWrapper;


public class TradingApplication extends ApplicationWrapper
{
	@Override
	public void execute(String[] args)
	{
		new BookingService(args).buy();
	}
	
}
