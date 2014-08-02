import external.ApplicationWrapper;


public class TradingApplication extends ApplicationWrapper
{
	@Override
	public void execute(String[] args)
	{
		ApplicationScope scope = new ApplicationScope(args);
		TradingInjector.injectBookingService(scope)
			.buy();
	}
	
}
