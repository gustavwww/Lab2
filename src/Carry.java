import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Carry implements ICarry{

    /**
     * Stack of objects.
     */
    protected final Deque<AbstractPositionable> objects;
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
    public Carry(int maxObjects, int maxObjectLength) {

        objects = new ArrayDeque<>();
        this.maxObjects = maxObjects;
        this.maxObjectLength = maxObjectLength;
    }

    @Override
    public boolean loadObject(AbstractPositionable carrier, AbstractPositionable object){
        if(objects.size() + 1 <= maxObjects && object.getLength() <= maxObjectLength){
            objects.push(object);
            updateObjectLocation(object, carrier, new Point(0,0) );
            return true;
        }
        return false;
    }
    @Override
    public AbstractPositionable unloadFirstObject(AbstractPositionable carrier, Point offset) {
        if (objects.size() <= 0) {
            return null;
        }
        updateObjectLocation(objects.peek(), carrier, offset);
        return objects.pop();
    }
    @Override
    public AbstractPositionable unloadLastObject(AbstractPositionable carrier, Point offset) {
        if (objects.size() <= 0) {
            return null;
        }
        updateObjectLocation(objects.peekLast(), carrier, offset);
        return objects.removeLast();
    }

    @Override
    public void updateObjectLocation(AbstractPositionable updateObject, AbstractPositionable carrierObject, Point offset){
        updateObject.setCurrentXCoordinate(carrierObject.getCurrentXCoordinate() + offset.x);
        updateObject.setCurrentYCoordinate(carrierObject.getCurrentYCoordinate() + offset.y);
    }


}
