package com.labPrograms;
import java.util.LinkedList;
public class Lab7 {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
class ProducerConsumer {
    private LinkedList<Integer> list = new LinkedList<>();
    private int capacity = 2;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (list.size() == capacity) {
                    wait();
                }
                System.out.println("Producer produced-" + value);
                list.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }
    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0) {
                    wait();
                }
                int val = list.removeFirst();
                System.out.println("Consumer consumed-" + val);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}

