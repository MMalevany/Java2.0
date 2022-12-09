import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadGenerator {
    private static char function;
    private static int thread;
    private static int number;
    static List<List<Integer>> list2 = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Enter count of threads: ");
        try (Scanner sc = new Scanner(System.in)) {
            thread = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the number A: ");
            number = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the action symbol: ");
            function = sc.nextLine().charAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        execute();
        System.out.println(getResult());
    }

    private static void execute() {
        List<CalculatorThread> calcList = new ArrayList<>();
        ThreadFactory trF = Executors.defaultThreadFactory();
        ThreadPoolExecutor poolThr = new ThreadPoolExecutor(10, 500, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(8), trF);
        for (int i = 0; i < thread; i++) {
            CalculatorThread cl = new CalculatorThread(number);
            calcList.add(cl);
            poolThr.execute(cl);
        }
        poolThr.shutdown();
        try {
            if (poolThr.getActiveCount() != 0) {
                Thread.currentThread().join(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (var s : calcList) {
            System.out.println(s.getList());
            list2.add(s.getList());
        }
    }

    private static Integer getResult() {
        int f = 0;
        switch (function) {
            case '+' -> {
                for (List<Integer> s : list2) {
                    for (var s2 : s) {
                        f += s2;
                    }
                }
                return f;
            }
            case '-' -> {
                for (List<Integer> s : list2) {
                    for (var s2 : s) {
                        f -= s2;
                    }
                }
                return f;
            }
            case '*' -> {
                f = 1;
                for (List<Integer> s : list2) {
                    for (var s2 : s) {
                        f *= s2;
                    }
                }
                return f;
            }
            default -> {
                return 0;
            }
        }
    }
}