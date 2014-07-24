import java.math.BigDecimal;
import external.Account;
import external.ApplicationWrapper;


public class TradingApplication extends ApplicationWrapper
{
	@Override
	public void execute(String[] args)
	{
		String accountKey = args[0];
		Account customerAccount = Account.getCustomerAccount(accountKey);
		String symbol = args[1];
		BigDecimal quantity = new BigDecimal(args[2]);
		BigDecimal commission = new BigDecimal(args[3]);
		Trade trade = new Trade();
		trade.setSymbol(symbol);
		trade.setQuantity(quantity);
		trade.buy(customerAccount, commission);
	}
	
}
