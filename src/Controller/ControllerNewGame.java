package Controller;

import java.util.ArrayList;
import java.util.List;
import Observer.ObserverNewGame;
import Observer.ObserverMap;

/**
 *
 * @author Barth_Reichert
 */
public class ControllerNewGame {

    private static ControllerNewGame instance = null;

    public static ControllerNewGame getIntance() {
        if (instance == null) {
            instance = new ControllerNewGame();
        }
        return instance;
    }

    private ControllerNewGame() {

    }

    public void selectMap(int id, boolean method) {
        ControllerMap control = ControllerMap.getIntance();
        control.setMap(id, method);
        notifyNewGameStart();
    }

    private List<ObserverNewGame> createNewGameObservers = new ArrayList<>();

    public void attachMap(ObserverNewGame obs) {
        this.createNewGameObservers.add(obs);
    }

    public void detach(ObserverMap obs) {
        this.createNewGameObservers.remove(obs);
    }

    private void notifyNewGameStart() {
        for (ObserverNewGame obs : createNewGameObservers) {
            obs.selectMap();
        }
    }

}
