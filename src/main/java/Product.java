public class Product {
    final String item;
    float quantity;
    float price;
    final String measurement;

    public Product(String item, float price, float quantity, String measurement){
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.measurement = measurement;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return (int) quantity;
    }

    public String getItem() {
        return item;
    }

    public String getMeasurement() {
        return measurement;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return " | " + item + " | " + price + " per " + measurement + " | " + quantity;
    }

}
