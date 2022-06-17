public class Sales {
    String item;
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

    public void setItem(String item) {
        this.item = item;
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
        return item + " | " + quantity + " | " + totalAmount;
    }
}
