package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        AList<Integer> N = new AList<>();
        for (int i = 0; i < sizes.length; i++) {
            N.addLast(sizes[i]);
        }

        AList<Integer> M = new AList<>();
        for (int i = 0; i < sizes.length; i++) {
            M.addLast(10000);
        }

        AList<Double> times = new AList<>();
        for (int i = 0; i < N.size(); i++) {
            SLList<Integer> lst = new SLList<>();
            for (int j = 0; j < N.get(i); j++) {
                lst.addLast(i);
            }

            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < M.get(i); j++) {
                lst.getLast();
            }
            times.addLast(sw.elapsedTime());
        }

        printTimingTable(N, times, M);
    }

}
