package model;

import java.awt.*;

interface ICarry {
    /**
     * Loads an object into the current carrier object.
     * @param carrier Current carrier object.
     * @param object Current object.
     * @return An object will be loaded to the carrier, returns true if successful.
     */
    boolean loadObject(AbstractPositionable carrier, AbstractPositionable object);

    /**
     * Unloads an object from the current carrier object.
     * @param carrier Current carrier object.
     * @param offset How far away from the carrier the object will be placed.
     * @return First in first out. Returns the removed object.
     */
    AbstractPositionable unloadFirstObject(AbstractPositionable carrier, Point offset);

    /**
     * Unloads an object from the current carrier object.
     * @param carrier Current carrier object.
     * @param offset How far away from the carrier the object will be placed.
     * @return First in last out. Returns the removed object.
     */
    AbstractPositionable unloadLastObject(AbstractPositionable carrier, Point offset);

    /**
     * Updates the location of the objects in the carrier object.
     * @param updateObject Current object.
     * @param carrierObject Current carrier object.
     * @param offset Offset from the carrier object.
     */
    void updateObjectLocation(AbstractPositionable updateObject, AbstractPositionable carrierObject, Point offset);

}
