package org.sda.java19;

import org.sda.java19.models.*;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Path vehiclePath = Paths.get("C:\\Users\\ktali\\java-advanced-coding\\src\\main\\resources\\vehicles.txt");

        //File Reading
        List<String> fileLines = Files.readAllLines(vehiclePath, StandardCharsets.UTF_8);
        List<Car> carList = new ArrayList<>();
        List<Motorcycle> motorcycleList = new ArrayList<>();
        List<Tractor> tractorList = new ArrayList<>();
        List<Bicycle> bicycleList = new ArrayList<>();

        // Just to print the file which was read above
        for (String fileLine : fileLines) {
            String[] vehicle = fileLine.split(", ");

            switch (vehicle[0]) { // Gets the first word
                case "Car":
                    Car car = new Car();
                    car.setBrand(vehicle[1]);
                    car.setModel(vehicle[2]);
                    car.setPrice(BigDecimal.valueOf(convertStringToLong(vehicle[3])));
                    car.setTopSpeed(convertStringToFloat(vehicle[4]));
                    car.setVehicleTransmission(VehicleTransmission.valueOf(vehicle[5]));
                    car.setVehicleShape(VehicleShape.valueOf(vehicle[6]));

                    carList.add(car);
                    break;
                case "Motorcycle":
                    Motorcycle motorcycle = new Motorcycle();
                    motorcycle.setBrand(vehicle[1]);
                    motorcycle.setModel(vehicle[2]);
                    motorcycle.setPrice(BigDecimal.valueOf(convertStringToLong(vehicle[3])));
                    motorcycle.setTopSpeed(convertStringToFloat(vehicle[4]));
                    motorcycle.setVehicleShape(VehicleShape.valueOf(vehicle[5]));

                    motorcycleList.add(motorcycle);
                    break;
                case "Tractor":
                    Tractor tractor = new Tractor();
                    tractor.setBrand(vehicle[1]);
                    tractor.setModel(vehicle[2]);
                    tractor.setPrice(BigDecimal.valueOf(convertStringToLong(vehicle[3])));
                    tractor.setMaxPulledWeight(convertStringToFloat(vehicle[4]));

                    tractorList.add(tractor);
                    break;
                case "Bicycle":
                    Bicycle bicycle = new Bicycle();
                    bicycle.setBrand(vehicle[1]);
                    bicycle.setModel(vehicle[2]);
                    bicycle.setPrice(BigDecimal.valueOf(convertStringToLong(vehicle[3])));

                    bicycleList.add(bicycle);
                    break;
                default:
                    System.out.println("Invalid vehicle!");
            }
        }

        // Count the number of cars, motorcycles, tractors
        System.out.println("Number of cars: " + carList.size());
        System.out.println("Number of motorcycles: " + motorcycleList.size());
        System.out.println("Number of tractors: " + tractorList.size());

        // Count how many vehicles of each brand are there
        Map<String, Long> brandMap = carList.stream()       // can do the same with moto and tractors, when using addAll after carList, we can add moto and tractors too
                .collect(Collectors.groupingBy(Car::getBrand, Collectors.counting()));
        System.out.println(brandMap);

        // Sort the cars by price
        carList.stream()
                .sorted(Comparator.comparing(Vehicle::getPrice))        // .sorted((car1, car2) -> car1.getPrice().compareTo(car2.getPrice()))
                .collect(Collectors.toList())
                .forEach(car -> System.out.println(car.toString()));

        // Sort the choppers by top speed
        // 1st filter all the vehicles whose shape is chopper
        motorcycleList.stream()
                .filter(motorcycle -> VehicleShape.CHOPPER.equals(motorcycle.getVehicleShape()))
                .sorted(Comparator.comparing((Motorcycle::getTopSpeed)))
                .collect(Collectors.toList())
                .forEach(motorcycle -> System.out.println(motorcycle.toString()));

        // Display each category of vehicles in separate files
        Path carPath = Paths.get("C:\\Users\\ktali\\java-advanced-coding\\src\\main\\resources\\cars.txt");
        Files.write(carPath, convertObjectListToStringList(Collections.singletonList(carList)), StandardOpenOption.WRITE);
        // Another way: Files.write(carPath, carList.stream().map(Car::toString).collect(Collectors.toList()), StandardOpenOption.WRITE);
    }


    private static Float convertStringToFloat(String numberStr) {
        try {
            return Float.parseFloat(numberStr);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return 0f;
        }
    }

    private static Long convertStringToLong(String numberStr) {
        try {
            return Long.parseLong(numberStr);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return 0L;
        }
    }

    private static List<String> convertObjectListToStringList(List<Object> objectsList) {
        return objectsList.stream()
                .map(Objects::toString)
                .collect(Collectors.toList());
    }
}
