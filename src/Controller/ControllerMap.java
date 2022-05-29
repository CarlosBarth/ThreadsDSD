package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import Model.Car;
import Model.Cell;
import Model.RoadMonitor;
import Model.RoadMutex;
import Observer.ObserverGame;

/**
 *
 * @author Barth_Reichert
 */
public class ControllerMap {

    private int mapID;
    private int carID;
    private int matrix[][];
    private Cell matrixCell[][];
    private int rows;
    private int collumns;
    private int qtdCars;
    private int velocidadeCarro = 300;
    private static ControllerMap instance = null;
    private ControllerSpawner spawn;

    public ControllerSpawner getSpawn() {
        return spawn;
    }

    public static ControllerMap getIntance() {
        if (instance == null) {
            instance = new ControllerMap();
        }
        return instance;
    }

    private ControllerMap() {

    }

    public int getColumns() {
        return collumns;
    }

    public int getRows() {
        return rows;
    }

    public void setMap(int id, boolean isMutex) {
        this.mapID = id;
        String arquivo = "./malhas/malha" + mapID + ".txt";
        try {
            BufferedReader in = new BufferedReader(new FileReader(arquivo));
            this.rows = Integer.parseInt(in.readLine().trim());
            this.collumns = Integer.parseInt(in.readLine().trim());

            matrix = new int[rows][collumns];
            for (int i = 0; i < rows; i++) {
                String row[] = in.readLine().split("\t");
                for (int j = 0; j < collumns; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        convertMatrixToCell(isMutex);
    }

    private void convertMatrixToCell(boolean isMutex) {
        matrixCell = new Cell[this.rows][this.collumns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collumns; j++) {
                if (matrix[i][j] != 0) {
                    RoadMutex newMutex;
                    RoadMonitor newMonitor;
                    if (isMutex) {
                        newMutex = new RoadMutex(matrix[i][j], i, j);
                        matrixCell[i][j] = newMutex;
                        roadSpawner(newMutex);
                    } else {
                        newMonitor = new RoadMonitor(matrix[i][j], i, j);
                        matrixCell[i][j] = newMonitor;
                        roadSpawner(newMonitor);
                    }
                } else {
                    matrixCell[i][j] = null;
                }
            }
        }
        setNextCell();
    }

    private void setNextCell() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collumns; j++) {
                Cell road = matrixCell[i][j];
                if (road != null) {
                    try {
                        switch (road.getDirection()) {
                            case 1:
                                //cima
                                road.addNextCell(matrixCell[i - 1][j]); 

                                break;
                            case 2:
                                //direita
                                road.addNextCell(matrixCell[i][j + 1]); 
                                break;
                            case 3:
                                // baixo
                                road.addNextCell(matrixCell[i + 1][j]); 
                                break;
                            case 4:
                                // esquerda
                                road.addNextCell(matrixCell[i][j - 1]); 
                                break;
                            case 5:
                                //cima
                                road.addNextCell(matrixCell[i - 1][j]); 
                                break;
                            case 6:
                                //direita
                                road.addNextCell(matrixCell[i][j + 1]);
                                break;
                            case 7:
                                //baixo
                                road.addNextCell(matrixCell[i + 1][j]);
                                break;
                            case 8:
                                //esquerda
                                road.addNextCell(matrixCell[i][j - 1]);
                                break;
                            case 9:
                                road.addNextCell(matrixCell[i - 1][j]);
                                road.addNextCell(matrixCell[i][j + 1]);
                                break;
                            case 10:
                                road.addNextCell(matrixCell[i - 1][j]);
                                road.addNextCell(matrixCell[i][j - 1]);
                                break;
                            case 11:
                                road.addNextCell(matrixCell[i + 1][j]);
                                road.addNextCell(matrixCell[i][j + 1]);
                                break;
                            case 12:
                                road.addNextCell(matrixCell[i + 1][j]);
                                road.addNextCell(matrixCell[i][j - 1]);
                                break;
                        }
                    } catch (Exception e) {
                       
                    }
                }
            }
        }

    }

    public Icon getImage(int col, int row) {
        return new ImageIcon();
    }

    public void mapLoad() {
        notifySetTable(matrix);
    }

    public void setCars(int value) {
        this.qtdCars = value;
        if (value < 0) {
            notifyQtdCarsError();
            return;
        }
        notifyQtdCars(value);
    }

    public synchronized void setCarImage(Car car) {

        int currentDir = car.getCurrentRoad().getDirection();
        int oldDir = 0;
        if (car.getOldRoad() != null) {
            oldDir = car.getOldRoad().getDirection();
        }
        if (currentDir > 4) {
            switch (currentDir) {
                case 5:
                    //cima
                    car.setImg(1); 
                    break;
                case 6:
                    //direita
                    car.setImg(2);
                    break;
                case 7:
                    //baixo
                    car.setImg(3);
                    break;
                case 8:
                    //esquerda
                    car.setImg(4);
                    break;
                case 9:
                    if (car.getNextDirection() == 0) {
                        car.setImg(1);
                    } else {
                        car.setImg(2);
                    }
                    break;
                case 10:
                    if (oldDir <= 4) {
                        if (car.getNextDirection() == 0) {
                            car.setImg(4);
                        } else {
                            car.setImg(1);
                        }
                    } else {
                        if (car.getNextDirection() == 0) {
                            car.setImg(1);
                        } else {
                            car.setImg(4);
                        }
                    }
                    break;
                case 11:
                    if (oldDir <= 4) {
                        if (car.getNextDirection() == 0) {
                            car.setImg(2);
                        } else {
                            car.setImg(3);
                        }
                    } else {

                        car.setImg(3);
                    }
                    break;
                case 12:
                    if (oldDir <= 4) {
                        if (car.getNextDirection() == 0) {
                            car.setImg(3);
                        } else {
                            car.setImg(4);
                        }
                    } else {
                        car.setImg(4);
                    }
                    break;
            }

        } else {
            car.setImg(currentDir);
        }
    }

    public void spawnCar() {
        List<Cell> roads = new ArrayList();
        for (Cell[] roadLine : matrixCell) {
            for (Cell road : roadLine) {
                if (road != null && road.isIsSpawner()) {
                    roads.add(road);
                }
            }
        }
        Random rand = new Random();
        printCar(roads.get(rand.nextInt(roads.size())));

    }

    private void printCar(Cell road) {
        road.receiveCar(createCar(road));
    }

    private Car createCar(Cell road) {
        Car newCar = new Car(carID++, road);
        setCarImage(newCar);
        ControllerCar driver = new ControllerCar(newCar, this.velocidadeCarro);
        driver.start();
        addQtdCars();
        return newCar;
    }

    private void roadSpawner(Cell road) {
        if (road != null) {
            if (road.getPosY() == 0) {
                if (road.getDirection() == 2) {
                    road.setIsSpawner(true);
                }
            } else if (road.getPosY() == (matrix[0].length - 1)) {
                if (road.getDirection() == 4) {
                    road.setIsSpawner(true);
                }
            }

            if (road.getPosX() == 0) {
                if (road.getDirection() == 3) {
                    road.setIsSpawner(true);
                }
            } else if (road.getPosX() == (matrix.length - 1)) {
                if (road.getDirection() == 1) {
                    road.setIsSpawner(true);
                }
            }
        }
    }

    public ImageIcon getRoad(int row, int collumn) {
        if (matrixCell[row][collumn].getCar() == null) {
            return new ImageIcon("./assets/asfalto.jpg");
        }
        return new ImageIcon(matrixCell[row][collumn].getCar().getImg());
    }

    public void setCarVelocity(int velocity) {
        if (velocity >= 0) {
            this.velocidadeCarro = velocity;

        } else {
            notifyVelocidadeInvalida();
        }

    }

    public int getQtdCars() {
        return qtdCars;
    }

    public void start() {
        notifyDisableButton(true);
        spawn = new ControllerSpawner();
        spawn.start();
    }

    public void stop() {
        notifyDisableButton(false);
        spawn.setOn(false);
    }

    //observer
    private List<ObserverGame> mapObserver = new ArrayList<>();

    public void attachMap(ObserverGame obs) {
        this.mapObserver.add(obs);
    }

    public void detach(ObserverGame obs) {
        this.mapObserver.remove(obs);
    }

    private void notifyQtdCars(int value) {
        for (ObserverGame obs : mapObserver) {
            obs.setQtdCars(value);
        }
    }

    private void addQtdCars() {
        for (ObserverGame obs : mapObserver) {
            obs.addQtdCars();
        }
    }

    public void decreaseQtdCars() {
        for (ObserverGame obs : mapObserver) {
            obs.decreaseQtdCars();
        }
    }

    private void notifyQtdCarsError() {
        for (ObserverGame obs : mapObserver) {
            obs.setQtdCarsError();
        }
    }

    private void notifySetTable(int[][] matrix) {
        for (ObserverGame obs : mapObserver) {
            obs.setTable(matrix, rows, collumns);
        }

    }

    public void notifyRepaint() {
        for (ObserverGame obs : mapObserver) {
            obs.rePaint();
        }
    }

    private void notifyDisableButton(boolean on) {
        for (ObserverGame obs : mapObserver) {
            obs.setButton(on);
        }
    }

    private void notifyVelocidadeInvalida() {
        for (ObserverGame obs : mapObserver) {
            obs.velocidadeInvalida();
        }
    }

    public void setCarInsertion(int velocidade) {
        spawn.setVelocidade(velocidade);

    }

}
