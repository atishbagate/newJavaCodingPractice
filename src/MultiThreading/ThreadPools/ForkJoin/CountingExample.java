package MultiThreading.ThreadPools.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class CountingExample {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        ForkJoinPool pool = new ForkJoinPool(2);
        CountEvenTask rootTask = new CountEvenTask(data, 0, data.length);
        int totalEvenCount = pool.invoke(rootTask);
        System.out.println("Total even count : " + totalEvenCount);
        pool.shutdown();

    }

    // task to count even numbers in a slice of the array.
    static class CountEvenTask extends RecursiveTask<Integer> {

        private static final int THRESHOLD = 3; // split if more than 3 items
        private final int[] numbers;
        private final int start;
        private final int end;

        public CountEvenTask(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int length = end - start;
            // 1 . base case : small enough to count with simple loop
            if (length <= THRESHOLD) {
                int count = 0;
                for (int i = start; i < end; i++) {
                    if (numbers[i] % 2 == 0) {
                        count++;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " Processed [ " + start + " - " + (end - 1) + " ] => found :  " + count);
                return count;
            }

            // 2. Divide : split range into two halves
            int mid = start + (length / 2);
            CountEvenTask leftTask = new CountEvenTask(numbers, start, mid);
            CountEvenTask rightTask = new CountEvenTask(numbers, mid, end);

            // 3. FORK , COMPUTE , JOIN
            leftTask.fork(); // put the left subtask on Queue
            int rightResult = rightTask.compute(); // current thread run right subtask
            int leftResult = leftTask.join(); // wait for left result

            // 4. COMBINE
            return leftResult + rightResult;
        }
    }
}
// What Happens When You Run ThisThe 10-item array gets split into smaller slices until each slice has 3 or fewer elements:
// [0 to 2]: elements 1, 2, 3 $\to$ 1 even (2)
// [3 to 4]: elements 4, 5 $\to$ 1 even (4)
// [5 to 6]: elements 6, 7 $\to$ 1 even (6)
// [7 to 9]: elements 8, 9, 10 $\to$ 2 even (8, 10)
// Different worker threads (worker-1 and worker-2) execute these slices in parallel via work-stealing.
// The counts bubble back up to return the final answer: 5.
