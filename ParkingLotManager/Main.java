import java.util.List;

public class Main{
    public static void main(String[] args) {
        System.out.println("===================================Welcome to the Parking Lot System!==============================");
        ParkingSpot s1 = new ParkingSpot("S1", ParkingSpotSize.SMALL);
        ParkingSpot s2 = new ParkingSpot("S2", ParkingSpotSize.MEDIUM);
        ParkingSpot s3 = new ParkingSpot("S3", ParkingSpotSize.LARGE);

        ParkingSpot s4 = new ParkingSpot("S4", ParkingSpotSize.SMALL);
        ParkingSpot s5 = new ParkingSpot("S5", ParkingSpotSize.MEDIUM);
        ParkingSpot s6 = new ParkingSpot("S6", ParkingSpotSize.LARGE);

        ParkingFloor floor1 = new ParkingFloor("F1", List.of(s1, s2, s3));
        ParkingFloor floor2 = new ParkingFloor("F2", List.of(s4, s5, s6));

        SpotAllocationStrategy spotStrategy = new FirstAvailableStrategy();
        FeeCalculationStrategy feeStrategy = new HourlyCalculationStrategy();

        ParkingLot parkingLot = new ParkingLot(
                "PARK_01",
                List.of(floor1, floor2),
                spotStrategy,
                feeStrategy
        );
        EntryGate entryGate1 = new EntryGate("ENTRY_1", parkingLot);
        EntryGate entryGate2 = new EntryGate("ENTRY_2", parkingLot);

        ExitGate exitGate1 = new ExitGate("EXIT_1", parkingLot);
        ExitGate exitGate2 = new ExitGate("EXIT_2", parkingLot);

        Vehicle car1 = new Vehicle("KA01AB1234", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("KA09XY9821", VehicleType.MOTORCYCLE);
        Ticket carTicket = entryGate1.allowEntry(car1);
        Ticket bikeTicket = entryGate2.allowEntry(bike1);
        System.out.println("Car Ticket ID: " + carTicket.getTicketId());
        System.out.println("Bike Ticket ID: " + bikeTicket.getTicketId());
        try {
            Thread.sleep(3000); // Wait 3 seconds - will round up to 1 hour
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double carFee = exitGate1.allowExit(carTicket);
        System.out.println("\nCar Exit Fee: ₹" + carFee);

        double bikeFee = exitGate2.allowExit(bikeTicket);
        System.out.println("Bike Exit Fee: ₹" + bikeFee);
    }
}