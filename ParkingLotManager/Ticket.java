
import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime; 

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot){
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketId(){
        return this.ticketId;
    }
    public Vehicle getVehicle(){
        return this.vehicle;
    }
    public ParkingSpot getParkingSpot(){
        return this.parkingSpot;
    }
    public LocalDateTime getEntryTime(){
        return this.entryTime;
    }
    public void setExitTime(){
        this.exitTime = LocalDateTime.now();
    }
}
