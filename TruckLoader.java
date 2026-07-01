import java.util.Scanner;

public class TruckLoader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Truck Loader");
        System.out.print("What is the maximum number of boxes that can fit inside the truck? ");
        int maximumBoxes = scanner.nextInt();
        
        String[] customerName = new String[maximumBoxes];
        double[] weight = new double[maximumBoxes];
        boolean[] dangerousItems = new boolean[maximumBoxes];

        for (int c = 0; c < maximumBoxes; c++) {
            System.out.print("Please enter the customer name for box " + (c + 1) + ": ");
            customerName[c] = scanner.next();
        
            System.out.print("Please enter the weight(kg) for box " + (c + 1) + ": ");
            weight[c] = scanner.nextDouble();
            
            String input;
            boolean validResponse = false;
            do {
                System.out.print("Does box " + (c + 1) + " contain dangerous goods (y/n)? ");
                input = scanner.next().toLowerCase();
                if (input.equals("y") || input.equals("n")) {
                    validResponse = true;
                } else {
                    System.out.println("Invalid response. Please enter 'y' for yes or 'n' for no.");
                }
            } while (!validResponse);
            
            dangerousItems[c] = input.equalsIgnoreCase("y");
        }

        // Moved outside the loop so it only prints once data entry is complete
        System.out.println("\nAll the information regarding the boxes has been entered.");

        while (true) {
            System.out.print("\nList (a)ll boxes information, search boxes by (c)ustomer name or (d)angerous cargo, or (q)uit? ");
            String choice = scanner.next().toLowerCase(); // Added .toLowerCase() for user flexibility
        
            if (choice.equals("a")) {
                listAllBoxes(customerName, weight, dangerousItems);
            } else if (choice.equals("c")) {
                searchByCustomerName(scanner, customerName, weight, dangerousItems); // Passed scanner
            } else if (choice.equals("d")) {
                searchByDangerousItems(scanner, customerName, weight, dangerousItems); // Passed scanner
            } else if (choice.equals("q")) {
                System.out.println("Thank you for using our truck Loader.");
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        
        scanner.close(); // Clean up resources
    }

    private static void listAllBoxes(String[] customerNames, double[] weights, boolean[] dangerousItems) {
        for (int i = 0; i < customerNames.length; i++) {
            String goodsType = dangerousItems[i] ? "Dangerous Goods" : "Non-Dangerous Goods";
            System.out.printf("Box %d Customer name: %s Weight (kg): %.1f %s%n", i + 1, customerNames[i], weights[i], goodsType);
        }
    }

    private static void searchByCustomerName(Scanner scanner, String[] customerNames, double[] weights, boolean[] dangerousItems) {
        System.out.print("What is the customer's name? ");
        String searchName = scanner.next();

        for (int i = 0; i < customerNames.length; i++) {
            if (customerNames[i].equalsIgnoreCase(searchName)) {
                String goodsType = dangerousItems[i] ? "Dangerous Goods" : "Non-Dangerous Goods";
                System.out.printf("Box %d Customer name: %s Weight (kg): %.1f %s%n", i + 1, customerNames[i], weights[i], goodsType);
            }
        }
    }

    private static void searchByDangerousItems(Scanner scanner, String[] customerNames, double[] weights, boolean[] dangerousItems) {
        System.out.print("Search for (d)angerous or (n)on-dangerous? ");
        String searchType = scanner.next().toLowerCase();
        boolean searchDangerous = searchType.equals("d");

        for (int i = 0; i < customerNames.length; i++) {
            if (dangerousItems[i] == searchDangerous) {
                String goodsType = dangerousItems[i] ? "Dangerous Goods" : "Non-Dangerous Goods";
                System.out.printf("Box %d Customer name: %s Weight (kg): %.1f %s%n", i + 1, customerNames[i], weights[i], goodsType);
            }
        } 
    }  
}