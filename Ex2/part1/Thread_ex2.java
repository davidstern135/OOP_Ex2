package Ex2.part1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Thread_ex2 extends Thread {

    String fileName;
    int counter=0;

    public Thread_ex2(String fileName){
        this.fileName=fileName;
    }
    public int getCounter() {
        return counter;
    }
    @Override
    public void run(){
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
    }
}
