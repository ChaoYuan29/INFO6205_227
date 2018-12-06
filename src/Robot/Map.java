package Robot;

import java.awt.*;

public class Map {

    private int x = 0;
    private int y = 0;
    private int space = 0;
    private int[][] matrix = null;

    public Map(int x, int y){
        this.x = x;
        this.y = y;
        matrix = new int[x][y];
        space = x*y;
    }

    public void setTrees(int v){
        if (v > space){
            v = space;
        }
        while (v > 0){
            int a = (int) (Math.random() * x);
            int b = (int) (Math.random() * y);
            if (matrix[a][b] == 0){
                matrix[a][b] = 1;
                v--;
            }
        }
    }

    public boolean isIntheMap(int x, int y){
        if( x < 0 || x >= this.x) return false;
        if( y < 0 || y >= this.y) return false;
        return true;
    }

    public boolean hasATree(int x, int y){
        if (matrix[x][y] == 0) return false;
        return true;
    }

    public boolean watering(int x, int y){
        if (hasATree(x,y)){
            matrix[x][y] = 0;
            return true;
        }
        return false;
    }

    public Point getStartingPoint(){
        int x = (int) (Math.random()*this.x);
        int y = (int) (Math.random()*this.y);
        return new Point(x,y);
    }

    public State getState(Point o){
        int central = condition(o);
        int forward = condition(new Point(o.x, o.y-1));
        int backward = condition(new Point(o.x, o.y+1));
        int left = condition(new Point(o.x-1, o.y ));
        int right = condition(new Point(o.x+1, o.y ));
        return new State(forward, backward, left, right, central);

    }

    public int condition(Point o){
        int con;
        if (!isIntheMap(o.x,o.y)) con = 0;
        else if (matrix[o.x][o.y] == 0) con = 1;
        else con = 2;

        return con;
    }
    public void print() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Map m = new Map(10, 10);
        m.setTrees(50);
        m.print();
    }

}

