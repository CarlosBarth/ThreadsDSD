package Controller;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Car;
import Observer.ObserverGame;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Barth_Reichert
 */
public class ControllerCar extends Thread {

    private Car car;
    private int contador;
    private int velocidade = 300;

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    ControllerMap controller = ControllerMap.getIntance();

    public ControllerCar(Car car, int velocity) {
        this.car = car;
        this.velocidade = velocity;
    }

    @Override
    public void run() {
        Random rand = new Random();
        controller.notifyRepaint();
        try {
            //Inicia o ciclo de vida do carro
            while (!this.car.getCurrentRoad().getNextCell().isEmpty()) {

                //velocidade do carro
                sleep(velocidade); 

                int numRand = rand.nextInt(2);
                if (this.car.getCurrentRoad().isIsCruzamento()) {
                    if (this.car.getOldRoad().isIsCruzamento()) {
                        contador++;
                    } else {
                        contador = 0;
                    }
                    if (contador >= 2) {
                        contador = 0;
                        if (this.car.getCurrentRoad().getNextCell().get(0).isIsCruzamento()) {
                            numRand = 1;
                        } else {
                            numRand = 0;
                        }
                    }
                    
                    this.car.getCurrentRoad().getNextCell().get(numRand).receiveCar(car);
                    this.car.getCurrentRoad().removeCar();
                    this.car.setOldRoad(this.car.getCurrentRoad());
                    this.car.setCurrentRoad(this.car.getCurrentRoad().getNextCell().get(numRand));
                    this.car.setNextDirection(numRand);

                } else {
                    
                    this.car.getCurrentRoad().getNextCell().get(0).receiveCar(car);
                    this.car.getCurrentRoad().removeCar();
                    this.car.setOldRoad(this.car.getCurrentRoad());
                    this.car.setCurrentRoad(this.car.getCurrentRoad().getNextCell().get(0));
                }
                
                controller.setCarImage(car);
                controller.notifyRepaint();
            }

            //Destroi o carro quando chega no fim
            sleep(velocidade);
            controller.setCarImage(car);
            this.car.getCurrentRoad().removeCar();
            controller.decreaseQtdCars();
            controller.notifyRepaint();
            controller.getSpawn().removeCar();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControllerCar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
