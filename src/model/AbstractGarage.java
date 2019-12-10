package model;

import java.util.ArrayList;

abstract class AbstractGarage<A extends Car> {

    private final int maxCars;
    private final ArrayList<A> cars;

    AbstractGarage(int maxCars) {
        this.maxCars = maxCars;
        cars = new ArrayList<A>();
    }

    protected boolean addCar(A car){
        if (cars.size() + 1 > maxCars ) {
            return false;
        }
        cars.add(car);
        return true;
    }
    protected A removeCar(A car){
        if (!cars.contains(car)) {
            return null;
        }
        cars.remove(car);
        return car;
    }


}
