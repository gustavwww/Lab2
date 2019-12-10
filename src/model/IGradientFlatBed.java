package model;

public interface IGradientFlatBed extends IVehicle {

    boolean raiseBed(double amount);
    boolean lowerBed(double amount);
}
