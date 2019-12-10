package model;

interface IPositionable {

    /**
     * @return The objects current x coordinate
     */
    double getCurrentXCoordinate();

    /**
     * @return The objects current y coordinate
     */
    double getCurrentYCoordinate();

    /**
     * @return The length of the object
     */
    int getLength();

    /**
     * @return The width of the object
     */
    int getWidth();

}
