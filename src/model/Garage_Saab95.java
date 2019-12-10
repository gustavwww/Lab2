package model;

class Garage_Saab95 extends AbstractGarage<Saab95> {

    Garage_Saab95(int maxCars) {
        super(maxCars);
    }

    public boolean addCar(Saab95 saab) {
        return super.addCar(saab);
    }

    public Saab95 removeCar(Saab95 saab){
        return super.removeCar(saab);
    }
}
