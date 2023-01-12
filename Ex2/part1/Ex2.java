package Ex2.part1;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Ex2 {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        String s[] = Ex2_1.createTextFiles(100, 1, 10);

        long start = System.currentTimeMillis();
        System.out.println("the amount of lines in the files are: " + Ex2_1.getNumOfLines(s));
        long end = System.currentTimeMillis();
        long total = end - start;
        double totalTimeInSeconds = (double)total / 1000.0;
        System.out.println("function used: getNumOfLines\ntakes a total of: " + totalTimeInSeconds + " seconds\n");


        start = System.currentTimeMillis();
        System.out.println("the amount of lines in the files are: "+ Ex2_1.getNumOfLinesThreads(s));
        end = System.currentTimeMillis();
        total = end - start;
        totalTimeInSeconds = (double)total / 1000.0;
        System.out.println("function used : getNumOfLinesThreads\ntakes a total of: " + totalTimeInSeconds + " seconds\n");


        start = System.currentTimeMillis();
        System.out.println("the amount of lines in the files are: "+ Ex2_1.getNumOfLinesThreadPool(s));
        end = System.currentTimeMillis();
        total = end - start;
        totalTimeInSeconds = (double)total / 1000.0;
        System.out.println("function used : getNumOfLinesThreadPool\ntakes a total of: " + totalTimeInSeconds + " seconds");

    }
}
