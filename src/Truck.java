public class Truck extends Vehicle{

    public Truck(VehicleBuilder vehicle)
    {
        super(vehicle);
    }
    public static  class TruckBuilder extends VehicleBuilder
    {
        String type="TRUCK";
        public Vehicle build()
        {
            return new Truck(this);
        }
    }
}
