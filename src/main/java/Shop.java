import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    Scanner scanner = new Scanner(System.in);
    Scanner scannerF = new Scanner(System.in);
    Scanner scannerInt = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Sales> sales = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();

    void addProduct(Product product){
        this.products.add(product);
    }

    ArrayList<Product> allProducts() {
        return this.products;
    }

    void addSales(Sales sale){
        this.sales.add(sale);
    }

    ArrayList<Sales> allSales(){
        return this.sales;
    }

    void addDefaultCustomer(Customer customer){
        this.customers.add(customer);
    }

    void addCustomer(){
        String customerName = JOptionPane.showInputDialog("Welcome to our SHOP. What is your name: ");
        Float wallet = Float.parseFloat((String) JOptionPane.showInputDialog("Dear " + customerName + ", \nwhat amount Eur per Month You are planning to spend: "));

        Float spending = 0f;

        Customer info = new Customer(customerName, wallet, spending);
        this.customers.add(info);
        int newCustomerNo = customers.indexOf(info);

        welcomeMessage(newCustomerNo);
    }

    public void welcomeMessage(int newCustomerNo) {
        String customerName = customers.get(newCustomerNo).getCustomerName();
        JOptionPane.showMessageDialog(null,customerName + " - we are happy that you joint us. Your Membership NO is --> " + (newCustomerNo+1));
    }

    ArrayList<Customer> allCustomers(){
        return customers;
    }

    void listOfAllCustomers(){
        System.out.println("\nCustomers balance: ");
        System.out.println("No|    Name    | Wallet | Spending");
        System.out.println("------------------------------------");
        for (Customer customer : allCustomers()) {
                System.out.println((customers.indexOf(customer)+1) +""+ customer);
                //JOptionPane.showMessageDialog(null, (customers.indexOf(customer) + 1) + "" + customer);
        }
    }

    void defaultCustomers(){
        Customer rasa = new Customer("Rasa", 100, 0);
        Customer jonas = new Customer("Jonas", 200, 0);
        Customer ana = new Customer("Ana", 150, 0);

        addDefaultCustomer(rasa);
        addDefaultCustomer(jonas);
        addDefaultCustomer(ana);
    }

    void defaultProducts(){
        Product milk = new Product("milk", 2.5f, 20, "liter");
        Product apple = new Product("apple", 1.5f, 5, "kg");
        Product sugar = new Product("sugar", 3.15f, 10, "kg");
        Product butter = new Product("butter", 1.15f, 15, "unit");
        Product cheese = new Product("cheese", 14.99f, 50, "kg");
        Product beef = new Product("beef", 17.99f, 50, "kg");
        addProduct(milk);
        addProduct(apple);
        addProduct(sugar);
        addProduct(butter);
        addProduct(cheese);
        addProduct(beef);
    }

    void addNewProduct(){

        String item = (String) JOptionPane.showInputDialog(null,
                "Enter NEW product:",
                "New product",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
        );

        Float price = Float.parseFloat((String) JOptionPane.showInputDialog(null,
                "Enter the price of " + item,
                "Price setter",
                JOptionPane.QUESTION_MESSAGE,
                null, null, null
        ));

        String[] availableMeasurements = {"kg", "ltr", "unt"};
        String measurement = (String) JOptionPane.showInputDialog(null,
                "Select Product measurement",
                "Measurement setter",
                JOptionPane.QUESTION_MESSAGE,
                null,
                availableMeasurements,
                availableMeasurements[2]
        );

        Float quantity = Float.parseFloat((String) JOptionPane.showInputDialog(null,
                "enter quantity of " + item,
                "Quantity setter",
                JOptionPane.QUESTION_MESSAGE,
                null, null,null
        ));

        Product product = new Product(item, price, quantity, measurement);
        addProduct(product);

        System.out.println(product.item + " added successfully.");
    }

    Product productAtIndex(int no){
        return this.products.get(no);
    }

    Customer customerAtIndex(int customerNo){
        return this.customers.get(customerNo);
    }

    Integer indexByCustomerName (String name) {
        for (Customer customer : customers){
            if (name.equals(customer.getCustomerName())){
                return customers.indexOf(customer);
            }
        }
        return null;
    }

    Integer indexByProduct (String name) {
        for (Product product : products){
            if (name.equals(product.getItem())){
                return products.indexOf(product);
            }
        }
        return null;
    }

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

    String[] listOfNames(){
        int howManyNames = allCustomers().size();
        String[] listOfNames = new String[howManyNames];
        for (int i = 0; i < howManyNames; i++){
            listOfNames[i] = allCustomers().get(i).getCustomerName();;
        }
        return listOfNames;
    }

    String[] namesOfProducts(){
        int howManyProducts = allProducts().size();
        String[] namesOfProducts = new String[howManyProducts];
        for (int i = 0; i < howManyProducts; i++){
            namesOfProducts[i] = allProducts().get(i).getItem();;
        }
        return namesOfProducts;
    }

    void buyProduct(){

        String member = (String) JOptionPane.showInputDialog(null,
                "Please show your Memebership card (choose your name)",
                "Recognising the Shop Member",
                JOptionPane.QUESTION_MESSAGE,
                null,
                listOfNames(),
                listOfNames()[0]
        );
       int customerNo = indexByCustomerName(member);

        String  productName = (String) JOptionPane.showInputDialog(null,
                "Choose Product",
                "Purchase",
                JOptionPane.QUESTION_MESSAGE,
                null,
                namesOfProducts(),
                namesOfProducts()[0]
        );
        int productNum = indexByProduct(productName);

        Float buyQuantity = Float.parseFloat(JOptionPane.showInputDialog("Input quantity:"));

        float amount = productAtIndex(productNum).getPrice() * buyQuantity;

        if ((buyQuantity <= productAtIndex(productNum).getQuantity()) && amount <= customerAtIndex(customerNo).getWallet()) {

            System.out.printf(buyQuantity + " " + productAtIndex(productNum).getMeasurement() +" " + productAtIndex(productNum).getItem() + " will cost for " + member + " %3.2f Eur.%n", amount);

            // changing product quantity in Product ArrayList
            float quantityChange = productAtIndex(productNum).getQuantity() - buyQuantity;
            productAtIndex(productNum).setQuantity(quantityChange);

            // adding sale to Sales ArrayList
            Sales sale = new Sales(productAtIndex(productNum).getItem(), buyQuantity, amount);
            this.addSales(sale);

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
        System.out.println("ID|  Product   | Price/Unit | Qty");
        System.out.println("------------------------------------");
        for (Product product : allProducts()) {
            System.out.println((products.indexOf(product)+1) + "" + product);
        }
    }

    void listOfSales(){
        float totalSales = 0;
        System.out.println("\nLook at the sales:");
        System.out.println("    Item    |Sold qty:| Total, eur");
        System.out.println("------------------------------------");
        for (Sales sale : allSales()) {
                System.out.println(sale);
                int index = sales.indexOf(sale);
                totalSales += sales.get(index).getTotalAmount();
        }
        System.out.println("------------------------------------");
        System.out.printf("TOTAL Sales amount %3.2f Eur.%n", totalSales);
    }
}
