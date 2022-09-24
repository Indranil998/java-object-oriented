import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Have to implement SEBI (Securities and Exchange Board of India) Guidelines
 */
public class StockAccount implements SEBIGuidelines{
	private Scanner scanner = new Scanner(System.in);
	public String customerName;
	private double dollars;
	private HashMap<String, CompanyShare> companyShares = new HashMap<String, CompanyShare>(); 
	
	/*
	 * Open Stock account of user by users name and some amount(dollars) in his stock account 
	 */
	StockAccount (String customerName, double dollars) {
		this.customerName = customerName;
		this.dollars = dollars;
	}
	
	/**
	 * Include company share to stock account with its company name, company symbol, number of shares, share price
	 * company symbol is unique so we can sarch it according to its symbol so store company share with its symbol
	 * @param companyShareName
	 * @param companyShareSymbol
	 * @param numberOfShare
	 * @param sharePrice
	 */
	public void addCompanyShare (String companyShareName, String companyShareSymbol, int numberOfShare, double sharePrice){
		// if have enough balance in stock account to buy number of share with its current share price
		if (dollars >= numberOfShare * sharePrice) {
			// then pay in dollars from account balance and dollars balance will reduce by number of shares * share price
			dollars -= numberOfShare * sharePrice;
			// add company share to stock account with number of shares of it
			companyShares.put(companyShareSymbol, new CompanyShare(companyShareName, companyShareSymbol, numberOfShare, sharePrice));	
		} else {
			System.out.println("Company sahre created but stock account not have enough balance to add "+numberOfShare+" shares");
			// add company share to stock account with 0 number of shares of it
			companyShares.put(companyShareSymbol, new CompanyShare(companyShareName, companyShareSymbol, 0, sharePrice));
		}
	}

	/**
	 * Include company share to stock account with its company name, company symbol, number of shares, share price
	 * company symbol is unique so we can sarch it according to its symbol so store company share with its symbol
	 * @param companyShareSymbol
	 * @param numberOfShare
	 */
	public void addCompanyShare (String companyShareSymbol, int numberOfShare){
		// get company share information from user
		System.out.println("Please enter company share information of symbol "+companyShareSymbol);
		System.out.print("Enter company share name : ");
		String companyShareName = scanner.nextLine();
		System.out.print("Enter company share price : ");
		double sharePrice = scanner.nextDouble();
		
		// if have enough balance in stock account to buy number of share with its current share price
		if (dollars >= numberOfShare * sharePrice) {
			// then pay in dollars from account balance and dollars balance will reduce by number of shares * share price
			dollars -= numberOfShare * sharePrice;
			// add company share to stock account with number of shares of it
			companyShares.put(companyShareSymbol, new CompanyShare(companyShareName, companyShareSymbol, numberOfShare, sharePrice));	
		} else {
			System.out.println("Company sahre created but stock account not have enough balance to add "+numberOfShare+" shares");
			// add company share to stock account with 0 number of shares of it
			companyShares.put(companyShareSymbol, new CompanyShare(companyShareName, companyShareSymbol, 0, sharePrice));
		}
	}
	
	/**
	 * Include company share to stock account with its company name, company symbol, number of shares, share price
	 * which file name is provided these file contains company share information
	 * @param fileName
	 */
	public void addCompanyShare (String fileName){
		String line = "";
		// Input file is considered as comma separated values format so every line have to be split by comma
		String splitBy = ","; 
		// Reading file which file name is provided to 
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			while((line = bufferedReader.readLine()) != null) {
				String[] companyShareData = line.split(splitBy);
				// line will have company share name, company share symbol, number of shares, price of share
				addCompanyShare(
					companyShareData[0], 					// company share name
					companyShareData[1], 					// company share symbol
					Integer.parseInt(companyShareData[2]), 	// number of shares
					Double.parseDouble(companyShareData[3])	// price of share
				);
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
	public double valueOf() {
		double totalCompanySharePrice = 0;
		for (CompanyShare companyShare : companyShares.values()) totalCompanySharePrice += companyShare.getStockPrice();
		return totalCompanySharePrice;
	}
	
	/**
	 * Buy company shares and add to stock account
	 * @param amount
	 * @param symbol
	 */
	public void buy(int amount, String symbol) {
		// Check is company share already available in stock account with company share symbol which is unique
		if (companyShares.containsKey(symbol)) {
			// Get company share by its symbol it is available in stock account 
			CompanyShare companyShare = companyShares.get(symbol);
			// Check stock account has balance for buying specific amount of share of company share with its current share price
			if (dollars >= amount * companyShare.getSharePrice()) {
				// buy company shares of that amount buy completed then reduce stock account balance by amount to buy * current share price
				if (companyShare.buy(amount)) dollars -= amount * companyShare.getSharePrice();
			} else {
				System.out.println("Stock account not have enough balance to buy shares.");
			}
		} else {
			// Company share is not available in stock account so add company share to stock account 
			// add specified amount of company shares to stock account 
			addCompanyShare(symbol, amount); 
			// if stock account will not have enough balance then company share will be add to stock account with 0 number of shares
		}
	}
	
	/**
	 * Sell company share and add to stock account
	 * @param amount
	 * @param symbol
	 */
	public void sell(int amount, String symbol) {
		// Check is company share already available in stock account with company share symbol which is unique
		if (companyShares.containsKey(symbol)) {
			// Get company share by its symbol it is available in stock account 
			CompanyShare companyShare = companyShares.get(symbol);
			// Check company shares has enough shares for selling specific amount of share of company share with its current share price
			// sell company shares of that amount Sell completed then increment stock account balance by amount to sell * current share price
			if (companyShare.sell(amount)) dollars += amount * companyShare.getSharePrice();
			else System.out.println("Company shares not have enough shares to sell");
		} else {
			// Company share is not available in stock account so add company share to stock account 
			// add 0 amount of company shares to stock account 
			addCompanyShare(symbol, 0); 
		}
	}
	
	public String customerInformation() {
		return "Customer Name = "+customerName+"\nCompany Shares Cost = "+valueOf()+"\nBalance = "+dollars;
	}
	
	public String companyShareInformation() {
		String result = "Company Shares = ";
		for (String companyShareSymbol : companyShares.keySet()) 
			result += "\n\t"+companyShareSymbol+" = "+companyShares.get(companyShareSymbol).toString().replaceAll("\n", "\n\t\t");
		return result;
	}
	
	public String toString() {
		return customerInformation()+"\n"+companyShareInformation();
	}
	
	/**
	 * write stock account information to file which name is given and save this file to storage
	 * @param fileName
	 */
	public void save(String fileName) {
        FileWriter fileWriter;
		try {
			// attach a file to FileWriter
			fileWriter = new FileWriter(fileName);

			String stockAccountInformation = toString();
	        
	        // read character wise from string and write
	        // into FileWriter
	        for (int i = 0; i < stockAccountInformation.length(); i++)
	        	fileWriter.write(stockAccountInformation.charAt(i));

	        //close the file
	        fileWriter.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * print company share information
	 */	
	public void printReport() {
		System.out.println(companyShareInformation());
	}
	
	public static void main(String[] args) {
		StockAccount stockAccount = new StockAccount("RAJ", 10000);
		stockAccount.addCompanyShare("company_shares.csv");
		stockAccount.buy(2, "TCS");
		stockAccount.sell(1, "NICE");
		stockAccount.buy(1, "IO");
		stockAccount.save("RAJ-shares.txt");
		stockAccount.printReport();
	}
}