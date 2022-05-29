package Model;

/**
 *
 * @author Barth_Reichert
 */
public class RoadMonitor extends Cell {

    public RoadMonitor(int direction, int posX, int posY) {
        super(direction, posX, posY);
    }

    @Override
     public synchronized void receiveCar(Car car) {
        try {
            while (getCar() != null) {
                wait(10);
            }
            setCar(car);
        } catch (Exception e) {
        }
    }

    @Override
    public synchronized void removeCar() {
        super.car = null;
    }
}
