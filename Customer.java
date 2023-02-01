import java.util.ArrayList;

public class Customer {
    private String name;
    private Status status;
    private final int id;
    private static int idCounter = 1;
    private ArrayList<BankAccount> accounts;


    public Customer(String name, Status status) {
        this.id = idCounter++;
        this.name = name;
        this.status = status;
        this.accounts = new ArrayList<BankAccount>();


    }

    public void addAccount(BankAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Account can't be null");
        }
        if (accounts.contains(account)) {
            throw new IllegalArgumentException("Customer already has this account");
        }
        if (account.getOwner() != this) {
            throw new IllegalArgumentException("Account already has an owner");
        }
        this.accounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        if (account.getOwner() == this) {
            throw new IllegalArgumentException("you can't remove an account that has an owner");
        }
        if (!accounts.contains(account)) {
            throw new IllegalArgumentException("Customer doesn't have this account");
        }

        if (accounts.size() > 0 && accounts.contains(account)) {
            accounts.remove(account);
        } else {
            throw new IllegalArgumentException("Customer has no accounts");
        }

    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Name can't be null, empty or have a number in it");
        } else {
            this.name = name;
        }

    }

    public void setStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("Status can't be null");
        } else {
            this.status = status;
        }

    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
}
