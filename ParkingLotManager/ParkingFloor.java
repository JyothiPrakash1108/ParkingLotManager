
import java.util.List;

public class ParkingFloor {

    private String floorId;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(String floorId, List<ParkingSpot> parkingSpots) {
        this.floorId = floorId;
        this.parkingSpots = parkingSpots;
    }

    public String getFloorId() {
        return this.floorId;
    }

    public List<ParkingSpot> getParkingSpots() {
        return this.parkingSpots;
    }

    public ParkingSpot getFreeSpot(ParkingSpotSize requiredSize) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.getStatus() && spot.getParkingSpotSize() == requiredSize) {
                return spot;
            }
        }
        return null; 
    }
}
