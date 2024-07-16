// parking lot
// lots: # lots number, availability, type
// vehicle: license, color, type, ticket
// ticket: price, time, vehicle

class ParkingLot {
    private int number;
    private String availability;
    private String type;
    private Vehicle vehicle;

    // constructor
    public ParkingLot(int number, String availability, String type) {
        this.number = number;
        this.availability = availability;
        this.type = type;
    }

    // getter and setter
    public Vehicle getVehicle() {
        if (this.vehicle == null) {
            return null;
        }
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // check for the availability of the lot
    public boolean isAvailable() {
        reutrn this.availability.equals("available");
    }

    public boolean isCompatible(Vehicle vehicle) {
        // check if the car can park here
        String carType = vehicle.getType();
        return carType.equals(this.type);
    }

    // park vehicle
    // remove the vehicle
    public void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && isCompatible(vehicle)) {
            this.vehicle = vehicle;
            // create a ticket
            Ticket ticket = new Ticket(10, LocalDateTime.now(), null, vehicle);
            vehicle.addTicket(ticket);
            this.availability = "unavailable";
        }
    }

    public removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        this.availability = "available";
        Ticket ticket = vehicle.getTicket();
        ticket.setEndingTime(LocalDateTime.now());
    }
}

class Vehicle {
    private String licensePlate;
    private String color;
    private String type;
    private Ticket ticket;

    // constructor
    public Vehicle(String licensePlate, String color, String type, Ticket ticket) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.type = type;
        this.ticket = ticket;
    }

    // getters and setters
    // add ticket
    public void addTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    // remove ticket
    public void removeTicket(){
        this.ticket = null;
    }

}

class Ticket {
    private double price;
    private datetime startingTime;
    private datetime endingTime;
    private Vehicle vehicle;

    // constructor
    public Ticket(double price, String time, Vehicle vehicle) {
        this.price = price;
        this.time = time;
        this.vehicle = vehicle;
    }

    // getters and setters


    // calcualte the price
    public double calculatePrice(){
        // assuem the price is 10/ hour
        // calculate the time difference
        datetime timeDifference = endingTime - startingTime;
        return timeDifference * price;
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(1, "available", "compact");
        Vehicle vehicle = new Vehicle("1234", "red", "compact", null);


        // check if the parking is aboe to be parked
        boolean isCompatible = parkingLot.isCompatible(vehicle);
        if isCompatible {
            parkingLot.parkVehicle(vehicle);
            Sytem.out.println("The vehicle is parked");

            // remove the vehicle
            parkingLot.removeVehicle(vehicle);
            Ticket ticket = vehicle.getTicket();
            double price = ticket.calculatePrice();
            Sytem.out.println("The price is: " + price);
            vehicle.removeTicket();
        }

    }
}
