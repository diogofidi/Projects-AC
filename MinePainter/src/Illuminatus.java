import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Illuminatus implements KeyboardHandler {

    private Picasso cursor;
    private Grid grid;

    public Illuminatus(Picasso cursor, Grid grid){
        this.cursor = cursor;
        this.grid = grid;
    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()){
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
            case KeyboardEvent.KEY_SPACE:
                cursor.setPainting(true);
                grid.paintCell(cursor.getRow(), cursor.getCol());
                break;
        }
    }
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()){
            case KeyboardEvent.KEY_UP:
                cursor.goUp();
                if(cursor.isPainting()){
                    grid.paintCell(cursor.getRow(),cursor.getCol());
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                cursor.goDown();
                if(cursor.isPainting()){
                    grid.paintCell(cursor.getRow(),cursor.getCol());
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                cursor.goLeft();
                if(cursor.isPainting()){
                    grid.paintCell(cursor.getRow(),cursor.getCol());
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                cursor.goRight();
                if(cursor.isPainting()){
                    grid.paintCell(cursor.getRow(),cursor.getCol());
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                cursor.setPainting(false);
                break;
            case KeyboardEvent.KEY_S:
                FileManager.write(grid.toString());
                break;
            case KeyboardEvent.KEY_L:
                grid.fromString(FileManager.read());
                break;
        }
    }
}