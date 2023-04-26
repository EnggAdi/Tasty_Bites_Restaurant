import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class viewMenu {
    static void viewMenuList() {

        System.out.println("Menu List:");
        BufferedReader menuBr;

        try{
            String menuDetailsFile ="menuDetails.csv";
            FileReader menuFr = new FileReader(menuDetailsFile);
            menuBr = new BufferedReader(menuFr);
            String line;
            while ((line = menuBr.readLine()) != null) {
                String[] items = line.split(",");
                System.out.printf("%s, %s, %s%n", items[0], items[1], items[2]);

            }
            menuBr.close();
        } catch (IOException e) {
            System.err.println("Error reading menu file: " + e.getMessage());
        }
    }

}

