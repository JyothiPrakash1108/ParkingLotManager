public class HourlyCalculationStrategy implements FeeCalculationStrategy {

    private static final double RATE_PER_HOUR_SMALL = 10.0;
    private static final double RATE_PER_HOUR_MEDIUM = 20.0;
    private static final double RATE_PER_HOUR_LARGE = 30.0;

    @Override
    public double calculateFee(Ticket ticket) {
        long durationInHours = ticket.getDurationInHours();
         if (durationInHours == 0) {
            durationInHours = 1;
        }
        ParkingSpotSize spotSize = ticket.getParkingSpot().getParkingSpotSize();

        double ratePerHour = switch (spotSize) {
            case SMALL -> RATE_PER_HOUR_SMALL;
            case MEDIUM -> RATE_PER_HOUR_MEDIUM;
            case LARGE -> RATE_PER_HOUR_LARGE;
        };

        return durationInHours * ratePerHour;
    }
    
}
