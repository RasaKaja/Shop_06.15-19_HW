import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        shop.defaultCustomers();
        shop.defaultProducts();

        System.out.println("Welcome to the SHOP!");
        String menuChoice = "";

        while (!menuChoice.equals("0")) {
            System.out.println("\nPlease choose an option below:");
            System.out.println("""
                    1. add New Customer
                    2. add New Product
                    3. restock Product
                    4. show All Products
                    5. buy Product
                    6. show Sales
                    7. show Customer Balance
                    0. QUIT
                    """);

            menuChoice = scanner.nextLine();

            switch (menuChoice) {
                case "1":
                    shop.addCustomer();
                    break;
                case "2":
                    shop.addNewProduct();
                    break;
                case "3":
                    shop.restockProduct();
                    break;
                case "4":
                    shop.listOfProducts();
                    break;
                case "5":
                    shop.buyProduct();
                    break;
                case "6":
                    shop.listOfSales();
                    break;
                case "7":
                    shop.listOfAllCustomers();
                    break;
                case "0":
                    System.exit(1);
                default:
                    System.out.println("Please choose the number from 1 to 7, o '0' for QUIT.");
            }
        }
    }
}

/*Possible to add customers
possible to add products
possible to buy products
possible to see sales
Product's quantity should reduce in shop once bought
customers will have a balance that gets reduced based on product the buy and quantity
should show error if not enough money or product*/