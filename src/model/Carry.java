package model;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Carry<T extends AbstractPositionable> {

    /**
     * Stack of objects.
     */
    private final Deque<T> objects;
    /**
     * The Carrier object.
     */
    private final AbstractPositionable carrier;
    /**
     * The maximum capacity of the carrier.
     */
    private final int maxObjects;
    /**
     * The maximum length of the objects.
     */
    private final int maxObjectLength;

    /**
     * Constructor for generic carrier.
     * @param maxObjects The maximum capacity of the carrier.
     * @param maxObjectLength The maximum length of the object.
     */
    Carry(AbstractPositionable carrier, int maxObjects, int maxObjectLength) {
        objects = new ArrayDeque<>();
        this.carrier = carrier;
        this.maxObjects = maxObjects;
        this.maxObjectLength = maxObjectLength;
    }

    /**
     * Loads an object into the current carrier object.
     * @param object Current object.
     * @return An object will be loaded to the carrier, returns true if successful.
     */
    public boolean loadObject(T object){
        if(objects.size() + 1 <= maxObjects && object.getLength() <= maxObjectLength){
            objects.push(object);
            updateObjectLocation(object, new Point(0,0) );
            return true;
        }
        return false;
    }

    /**
     * Unloads an object from the current carrier object.
     * @param offset How far away from the carrier the object will be placed.
     * @return First in first out. Returns the removed object.
     */
    public T unloadFirstObject(Point offset) {
        if (objects.size() <= 0) {
            return null;
        }
        updateObjectLocation(objects.peek(), offset);
        return objects.pop();
    }

    /**
     * Unloads an object from the current carrier object.
     * @param offset How far away from the carrier the object will be placed.
     * @return First in last out. Returns the removed object.
     */
    public T unloadLastObject(Point offset) {
        if (objects.size() <= 0) {
            return null;
        }
        updateObjectLocation(objects.peekLast(), offset);
        return objects.removeLast();
    }

    /**
     * Updates the location of the objects in the carrier object.
     * @param object The current object.
     * @param offset Offset from the carrier object.
     */
    public void updateObjectLocation(T object, Point offset){
        object.setCurrentXCoordinate(carrier.getCurrentXCoordinate() + offset.x);
        object.setCurrentYCoordinate(carrier.getCurrentYCoordinate() + offset.y);
    }

    /**
     * Updates the location of all objects on the carrier object.
     */
    public void updateAllObjectsLocation() {
        for (T object : objects) {
            updateObjectLocation(object, new Point(0,0));
        }
    }


}
