//Exercise 7.13
public class Counter {

    private int counter;

    public Counter(int value){
        this.counter = value;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


    public void increment(){
        setCounter(getCounter() + 1);
    }

    public void decrement(){
        setCounter(getCounter() - 1);
    }

}
