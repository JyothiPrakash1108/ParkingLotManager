
import java.util.List;

public interface  SpotAllocationStrategy {
    public ParkingSpot getParkingSpot(List<ParkingFloor> parkingFloors,Vehicle vehicle);
}
