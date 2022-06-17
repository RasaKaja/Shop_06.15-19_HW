import java.util.Scanner;

public class Main {

    Shop shop = new Shop();
    Scanner scanner = new Scanner(System.in);
    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerInt2 = new Scanner(System.in);
    Scanner scannerF = new Scanner(System.in);
    Scanner scannerF2 = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        Shop shop = new Shop();
        //shop.addCustomer();
        //shop.addCustomer();
        main.defaultCustomers();
        main.listOfAllCustomers();
        main.defaultProducts();
//        //main.addNewProduct();
        main.listOfProducts();
        main.buyProduct();
        //main.buyProduct();

//        //main.restockProduct();
        //main.listOfProducts();
        main.listOfSales();
        main.listOfAllCustomers();
        main.listOfProducts();


    }

    //some products are by default at the shop
    void defaultProducts(){
        Product milk = new Product("milk", 2.5f, 20);
        Product apple = new Product("apple", 1.5f, 5);
//        Product sugar = new Product("sugar", 3.15f, 10);
//        Product butter = new Product("butter", 1.15f, 15);
//        Product cheese = new Product("cheese", 14.99f, 50);
//        Product beef = new Product("beef", 17.99f, 50);
        shop.addProduct(milk);
        shop.addProduct(apple);
//        shop.addProduct(sugar);
//        shop.addProduct(butter);
//        shop.addProduct(cheese);
//        shop.addProduct(beef);
    }

    void defaultCustomers(){
        Customer rasa = new Customer("Rasa", 200, 0);
//        Customer jonas = new Customer("Jonas", 500, 0);
//        Customer ana = new Customer("Ana", 300, 0);

        shop.addDefaultCustomer(rasa);
//        shop.addDefaultCustomer(jonas);
//        shop.addDefaultCustomer(ana);
    }

    void listOfAllCustomers(){
        System.out.println("\nCustomers basic info: ");
        System.out.println("No | Name | Wallet | Spending");
        for (Customer customer: shop.allCustomers()){
            System.out.println((shop.customers.indexOf(customer)+1) +""+ customer);
        }
    }

    void listOfProducts(){
        System.out.println("\nIn the shop we have: ");
        System.out.println("ID | Product | Price | Qty");
        for (Product product : shop.allProducts()) {
            System.out.println((shop.products.indexOf(product)+1) + "" + product);
        }
    }

    void listOfSales(){
        System.out.println("\nLook at the sales:");
        System.out.println("Item | Sold qty: | Total, eur");
        for (Sales sale : shop.allSales()){
            //System.out.println((shop.sales.indexOf(sale)+1) + ". " + sale);
            System.out.println(sale);
        }
    }

    void addNewProduct(){
        System.out.println("Entering NEW product to the shop.");
        System.out.println("NEW product is:");
        String type = scanner.nextLine();

        System.out.println(type + " price is:");
        float price = Float.parseFloat(scannerF.nextLine());

        System.out.println("and TOTAL quantity:");
        float quantity = scannerF.nextInt();

        Product product = new Product(type, price, quantity);
        shop.addProduct(product);

        System.out.println(product.item + " added successfully.");
    }

    void restockProduct(){
        System.out.println("\nChoose the index of Product you want to restock: ");
        int no = scannerInt.nextInt();

        System.out.println(productAtIndex(no));
        //System.out.println(shop.products.get(1));

        //changing price
        System.out.println("Would you like to change the price of " + productAtIndex(no).item + "? (y/n)"); //everywhere "shop.products.get(no-1)" changed to "productAtIndex"
        String changePrice = scanner.nextLine();
        if (changePrice.equals("y")){
            System.out.println("Input please NEW price: ");
            float price = Float.parseFloat(scannerF.nextLine());
            productAtIndex(no).setPrice(price);
        }

        //changing quantity
        System.out.println("Would you like to change the quantity of " + productAtIndex(no).item + "? (y/n)");
        String changeQty = scanner.nextLine();
        if (changeQty.equals("y")){
            System.out.println("Input please NEW quantity: ");
            float quantity = Float.parseFloat(scannerF.nextLine());
            productAtIndex(no).setQuantity(quantity);
        }

        System.out.println(productAtIndex(no));
    }

    Product productAtIndex(int no){
        return shop.products.get((no-1));
    }

    Customer customerAtIndex(int customerNo){
        return shop.customers.get((customerNo-1));
    }

    void buyProduct(){
        System.out.print("\nEnter please your No: ");
        int customerNo = scannerInt.nextInt();

        System.out.print("Input product ID you want to buy: ");
        int productNum = scannerInt2.nextInt();

        System.out.print("Input quantity: ");
        float buyQuantity = Float.parseFloat(scannerF2.nextLine());

        float amount = productAtIndex(productNum).price * buyQuantity;
        System.out.println(buyQuantity + " " + productAtIndex(productNum).item + " will cost you: " + amount);

        // changing product quantity in Product ArrayList
        float quantityChange = productAtIndex(productNum).getQuantity() - buyQuantity;
        productAtIndex(productNum).setQuantity(quantityChange);

        // adding sale to Sales ArrayList
        Sales sale = new Sales(productAtIndex(productNum).item, buyQuantity, amount);
        shop.addSales(sale);

        // changing customer balance
        float walletChange = customerAtIndex(customerNo).getWallet() - amount;
        customerAtIndex(customerNo).setWallet(walletChange);

        float balanceChange = customerAtIndex(customerNo).getSpending() + amount;
        customerAtIndex(customerNo).setSpending(balanceChange);
    }

}

/*Possible to add customers
possible to add products
possible to buy products
possible to see sales
Products quantity should reduce in shop once bought
customers will have a balance that gets reduced based on product the buy and quantity
should show error if not enough money or product*/