public class AccountTest {

	public static void main(String[] args) {
		double amountToAdd = 150;
		Account account = new Account(amountToAdd);
		if (amountToAdd == account.balance()) {
			System.out.println("PASS: proper amount added to account balance");
		} else {
			System.out.println("FAIL: proper amount added to account balance");
		}
		double amountToDebit = 40;
		if (amountToDebit == account.debit(amountToDebit)) {
			System.out.println("PASS: proper amount debited got correctly");
		} else {
			System.out.println("FAIL: proper amount debited got correctly");
		}
		if (account.balance() == (amountToAdd - amountToDebit)) {
			System.out.println("PASS: proper amount reduced from balance after debit correct");
		} else {
			System.out.println("FAIL: proper amount reduced from balance after debit correct");
		}
		double moreAmountToDebit = 60;
		double balanceBeforeTransaction = account.balance();
		amountToDebit = account.balance() + moreAmountToDebit;
		if (0 == account.debit(amountToDebit)) {
			System.out.println("PASS: debit amount excids account balance");
		} else {
			System.out.println("FAIL: debit amount excids account balance");
		}
		if (balanceBeforeTransaction == account.balance()) {
			System.out.println("PASS: balance remain unchanged after debit not happen or fail");
		} else {
			System.out.println("FAIL: balance remain unchanged after debit not happen or fail");
		}
		double lessAmountToDebit = 30;
		balanceBeforeTransaction = account.balance();
		amountToDebit = account.balance() - lessAmountToDebit;
		if (amountToDebit == account.debit(amountToDebit)) {
			System.out.println("PASS: proper amount debited got correctly even after debit fail occurs");
		} else {
			System.out.println("FAIL: proper amount debited got correctly even after debit fail occurs");
		}
		if (account.balance() == (balanceBeforeTransaction - amountToDebit)) {
			System.out.println("PASS: proper amount reduced from balance after debit correct even after debit fail occurs");
		} else {
			System.out.println("FAIL: proper amount reduced from balance after debit correct even after debit fail occurs");
		}
		amountToDebit = account.balance();
		if (amountToDebit == account.debit(amountToDebit) && 0 == account.balance()) {
			System.out.println("PASS: all amount debited from account");
		} else {
			System.out.println("FAIL: all amount debited from account");
		}
	}

}