package Ex2.part1;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex2_1 {


    public static String[] createTextFiles(int n, int seed, int bound) {
        String fileNames[] = new String[n];
        Random rand = new Random(seed);
        int numLines;
        for (int i = 0; i < n; i++) {
            numLines = rand.nextInt(bound);
            fileNames[i] = "file_example" + i + ".txt";
            FileWriter fw = null;
            try {
                fw = new FileWriter(fileNames[i]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            BufferedWriter bw = new BufferedWriter(fw);
            for (int j = 0; j < numLines; j++) {
                try {
                    bw.write("hello world\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return fileNames;
    }

    public static int getNumOfLines(String[] fileNames) {
        int lineCounter = 0;
        for (int i = 0; i < fileNames.length; i++) {
            FileReader fr = null;
            try {
                fr = new FileReader(fileNames[i]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                try {
                    if (!(br.readLine() != null))
                        break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                lineCounter++;
            }
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return lineCounter;
    }

    public static int getNumOfLinesThreads(String[] fileNames) {
        Thread_ex2 threads[] = new Thread_ex2[fileNames.length];
        int counterAll=0;
        for (int i = 0; i < fileNames.length; i++) {
            threads[i] = new Thread_ex2(fileNames[i]);
            threads[i].start();
        }
        for (int i = 0; i < fileNames.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < fileNames.length; i++) {
            counterAll= counterAll + threads[i].getCounter();
        }
        return counterAll;
    }
    public static int getNumOfLinesThreadPool(String[] fileNames) {
        Future[] future=new Future[fileNames.length];
        ExecutorService ThreadPool = Executors.newFixedThreadPool(fileNames.length);
        int counter=0;
        for (int i = 0; i < fileNames.length ;i++) {
            ThreadP_ex2 task=new ThreadP_ex2((fileNames[i]));
            future[i]=ThreadPool.submit(task);
    }
        ThreadPool.shutdown();
        for (int i=0;i< future.length;i++) {
            try {
                counter = counter+(int)future[i].get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return counter;
    }

    public static void FileDeleter(String[] fileNames) {
        for (int i = 0; i < fileNames.length; i++) {
            File file = new File(fileNames[i]);
            boolean deleted = file.delete();
        }
    }
}
