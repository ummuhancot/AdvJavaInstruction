package generics.bounding;

//wildcard(?) :joker , bilinmeyen data tipi
//generic yapıları kullanırken data tipine karar veriyorduk bu kullanmada
//alttan veya üstten sınırlandırabiliriz.

import java.util.ArrayList;
import java.util.List;

public class GenericWithWildcard {
    public static void main(String[] args) {

        List<Integer> integerList=new ArrayList<>();
        List<Double> doubleList=new ArrayList<>();
        List<String> stringList=new ArrayList<>();
        List<Number> numberList=new ArrayList<>();
        List<Object> objectList=new ArrayList<>();

        //-------------------------------------------alttan sınırlandırma
        addElemants(integerList);
        //addElemants(doubleList);--> Double Integer in parenti değil kardeşidir.
        //addElemants(stringList);
        addElemants(numberList);
        addElemants(objectList);

        //-------------------------------------------üstten sınırlandırma
        multiplyByTwo(integerList);
        multiplyByTwo(doubleList);
        //multiplyByTwo(stringList);
        multiplyByTwo(numberList);
        //multiplyByTwo(objectList);//-->Object --> Number parantıdır!!! o yüzden kabul etmedi üstten sınırlandırdığımız için







    }
    //generic yapıyı kullanırken alttan sınırlama yapabiliriz
    //Task : Listeye 1 den 10 a kadar tam sayıları yazdıran bir method tanımlayalım
    //E : Integer-> Number-> Object
    public static void addElemants(List<? super Integer>list){//? -> Integer -> Number -> Object kullanabilirim demek double bayt olmazmış kardeşleriymiş alttan sınırlama yaptık

        for (int i= 1;i <11;i++){
            list.add(i);
        }



    }
    //generic yapıyı kullanırken üstten sınırlama
    //Task: listedeki elemanları 2 ile carpan bir method tanımlayalım
    //E: Number ve childları üstten sınırlandırılmalı yani

    public static void multiplyByTwo(List<? extends Number> list){

        //list.add(3);  -->  joker belirsiz old icin yazdırma işlemlerine izin veremez
        //belirsiz olduğu için daha çok tanımlama amaclı kullanılır

        list.stream().map(t-> 2*t.doubleValue());

    }

    //NOT: List<?> ve list<T>arasındaki farkı nedir.
    //ikisi birbirinin yerine kullanılamaz
    // belirli bir data tipi demek T parametresi .
    //benzer fakat farklı kullanımı vardır!!!
    //detayında kullanım farkları var
    //edvens seviyede old icin bu kullanıma girmedi

    //List<T> list1 , List<U> list2
    //List<?> list1 , List<?> list2 listeye ekleme yapamazsınız

    //hocanın notu c
    //NOT: List<?> ve List<T> benzer fakat farklı kullanımı vardır!!!
    // List<T> list1,List<U> list2
    // List<?> list1,List<?> list2

}
