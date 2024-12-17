package org.example;

public class BuilderExample {
    public static void main(String[] args) {
        Director director = new Director();

        Car.Builder<?> carBuilder = new Car.CarBuilder("Toyota", "Camry", 2023);
        director.setBuilder(carBuilder);

        Car standardCar = director.constructStandardCar();
        System.out.println("Standard Car: " + standardCar);

        Car luxuryCar = director.constructLuxuryCar();
        System.out.println("Luxury Car: " + luxuryCar);

        Car.Builder<?> sportCarBuilder = new Car.SportCarBuilder("Ferrari", "F8", 2024);
        director.setBuilder(sportCarBuilder);

        Car sportsCar = director.constructSportsCar();
        System.out.println("Sports Car: " + sportsCar);
    }
}