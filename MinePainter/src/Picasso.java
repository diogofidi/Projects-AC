import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Picasso {

    private Ellipse representation;
    private Grid grid;
    private boolean painting;
    private int col;
    private int row;

    public Picasso(int col, int row, Grid grid){
        representation = new Ellipse(Grid.colToX(col),Grid.rowToY(row),Grid.CELL_SIZE,Grid.CELL_SIZE);
        representation.setColor(Color.GRAY);
        representation.fill();
        this.grid = grid;
        this.col = col;
        this.row = row;
        painting = false;
    }
    public void goUp(){
        if(row == 0){
            return;
        }
        row--;
        representation.translate(0, -Grid.CELL_SIZE);
    }
    public void goDown(){
        if(row == grid.getRows() - 1){
            return;
        }
        row++;
        representation.translate(0, Grid.CELL_SIZE);
    }
    public void goRight(){
        if(col == grid.getCols() - 1){
            return;
        }
        col++;
        representation.translate(Grid.CELL_SIZE, 0);
    }
    public void goLeft(){
        if(col == 0){
            return;
        }
        --col;
        representation.translate(-Grid.CELL_SIZE, 0);
    }
    public int getCol(){
        return col;
    }
    public int getRow(){
        return row;
    }
    public boolean isPainting(){
        return painting;
    }
    public void setPainting(boolean painting){
        this.painting = painting;
    }
}
