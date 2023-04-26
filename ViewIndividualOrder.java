//package Tasty_Bites_Restaurant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ViewIndividualOrder {
    public static void main(String[] args) throws IOException {

        // Take Order ID as an input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the order ID:");
        int orderId = scanner.nextInt();

        String lineread= ""; //empty string created which will store the read line from csv file for a particular iteration

        String orderDetailsFile ="orderDetails.csv";
        FileReader fr;
        BufferedReader br;
        String csvSplitBy = ",";
        try {
            fr = new FileReader(orderDetailsFile);
            br =new BufferedReader(fr);
            
            Boolean flag=false;
            while((lineread=br.readLine())!=null){
                String[] orderDetails=lineread.split(csvSplitBy);

                // Print the contents of the orderDetails array
                //System.out.println(Arrays.toString(orderDetails));

                //check if the order id entered matches the order id present in orderDetails.csv
                
                if(Integer.parseInt(orderDetails[0]) == orderId){ //converting the string orderDetails[0] to an integer using the Integer.parseInt()
                    
                    //System.out.println("Order ID is valid");
                    // Display the order information
                    System.out.println("OrderID: " + orderDetails[0]);
                    System.out.println("OrderDate: " + orderDetails[1]);
                    System.out.println("TotalBillingAmount: " + orderDetails[2]);
                    System.out.println("OrderStatus: " + orderDetails[4]);
                    System.out.println("---------"+"Item wise breakup"+"----------");
                    System.out.println();

                    // This will print order details 
                    // now we need item wise breakup of the order Detail

                    // item details is present at orderDetails[3]
                    // need to split the item and quantity etails and store in an array
                    // iterate through each item and fetch its details from menuDetails.csv

                    String[] items = orderDetails[3].split(" ");
                    //System.out.println(Arrays.toString(items));
                    double OverallTotalCost=0;

                    for (int i = 0; i < items.length; i += 2) {
                        String itemId = items[i];
                        int item_quantity = Integer.parseInt(items[i + 1]);
                        
                        //System.out.println(Arrays.asList(itemId, quantity));
                        String menuDetailsFile ="menuDetails.csv";
                        FileReader menuFr = new FileReader(menuDetailsFile);
                        BufferedReader menuBr = new BufferedReader(menuFr);
                        String lineread2=""; 
                        while((lineread2=menuBr.readLine())!=null){
                            String[] menuDetails= lineread2.split(csvSplitBy);
                            if(itemId.equals(menuDetails[0])){
                                // calculate the cost of the item
                                double itemCost = Double.parseDouble(menuDetails[2]);
                                double totalItemCost = itemCost * item_quantity;
                                
                                // print the item details
                                //System.out.println("------- "+menuDetails[0]+" "+menuDetails[1]+" -------");
                                System.out.println("-----"+"Item Order Details"+"-----");
                                System.out.println("Item ID: " + itemId);
                                System.out.println("Item Name: "+menuDetails[1]);
                                System.out.println("Item Cost: " + itemCost);
                                System.out.println("Order Quantity: " + item_quantity);
                                System.out.println("Total Cost for the Item: " + totalItemCost);
                                OverallTotalCost+=totalItemCost;
                                System.out.println("");
                                break; // break out of the loop once the item details have been found
                            }

                        }
                        // close the menuDetails file reader
                        menuBr.close();
                        menuFr.close();

                    


                    }
                    System.out.println(" ");
                    System.out.println("Over All Total Cost= "+OverallTotalCost);
                    

                    

                    

                }else{
                    flag=true;

                }

            }
            if(flag=true){
                System.out.println("     !!!! WARNING !!!    ");
                System.out.println();
                System.out.println("--- Please enter a valid Order ID ---");
            }
            fr.close();
            br.close();
            

        
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
        
}
