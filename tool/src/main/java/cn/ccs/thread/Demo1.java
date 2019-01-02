package cn.ccs.thread;
 
import java.util.Collections;
 
/**
 * @author myvina@qq.com
 * @date 18-5-27  下午8:00
 */
 
public class Demo1 {
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        PrintLetter printLetter = demo1.new PrintLetter();
        new Thread(demo1.new PrintThread(printLetter, 'B')).start();
        new Thread(demo1.new PrintThread(printLetter, 'A')).start();
        new Thread(demo1.new PrintThread(printLetter, 'C')).start();
//        Collections.synchronizedList()
    }
 
    private class PrintLetter {
        private char letter = 'A';
 
        public char getLetter() {
            return letter;
        }
 
        public void print() {
            System.out.print(letter);
            if('C' == letter) {
                System.out.println();
            }
        }
 
        public void nextLetter() {
            switch (letter) {
                case 'A': {
                    letter = 'B';
                    break;
                }
                case 'B': {
                    letter = 'C';
                    break;
                }
                case 'C': {
                    letter = 'A';
                    break;
                }
            }
        }
    }
 
    private class PrintThread implements Runnable {
        private PrintLetter printLetter;
        private char letter;
 
        public PrintThread(PrintLetter printLetter, char letter) {
            this.printLetter = printLetter;
            this.letter = letter;
        }
 
        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                synchronized (printLetter) {
                    while(letter != printLetter.getLetter()) {
                        try {
                            printLetter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    printLetter.print();
                    printLetter.nextLetter();
                    printLetter.notifyAll();
                } 
            }
        }
    }
}
