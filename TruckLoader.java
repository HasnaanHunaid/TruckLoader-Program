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

		for (int c = 0; c < maximumBoxes; c ++) {
			System.out.print("Please enter the customer name for box: "+ (c + 1) + " : ");
			customerName[c] = scanner.next();
		
			
			System.out.print("Please enter the weight(kg) for box: " + (c + 1) + " : ");
			weight[c] = scanner.nextDouble();
			
			String input;
			boolean validResponse = false;
			do {
			System.out.print("Does box " + (c+1) + " contain dangerous goods (y/n)? " + (c + 1) + " : ");
			input = scanner.next().toLowerCase();
			if (input.equals("y") || input.equals("n"))
				validResponse = true;
			else {
				System.out.println("Invalid respose. Please enter 'y' for yes or 'n' for no.");
				}
			}
			while (!validResponse);
			dangerousItems[c] = input.equalsIgnoreCase("y");
			}
		while (true) {
			System.out.println("All the information regarding the boxes has been entered.");
			System.out.print(" List (a)ll boxes information, search boxes by (c)ustomer name or (d)angerous cargo, or (q)uit? ");
			String choice = scanner.next();
		
			if(choice.equals("a")){
				listAllBoxes(customerName, weight, dangerousItems);
			}
			else if (choice.equals("c")){
					searchByCustomerName(customerName, weight, dangerousItems);
				}
				else if (choice.equals("d")){
						searchByDangerousItems(customerName, weight, dangerousItems);
					}
					else if (choice.equals("q")) {
							System.out.println("Thank you for using our truck Loader.");
							break;
						}
						else
							System.out.println("Invalid choice. Please select a valid option. ");
		}
	}
	private static void listAllBoxes(String[] customerNames, double[] weights, boolean[] dangerousItems) {
        for (int i = 0; i < customerNames.length; i++) {
            String goodsType = dangerousItems[i] ? "Dangerous Goods" : "Non Dangerous Goods";
            System.out.printf("Box %d Customer name: %s Weight (kg): %.1f %s%n", i + 1, customerNames[i], weights[i], goodsType);
        }
    }
    private static void searchByCustomerName(String[] customerNames, double[] weights, boolean[] dangerousItems) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the customer's name? ");
        String searchName = scanner.next();

        for (int i = 0; i < customerNames.length; i++) {
            if (customerNames[i].equalsIgnoreCase(searchName)) {
                String goodsType = dangerousItems[i] ? "Dangerous Items" : "Non Dangerous Items";
                System.out.printf("Box %d Customer name: %s Weight (kg): %.1f %s%n", i + 1, customerNames[i], weights[i], goodsType);
            }
				}
			}
    private static void searchByDangerousItems(String[] customerNames, double[] weights, boolean[] dangerousItems) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search for (d)angerous or (n)on-dangerous? ");
        String searchType = scanner.next();
        boolean searchDangerous = searchType.equals("d");

        for (int i = 0; i < customerNames.length; i++) {
            if (dangerousItems[i] == searchDangerous) {
                String goodsType = dangerousItems[i] ? "Dangerous Items" : "Non Dangerous Items";
                System.out.printf("Box %d Customer name: %s Weight (kg): %.1f %s%n", i + 1, customerNames[i], weights[i], goodsType);
            }
        } 
    }  
}
