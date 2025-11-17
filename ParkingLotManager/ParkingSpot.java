public class ParkingSpot {
    private String parkingSpotId;
    private ParkingSpotSize parkingSpotSize;
    private boolean isOccupied;

    public ParkingSpot(String parkingSpotId, ParkingSpotSize parkingSpotSize){
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotSize = parkingSpotSize;
        this.isOccupied = false;
    }
    public void occupySpot(){
        this.isOccupied = true;
    }

    public void vacateSpot(){
        this.isOccupied = false;
    }
    public boolean  getStatus(){
        return this.isOccupied;
    }
    public ParkingSpotSize getParkingSpotSize(){
        return this.parkingSpotSize;
    }


}
enum ParkingSpotSize{
    SMALL,
    MEDIUM,
    LARGE
}

