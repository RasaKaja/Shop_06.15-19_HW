public class Sales {
    final String item;
    float quantity;
    float totalAmount;

    public Sales(String item, float quantity, float totalAmount) {
        this.item = item;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public String getItem() {
        return item;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return String.format(" %10s |%9.2f| %3.2f", item, quantity,totalAmount);
    }
}
