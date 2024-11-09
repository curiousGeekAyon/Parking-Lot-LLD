import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        create_parking_lot PR1234 2 6
//        display free_count CAR
//        display free_count BIKE
//        display free_count TRUCK
//        display free_slots CAR
//        display free_slots BIKE
//        display free_slots TRUCK
//        display occupied_slots CAR
//        display occupied_slots BIKE
//        display occupied_slots TRUCK
//        park_vehicle CAR KA-01-DB-1234 black
//        park_vehicle CAR KA-02-CB-1334 red
//        park_vehicle CAR KA-01-DB-1133 black
//        park_vehicle CAR KA-05-HJ-8432 white
//        park_vehicle CAR WB-45-HO-9032 white
//        park_vehicle CAR KA-01-DF-8230 black
//        park_vehicle CAR KA-21-HS-2347 red
//        display free_count CAR
//        display free_count BIKE
//        display free_count TRUCK
//        unpark_vehicle PR1234_2_5
//        unpark_vehicle PR1234_2_5
//        unpark_vehicle PR1234_2_7
//        display free_count CAR
//        display free_count BIKE
//        display free_count TRUCK
//        display free_slots CAR
//        display free_slots BIKE
//        display free_slots TRUCK
//        display occupied_slots CAR
//        display occupied_slots BIKE
//        display occupied_slots TRUCK
//        park_vehicle BIKE KA-01-DB-1541 black
//        park_vehicle TRUCK KA-32-SJ-5389 orange
//        park_vehicle TRUCK KL-54-DN-4582 green
//        park_vehicle TRUCK KL-12-HF-4542 green
//        display free_count CAR
//        display free_count BIKE
//        display free_count TRUCK
//        display free_slots CAR
//        display free_slots BIKE
//        display free_slots TRUCK
//        display occupied_slots CAR
//        display occupied_slots BIKE
//        display occupied_slots TRUCK
//        exit
        Scanner scanner = new Scanner(System.in);
        String input;
        InputHandeller inputHandeller = null;
        // Process the first line for parking lot creation
        if (scanner.hasNextLine()) {
            input = scanner.nextLine().trim();
            inputHandeller = new InputHandeller(input);
        } else {
            return;
        }
        // Process remaining commands until "exit"
        while (true) {
            if (scanner.hasNextLine()) {
                input = scanner.nextLine().trim();
                System.out.println("printing input " + input);
                if (input.contains("exit")) {
                    break;
                }
                inputHandeller.handelInput(input);
            } else {
                return;
            }
        }
    }
}