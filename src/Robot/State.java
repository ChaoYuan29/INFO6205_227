package Robot;

public class State {

    private int forward;
    private int backward;
    private int left;
    private int right;
    private int central;

    public State(int forward, int backward, int left, int right, int central){

        this.backward = backward;
        this.forward = forward;
        this.left = left;
        this.right =right;
        this.central = central;

    }

    public int getBackward() {
        return backward;
    }

    public void setBackward(int backward) {
        this.backward = backward;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getCentral() {
        return central;
    }

    public void setCentral(int central) {
        this.central = central;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }
}
