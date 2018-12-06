package Robot;

public class MapGenerator {
    private static int x;
    private static int y;
    private static int trees;
//    private static int num;

    private static MapGenerator mg = null;
    private Map[] maps;

    public MapGenerator() {
        this.x = 10;
        this.y = 10;
        this.trees = 50;

    }



    public Map getMap() {

        Map map = new Map(x, y);
        map.setTrees(trees);
        return map;

    }

    public static void main(String[] args) {
        MapGenerator mg = new MapGenerator();
        mg.getMap().print();

    }

}
