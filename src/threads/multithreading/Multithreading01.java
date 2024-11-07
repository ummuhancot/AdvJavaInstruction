package threads.multithreading;

public class Multithreading01 {
    public static void main(String[] args) {

        //TASK: 1 den 10 a kadar 2 defa kadar sayalım:main thread

        long start = System.currentTimeMillis();
        Counter counter1 = new Counter("Ramazan");
        Counter counter2 = new Counter("Ummuhanı");
        counter1.count();
        counter2.count();
        long finish = System.currentTimeMillis();//10228

        System.out.println("Single thread ile geçen süre : " + (finish-start));

        //TASK: 1 den 10 a 2 defa kadar sayalım:multithreading:asenkron
        long start2 = System.currentTimeMillis();
        Thread counter3 = new  CounterThread("Ronaldo");
        Thread counter4 = new  CounterThread("Messi");
        counter3.start();
        counter4.start();
        //join kullandık counter 3 ve 4 işini bitirene kadar main thread bekleyecek
        try {
            counter3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            counter4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long finish2 = System.currentTimeMillis();//5096
        System.out.println("Multi thread ile geçen süre : " +(finish2 - start2));

    }

}

class Counter{

    public String name;

    //parametreli const


    public Counter(String name) {
        this.name = name;
    }

    //1 den 10 a kadar konsola yazdıran metod
    public void count(){
        for (int i=1 ; i<11; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(i+"------->"+this.name);
        }
    }

}

class CounterThread extends Thread{

    public String name;

    public CounterThread(String name) {
        this.name = name;
    }

    //1 den 10 a kadar yazdıran method
    public void count(){
        for (int i = 1; i<11; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i+"--------->"+this.name);
        }
    }
    //run methodunu override edelim:sayma işlemini threadlere verelim
    //run yazınca çıkıyor

    @Override
    public void run() {
        count();//her bir threade count metodunu çağırma işlemini verdik
    }
}