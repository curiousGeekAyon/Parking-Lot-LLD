import java.util.Objects;

public  class Vehicle {
    private String type;
    private String registration;
    private String color;

    public String getType() {
        return type;
    }

    public String getRegistration() {
        return registration;
    }

    public String getColor() {
        return color;
    }

    public Vehicle(VehicleBuilder vehicle)
    {
        this.type=vehicle.getType();
        this.color=vehicle.getColor();
        this.registration= vehicle.getRegistration();
    }
    public static abstract class VehicleBuilder{
        String type;
        String registration;
        String color;
        public VehicleBuilder()
        {

        }

        public VehicleBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public VehicleBuilder setRegistration(String registration) {
            this.registration = registration;
            return this;
        }

        public VehicleBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public String getType() {
            return type;
        }

        public String getRegistration() {
            return registration;
        }

        public String getColor() {
            return color;
        }
        public abstract Vehicle build();
    }
}
