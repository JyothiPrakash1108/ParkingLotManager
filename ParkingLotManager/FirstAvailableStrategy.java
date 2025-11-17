
import java.util.List;

public class FirstAvailableStrategy implements SpotAllocationStrategy {

    @Override
    public ParkingSpot getParkingSpot(List<ParkingFloor> floors, Vehicle vehicle) {

        ParkingSpotSize requiredSize = mapVehicleToSize(vehicle.getVehicleType());

        for (ParkingFloor floor : floors) {
            ParkingSpot freeSpot = floor.getFreeSpot(requiredSize);
            if (freeSpot != null) {
                return freeSpot;
            }
        }
        return null; 
    }

    private ParkingSpotSize mapVehicleToSize(VehicleType type) {
        return switch (type) {
            case MOTORCYCLE -> ParkingSpotSize.SMALL;
            case CAR -> ParkingSpotSize.MEDIUM;
            case BUS -> ParkingSpotSize.LARGE;
        };
    }
}
