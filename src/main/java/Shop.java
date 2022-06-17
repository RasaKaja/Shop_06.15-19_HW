import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    Scanner scanner = new Scanner(System.in);
    Scanner scannerF = new Scanner(System.in);
    Scanner scannerF2 = new Scanner(System.in);
    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerInt2 = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Sales> sales = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();

    void addProduct(Product product){
        products.add(product);
    }

    ArrayList<Product> allProducts() {
        return products;
    }

    void addSales(Sales sale){
        sales.add(sale);
    }

    ArrayList<Sales> allSales(){
        return sales;
    }

    void addDefaultCustomer(Customer customer){
        customers.add(customer);
    }

    void addCustomer(){
        System.out.print("Welcome to our SHOP. What is your name: ");
        String customerName = scanner.nextLine();

        System.out.print("What amount per Month You planning to spend: ");
        float wallet = Float.parseFloat(scannerF.nextLine());

        float spending = 0f;

        Customer info = new Customer(customerName, wallet, spending);
        customers.add(info);

        //welcomeMessage(customerName);
    }

    private void welcomeMessage(String customerName) {
        int membershipNo = customers.indexOf(customerName);
        System.out.println(customerName + "  - we are happy that you joint us. Your Membership NO is -> " + membershipNo);
    }

    ArrayList<Customer> allCustomers(){
        return customers;
    }

    void listOfAllCustomers(){
        System.out.println("\nCustomers balance: ");
        System.out.println("No | Name | Wallet | Spending");
        for (Customer customer: allCustomers()){
            System.out.println((customers.indexOf(customer)+1) +""+ customer);
        }
    }

    void defaultCustomers(){
        Customer rasa = new Customer("Rasa", 10, 0);
        Customer jonas = new Customer("Jonas", 500, 0);
        Customer ana = new Customer("Ana", 300, 0);

        addDefaultCustomer(rasa);
        addDefaultCustomer(jonas);
        addDefaultCustomer(ana);
    }

    void defaultProducts(){
        Product milk = new Product("milk", 2.5f, 20);
        Product apple = new Product("apple", 1.5f, 5);
        Product sugar = new Product("sugar", 3.15f, 10);
        Product butter = new Product("butter", 1.15f, 15);
        Product cheese = new Product("cheese", 14.99f, 50);
        Product beef = new Product("beef", 17.99f, 50);
        addProduct(milk);
        addProduct(apple);
        addProduct(sugar);
        addProduct(butter);
        addProduct(cheese);
        addProduct(beef);
    }

    void addNewProduct(){
        System.out.println("Entering NEW product to the shop.");
        System.out.print("NEW product is: ");
        String type = scanner.nextLine();

        System.out.print(type + " unit price is: ");
        float price = Float.parseFloat(scannerF.nextLine());

        System.out.print("and TOTAL quantity: ");
        float quantity = scannerF.nextInt();

        Product product = new Product(type, price, quantity);
        addProduct(product);

        System.out.println(product.item + " added successfully.");
    }

    Product productAtIndex(int no){
        return products.get((no-1));
    }

    Customer customerAtIndex(int customerNo){
        return customers.get((customerNo-1));
    }

//    Sales salesAtIndex(int num){
//        return sales.get((num-1));
//    }

    void restockProduct(){
        System.out.print("\nChoose the index of Product you want to restock: ");
        int no = scannerInt.nextInt();

        System.out.println(productAtIndex(no));

        //changing price
        System.out.print("Would you like to change the price of " + productAtIndex(no).item + "? (y/n)");
        String changePrice = scanner.nextLine();
        if (changePrice.equals("y")){
            System.out.print("Input please NEW price: ");
            float price = Float.parseFloat(scannerF.nextLine());
            productAtIndex(no).setPrice(price);
        }

        //changing quantity
        System.out.print("Would you like to change the quantity of " + productAtIndex(no).item + "? (y/n)");
        String changeQty = scanner.nextLine();
        if (changeQty.equals("y")){
            System.out.print("Input please NEW quantity: ");
            float quantity = Float.parseFloat(scannerF.nextLine());
            productAtIndex(no).setQuantity(quantity);
        }

        System.out.println(productAtIndex(no));
    }

    void buyProduct(){
        System.out.print("\nEnter please your No: ");
        int customerNo = scannerInt.nextInt();

        System.out.print("Input product ID you want to buy: ");
        int productNum = scannerInt2.nextInt();

        System.out.print("Input quantity: ");
        float buyQuantity = Float.parseFloat(scannerF2.nextLine());

        float amount = productAtIndex(productNum).price * buyQuantity;

        if ((buyQuantity <= productAtIndex(productNum).getQuantity()) && amount <= customerAtIndex(customerNo).getWallet()) {

            System.out.println(buyQuantity + " " + productAtIndex(productNum).item + " will cost you: " + amount + " Eur.");

            // changing product quantity in Product ArrayList
            float quantityChange = productAtIndex(productNum).getQuantity() - buyQuantity;
            productAtIndex(productNum).setQuantity(quantityChange);

            // adding sale to Sales ArrayList
            Sales sale = new Sales(productAtIndex(productNum).item, buyQuantity, amount);
            addSales(sale);

            //String itemChange = salesAtIndex(productNum).getItem();
            //salesAtIndex(productNum).setItem(itemChange);
            //salesAtIndex(productNum).getItem();
//        salesAtIndex(productNum).setQuantity(quantityChange);
//        salesAtIndex(productNum).setTotalAmount(amount);

            // changing customer balance
            float walletChange = customerAtIndex(customerNo).getWallet() - amount;
            customerAtIndex(customerNo).setWallet(walletChange);

            float balanceChange = customerAtIndex(customerNo).getSpending() + amount;
            customerAtIndex(customerNo).setSpending(balanceChange);
        } else if (buyQuantity > productAtIndex(productNum).getQuantity()){
            System.out.println("We don't have at the moment quantity you need.");
        } else {
            System.out.println("Your wallet is empty or not enough money for this purchase.");
        }
    }

    void listOfProducts(){
        System.out.println("\nIn the shop we have: ");
        System.out.println("ID | Product | Price | Qty");
        for (Product product : allProducts()) {
            System.out.println((products.indexOf(product)+1) + "" + product);
        }
    }

    void listOfSales(){
        float totalSales = 0;
        System.out.println("\nLook at the sales:");
        System.out.println("Item | Sold qty: | Total, eur");
        for (Sales sale : allSales()) {
                System.out.println(sale);
                int index = sales.indexOf(sale);
                totalSales += sales.get(index).getTotalAmount();
        }
        System.out.println("TOTAL Sales amount " + totalSales + " Eur.");
    }

}
