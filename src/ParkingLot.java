import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<Floor> floorList;

    public List<Floor> getFloorList() {
        return floorList;
    }
    public ParkingLot(int floorCount,int slotCount)
    {
        floorList=new ArrayList<>();
        for(int i=0;i<floorCount;i++)
        {
            floorList.add(new Floor(slotCount));
        }
    }
}
