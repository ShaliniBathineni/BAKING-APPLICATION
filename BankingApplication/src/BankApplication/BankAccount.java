package BankApplication;

import java.util.Random;

public class BankAccount {

    private int accountId;
    private String name;
    private String password;
    private double balance;
    private long phone;

    public int getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public long phoneNumber() {
        return phone;
    }

    public boolean nameException(String name) throws InvalidNameException {
        if (!name.matches("[a-zA-Z ]{3,}")) {
            throw new InvalidNameException("Invalid name! Name must contain only letters and be at least 3 characters long.");
        }
        return true;
    }

    public boolean passwordException(String password) throws InvalidPasswordException {
        if (password.length() < 6 || !password.matches(".*\\d.*") || !password.matches(".*[a-zA-Z].*")) {
            throw new InvalidPasswordException("Invalid password! Password must be at least 6 characters long and contain both letters and numbers.");
        }
        return true;
    }

    public boolean balanceException(double balance) throws MinBalanceException {
        if (balance >= 500) {
            return true;
        } else {
            throw new MinBalanceException("Enter amount more than 500");
        }
    }

    public boolean numberException(long number) throws InvalidPhoneNumberException {
        if (number < 10000000000L && number > 6000000000L) {
            return true;
        } else {
            throw new InvalidPhoneNumberException("Enter a valid Indian phone number.");
        }
    }

    private BankAccount(String name, String password, long number, double balance) throws MinBalanceException, InvalidPhoneNumberException {
        Random r = new Random();
        int account = r.nextInt(1000000);
        this.accountId = account;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.phone = number;
    }

    public BankAccount() {}

    @Override
    public String toString() {
        return "BankAccount [accountId=" + accountId + ", name=" + name + ", password=" + password + ", balance=" + balance + "]";
    }

    BankAccount[] accounts = new BankAccount[5];
    int index = 0;

    public BankAccount createBankAccount(String name, String password, long number, double balance) throws MinBalanceException, InvalidPhoneNumberException {
        if (index < accounts.length) {
            BankAccount account = new BankAccount(name, password, number, balance);
            accounts[index] = account;
            System.out.println("Account is created successfully, Account ID is: " + accounts[index].accountId);
            index++;
            return account;
        } else {
            System.out.println("Account storage is full.");
            return null;
        }
    }

    public BankAccount logIn(int accountId, String password) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].accountId == accountId && accounts[i].password.equals(password)) {
                System.out.println("Account logged in successfully.");
                return accounts[i];
            }
        }
        System.out.println("Invalid Account ID or Password.");
        return null;
    }

    public void withdraw(double amount) throws LowAmountException {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn Successfully, Current Balance: " + balance);
        } else {
            throw new LowAmountException("Insufficient balance.");
        }
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Successfully, New Balance is: " + balance);
        } else {
            throw new NegativeAmountException("Amount should be greater than 0.");
        }
    }

    public void balance() {
        System.out.println("Current Balance: " + balance);
    }

    public void showDetails() {
        System.out.println("Your Account ID: " + this.accountId);
        System.out.println("Your Name: " + this.name);
        System.out.println("Your Current Balance: " + this.balance);
    }
}
