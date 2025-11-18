public class EntryGate {
    private String gateId;
    private ParkingLot parkingLot;

    public EntryGate(String gateId, ParkingLot parkingLot){
        this.gateId = gateId;
        this.parkingLot = parkingLot;
    }
    public Ticket allowEntry(Vehicle vehicle){
        Ticket ticket = parkingLot.parkVehicleTicket(vehicle);
        return ticket;
    }
    public String getGateId(){
        return this.gateId;
    }
}
