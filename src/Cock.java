public class Cock {
    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread clockThread = new Thread(clock);
        clockThread.start();

        Thread.sleep(1000);
        clock.cancel();
    }
    static class Clock implements Runnable {
        private boolean isCancel = false;
        private int n = 0;

        public void cancel() {
            this.isCancel = true;
        }
        @Override
        public void run() {
            while(!isCancel){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                n++;
                System.out.println(n + ") tik");
            }
        }
    }
}
