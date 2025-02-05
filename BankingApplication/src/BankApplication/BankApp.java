package BankApplication;

	import java.util.Scanner;
	public class BankApp {
		public static void main(String[] args) throws LowAmountException {
			{
				BankAccount account = new BankAccount();
				BankAccount logInUser = null;
				while (true) {

					Scanner sc = new Scanner(System.in);

					if (logInUser == null) {
						System.out.println("wel-come to penta bank");
						System.out.println("1:Create account");
						System.out.println("2:logIn");
						System.out.println("3:Exit");
						System.out.println("Choose option");
						int option = sc.nextInt();

						switch (option) {
						case 1: {
							
							
							String	name = sc.nextLine();
							 
							boolean checkName = false;
							while (!checkName) {
								try {
									System.out.println("Enter name:");
									name = sc.nextLine();
									checkName = account.nameException(name);
								} catch (InvalidNameException e) {
									System.err.println(e.getMessage());
								}
							}
							String password = "";
							boolean checkPassword = false;
							while (!checkPassword) {
								try {
									System.out.println("Enter password:");
									password = sc.nextLine();
									checkPassword = account.passwordException(password);
								} catch (InvalidPasswordException e) {
									System.err.println(e.getMessage());
								}
							}

							sc.nextLine();
							boolean checkPhoneNum = false;
							long number = 0;
							while (!checkPhoneNum) {
								try {
									System.out.println("enter phone number");
									number = sc.nextLong();
									checkPhoneNum = account.numberException(number);
								} catch (InvalidPhoneNumberException e) {

									System.err.println(e.getMessage());
								}

							}
							sc.nextLine();

							double balance = 0;
							boolean checkBalance = false;

							while (!checkBalance) {
								try {
									System.out.println("enter balance");
									balance = sc.nextDouble();
									checkBalance = account.balanceException(balance);
								} catch (MinBalanceException e) {
									System.err.println(e.getMessage());
								}
							}

							try {
								account.createBankAccount(name, password, number, balance);
							} catch (MinBalanceException | InvalidPhoneNumberException e) {
								e.printStackTrace();
							}

							break;
						}
						case 2: {
							System.out.println("enter the account ID");
							int accountId = sc.nextInt();
							System.out.println("enter the  Password");
							String password = sc.next();
							logInUser = account.logIn(accountId, password);
							break;
						}
						case 3: {
							System.out.println("Good Bye !");
							System.exit(0);
						}
						default:
							System.out.println("wrong input");

						}
					} else {
						System.out.println("Welcome to Pentagon Bank! " + logInUser.getName());
						System.out.println("1:show details");
						System.out.println("2:withdraw");
						System.out.println("3:deposit ");
						System.out.println("4:balance ");
						System.out.println("5:logout ");
						int entry = sc.nextInt();
						switch (entry) {
						case 1: {
							logInUser.showDetails();
							break;
						}
						case 2:
							try {
								System.out.println("enter withdraw amount");
								double withdraw = sc.nextDouble();
								logInUser.withdraw(withdraw);
							} catch (LowAmountException e) {
								System.out.println(e.getMessage());
							}

							break;
						case 3:

							System.out.println("enter Deposit amount");
							double deposit = sc.nextDouble();
							try {
								logInUser.deposit(deposit);
							} catch (NegativeAmountException e) {

								System.out.println(e.getMessage());
							}
							break;
						case 4:
							logInUser.balance();
							break;
						case 5:
							logInUser = null;
							System.out.println("Exited Succesfully");
							break;
						default:
							System.out.println("Oops!! wrong entry");
						}
					}

				}

			}

		}

	}