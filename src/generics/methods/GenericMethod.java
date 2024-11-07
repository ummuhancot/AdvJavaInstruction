package generics.methods;

import java.util.Arrays;

//amaç: farklı data tipindeki arrayleri konsola yazdırma için metod tanımlama
public class GenericMethod {

    public static void main(String[] args) {

        Integer[] intArr={2,3,8,99,55};
        Double[] doubleArr={1.3,35.6,99.9,0.5};
        String[] stringArr={"Java","generics","hayatımızı","kolaylaştırır"};

        System.out.println("-----------------------printArray kullanımı----------------------");
        printArray(intArr);
        printArray(doubleArr);
        printArray(stringArr);

        System.out.println("-----------------------printArrayGeneric kullanımı----------------------");
        printArray(intArr);//T:Integer
        printArray(doubleArr);//T:Double
        printArray(stringArr);//T:String

        System.out.println("-----------------------return type olaran generic metod----------------------");

        Integer eleman = getFirst(intArr);//T : Integer
        Double eleman2 = getFirst(doubleArr);//T : Double
        String eleman3 = getFirst(stringArr);//T : String

        System.out.println("----------------iki paramli metod---------------------");
        printArrAndElement(stringArr,5);//S:String U:Integer
        printArrAndElement(intArr,"abc");//S:Integer U:String
        printArrAndElement(intArr,5);//S:Integer U:Integer



    }

    //amaç: farklı data tipindeki arrayleri konsola yazdırma için metod tanımlama
    //farklı data tipleri ile kullanmak icin : overloding yaparız
    //        System.out.println("-----------------------printArray kullanımı----------------------");
    public static void printArray(Integer[] arr){

        Arrays.stream(arr).forEach(t-> System.out.println(t + " "));
        System.out.println();

    }

    //farklı data tipleri ile kullanmak icin : overloding yaparız
    //        System.out.println("-----------------------printArray kullanımı----------------------");
    public static void printArray(String[] arr){

        Arrays.stream(arr).forEach(t-> System.out.println(t + " "));
        System.out.println();

    }

    //farklı data tipleri ile kullanmak icin : overloding yaparız
    //        System.out.println("-----------------------printArray kullanımı----------------------");
    public static void printArray(Double[] arr){

        Arrays.stream(arr).forEach(t-> System.out.println(t + " "));
        System.out.println();

    }

    //keşke methodumuz generic olsaydı....
    //System.out.println("-----------------------printArrayGeneric kullanımı----------------------");
    //generic bi method tanımlama yaparız overlood yapmak yerine
    public static <T> void printArrGeneric(T[] arr){
        Arrays.stream(arr).forEach(t-> System.out.println(t + " "));
        System.out.println();
    }

    //        System.out.println("-----------------------return type olaran generic metod----------------------");
    //return type ı olan generic metod nasıl tanımlanır?
    //verilen arrayin ilk elemanını döndüren method yazalım
    public static <T> T getFirst(T[] arr){

        T first = arr[0];
        return first;

    }

    //birden fazla parametreli generic metod
    public static <S,U> void printArrAndElement(S[] arr,U obj){//S:String , U:Integer

//        arr[0]=obj;--->data tipi belli değil, farklı data tipleri olabilir,o yüzden eleman ekleyip koyamıyor
//        arr[0]=3;


        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println(obj);

    }

    public static <T> void printArrAndElement2(T[] arr,T obj){

        arr[0]=obj;//--->data tipi belli değil,fakat ikisi de T data tipinde
//        arr[0]=3;


        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println(obj);

    }


}
