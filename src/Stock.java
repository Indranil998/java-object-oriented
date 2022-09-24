public class Stock {
	public String name;
	private int numberOfShare;
	private double sharePrice;

	Stock(String name, int numberOfShare, double sharePrice) {
		this.name = name;
		this.numberOfShare = numberOfShare;
		this.sharePrice = sharePrice;
	}

	public void setNumberOfShare(int numberOfShare) {
		this.numberOfShare = numberOfShare;
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
		return "Stock Name = "+name+"\nStock Price = "+getStockPrice()+"\nNumber Of Share = "+numberOfShare+"\nShare Price = "+sharePrice;
	}
}