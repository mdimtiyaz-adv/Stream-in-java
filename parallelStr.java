// parallel stream used in multi thread . when we have to play with multi thread
// we use parallel stream and whrn we have large amt of data we use it.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class parallelStr {
    public static void main(String[] args) {
        int size = 1000;
        List<Integer> nums = new ArrayList<>(size);
        Random ran = new Random();
        for (int i = 1; i < size; i++) {
            nums.add(ran.nextInt(100));

        }
        // System.out.println(nums);
        // here comes mapInt . it sures the type of datatype for sum method. sum is in
        // intStream object. when we work with bigdata we use parallel strema . beacuse
        // it works with multiple threads
        long timeStart1 = System.currentTimeMillis();
        int sum = nums.stream()
                .map(n -> {
                    try {
                        Thread.sleep(1);
                    }

                catch (Exception e) {
                    }
                    return n * 2;
                })
                .mapToInt(n -> n)
                .sum();
        long timeEnd1 = System.currentTimeMillis();

        long timeStart2 = System.currentTimeMillis();
        int sum1 = nums.stream()
                .map(n -> {
                    try {
                        Thread.sleep(1);
                    }

                catch (Exception e) {
                    }
                    return n * 2;
                })
                .mapToInt(n -> n)
                .sum();
        long timeEnd2 = System.currentTimeMillis();
        System.out.println("sum: " + (timeEnd1 - timeStart1));
        System.out.println("sum1: " + (timeEnd2 - timeStart2));

    }
}