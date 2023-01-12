package Ex2.part1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Ex2_1Test {

    @Test
    void createTextFiles() {
        String []s= Ex2_1.createTextFiles(5,3,7);
        for (int i = 0; i < s.length; i++) {
            File file = new File(s[i]);
            assertTrue(file.exists());
        }
    }

    @Test
    void getNumOfLines() {
        String []s= Ex2_1.createTextFiles(3,1,10);
        assertEquals(Ex2_1.getNumOfLines(s),20);
        String []s2= Ex2_1.createTextFiles(20,2,100);
        assertEquals(Ex2_1.getNumOfLines(s2),951);
        String []s3= Ex2_1.createTextFiles(100,3,200);
        assertEquals(Ex2_1.getNumOfLines(s3),10676);

    }

    @Test
    void getNumOfLinesThreads() {
        String []s= Ex2_1.createTextFiles(3,1,10);
        assertEquals(Ex2_1.getNumOfLinesThreads(s),20);
        String []s2= Ex2_1.createTextFiles(20,2,100);
        assertEquals(Ex2_1.getNumOfLinesThreads(s2),951);
        String []s3= Ex2_1.createTextFiles(100,3,200);
        assertEquals(Ex2_1.getNumOfLinesThreads(s3),10676);
    }

    @Test
    void getNumOfLinesThreadPool() {
        String []s= Ex2_1.createTextFiles(3,1,10);
        assertEquals(Ex2_1.getNumOfLinesThreadPool(s),20);
        String []s2= Ex2_1.createTextFiles(20,2,100);
        assertEquals(Ex2_1.getNumOfLinesThreadPool(s2),951);
        String []s3= Ex2_1.createTextFiles(100,3,200);
        assertEquals(Ex2_1.getNumOfLinesThreadPool(s3),10676);
    }
}