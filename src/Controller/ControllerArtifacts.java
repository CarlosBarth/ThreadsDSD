package Controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barth_Reichert
 */
public class ControllerArtifacts extends Thread {

    ControllerMap ctrlMap = ControllerMap.getIntance();
    private int velocidade = 500;
    private boolean on = true;

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    private int totalCars = 0;

    public void removeCar() {
        this.totalCars--;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public void run() {
        while (on) {
            try {
                if (totalCars < ctrlMap.getQtdCars()) {
                    ctrlMap.spawnCar();
                    totalCars++;
                    sleep(velocidade);
                }
                sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControllerArtifacts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
