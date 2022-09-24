import java.util.ArrayList;

public class CompanyShare {
	public String name;
	public String symbol;
	private int numberOfShare;
	private double sharePrice;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	/**
	 * create company share with company name, company symbol, number of shares, share price
	 * enter that transaction details to the transactions list
	 * @param name
	 * @param symbol
	 * @param numberOfShare
	 * @param sharePrice
	 */
	CompanyShare(String name, String symbol, int numberOfShare, double sharePrice) {
		this.name = name;
		this.symbol = symbol;
		this.sharePrice = sharePrice;
		this.numberOfShare = numberOfShare;
		// add transaction details of BUY number of shares
		makeTransaction(Transaction.ACTION_BUY, numberOfShare);
	}
	
	/**
	 * make transaction transaction action, amount of shares and current share price
	 * @param action
	 * @param amount
	 */
	private void makeTransaction(String action, int amount) {
		// add transaction with its information to the transactions list
		transactions.add(new Transaction(action, amount, sharePrice));
	}

	/**
	 * buy number of shares and make its transaction entry
	 * @param numberOfShares
	 * @return buy is succusfull or not (boolean)
	 */	
	public boolean buy(int numberOfShare) {
		this.numberOfShare += numberOfShare;
		makeTransaction(Transaction.ACTION_BUY, numberOfShare);
		return true;
	}
	
	/**
	 * sell number of shares and make its transaction entry
	 * @param numberOfShares
	 * @return sell is succusfull or not (boolean)
	 */	
	public boolean sell(int numberOfShare) {
		// check is number of shares are available or not 
		if (this.numberOfShare >= numberOfShare) {
			this.numberOfShare -= numberOfShare;
			makeTransaction(Transaction.ACTION_SELL, numberOfShare);
			return true;
		} else return false;
	}

	public int getNumberOfShare() {
		return this.numberOfShare;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public double getSharePrice() {
		return this.sharePrice;
	}

	public double getStockPrice() {
		return this.sharePrice * this.numberOfShare;
	}

	public String toString() {
		return "\nCompany Share Name = "+name+"\nCompany Share Symbol = "+symbol+"\nNumber Of Shares = "+numberOfShare
				+"\nShare Price = "+sharePrice+"\nStock Price = "+getStockPrice()+"\nTransactions = "+transactions.toString().replaceAll("\n", "\n\t");
	}
}