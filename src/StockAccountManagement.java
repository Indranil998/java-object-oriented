public class StockAccountManagement {

	public static void main(String[] args) {
		// Create Stock Portfolio
		StockPortfolio stockPortfolio = new StockPortfolio("Stock Portfolio");
		// Add stocks to stock portfolio according to stocks information in stock_info.csv file
		stockPortfolio.addStock("stock_info.csv");
		// Print amount of stock portfolio
		System.out.println("Amount : "+stockPortfolio.amount());
		// Show stock portfolio information
		stockPortfolio.show();
	}

}