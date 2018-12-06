package Robot;

import java.awt.*;

public class Fitness {

    private static int simulateTimes = 2;
    private static int simulateSteps = 200;

    public static int getFitness(Individual individual){
        return getFitness(individual, simulateTimes);
    }

    public static int getFitness(Individual individual, int times){
        int fitness = 0;
        MapGenerator mg = new MapGenerator();
        for(int i = 0; i < times; i++){
            Map map = mg.getMap();
            Point point = map.getStartingPoint();
            for (int j= 0; j < simulateSteps; j++){
                State state = map.getState(point);
                int actionNumber = individual.getActionNumber(state);
                fitness += action(point, map, actionNumber);
            }
        }
        return fitness / simulateTimes;
    }


    private static int action(Point point, Map map, int actionNumber){
        int score = 0;
        switch (actionNumber){
            case 0:
                if (map.isIntheMap(point.x,point.y-1)){
                    score = 0;
                    point.y = point.y-1;
                }else{
                    score = -5;
                }
                break;
            case 1:
                if (map.isIntheMap(point.x-1, point.y)){
                    score = 0;
                    point.x = point.x -1;
                }else {
                    score = -5;
                }
                break;
            case 2:
                if (map.isIntheMap(point.x, point.y + 1)) {
                    score = 0;
                    point.y = point.y + 1;
                } else {
                    score = -5;
                }
                break;
            case 3:
                if (map.isIntheMap(point.x + 1, point.y)) {
                    score = 0;
                    point.x = point.x + 1;
                } else {
                    score = -5;
                }
                break;
            case 4:
                if (map.watering(point.x, point.y)) {
                    score = 10;
                } else {
                    score = -1;
                }
                break;
            case 5:
                score = 0;
                break;
        }
        return score;
    }
}
