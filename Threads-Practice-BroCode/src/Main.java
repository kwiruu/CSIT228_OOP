public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Threaders.activeCount());
//        Threaders.currentThread().setName("Keiru's Thread");
//        System.out.println(Threaders.currentThread().getName());
//        Threaders.currentThread().setPriority(10);
//        System.out.println(Threaders.currentThread().getPriority());
//        System.out.println(Threaders.currentThread().isAlive());
//
//        for(int i=3; i>0;i--){
//            System.out.println(i);
//            Threaders.sleep(1000);
//        }
//        System.out.println("Done!");
//
//        Threaders thready = new Threaders();
//
//        thready.start();
//        System.out.println(thready.isAlive());
//        thready.setName("Keiru's Thread-1");
//
//        thready.setPriority(1);
//        System.out.println(thready.getPriority());
//        System.out.println(thready.getName());
//
//        System.out.println(Threaders.activeCount());
//
//        Threaders thready2 = new Threaders();
//        thready2.setDaemon(true);
//        System.out.println(thready2.isDaemon());
//        thready2.start();


        Threaders thread1 = new Threaders();

        Runnables runnable1 = new Runnables();
        Thread thread2 = new Thread(runnable1);

        thread1.start();
        thread1.join(3000);
        thread2.start();
    }
}