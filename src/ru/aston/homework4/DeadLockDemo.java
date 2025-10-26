package ru.aston.homework4;

import java.util.logging.Logger;

public class DeadLockDemo {

    static class RobotProducer {
        private final Logger logger;

        public RobotProducer() {
            this.logger = Logger.getLogger(this.getClass().getName());
        }

        public void Produce() {
            logger.info("Создан робот, кол-во увеличилось");
        }

        public void Disassemble() {
            logger.info("Разобран робот, кол-во уменьшилось");
        }
    }

    static class PartStorage {
        private final Logger logger;

        public PartStorage() {
            this.logger = Logger.getLogger(this.getClass().getName());
        }

        public void AddParts() {
            logger.info("Добавлены запчасти на склад");
        }

        public void RemoveParts() {
            logger.info("Со склада взяли запчасти");
        }
    }

    public static void main(String[] args) {

        PartStorage store = new PartStorage();
        RobotProducer producer = new RobotProducer();

        Thread createRobot = new Thread(() -> {
            synchronized (store) {
                store.RemoveParts();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (producer) {
                    producer.Produce();
                }
            }
        });

        Thread disassembleRobot = new Thread(() -> {
            synchronized (producer) {
                producer.Disassemble();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (store) {
                    store.AddParts();
                }
            }
        });

        createRobot.start();
        disassembleRobot.start();
    }
}
