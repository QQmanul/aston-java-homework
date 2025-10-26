package ru.aston.homework4;

import java.util.logging.Logger;

public class LiveLockDemo {

    static abstract class Notifier {
        private final Logger logger;
        protected final String system;
        protected int priority = 1;

        public String GetSystemName() {
            return system;
        }

        public Notifier(String systemName) {
            this.logger = Logger.getLogger(this.getClass().getName());
            this.system = systemName;
        }

        public void Notify(Notifier notifier) {
            while (true) {

                if (notifier.priority >= priority) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    logger.info("Уступаю " + notifier.GetSystemName());
                    continue;
                }

                logger.info("Отправлено в " + system);
                return;
            }

        }
    }

    static class Telegram extends Notifier {
        public Telegram() {
            super("telegram");
        }
    }

    static class Email extends Notifier {
        public Email() {
            super("email");
        }
    }

    public static void main(String[] args) {
        Notifier tg = new Telegram();
        Notifier email = new Email();

        Thread firstThread = new Thread(() -> tg.Notify(email));
        Thread secondThread = new Thread(() -> email.Notify(tg));

        firstThread.start();
        secondThread.start();
    }

}
