import java.util.*;

// Container ADT Class for Item No. 1 in Requirements (Create ADT Classes)
class Container {
    private String id;
    private String description;
    private double weight;

    // Constructor to initialize values
    public Container(String id, String description, double weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    // toString() →
    @Override
    public String toString() {
        return String.format("%s | %-12s | %.0fkg", id, description, weight);
    }
}

// Ship ADT Class also for Item No. 1 in Requirements (Create ADT Classes)
class Ship {
    private String name;
    private String captain;

    // Constructor to initialize values
    public Ship(String name, String captain) {
        this.name = name;
        this.captain = captain;
    }

    // toString() →
    @Override
    public String toString() {
        return name + " | " + captain;
    }
}

public class PortContainerManagementSystem {
    private static ArrayDeque<Container> containerStack = new ArrayDeque<>();
    private static ArrayDeque<Ship> shipQueue = new ArrayDeque<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    storeContainer();
                    break;
                case 2:
                    viewPortContainers();
                    break;
                case 3:
                    registerArrivingShip();
                    break;
                case 4:
                    viewWaitingShips();
                    break;
                case 5:
                    loadNextShip();
                    break;
                case 0: // [0] Exit - Ends program
                    running = false;
                    System.out.println("\nExiting Port Container Management System. Goodbye!");
                    break;
                default:
                    System.out.println("\nInvalid option! Please try again.");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Port Container Management System ===");
        System.out.println("[1] Store container (push)");
        System.out.println("[2] View port containers");
        System.out.println("[3] Register arriving ship (enqueue)");
        System.out.println("[4] View waiting ships");
        System.out.println("[5] Load next ship (pop container + poll ship)");
        System.out.println("[0] Exit");
        System.out.print("\nSelect option: ");
    }

    private static int getMenuChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    // [1] Store container
    private static void storeContainer() {
        System.out.println("\n--- Store Container ---");

        //Ask for id, description, and weight
        System.out.print("Enter container ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        double weight = 0;
        boolean validWeight = false;
        while (!validWeight) {
            System.out.print("Enter weight (kg): ");
            try {
                weight = scanner.nextDouble();
                scanner.nextLine();
                validWeight = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid weight! Please enter a number.");
                scanner.nextLine();
            }
        }

        // Push to containerStack
        Container container = new Container(id, description, weight);
        containerStack.push(container);

        System.out.println("\nStored: " + container);
    }

    // [2] View port containers
    private static void viewPortContainers() {
        System.out.println("\n--- Port Containers ---");

        if (containerStack.isEmpty()) {
            System.out.println("No containers in the port.");
        } else {
            System.out.println("TOP →");

            ArrayDeque<Container> temp = new ArrayDeque<>();

            while (!containerStack.isEmpty()) {
                Container container = containerStack.pop();
                System.out.println(container);
                temp.push(container);
            }

            while (!temp.isEmpty()) {
                containerStack.push(temp.pop());
            }

            System.out.println("← BOTTOM");
        }
    }

    // [3] Register arriving ship
    private static void registerArrivingShip() {
        System.out.println("\n--- Register Arriving Ship ---");

        // Ask for ship name and captain
        System.out.print("Enter ship name: ");
        String name = scanner.nextLine();

        System.out.print("Enter captain name: ");
        String captain = scanner.nextLine();

        // Enqueue to shipQueue
        Ship ship = new Ship(name, captain);
        shipQueue.offer(ship);

        System.out.println("\nRegistered: " + ship);
    }

    // [4] View waiting ships
    private static void viewWaitingShips() {
        System.out.println("\n--- Waiting Ships ---");

        if (shipQueue.isEmpty()) {
            System.out.println("No ships waiting at the dock.");
        } else {
            System.out.println("FRONT →");

            for (Ship ship : shipQueue) {
                System.out.println(ship);
            }

            System.out.println("← REAR");
        }
    }

    // [5] Load next ship
    private static void loadNextShip() {
        System.out.println("\n--- Load Next Ship ---");

        if (containerStack.isEmpty()) {
            System.out.println("No containers available to load!");
        } else if (shipQueue.isEmpty()) {
            System.out.println("No ships waiting to be loaded!");
        } else {
            // Pop container from stack
            Container container = containerStack.pop();

            // Poll ship from queue
            Ship ship = shipQueue.poll();

            // Print loading result
            System.out.println("\nLoaded: " + container + " → " + ship);
            System.out.println("Remaining containers: " + containerStack.size());
            System.out.println("Remaining ships waiting: " + shipQueue.size());
        }
    }
}