import java.util.List;

public class DisplayService {
    ParkingLot parkingLot;
    public DisplayService(ParkingLot parkingLot)
    {
        this.parkingLot=parkingLot;
    }
    public void displayFreeSlotCountForVehicle(String vehicleType)
    {
        List<Floor> floorList=parkingLot.getFloorList();
        for(int i=0;i<floorList.size();i++)
            {
                Floor floor=floorList.get(i);
                if(vehicleType.equals("CAR"))
                {
                    System.out.println("No. of free slots for CAR on Floor "+(i+1)+" :"+(floor.carCapacity-floor.carCount));
                }
                else if(vehicleType.equals("BIKE"))
                {
                    System.out.println("No. of free slots for BIKE on Floor "+(i+1)+" :"+(floor.bikeCapacity-floor.bikeCount));
                }
                else{
                    System.out.println("No. of free slots for TRUCK on Floor "+(i+1)+" :"+(floor.truckCapacity-floor.truckCount));
                }
            }
    }
    public void displayFreeSlotNoForVehicle(String vehicleType)
    {
        List<Floor> floorList=parkingLot.getFloorList();


        for(int i=0;i<floorList.size();i++) {
            //for each floor looking for answers of vehicle type

            Floor floor=floorList.get(i);
            if (vehicleType.equals("CAR")) {
                System.out.print("No. of free slots for CAR on Floor " + (i + 1) + " :" );
                Vehicle[]slots=floor.getSlots();
                int slotsLength=slots.length;
                for(int currSlot=3;currSlot<slotsLength;currSlot++)
                {
                    if(slots[currSlot]==null)
                    {
                        System.out.print(currSlot+1+" ");
                    }
                }
                System.out.println();
            } else if (vehicleType.equals("BIKE")) {
                System.out.print("No. of free slots for Bike on Floor " + (i + 1) + " :" );
                Vehicle[]slots=floor.getSlots();
                int slotsLength=slots.length;
                for(int currSlot=1;currSlot<slotsLength&&currSlot<3;currSlot++)
                {
                    if(slots[currSlot]==null)
                    {
                        System.out.print(currSlot+1+" ");
                    }
                }
                System.out.println();
            } else {
                Vehicle[]slots= floor.getSlots();
                if(slots.length>0&&slots[0]==null) {
                    System.out.println("No. of free slots for CAR on Floor " + (i + 1) + " :" + 0);
                }
            }
        }
    }
    public void displayOccupiedSlotCountForVehicle(String vehicleType)
    {
        List<Floor> floorList=parkingLot.getFloorList();
        for(int i=0;i<floorList.size();i++)
        {
            Floor floor=floorList.get(i);
            if(vehicleType.equals("CAR"))
            {
                System.out.println("No. of occupied slots for CAR on Floor "+(i+1)+" :"+(floor.carCount));
            }
            else if(vehicleType.equals("BIKE"))
            {
                System.out.println("No. of occupied slots for CAR on Floor "+(i+1)+" :"+(floor.bikeCount));
            }
            else{
                System.out.println("No. of occupied slots for truck on Floor "+(i+1)+" :"+(floor.truckCount));
            }
        }
    }
    public void displayOccupiedSlotNoForVehicle(String vehicle)
    {
        List<Floor> floorList=parkingLot.getFloorList();
        for(int i=0;i<floorList.size();i++) {
            Floor floor=floorList.get(i);
            if (vehicle.equals("CAR")) {
                System.out.print("Occupied slot numbers for CAR on Floor " + (i + 1) + " :" );
                Vehicle[]slots=floor.getSlots();
                int slotsLength=slots.length;
                for(int currSlot=3;currSlot<slotsLength;currSlot++)
                {
                    if(slots[currSlot]!=null)
                    {
                        System.out.print(currSlot+1+" ");
                    }
                }
                System.out.println();
            } else if (vehicle.equals("BIKE")) {
                System.out.print("Occupied slot numbers for Bike on Floor " + (i + 1) + " :" );
                Vehicle[]slots=floor.getSlots();
                int slotsLength=slots.length;
                for(int currSlot=1;currSlot<slotsLength&&currSlot<3;currSlot++)
                {
                    if(slots[currSlot]!=null)
                    {
                        System.out.print(currSlot+1+" ");
                    }
                }
                System.out.println();
            } else {
                Vehicle[]slots= floor.getSlots();
                System.out.print("Occupied slot numbers for Truck on Floor "+(i+1)+" :");
                if(slots.length>0&&slots[0]!=null) {
                    System.out.println(0);
                }
                else{
                    System.out.println();
                }
            }
        }
    }

    //display free_count TRUCK
    //        display free_slots CAR
//        display free_slots BIKE

}
