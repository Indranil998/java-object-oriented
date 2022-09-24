import java.io.*;
import java.util.ArrayList;

public class StockPortfolio {
	public String name;
	ArrayList<Stock> stockList = new ArrayList<Stock>();

	StockPortfolio(String name) {
		this.name = name;
	}

	/**
	 * Add stock to the stock list according to function parameters
	 * @param stockName
	 * @param numberOfShare
	 * @param sharePrice
	 */
	public void addStock(String stockName, int numberOfShare, double sharePrice) {
		stockList.add(new Stock(stockName, numberOfShare, sharePrice));
	}

	/**
	 * Add stock to the stock list according to information of stocks in file
	 * @param fileName
	 */
	public void addStock(String fileName){
		String line = "";
		// Input file is considered as comma separated values format so every line have to be split by comma
		String splitBy = ","; 
		// Reading file which file name is provided to 
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			while((line = bufferedReader.readLine()) != null) {
				String[] stockData = line.split(splitBy);
				// line will have stock name, number of shares, price of share
				addStock(stockData[0], Integer.parseInt(stockData[1]), Double.parseDouble(stockData[2]));
			}
		}
		catch (Exception e) {
			System.out.println(e);
			return;
		}
	}

	/*
	 * Calculates amount of portfolio by making total of all stocks prices
	 */
	public double amount() {
		double totalStockPrice = 0;
		for (Stock stock : stockList ) totalStockPrice += stock.getStockPrice();
		return totalStockPrice;
	}

	public void show() {
		System.out.println("Portfolio name :- "+name);
		System.out.println("Portfolio amount :- "+amount());
		System.out.println("Stocks in portfolio :- ");
		for (Stock stock : stockList ) {
			System.out.println("\t Stock name :- "+stock.name);
			System.out.println("\t Stock price :- "+stock.getStockPrice());
			System.out.println("\t Number of share :- "+stock.getNumberOfShare());
			System.out.println("\t One sahre price :- "+stock.getSharePrice());
		}
	}
}