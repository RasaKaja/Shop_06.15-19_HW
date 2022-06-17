public class Sales {
    String item;
    float quantity;
    float totalAmount;
    //float price;

    public Sales(String item, float quantity, float totalAmount) {
        this.item = item;
        this.quantity = quantity;
        //this.price = getPrice();
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public float getPrice() {
//        return price;
//    }
//
//    public void setPrice(float price) {
//        this.price = price;
//    }

    @Override
    public String toString() {
        return item + " | " + quantity + " | " + totalAmount;
    }
}
