package BankApplication;

	public class LowAmountException extends Exception {
		public LowAmountException(String string) {

			System.out.println(string);
		}

}
