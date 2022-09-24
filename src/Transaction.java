import java.time.LocalDateTime;

public class Transaction {
	public static final String ACTION_BUY = "BUY";
	public static final String ACTION_SELL = "SELL";
	private int amount;
	private String action;
	private double atCost;
	private LocalDateTime dateTime;
	
	Transaction(String action, int amount, double atCost) {
		dateTime = LocalDateTime.now();
		this.action = action;
		this.amount = amount;
		this.atCost = atCost;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getAction() {
		return action;
	}

	public int getAmount() {
		return amount;
	}
	
	public double getAtCost() {
		return atCost;
	}
	
	public double getTransactionCost() {
		return amount * atCost;
	}

	public String getDescription() {
		return amount+" shares "+action+" at cost "+atCost+" on date time "+dateTime+" transaction cost is "+getTransactionCost();
	}
	
	public String toString() {
		return "\nAmount = "+amount+", Action = "+action+", At Cost = "+atCost+", Date Time = "+dateTime+", Transaction Cost = "+getTransactionCost()
		+",\nDescription = "+getDescription();
	}
}