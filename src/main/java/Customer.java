public class Customer {
    private final String customerName;
    private float wallet;
    float spending;

    public Customer(String customerName, float wallet, float spending) {
        this.customerName = customerName;
        this.wallet = wallet;
        this.spending = spending;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public void setSpending(float spending) {
        this.spending = spending;
    }

    public float getSpending() {
        return spending;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return " | " + customerName + " | " + getWallet() + " | " + spending;
    }
}
