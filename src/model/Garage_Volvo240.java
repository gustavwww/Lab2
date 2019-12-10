package model;

class Garage_Volvo240 extends AbstractGarage<Volvo240> {

    Garage_Volvo240(int maxCars) {
        super(maxCars);
    }

    public boolean addCar(Volvo240 volvo) {
        return super.addCar(volvo);
    }

    public Volvo240 removeCar(Volvo240 volvo){
        return (Volvo240) super.removeCar(volvo);
    }
}
