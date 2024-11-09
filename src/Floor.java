public class Floor {
    public Vehicle[] getSlots() {
        return slots;
    }

    private final Vehicle[]slots;
    int bikeCount=0;
    int truckCount=0;
    int carCount=0;
    int bikeCapacity;
    int carCapacity;
    int truckCapacity;
    public Floor(int slotCount)
    {
        slots=new Vehicle[slotCount];
        truckCapacity=Math.min(1,slotCount);
        bikeCapacity=Math.min(slotCount - 1, 2);
        carCapacity=Math.max(slotCount-3,0);
    }



}
