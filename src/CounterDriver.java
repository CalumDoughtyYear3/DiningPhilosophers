public class CounterDriver {
    public static void main(String[] args) {

        ThreadGroup threadGroupA = new ThreadGroup("threadGroupA");
        CounterApp a1 = new CounterApp("Aone", threadGroupA);
        System.out.println("Starting A one");
        CounterApp a2 = new CounterApp("Atwo", threadGroupA);
        System.out.println("Starting A two");
        CounterApp a3 = new CounterApp("Athree", threadGroupA);
        System.out.println("Starting A three");

        ThreadGroup threadGroupB = new ThreadGroup("threadGroupB");
        CounterApp b1 = new CounterApp("Bone", threadGroupB);
        System.out.println("Starting B one");
        CounterApp b2 = new CounterApp("Btwo", threadGroupB);
        System.out.println("Starting B two");
        CounterApp b3 = new CounterApp("Bthree", threadGroupB);
        System.out.println("Starting B three");

        // checking the number of active thread
        System.out.println("number of active thread: " + threadGroupA.activeCount());
        System.out.println("number of active thread: " + threadGroupB.activeCount());


    }
}
