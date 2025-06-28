public class MultiThreadedLibrary {

    //Exception
    static class InvalidThreadOperationException extends Exception {
        public InvalidThreadOperationException(String message) {
            super(message);
        }
    }

    // Thread 1: Print numbers from 1 to 10
    static class NumberPrinter extends Thread {
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Printing number: " + i);
                    Thread.sleep(1000); // 1-second delay
                }
            } catch (InterruptedException e) {
                System.out.println("NumberPrinter thread interrupted.");
            }
        }
    }

    // Thread 2: Calculate factorial of a given number
    static class FactorialCalculator extends Thread {
        private static final Object lock = new Object(); // for synchronization
        private int number;

        public FactorialCalculator(int number) {
            this.number = number;
        }

        private long calculateFactorial(int num) throws InvalidThreadOperationException {
            if (num < 0) {
                throw new InvalidThreadOperationException("Invalid number for factorial: " + num);
            }
            long fact = 1;
            for (int i = 2; i <= num; i++) {
                fact *= i;
            }
            return fact;
        }

        public void run() {
            synchronized (lock) {
                try {
                    long result = calculateFactorial(number);
                    System.out.println("Factorial of " + number + " = " + result);
                } catch (InvalidThreadOperationException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        // Start NumberPrinter thread
        Thread printerThread = new NumberPrinter();
        try {
            printerThread.start();
        } catch (IllegalThreadStateException e) {
            System.out.println("Could not start NumberPrinter thread: " + e.getMessage());
        }

        // Start FactorialCalculator threads for numbers 1 to 5
        for (int i = 1; i <= 5; i++) {
            try {
                Thread factorialThread = new FactorialCalculator(i);
                factorialThread.start();
            } catch (IllegalThreadStateException e) {
                System.out.println("Could not start factorial thread for " + i + ": " + e.getMessage());
            }
        }
    }
}
