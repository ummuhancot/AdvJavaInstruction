package threads.multithreading;

    /*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
    Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
    Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/

//üretici(producer)-tüketici(consumer)
///wait-notify:threadler arasında iletişimi sağlar///

/**
wait() : bir threadin belirli bir kaynağın kilidini serbest bırakmasını
ve başka bir threadden sinyal alana kadar beklemesini sağlar. wait metodu
genellikle bir kilit mekanizması olan synchronized blok veya metod içinde kullanılır.

 notify(): Bir threadi uyandırır ve çalışmasına izin verir.
*/

public class WaitNotify {

    public static int balance=0;//bakiye---alican ve velihanın ortak hesabı
    //para yatırma
    public synchronized void depasit(int amount){
        System.out.println(Thread.currentThread().getName()+"para yatırmak istiyor");
        balance+=amount;//okuma, arttırma ,yazdırma//bakiyeyi parametrede verilen miktar kadar arttır demek
        System.out.println("para yatırma işlemi başarılı, mevcut bakiye : " +balance);
        notify();//wait ile bekleyen threade bildirim gönderir
        //notifyAll();//wait ile bekleyen tüm threaadlere bildirim gönderir.
    }

    //wait();monitör edilen objeyi geçici olarak serbest bırakır.//notify ile uyarılana kadar bekler wait() notify ile uyarılınca kaldığı yerden işleme devam eder wait()
    //notify();wait ile bekleyen threade bildirim gönderir
    //notifyAll();wait ile bekleyen tüm threaadlere bildirim gönderir.
    //synchronized aynı zaman da 2 işlem yapılamasın tek işlem yapılsın dedik

    //para çekme
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+"para çekmek istiyor");
        //bakiye yetersiz ise
        if (balance == 0 || balance<amount){
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye : " + balance);
            //işleme devam edemez, bekleyecek
            System.out.println("Bakiyenin güncellenmesi bekleniyor...");
            try {
                wait();//motitör edilen objeyi geçici olarak serbest bırakır.
                       //notify ile uyarılana kadar bekler wait() notify ile uyarılınca kaldığı yerden işleme devam eder wait()
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }

        ///bakiye yetersiz--- sildik---

        //kaldığı yerden işleme devam eder
        //bakiye güncellendi
        //bakiye yeterli ise
        if (balance>=amount){
            System.out.println("Bakiye yeterli , işlem gerçekleşiyor...");
            balance-=amount;//okuma, azaltma, yazdırma
            System.out.println("Para çekme başarılı, mevcut bakiye : "+balance);
        }else {
            System.out.println("Bakiye yetrsiz!!! Mevcut bakiye : "+balance);
            System.out.println("Umudunu kaybetme, yarın gel!!!");
        }

    }

    public static void main(String[] args) {

        WaitNotify obj = new WaitNotify();

        //para çekme ve yatırma işlemlerini 2 tane threade yaptıralım
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
               obj.withdraw(1000);
            }
        });
        thread1.setName("AliCan");//tüketici

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
               // //olumsuz seneryo gözlemi baba uyuya kalmış seneryoya dahil değil gözlemlemek için.sleep koyduk
               // try {
               //     Thread.sleep(3000);
               // } catch (InterruptedException e) {
               //     throw new RuntimeException(e);
               // }
                obj.depasit(2000);
            }
        });
        thread2.setName("VeliHan");//üretici

        thread1.start();
        thread2.start();
    }


}
