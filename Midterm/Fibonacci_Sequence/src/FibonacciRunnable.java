public class FibonacciRunnable implements Runnable {
    private int num;

    public FibonacciRunnable(int num) {
        this.num = num;
    }
    @Override
    public void run() {
        try {
            if(num == 1){
                Main.res[0] = 0;
            }else if(num == 2){
                Main.res[1] = 1;
                Main.thrds[num -2].start();
                synchronized (Main.thrds[num -2]){
                    Main.thrds[num -2].join();
                }
            }else{
                Main.thrds[num -2].start();
                synchronized (Main.thrds[num -2]){
                    Main.thrds[num -2].join();
                }
                Main.res[num - 1] = Main.res[num -2] + Main.res[num -3];
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}