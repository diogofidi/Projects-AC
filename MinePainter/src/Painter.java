public class Painter {
    public static void main(String[] args) {
        Grid g = new Grid(30, 30);
        Picasso cursor = new Picasso(0, 0, g);
        Illuminatus boss = new Illuminatus(cursor, g);
        KeyboardManager.initKeyEvents(boss);
    }
}