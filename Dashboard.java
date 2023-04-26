import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dashboard {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. View Menu List");
            System.out.println("2. Edit existing Menu");
            System.out.println("3. Add New Menu");
            System.out.println("4. Change existing Order Status");
            System.out.println("5. View Consolidated Collection of the Day");
            System.out.println("6. View Individual Order information");
            System.out.println("7. Add new Order Details");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    viewMenuList();
                    break;
                case 2:
                    //editMenu();
                    break;
                case 3:
                    //addNewMenu();
                    break;
                case 4:
                    //changeOrderStatus();
                    break;
                case 5:
                    //viewConsolidatedCollection();
                    break;
                case 6:
                    //viewIndividualOrderInformation(args);
                    break;
                case 7:
                    //addNewOrder();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // MODULE 1
    // 1. View Menu List
    public static void viewMenuList(){
        viewMenu menulist= new viewMenu();
        viewMenu.viewMenuList();

    }

    // 6. View Individual Order Details
    public static void viewIndividualOrderInformation(String[] args) {
        ViewIndividualOrder viewOrder = new ViewIndividualOrder();
        try {
            viewOrder.main(args);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    
}
