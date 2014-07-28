import external.ApplicationWrapper;


public class TradingApplication extends ApplicationWrapper
{
	@Override
	public void execute(String[] args)
	{
		TradingInjector.injectBookingService(args).buy();
	}
	
}
