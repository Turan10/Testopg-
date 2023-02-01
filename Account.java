public class Account extends BankAccount {
    private double balance;
    private Customer owner;
    public Account(Customer owner) {
        this.owner = owner;
    }
    public void setOwner(Customer owner) {
        this.owner = owner;
    }
    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
    public int getID() {
        return owner.getId();
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public double getBalance() {
        return balance;
    }
    public Customer getOwner() {
        return owner;
    }
}

