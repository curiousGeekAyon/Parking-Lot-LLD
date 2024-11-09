public class Car extends Vehicle{

    public Car(VehicleBuilder vehicle)
    {
        super(vehicle);
    }
    public static  class CarBuilder extends VehicleBuilder
    {
        String type="CAR";
        public Vehicle build()
        {
            return new Car(this);
        }
    }
}
