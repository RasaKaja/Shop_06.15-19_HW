import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    Scanner scanner = new Scanner(System.in);
    Scanner scannerF = new Scanner(System.in);
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

        System.out.print("What amount of Eur You planning to spend: ");
        float wallet = Float.parseFloat(scannerF.nextLine());

        float spending = 0f;

        Customer info = new Customer(customerName, wallet, spending);
        customers.add(info);
    }

    void updateCustomerInfo(Customer customer){
        customers.add(customer);
    }

    ArrayList<Customer> allCustomers(){
        return customers;
    }

//    void listOfAllCustomers(){
//        System.out.println("Customers basic info: ");
//        System.out.println("No | Name | Wallet | Spending");
//        for (Customer customer: customers){
//            System.out.println(customers.indexOf(customer) +""+ customer);
//        }
//    }


}
