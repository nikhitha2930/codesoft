import java.util.Scanner;

class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit method
    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposit successful! New balance: $" + String.format("%.2f", balance);
        } else {
            return "Deposit amount must be greater than zero.";
        }
    }

    // Withdraw method
    public String withdraw(double amount) {
        if (amount > balance) {
            return "Insufficient balance for this withdrawal.";
        } else if (amount <= 0) {
            return "Withdrawal amount must be greater than zero.";
        } else {
            balance -= amount;
            return "Withdrawal successful! New balance: $" + String.format("%.2f", balance);
        }
    }

    // Check balance method
    public String checkBalance() {
        return "Your current balance is: $" + String.format("%.2f", balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println(account.checkBalance());
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleWithdrawal();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }

    private void handleDeposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        System.out.println(account.deposit(amount));
    }

    private void handleWithdrawal() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        System.out.println(account.withdraw(amount));
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount account = new BankAccount("123456789", 500.00);

        // Create an ATM instance for the account
        ATM atm = new ATM(account);

        // Start the ATM interface
        atm.start();
    }
}
