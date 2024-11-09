public class InputHandeller {
    ParkingLot parkingLot;
    DisplayService displayService;
    ParkingManagementSystem parkingManagementSystem;
    public InputHandeller (String input)
    {
        String  []start= input.split(" ");
        int floorCount=0;
        if(start.length>=3) {
            floorCount = Integer.parseInt(start[2]);
        }
        int slotCount=0;
        if(start.length>=4) {
            slotCount = Integer.parseInt(start[3]);
        }
        this.parkingLot=new ParkingLot(floorCount,slotCount);
        this. parkingManagementSystem=new ParkingManagementSystem(parkingLot);
        this. displayService=new DisplayService(parkingLot);
    }

    void handelInput(String input)
    {
        if(input.contains("display"))
        {
            handelDisplay(input);
        }
        else if(input.contains("park"))
        {
            handelParkingAndUnparking(input);
        }
    }

    private void handelParkingAndUnparking(String input) {

        if(input.contains("unpark"))
        {

           handelUnpark(input);
        }
        else{
            handelParking(input);
        }
    }

    private void handelParking(String input) {
        //park_vehicle CAR KA-01-DF-8230 black
        String[]parkingVehicleDetails=input.split(" ");
        String vehicleType =parkingVehicleDetails[1];
        String registration=parkingVehicleDetails[2];
        String color=parkingVehicleDetails[3];
        Vehicle vehicle=null;
        if(vehicleType.equalsIgnoreCase("CAR")) {
            vehicle= new Car.CarBuilder().setRegistration(registration).setType(vehicleType).setColor(color).build();
            parkingManagementSystem.parkVehicle(vehicle);
        }
        else if(vehicleType.equalsIgnoreCase("BIKE")) {
            vehicle= new Bike.BikeBuilder().setRegistration(registration).setType(vehicleType).setColor(color).build();
            parkingManagementSystem.parkVehicle(vehicle);
        }
        else{
            vehicle= new Truck.TruckBuilder().setRegistration(registration).setType(vehicleType).setColor(color).build();
            parkingManagementSystem.parkVehicle(vehicle);
        }
    }

    private void handelUnpark(String input) {
        //unpark_vehicle PR1234_2_5
        String []parkingDetails=input.split(" ");

        String[]parkingPosDetails=parkingDetails[1].split("_");
        String slotNoString=parkingPosDetails[2];
        int slotNo=Integer.parseInt(slotNoString)-1;
        String floorNoString=parkingPosDetails[1];
        int floorNo=Integer.parseInt(floorNoString)-1;
        parkingManagementSystem.unPark(floorNo,slotNo);
    }

    public void handelDisplay(String input) {
        //display free_slots CAR
        String []displayParameter=input.split(" ");
        if(displayParameter[1].contains("free"))
        {
            handelFreeSlotorCountRequest(displayParameter[1],displayParameter[2]);
        }
        else{
            handelOccupiedSlotorCountRequest(displayParameter[1],displayParameter[2]);
        }
    }

    private void handelOccupiedSlotorCountRequest(String requestType, String vehicleType) {
        if(requestType.contains("slot"))
        {
            displayService.displayOccupiedSlotNoForVehicle(vehicleType);
        }
        else{
            displayService.displayOccupiedSlotCountForVehicle(vehicleType);
        }
    }

    private void handelFreeSlotorCountRequest(String requestType, String vehicleType) {
        if(requestType.contains("slot"))
        {
            displayService.displayFreeSlotNoForVehicle(vehicleType);
        }
        else{
            displayService.displayFreeSlotCountForVehicle(vehicleType);
        }
    }

}
