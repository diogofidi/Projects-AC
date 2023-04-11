public class Grid {

    public static final int CELL_SIZE = 25;
    public static final int PADDING = 10;

    public Cell[][] cells;
    private int rows;
    private int cols;
    public Grid(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        InitCells();
    }
    private void InitCells(){
        cells = new Cell[rows][cols];
        for( int row = 0; row < rows; row++ ){
            for( int col = 0; col < cols; col++){
                cells[row][col] = new Cell(row,col);
            }
        }
    }
    public void paintCell(int row, int col){
        Cell c = cells[row][col];
        if(c.isPainted()){
            c.clear();
            return;
        }
        c.paint();
    }
    public static int colToX(int col){
        return col * CELL_SIZE + PADDING;
    }
    public static int rowToY(int row){
        return row * CELL_SIZE + PADDING;
    }
    public int getCols(){
        return cols;
    }
    public int getRows(){
        return rows;
    }
    public void fromString(String gridString){
        if(gridString == null){
            return;
        }
        String[] lines = gridString.split("\n");
        for(int row = 0; row < lines.length; row++){
            String[] line = lines[row].split(" ");
            for(int col = 0; col < lines.length; col++){
                if(line[col].equals("1")){
                    cells[row][col].paint();
                } else {
                    cells[row][col].clear();
                }
            }
        }
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(Cell[] innerArray : cells){
            for(Cell cell : innerArray){
                builder.append(cell.toString());
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}