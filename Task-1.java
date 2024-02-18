package OIBSIP;
import java.util.Scanner;

class task1  {
    private static boolean[] seats = new boolean[10]; // initialize an array of 10 seats, all empty
    private static boolean loggedIn = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        login(scanner);

        while (!loggedIn) {
            System.out.println("Invalid credentials. Please try again.");
            login(scanner);
        }

        while (true) {
            // display menu
            System.out.println("------------------------------ Select the Corresponding Number for Corresponding Action -----------------------------");
            System.out.println("1. View Seat Map");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            // get user input
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.println("Enter your option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    viewSeatMap();
                    break;
                case 2:
                    reserveSeat(scanner);
                    break;
                case 3:
                    cancelReservation(scanner);
                    break;
                case 4:
                    System.exit(0); // exit the program
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.println("------------------------------ Login -----------------------------");
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        // Dummy validation for demonstration purposes
        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Login successful!");
            loggedIn = true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void viewSeatMap() {
        System.out.println("\nCurrent Seat Map :");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("X  "); // print an "X" if the seat is reserved
            } else {
                System.out.print(i + 1 + "  ");
            }
        }
        System.out.println();
    }

    private static void reserveSeat(Scanner scanner) {
        System.out.println("\nReservation Form:");

        // Collecting necessary details
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.next();
        String trainName = "Sample Train"; 
        System.out.print("Enter class type: ");
        String classType = scanner.next();
        System.out.print("Enter date of journey (DD/MM/YYYY): ");
        String dateOfJourney = scanner.next();
        System.out.print("Enter source station: ");
        String source = scanner.next();
        System.out.print("Enter destination station: ");
        String destination = scanner.next();

        // Displaying confirmation msg
        System.out.println("\nReservation Details:");
        System.out.println("Name: " + name);
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Train Name: " + trainName);
        System.out.println("Class Type: " + classType);
        System.out.println("Date of Journey: " + dateOfJourney);
        System.out.println("From: " + source);
        System.out.println("To: " + destination);
        System.out.println("Seat reserved!");

    }

    private static void cancelReservation(Scanner scanner) {
        // Implementation of cancellation form
        System.out.println("\nCancellation Form:");
        System.out.print("Enter your PNR number: ");
        int pnrNumber = scanner.nextInt();
        if (pnrNumber < 1 || pnrNumber > 10) {
            System.out.println("Invalid PNR number!");
        } else if (!seats[pnrNumber - 1]) {
            System.out.println("Reservation cancelled!");
        } else {
            seats[pnrNumber - 1] = false;
            System.out.println("No reservation found with this PNR number!");
        }
    }
}
