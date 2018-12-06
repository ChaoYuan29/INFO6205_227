package Robot;

import Robot.Individual;

public class Population {

    private Individual[] individual;

    public Population(int size){

        individual = new Individual[size];
        for(int i = 0; i < individual.length; i++){
                Individual x = new Individual();
                x.generateChromos();
                individual[i] = x;
        }
    }

    public Individual getIndividual(int v) {
        return individual[v];
    }

    public void setIndividual(int v, Individual individual) {
        this.individual[v] = individual;
    }


    public Individual getBest(){
        Individual best = individual[0];
        for(int i = 1; i < size(); i++){
            if(best.getFitness() <= getIndividual(i).getFitness()){
                best = getIndividual(i);
            }
        }
        return best;
    }
    public Individual getWorst(){
        Individual worst = individual[0];
        for(int i = 1; i<size(); i++){
            if(worst.getFitness()>getIndividual(i).getFitness()){
                worst = getIndividual(i);
            }
        }
        return worst;
    }
    public double getAverage(){
        double sum = 0;
        for (int i = 0; i< size(); i++){
            sum += individual[i].getFitness();
        }
        return sum / size();
    }
    public int size() {
        return individual.length;
}

    @Override
    public String toString(){
        StringBuffer st = new StringBuffer();
        st.append("The size of Population :  " + size() + "\n")
                .append("The best fitness :  " + getBest().getFitness() + "\n")
//                .append("The worst fitness : " + getWorst().getFitness() + "\n")
                .append("Average Fitness : " + getAverage() + "\n");
        return st.toString();
    }

    public static void main(String[] args) {
        Population population = new Population(100);
        System.out.println("..........");
        System.out.println(population);
        int gene = (int) (Math.random() * 5);
        System.out.println(gene);
    }

}
