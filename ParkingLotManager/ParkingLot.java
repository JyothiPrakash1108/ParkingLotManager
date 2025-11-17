
import java.util.List;

public class ParkingLot {
    private String parkingLotId;
    private List<ParkingFloor> parkingFloors;
    private SpotAllocationStrategy spotAllocationStrategy;
    private FeeCalculationStrategy feeCalculationStrategy;
    public ParkingLot(String parkingLotId, List<ParkingFloor> parkingFloors,
                      SpotAllocationStrategy spotAllocationStrategy,
                      FeeCalculationStrategy feeCalculationStrategy) {
        this.parkingLotId = parkingLotId;
        this.parkingFloors = parkingFloors;
        this.spotAllocationStrategy = spotAllocationStrategy;
        this.feeCalculationStrategy = feeCalculationStrategy;
    }
    public Ticket parkVehicleTickete(Vehicle vehicle){
        ParkingSpot spot = getFreeSpot(vehicle);
        if(spot == null){
            return null; 
        }
        spot.occupySpot();
        Ticket ticket = generateTicket(vehicle,spot);
        return ticket;
    }
    private ParkingSpot getFreeSpot(Vehicle vehicle){
        ParkingSpot spot = spotAllocationStrategy.getParkingSpot(parkingFloors,vehicle);
        return spot;
    }
    private  Ticket generateTicket(Vehicle vehicle, ParkingSpot spot){
        String ticketId = "TICKET_" + System.currentTimeMillis();
        Ticket ticket = new Ticket(ticketId,vehicle,spot);
        return ticket;
    }

    public boolean unparkVehicle(Ticket ticket) {
        double amount = feeCalculationStrategy.calculateFee(ticket);
        ticket.setExitTime();
        ParkingSpot spot = ticket.getParkingSpot();
        spot.vacateSpot();
        return true;
    }
}
