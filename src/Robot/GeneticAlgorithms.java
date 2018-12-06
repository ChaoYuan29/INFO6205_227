package Robot;

public class GeneticAlgorithms {

    private static final double crossRate = 0.5;
    private static final double mutateRate = 0.001;
    private static final int selectedpart = 10;

    public static Population evolve(Population population){
        Population p = new Population(population.size());
        for (int i = 0; i < population.size(); i++){
            Individual v1 = selectIndividuals(population);
            Individual v2 = selectIndividuals(population);

            Individual v = crossover(v1,v2);
            p.setIndividual(i,v);
        }
        for(int i = 0; i< p.size();i++){
            mutate(p.getIndividual(i));
        }
        return p;
    }

    public static Individual selectIndividuals(Population population){
        Population p = new Population(selectedpart);
        for(int i = 0; i < selectedpart; i++){
            int n = (int) (Math.random()*population.size());
            p.setIndividual(i,population.getIndividual(n));
        }
        Individual best = p.getBest();
        return best;
    }

    public static void mutate(Individual individual){
        for(int i = 0; i < individual.size(); i++){
            if (Math.random() <= mutateRate){
                int chromo = (int) (Math.random()*6);
                individual.setChromos(i, chromo);
            }
        }
    }

    public static Individual crossover(Individual v1, Individual v2){
        Individual individual = new Individual();
        for (int i = 0; i < v1.size(); i++){
            if (Math.random() <= crossRate){
                individual.setChromos(i, v1.getChromos(i));
            }else {
                individual.setChromos(i,v2.getChromos(i));
            }
        }
        return individual;
    }


}
