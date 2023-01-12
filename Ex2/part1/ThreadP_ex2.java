package Ex2.part1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class ThreadP_ex2 implements  Callable<Integer> {

    int counter;
    String fileName;
    public ThreadP_ex2 (String fileName){
        this.fileName=fileName;
    }
    @Override
    public Integer call() {
        FileReader fr = null;
        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        while (true){
            try {
                if (!(br.readLine()!=null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return counter;
    }
}

