public class ExitGate {
    private String gateId;
    private ParkingLot parkingLot;

    public ExitGate(String gateId, ParkingLot parkingLot){
        this.gateId = gateId;
        this.parkingLot = parkingLot;
    }
    public boolean allowExit(Ticket ticket){
        return parkingLot.unparkVehicle(ticket);
    }
}
