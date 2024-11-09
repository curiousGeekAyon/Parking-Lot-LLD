public class Ticket {
private final String parkingLotId="PR1234";
private final int floorNo;
private final int slotNo;
public Ticket(int floorNo,int slotNo)
{
    this.floorNo=floorNo;
    this.slotNo=slotNo;
}

    public int getFloorNo() {
        return floorNo;
    }

    public int getSlotNo() {
        return slotNo;
    }
}
