package org.example;

public class Car {
    private final String make;
    private final String model;
    private final int year;
    private final String color;
    private final boolean sunroof;
    private final int topSpeed;

    private Car(Builder<?> builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.color = builder.color;
        this.sunroof = builder.sunroof;
        this.topSpeed = builder.topSpeed;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public boolean hasSunroof() {
        return sunroof;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", sunroof=" + sunroof +
                ", topSpeed=" + topSpeed +
                '}';
    }

    public static abstract class Builder<T extends Builder<T>> {
        private final String make;
        private final String model;
        private final int year;

        protected String color = "Unknown";
        protected boolean sunroof = false;
        protected int topSpeed = 180;

        public Builder(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        public T setColor(String color) {
            this.color = color;
            return self();
        }

        public T setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return self();
        }

        public T setTopSpeed(int topSpeed) {
            this.topSpeed = topSpeed;
            return self();
        }

        protected abstract T self();

        public Car build() {
            return new Car(this);
        }
    }

    public static class CarBuilder extends Builder<CarBuilder> {
        public CarBuilder(String make, String model, int year) {
            super(make, model, year);
        }

        @Override
        protected CarBuilder self() {
            return this;
        }
    }

    public static class SportCarBuilder extends Builder<SportCarBuilder> {
        public SportCarBuilder(String make, String model, int year) {
            super(make, model, year);
        }

        @Override
        protected SportCarBuilder self() {
            return this;
        }
    }
}

class Director {
    private Car.Builder<?> builder;

    public void setBuilder(Car.Builder<?> builder) {
        this.builder = builder;
    }

    public Car constructStandardCar() {
        return builder
                .setColor("Blue")
                .setSunroof(false)
                .setTopSpeed(200)
                .build();
    }

    public Car constructLuxuryCar() {
        return builder
                .setColor("Black")
                .setSunroof(true)
                .setTopSpeed(220)
                .build();
    }

    public Car constructSportsCar() {
        return builder
                .setColor("Yellow")
                .setTopSpeed(350)
                .setSunroof(true)
                .build();
    }
}
