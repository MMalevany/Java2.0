import java.util.ArrayList;
import java.util.List;

public class CalculatorThread implements Runnable {
    private int number;
    private boolean task;
    private List<Integer> list = new ArrayList<>();

    public CalculatorThread(int number) {
        this.number = number;
        this.task = true;
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public void run() {
        while (task) {
            for (int i = 1; i < number; i++) {
                if ((i % 5) == 1) {
                    System.out.println("Start thread " + Thread.currentThread().getName());
                    try {
                        list.add(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            task = false;
        }
        System.out.println("Finish thread " + Thread.currentThread().getName());
    }
}
