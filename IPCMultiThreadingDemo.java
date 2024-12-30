class SharedBuffer {
    private int data;
    private boolean isDataAvailable = false;

    public synchronized void produce(int value) {
        while (isDataAvailable) {
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        isDataAvailable = true;
        System.out.println("Produced: " + data);
        notify(); 
    }

    public synchronized int consume() {
        while (!isDataAvailable) {
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isDataAvailable = false;
        System.out.println("Consumed: " + data);
        notify(); 
        return data;
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.produce(i); 
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.consume(); 
            try {
                Thread.sleep(150); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class IPCMultiThreadingDemo	{
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start(); // Start producer thread
        consumer.start(); // Start consumer thread
    }
}
