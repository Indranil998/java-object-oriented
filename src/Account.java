public class Account {
	private double amount;
	
	Account(double amount) {
		this.amount = amount;
	}
	
	public double debit(double amount) {
		if (this.amount >= amount) {
			this.amount -= amount;
			return amount;
		} else {
			System.out.println("―Debit amount exceeded account balance.");
			return 0;
		}
	}
	
	public double balance() {
		return amount;
	}
}