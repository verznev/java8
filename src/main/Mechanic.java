package main;

import main.domain.Car;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Win7 on 2/3/2018.
 */
public class Mechanic {

    public Mechanic() {
        System.out.println("I am a constructor that don't have arguments.");
    }

    public Mechanic(String arg) {
        System.out.println("I am a constructor that does have argument: " + arg);
    }

    public Mechanic(String arg1, String arg2) {
        System.out.println("I am a constructor that does have 2 arguments: " + arg1 + " and " + arg2);
    }

    public void fix(Car c) {
        System.out.println("Fixing car " + c.getId() + " color " + c.getColor());
    }

    public void executeFix(Car car, Consumer<Car> c) {
        c.accept(car);
    }

}
