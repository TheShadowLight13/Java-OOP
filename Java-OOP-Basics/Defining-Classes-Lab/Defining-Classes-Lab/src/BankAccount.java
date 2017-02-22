
public class BankAccount {

    private int id;
    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {

        if (amount < 0) {
            System.out.println("Invalid amount");
            return;
        }

        this.balance += amount;
    }

    public void withDraw(double amount) {

        if (amount > this.balance) {
            System.out.println("Insufficient balance");
            return;
        }

        this.balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.id, this.balance);
    }
}
