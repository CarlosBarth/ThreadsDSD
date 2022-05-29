package Observer;

/**
 *
 * @author Barth_Reichert
 */
public interface ObserverMap {

    void setQtdCars(int value);

    void setQtdCarsError();

    public void setTable(int[][] matrix, int rows, int collumns);

    public void rePaint();
    
    public void setButton(boolean on);

    public void velocidadeInvalida();

}
