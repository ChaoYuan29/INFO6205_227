import Robot.GeneticAlgorithms;
import Robot.Individual;
import Robot.Population;
import Robot.State;
import org.junit.Test;

public class test {
    @Test
    public void testMutate() throws Exception{
        GeneticAlgorithms ga = new GeneticAlgorithms();
        Individual ind = new Individual();
        ind.generateChromos();
        String s1 = ind.toString();
        System.out.println(s1);
        ga.mutate(ind);
        String s2= ind.toString();
        System.out.println(s2);
        System.out.println(s1.compareTo(s2));
        assert !s1.equals(s2) : "mute failed";

    }
    @Test
    public void testCrossover() throws Exception{
        GeneticAlgorithms ga = new GeneticAlgorithms();
        Individual ind1 = new Individual();
        Individual ind2 = new Individual();
        ind1.generateChromos();
        ind2.generateChromos();
        System.out.println(ind1);
        System.out.println(ind2);
        Individual ind = ga.crossover(ind1, ind2);
        System.out.println(ind);
        int count = 0;
        for (int i= 0; i<200; i++){
            if( ind1.getChromos(i) == ind.getChromos(i)){
                count++;
            }else if(ind2.getChromos(i) == ind.getChromos(i)){
                count++;
            }
        }
        System.out.println(count);
        assert count == 200 : "crossover failed";
    }

    @Test
    public void testEvolve() throws Exception{
        Population p = new Population(100);
        double beforeEvolve = p.getAverage();
        System.out.println(beforeEvolve);
        int count = 0;
        Population np = null;
        while (count < 10) {
            np = GeneticAlgorithms.evolve(p);
            p = np;
            count++;
        }
        double afterEvolve = p.getAverage();
        System.out.println(afterEvolve);

        assert beforeEvolve < afterEvolve : "evolve failed";

    }

    @Test
    public void testGeneExpression() throws Exception{

        Individual ind = new Individual();
        ind.generateChromos();
        System.out.println(ind);
        for (int i=0; i<ind.size(); i++){
            assert ind.getChromos(i) >=0 || ind.getChromos(i) <= 5 : "GeneExpression failed";
        }

    }

    @Test
    public  void testActionNumber() throws Exception{

        State state1 = new State(2,2,2,2,2);
        State state2 = new State(1,1,1,1,1);
        State state3 = new State(0,0,0,0,0);
        Individual ind = new Individual();
        ind.setChromos(242,5);
        ind.setChromos(121,4);
        ind.setChromos(0,3);

        assert ind.getActionNumber(state1) == 5 : "action number is wrong";
        assert ind.getActionNumber(state2) == 4 : "action number is wrong";
        assert ind.getActionNumber(state3) == 3 : "action number is wrong";

    }

    @Test
    public void testChromos() throws Exception{

        Individual ind = new Individual();
        for(int i = 0; i < 10; i++){
            ind.setChromos(i,5-i);
            assert ind.getChromos(i) == 5-i : "get&set chromos failed";
        }
    }


}
