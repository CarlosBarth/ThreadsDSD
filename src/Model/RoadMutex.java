package Model;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barth_Reichert
 */
public class RoadMutex extends Cell {

    private final Semaphore semaforo;

    public RoadMutex(int direction, int posX, int posY) {
        super(direction, posX, posY);
        this.semaforo = new Semaphore(1);
    }

    @Override
    public void receiveCar(Car car) {
        try {
            while (getCar() != null) {
                sleep(300);
            }
            semaforo.acquire();
            setCar(car);
        } catch (InterruptedException ex) {
            Logger.getLogger(RoadMutex.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            semaforo.release();
        }
    }
    @Override
    public void removeCar() {
        try {
            semaforo.acquire();
            setCar(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
}
