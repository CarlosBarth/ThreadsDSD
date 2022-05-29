package Observer;

/**
 *
 * @author Barth_Reichert
 */
public interface ObserverGame {

    void setQtdCars(int value);
    
    void addQtdCars();
    
    void decreaseQtdCars();

    void setQtdCarsError();

    public void setTable(int[][] matrix, int rows, int collumns);

    public void rePaint();
    
    public void setButton(boolean on);

    public void velocidadeInvalida();

}
