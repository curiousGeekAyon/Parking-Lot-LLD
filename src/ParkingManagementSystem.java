import java.util.List;

public class ParkingManagementSystem {
    ParkingLot parkingLot;
    public ParkingManagementSystem(ParkingLot parkingLot)
    {
        this.parkingLot=parkingLot;
    }
    public void parkVehicle(Vehicle vehicle)
    {
        boolean gotParkingSlot=false;
        List<Floor> floorList=parkingLot.getFloorList();
        int floorNo=1;
        for(Floor floor:floorList)
        {
            int availableSlotNo=findAvailableSlotForVehicle(vehicle,floor);
            if(availableSlotNo!=-1)
            {
                park(floorList.get(floorNo-1),availableSlotNo,vehicle);
                System.out.println("Parked vehicle ,Ticket: "+"PR1234 "+floorNo+" "+(availableSlotNo+1));
                gotParkingSlot=true;
                break;
            }
            floorNo++;
        }
        if(!gotParkingSlot)
            {
                System.out.println("Sorry no parking lot available for "+vehicle.getType());
            }
    }
    public void unParkVehicle(Ticket ticket)
    {
            int floorNo=ticket.getFloorNo();
            int slotNo=ticket.getSlotNo();
            unPark(floorNo,slotNo);
    }

    private int findAvailableSlotForVehicle(Vehicle vehicle,Floor floor) {
        String type=vehicle.getType();
        switch(type)
        {
            case "BIKE":
                if(hasBikeSlot(floor))
                {
                    return getAvailableBikeSlotNo(floor);
                }
                return -1;
            case "CAR":
                if(hasCarSlot(floor))
                {
                    return getAvailableCarSlotNo(floor);
                }
                return -1;
            case "TRUCK":
                if(hasTruckSlot(floor))
                {
                    return getAvailableTruckSlotNo(floor);
                }
                return -1;
            default:
                throw new RuntimeException("New type "+vehicle.getType());
        }
    }

    public boolean hasCarSlot(Floor floor){
        return (floor.carCapacity-floor.carCount)>0?true:false;
    }
    public boolean hasBikeSlot(Floor floor){
        return (floor.bikeCapacity-floor.bikeCount)>0?true:false;
    }
    public boolean hasTruckSlot(Floor floor){
        return (floor.truckCapacity-floor.truckCount)>0?true:false;
    }
    public int getAvailableBikeSlotNo(Floor floor)
    {
        Vehicle[]slots=floor.getSlots();
        if(slots[1]==null)
        {
            return 1;
        }
        else if(slots[2]==null){
            return 2;
        }
        return -1;
    }
    public int getAvailableTruckSlotNo(Floor floor)
    {
        Vehicle[]slots=floor.getSlots();
        if(slots[0]==null) {
            return 0;
        }
        return -1;
    }
    public int getAvailableCarSlotNo(Floor floor)
    {
        Vehicle[]slots=floor.getSlots();
        for(int i=3;i<slots.length;i++)
        {
            if(slots[i]==null)
            {
                return i;
            }
        }
        return -1;
    }
    public void park(Floor floor,int slotNo,Vehicle vehicle)
    {
        Vehicle[]slots=floor.getSlots();
        slots[slotNo]=vehicle;
        String type=vehicle.getType();
        if(type.equals("CAR"))
        {
           floor.carCount++;
        }
        else if(type.equals("TRUCK"))
        {
            floor.truckCount++;
        }
        else
        {
            floor.bikeCount++;
        }
    }
    public void unPark(int floorNo,int slotNo)
    {
        if(!checkifFloorandSlotBothInBounds(floorNo,slotNo))
        {
            return;
        }
        List<Floor>floorList=parkingLot.getFloorList();

        Floor floor=floorList.get(floorNo);
        Vehicle[]slots=floor.getSlots();
        Vehicle removedVehicle=slots[slotNo];
        if(removedVehicle==null)
        {
            System.out.println("Wrong ticket info, no vehicle got  parked here");
            return;
        }
        slots[slotNo]=null;
        String type=removedVehicle.getType();
        if(type.equals("CAR"))
        {
            floor.carCount--;
        }
        else if(type.equals("TRUCK"))
        {
            floor.truckCount--;
        }
        else if(type.equals("BIKE"))
        {
            floor.bikeCount--;
        }
        System.out.println("Unparked vehicle with Registration Number: "+removedVehicle.getRegistration()+" and color: "+removedVehicle.getColor());
    }

    public boolean checkifFloorandSlotBothInBounds(int floorNo,int slotsCount) {
        List<Floor>floorList=parkingLot.getFloorList();
        int floorsCount=floorList.size();
        int slotCountPerFloor=floorList.getFirst().getSlots().length;
        if(floorsCount<=floorNo)
        {
            System.out.println("This floor is not present  in the Parking lot");
            return false;
        }
        if(slotsCount>=slotCountPerFloor)
        {
                System.out.println("This slot is not present  in the floor");
                return false;

        }
        return true;
    }
}
