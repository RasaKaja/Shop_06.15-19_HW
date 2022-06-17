public class Product {
    String item;
    float quantity;
    float price;

    public Product(String item, float price, float quantity){
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return (int) quantity;
    }

    @Override
    public String toString() {
        return " | " + item + " | " + price + " | " + quantity;
    }



}
