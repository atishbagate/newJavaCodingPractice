package MultiThreading.ThreadPools.ForkJoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class ForkJoinLoggingDemo {

    // Configure a clean single-line logger for thread tracing
    private static final Logger LOGGER = Logger.getLogger(ForkJoinLoggingDemo.class.getName());

    static {
        LOGGER.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return String.format("[%s] [%s] %s%n",
                        record.getSourceMethodName(),
                        Thread.currentThread().getName(),
                        record.getMessage());
            }
        });
        LOGGER.addHandler(handler);
    }

    public static void main(String[] args) {
        int[] data = {12, 45, 7, 89, 23, 56, 91, 34, 67, 10};

        LOGGER.info("Input Array: " + Arrays.toString(data));

        // Create a ForkJoinPool.md with 4 worker threads
        ForkJoinPool pool = new ForkJoinPool(4);

        FindMaxTask rootTask = new FindMaxTask(data, 0, data.length);

        LOGGER.info("Invoking ForkJoinPool.md...");
        int maxResult = pool.invoke(rootTask);

        LOGGER.info("Final Maximum Value Found: " + maxResult);

        pool.shutdown();
    }

    // RecursiveTask to compute the maximum value in an array segment
    static class FindMaxTask extends RecursiveTask<Integer> {
        private static final int THRESHOLD = 3; // Small threshold to force task splitting
        private final int[] array;
        private final int start;
        private final int end;

        public FindMaxTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int length = end - start;

            // BASE CASE: Process sequentially when size <= THRESHOLD
            if (length <= THRESHOLD) {
                LOGGER.info(String.format("BASE CASE processing range [%d, %d)", start, end));
                int max = Integer.MIN_VALUE;
                for (int i = start; i < end; i++) {
                    if (array[i] > max) {
                        max = array[i];
                    }
                }
                LOGGER.info(String.format("BASE CASE result for range [%d, %d) is %d", start, end, max));
                return max;
            }

            // RECURSIVE STEP: Split range into two halves
            int mid = start + (length / 2);
            LOGGER.info(String.format("SPLITTING range [%d, %d) -> Left: [%d, %d), Right: [%d, %d)",
                    start, end, start, mid, mid, end));

            FindMaxTask leftTask = new FindMaxTask(array, start, mid);
            FindMaxTask rightTask = new FindMaxTask(array, mid, end);

            // 1. FORK: Push leftTask to the current thread's deque (available to be stolen)
            leftTask.fork();

            // 2. COMPUTE: Current thread works on the rightTask directly (avoids idle waiting)
            Integer rightResult = rightTask.compute();

            // 3. JOIN: Wait for leftTask result (computes locally if not stolen yet)
            Integer leftResult = leftTask.join();

            // COMBINE: Take the max of both sub-results
            int combinedMax = Math.max(leftResult, rightResult);
            LOGGER.info(String.format("JOINED range [%d, %d) -> Combined Max: %d", start, end, combinedMax));

            return combinedMax;
        }
    }
}