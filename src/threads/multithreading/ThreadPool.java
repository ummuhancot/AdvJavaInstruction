package threads.multithreading;
//threadlerle çalışmak maliyetlidir!!!
//maliyeti acazlmak için thread havuzu oluşturulur.

//kontrol şhft slaş toplu yoruma alır

//.shutdown();//tüm işlemler tamamlandıktan sonra havuzu sonlandırmalıyız, aksi halde threadler
//havuzda kalmaya devam eder

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        //9 tane paket için 9 tane kurye alalım:maliyetli olur
        //az thread ile çok iş yapma:thread pool

        ExecutorService service = Executors.newFixedThreadPool(4);
        //aktif çalışan 4 tane

        //bunlar görev
        Thread kurye1 = new ThreadCreator("A",5000);
        Thread kurye2 = new ThreadCreator("B",3000);
        Thread kurye3 = new ThreadCreator("C",9000);
        Thread kurye4 = new ThreadCreator("D",8000);
        Thread kurye5 = new ThreadCreator("E",1000);
        Thread kurye6 = new ThreadCreator("F",6000);
        Thread kurye7 = new ThreadCreator("G",5000);
        Thread kurye8 = new ThreadCreator("H",2000);
        Thread kurye9 = new ThreadCreator("K",4000);

        /**
        kurye1.start();
        kurye2.start();
        kurye3.start();
        kurye4.start();
        kurye5.start();
        kurye6.start();
        kurye7.start();
        kurye8.start();
        kurye9.start();
        */

        service.execute(kurye1);
        service.execute(kurye2);
        service.execute(kurye3);
        service.execute(kurye4);
        service.execute(kurye5);
        service.execute(kurye6);
        service.execute(kurye7);
        service.execute(kurye8);
        service.execute(kurye9);

        service.shutdown();//tüm işlemler tamamlandıktan sonra havuzu sonlandırmalıyız, aksi halde threadler
        //havuzda kalmaya devam eder




    }

}

class ThreadCreator extends Thread{//thread lere görev verebilmek için hazırlandı

    public String task;//her threadin işinin farklı olduğunu belirtmek için

    //.sleep() uyutma süresini dinamik olarak yapma
    public int duration;//treadlerin çalışma süresini sleep ile temsil edecegiz, bu süreyi dinamik verebilmek için tanımladık bu değişkeni

    //parametreli cont


    public ThreadCreator(String task, int duration) {
        this.task = task;
        this.duration = duration;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " işe başladı. Görevi: " +this.task);
        System.out.println();
        //bazı kodlar çalışıyormuş gibi bir süre uyutalım

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "işi tamamladı..." );
        System.out.println();



    }
}