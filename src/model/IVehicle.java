package model;

public interface IVehicle extends IMoveable {

    void startEngine();
    void stopEngine();
    boolean gas(double amount);
    boolean brake(double amount);

    String getModelName();
}
