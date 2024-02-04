package lesson12;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
public class CustomerAccount {
    private String cusName;
    private int accNo;
    private double balance;

    public CustomerAccount(String cusName, int accNo, double balance) {
        this.cusName = cusName;
        this.accNo = accNo;
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount >= 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) throws InsufficientBalanceException {
        if (amount >= 0 && balance - amount >= 0 && balance - amount >= 100) {
            balance -= amount;
            return true;
        } else if (amount < 0) {
            return false;
        } else if (balance - amount < 0) {
            throw new InsufficientBalanceException("Withdrawal amount exceeds the current balance.");
        } else {
            throw new InsufficientBalanceException("Balance reach below $100.");
        }
    }

    public double getBalance() {
        return balance;
    }
    public static void main(String[] args) {
        CustomerAccount customerAccount = new CustomerAccount("kukila Motto", 123456, 400);

        System.out.println("Initial Balance: $" + customerAccount.getBalance());

        try {
            customerAccount.deposit(300);
            System.out.println("After Deposit: $" + customerAccount.getBalance());

            customerAccount.withdraw(650);
            System.out.println("After Withdrawal: $" + customerAccount.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

