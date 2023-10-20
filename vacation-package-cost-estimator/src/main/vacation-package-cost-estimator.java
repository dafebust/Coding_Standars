import java.util.Scanner;

module vacation-package-cost-estimator {
//CHECKSTYLE:OFF
	public static void main(String[] args) {
//CHECKSTYLE:ON		
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the destination of the vacation: ");
        String destination = input.nextLine();

        System.out.print("Enter the number of travelers: ");
        int numTravelers = input.nextInt();

        System.out.print("Enter the duration of the vacation in days: ");
        int duration = input.nextInt();

        int totalCost = calculateVacationCost(destination, numTravelers, duration);

        if (totalCost == -1) {
            System.out.println("Invalid input. Please check the input data.");
        } else {
            System.out.println("Total cost of the vacation package: $" + totalCost);
        }

        input.close();
    }

    public static int calculateVacationCost(String destination, int numTravelers, int duration) {
        int baseCost = 1000;
        int additionalCost = 0;
        double groupDiscount = 0;
        int penaltyFee = 0;

        // Validate input data
        if (!destination.equals("Paris") && !destination.equals("New York City")) {
            return -1;
        }

        if (numTravelers < 2 || numTravelers > 80) {
            return -1;
        }

        if (duration < 1 || duration > 365) {
            return -1;
        }

        // Calculate additional cost based on destination
        if (destination.equals("Paris")) {
            additionalCost = 500;
        } else if (destination.equals("New York City")) {
            additionalCost = 600;
        }

        // Apply group discount
        if (numTravelers > 4 && numTravelers < 10) {
            groupDiscount = 0.10;
        } else if (numTravelers >= 10) {
            groupDiscount = 0.20;
        }

        // Apply penalty fee
        if (duration < 7) {
            penaltyFee = 200;
        }

        // Apply promotion policy
        if (duration > 30 || numTravelers == 2) {
            baseCost -= 200;
        }

        // Calculate total cost
        double totalCost = (baseCost + additionalCost) * (1 - groupDiscount) + penaltyFee;

        return (int) totalCost;
    }
}

