package Robot;

public class Individual {

    private static int length = 243;
    private static int action = 6;

    private int chromos [] = null;
    private int fitness;

    public Individual(){
        chromos = new int [length];
    }

    public void generateChromos(){
        for (int i = 0; i < length; i++){
            int gene = (int) (Math.random() * action);
            chromos[i] = gene;
        }
    }

    public int getFitness(){
        fitness = Fitness.getFitness(this);
        return fitness;
    }

    public int getActionNumber(State state){
        int code = (int) (state.getForward()*Math.pow(3,4) + state.getBackward()*Math.pow(3,3)
        + state.getLeft()*Math.pow(3,2) + state.getRight()* 3 + state.getCentral());
        return chromos[code];
    }


    public int getChromos(int v) {
        return chromos[v];
    }

    public void setChromos(int v, int chromos) {
        this.chromos[v] = chromos;
    }

    public int size() {
        return length;
    }

    @Override
    public String toString() {
        StringBuffer st = new StringBuffer();
        for (int i = 0; i < length; i++) {
            st.append(chromos[i]);
        }
        return st.toString();
    }

    public static void main(String[] args) {
        Individual ind = new Individual();
        ind.generateChromos();
        System.out.println(ind);
        System.out.println(ind.getFitness());
    }
}


