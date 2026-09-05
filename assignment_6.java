import java.util.Scanner;

class Vehicle {
    private String vehicleNumber;
    private String model;
    private String customerName;
    private int rentalDays;

    Vehicle(String vehicleNumber, String model, String customerName, int rentalDays) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.customerName = customerName;
        this.rentalDays = rentalDays;
    }

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Model         : " + model);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Rental Days   : " + rentalDays);
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double calculateCharge() {
        return 0;
    }
}

class Car extends Vehicle {
    private int numberOfSeats;

    Car(String vehicleNumber, String model, String customerName,
        int rentalDays, int numberOfSeats) {

        super(vehicleNumber, model, customerName, rentalDays);
        this.numberOfSeats = numberOfSeats;
    }

    public void displayDetails() {
        System.out.println("Vehicle Type  : Car");
        super.displayDetails();
        System.out.println("Number of Seats: " + numberOfSeats);
    }

    public double calculateCharge() {
        return getRentalDays() * 1500;
    }
}

class Bike extends Vehicle {
    private int engineCapacity;

    Bike(String vehicleNumber, String model, String customerName,
         int rentalDays, int engineCapacity) {

        super(vehicleNumber, model, customerName, rentalDays);
        this.engineCapacity = engineCapacity;
    }

    public void displayDetails() {
        System.out.println("Vehicle Type  : Bike");
        super.displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity + " cc");
    }

    public double calculateCharge() {
        return getRentalDays() * 700;
    }
}

class Scooter extends Vehicle {
    private int storageCapacity;

    Scooter(String vehicleNumber, String model, String customerName,
            int rentalDays, int storageCapacity) {

        super(vehicleNumber, model, customerName, rentalDays);
        this.storageCapacity = storageCapacity;
    }

    public void displayDetails() {
        System.out.println("Vehicle Type  : Scooter");
        super.displayDetails();
        System.out.println("Storage Capacity: " + storageCapacity + " litres");
    }

    public double calculateCharge() {
        return getRentalDays() * 500;
    }
}

class ElectricCar extends Vehicle {
    private int batteryCapacity;

    ElectricCar(String vehicleNumber, String model, String customerName,
                int rentalDays, int batteryCapacity) {

        super(vehicleNumber, model, customerName, rentalDays);
        this.batteryCapacity = batteryCapacity;
    }

    public void displayDetails() {
        System.out.println("Vehicle Type  : Electric Car");
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }

    public double calculateCharge() {
        return getRentalDays() * 1800;
    }
}

public class assignment_6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Vehicle rentedVehicle = null;

        while (true) {

            System.out.println("\n===== Vehicle Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Rent a Bike");
            System.out.println("3. Rent a Scooter");
            System.out.println("4. Rent an Electric Car");
            System.out.println("5. Display Rental Details");
            System.out.println("6. Calculate Rental Charges");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 7) {
                System.out.println("Thank you for using Vehicle Rental System.");
                break;
            }

            if (choice >= 1 && choice <= 4) {

                System.out.print("Enter Vehicle Number: ");
                String number = sc.nextLine();

                System.out.print("Enter Vehicle Model: ");
                String model = sc.nextLine();

                System.out.print("Enter Customer Name: ");
                String customer = sc.nextLine();

                System.out.print("Enter Rental Days: ");
                int days = sc.nextInt();

                if (days <= 0) {
                    System.out.println("Rental days must be greater than 0.");
                    continue;
                }

                if (choice == 1) {
                    System.out.print("Enter Number of Seats: ");
                    int seats = sc.nextInt();

                    rentedVehicle = new Car(
                            number, model, customer, days, seats
                    );
                }

                else if (choice == 2) {
                    System.out.print("Enter Engine Capacity (cc): ");
                    int engine = sc.nextInt();

                    rentedVehicle = new Bike(
                            number, model, customer, days, engine
                    );
                }

                else if (choice == 3) {
                    System.out.print("Enter Storage Capacity (litres): ");
                    int storage = sc.nextInt();

                    rentedVehicle = new Scooter(
                            number, model, customer, days, storage
                    );
                }

                else if (choice == 4) {
                    System.out.print("Enter Battery Capacity (kWh): ");
                    int battery = sc.nextInt();

                    rentedVehicle = new ElectricCar(
                            number, model, customer, days, battery
                    );
                }

                System.out.println("\nVehicle rented successfully.");
            }

            else if (choice == 5) {

                if (rentedVehicle == null) {
                    System.out.println("No vehicle has been rented yet.");
                } else {
                    System.out.println("\n===== Vehicle Rental Receipt =====");
                    rentedVehicle.displayDetails();
                }
            }

            else if (choice == 6) {

                if (rentedVehicle == null) {
                    System.out.println("No vehicle has been rented yet.");
                } else {
                    System.out.println("\n===== Rental Charges =====");
                    System.out.println(
                        "Total Amount : ₹" +
                        rentedVehicle.calculateCharge()
                    );
                }
            }

            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
