package model;

import java.util.Random;

public class VehicleFactory {

    private VehicleFactory() {}

    public static IVehicle createVolvo240(int x, int y) {
        return new Volvo240(x, y);
    }

    public static IVehicle createSaab95(int x, int y) {
        return new Saab95(x, y);
    }

    public static IVehicle createScania(int x, int y) {
        return new Scania(x, y);
    }

    public static IVehicle createRandomVehicle(int x, int y) {
        switch (new Random().nextInt(3)) {
            case 0:
                return new Volvo240(x, y);
            case 1:
                return new Saab95(x, y);
            case 2:
                return new Scania(x, y);
        }
        throw new Error();
    }

}
