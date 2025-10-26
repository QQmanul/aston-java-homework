package ru.aston.homework4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class DuoBalancedThreadDemo {

    static class DuoBalancer {

        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();

        private final Runnable firstFunc;
        private final Runnable secondFunc;
        private final int amount;

        private final Thread masterThread;
        private final Thread slaveThread;
        private boolean isFirstTurn = true;


        public DuoBalancer(Runnable firstFunc, Runnable secondFunc, int amount) {
            this.firstFunc = firstFunc;
            this.secondFunc = secondFunc;
            this.amount = amount;

            masterThread = new Thread(this::runFirst);
            slaveThread = new Thread(this::runSecond);
        }

        private void runFirst() {
            for (int i = 0; i < amount; i++) {
                lock.lock();

                try {
                    while (!isFirstTurn) {
                        condition.await();
                    }

                    firstFunc.run();
                    isFirstTurn = false;
                    condition.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            }
        }

        private void runSecond() {
            for (int i = 0; i < amount; i++) {
                lock.lock();

                try {
                    while (isFirstTurn) {
                        condition.await();
                    }

                    secondFunc.run();
                    isFirstTurn = true;
                    condition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            }
        }

        public void start() {
            slaveThread.start();
            masterThread.start();
        }
    }


    public static void main(String[] args) {
        Logger logger = Logger.getLogger(DuoBalancedThreadDemo.class.getName());

        Runnable printOne = () -> logger.info("1");
        Runnable printTwo = () -> logger.info("2");

        DuoBalancer balancer = new DuoBalancer(printOne, printTwo, 10);
        balancer.start();

    }
}
