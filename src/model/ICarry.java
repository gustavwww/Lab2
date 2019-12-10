package model;

import java.awt.*;

public interface ICarry<T extends AbstractPositionable> {

    T unload();
    boolean load(T t);

}
