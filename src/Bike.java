public class Bike extends Vehicle{

    public Bike (VehicleBuilder vehicle)
    {
        super(vehicle);
    }
    public static  class BikeBuilder extends VehicleBuilder
    {
        String type="BIKE";
        public Vehicle build()
        {
            return new Bike(this);
        }
    }
}
