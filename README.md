# 🚗 Smart Parking Lot System – Low Level Design (LLD)

#### It models real-world parking operations like:

-Parking vehicle entry

-Automatic parking spot allocation

-Ticket generation

-Exit processing & fee calculation

-Multi-floor management

-Multiple entry/exit gates

-Strategy-based allocation & fee calculation

-Concurrency safety concepts


#### Core Class Responsibilities
#### `ParkingLot.java`
- Central orchestrator for parking operations
- Manages multiple floors and allocation strategy
- **Thread-safe** methods: `parkVehicleTicket()`, `unparkVehicle()`
- Integrates fee calculation strategy

```java
parkingLot.parkVehicleTicket(vehicle)    // Entry point
parkingLot.unparkVehicle(ticket)         // Exit point with fee
```

#### `ParkingFloor.java`
- Represents a single floor in the parking lot
- Contains multiple parking spots
- Finds available spots by size

#### `ParkingSpot.java`
- Represents a single parking space
- **Sizes**: `SMALL`, `MEDIUM`, `LARGE`
- Status tracking: `occupySpot()`, `vacateSpot()`

#### `Ticket.java`
- Entry/exit pass for vehicles
- Tracks entry time, exit time, and duration
- Used for fee calculation
#### `Vehicle.java`
- Represents a parked vehicle
- **Types**: `MOTORCYCLE`, `CAR`, `BUS`
- Linked to ticket and parking spot

#### `EntryGate.java`
- Handles vehicle entry
- Calls `ParkingLot.parkVehicleTicket()`
- Returns ticket to driver

#### `ExitGate.java`
- Handles vehicle exit
- Calls `ParkingLot.unparkVehicle()`
- Returns calculated fee

###  **Strategy Interfaces**

#### `SpotAllocationStrategy.java`
Defines how parking spots are allocated:
```java
ParkingSpot getParkingSpot(List<ParkingFloor> floors, Vehicle vehicle)
```
**Implementation**: `FirstAvailableStrategy.java`
- Maps vehicle type to required spot size
- Returns first available spot of that size

#### `FeeCalculationStrategy.java`
Defines how parking fees are calculated:
```java
double calculateFee(Ticket ticket)
```

**Implementation**: `HourlyCalculationStrategy.java`
- **Rates**:
  - SMALL spot: ₹10/hour
  - MEDIUM spot: ₹20/hour
  - LARGE spot: ₹30/hour
- Minimum charge: 1 hour

### 3. **Enums**

- `VehicleType`: `MOTORCYCLE`, `CAR`, `BUS`
- `ParkingSpotSize`: `SMALL`, `MEDIUM`, `LARGE`
---

