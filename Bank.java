import java.util.Scanner;

public class Bank {
    public static void main(String args[]) {
        // Initialising the Scanner class to take input from user
        Scanner sc = new Scanner(System.in);

        // Initialize the customerid
        int customerid = 0;

        // Initializing array where we will be storing the Name and Amount
        String[] userName = new String[250]; // Here the size of our Array is 250 so we can store 250 customers
        Double[] userBalance = new Double[250];

        for (; true;) {
            // Displaying the menu
            System.out.println("Welcome to Jinit's Bank");
            System.out.println("Enter a option from below");
            System.out.println("(1) Add Customer to Bank");
            System.out.println("(2) Change customer Name");
            System.out.println("(3) Check Account Balance");
            System.out.println("(4) Make a Deposit");
            System.out.println("(5) Make a Withdrawal");
            System.out.println("(6) Summary of All Accounts");
            System.out.println("(0) Quit");

            // Taking input from the user
            int userInput = sc.nextInt();

            // Relevant steps to be followed after taking input
            if (userInput == 1) {
                System.out.println("Welcome to Jinit's Bank");
                System.out.println("Please enter the following Information");
                System.out.println("Please enter your Full Name : ");
                String name = sc.nextLine();
                userName[customerid] = name;
                sc.nextLine(); // Adding extra .nextLine so that we dont mix up String and double
                System.out.println("Enter your initial Deposit : ");
                double deposit = sc.nextDouble();
                userBalance[customerid] = deposit;
                System.out.println("Your Account is sucessfully created !");
                System.out.println("Your unique Customer Id is " + customerid);
                customerid++;
            } else if (userInput == 2) {
                System.out.println("Welcome to update the Customer Name");
                System.out.print("Please enter the unique Customer Id : ");
                int id = sc.nextInt();
                System.out.println("Enter your updated Full Name : ");
                String updated = sc.nextLine();
                userName[id] = updated;
                sc.nextLine(); // Adding extra .nextLine so that we dont mix up String and double
                System.out.println("Your Updates have been processed.");
                System.out.println("Please wait for 24 hours for the changes to be reflected.");
            } else if (userInput == 3) {
                System.out.println("Welcome to the Balance Information");
                System.out.println("Enter your unique Customer Id : ");
                int id = sc.nextInt();
                double Balance = userBalance[id];
                System.out.println("Your Balance as of Today is : $" + Balance);
            } else if (userInput == 4) {
                System.out.println("Welcome to Deposit Portal");
                System.out.println("Please enter your unique Customer Id : ");
                int id = sc.nextInt();
                System.out.println("Please enter your New Deposit Amount");
                double deposit = sc.nextDouble();
                double balance = deposit + userBalance[id];
                userBalance[id] = balance;
                System.out.println("Your Deposit is Successful");
                System.out.println("The Balance in account with Customer Id " + id + "  :$" + balance);
            } else if (userInput == 5) {
                System.out.println("Welcome to Withdrawal Portal");
                System.out.println("Please enter your unique Customer Id : ");
                int id = sc.nextInt();
                System.out.println("Please enter your Withdrawal Amount");
                double Withdrawal = sc.nextDouble();
                if (Withdrawal > userBalance[id]) {
                    System.out.println("You have insufficient balance");
                } else {
                    double balance = userBalance[id] - Withdrawal;
                    userBalance[id] = balance;
                    System.out.println("Your Deposit is Successful");
                    System.out.println("The Balance in account with Customer Id " + id + "  :$" + balance);
                }
            } else if (userInput == 6) {
                System.out.println("Welcome to the Summary of our Bank");
                double Balance = 0;
                for (int i = 0; i < customerid; i++) {
                    Balance = Balance + userBalance[i];
                    System.out.println("CustomerID is  " + i + "the name of the customer is " + userName[i]
                            + " and they have balance " + userBalance[i]);
                }
                System.out.println("The total amount at bank is " + Balance);
            } else if (userInput == 0) {
                System.exit(0);
            } else {
                System.out.println("Please enter valid menu option");
            }
        }
    }
}