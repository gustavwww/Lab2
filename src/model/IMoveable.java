package model;

interface IMoveable extends IPositionable {
    /**
     * Moves the object in the correct direction.
     */
    void move();
    /**
     * Direction calculation makes the direction change between 0,1,2,3.
     * Turns right.
     */
    void turn90Left();
    /**
     * Direction calculation makes the direction change between 0,1,2,3.
     * Turns left.
     */
    void turn90Right();

    /**
     * Turns the object in the opposite direction.
     */
    void turn180();

    /**
     * @return Get the current speed of the object
     */
    double getCurrentSpeed();

    /**
     * @return Get the current direction of the object
     */
    int getDirection();
}
