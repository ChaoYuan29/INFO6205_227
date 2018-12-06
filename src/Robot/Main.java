package Robot;

public class Main {
    public static void main(String[] args){
        Population population = new Population(1000);
//        System.out.println(population);
//        Population p = GeneticAlgorithms.evolve(population);
//        System.out.println(p);
        int count = 1;
        double a = 0.0;
        do {
            Population p = GeneticAlgorithms.evolve(population);
            if (count % 5 == 0) {
                System.out.println("The " + count + " generations");
                System.out.println(p);
            }
            population = p;
            a = population.getAverage();
            System.out.println("-----------++++ " + a + " +++++-----------");
            count++;
        }while(population.getAverage() < 400 && count <= 10000);
    }

}
