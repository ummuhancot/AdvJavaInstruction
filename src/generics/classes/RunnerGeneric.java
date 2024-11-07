package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class RunnerGeneric {
    public static void main(String[] args) {

        //2 farklı ürün : laptop, book

        //generic yapıları kullanırken data tipine karar verilir.
        GenericProduct<String> laptop=new GenericProduct<>();// T : String
        laptop.setCode("ABC123");
        //laptop.setCode(123);
        String str1=laptop.getCode(); //1-CAST problemi KALMADI!
        System.out.println(str1);

        GenericProduct<Integer> book=new GenericProduct<>();//T : Integer
        book.setCode(123);
        Integer code=book.getCode();
        System.out.println(code);
        //book.setCode("123");//--> sıkı bir tür denetimi uygular
        //String str2=book.getCode();
        // CTE(comple time exception): 2-Castinge gerek kalmadığı için, ClassCastException almaktan kurtardı!




        //---------- önceden bildiğimiz generic yapılar -----------------


        ArrayList<Boolean> list=new ArrayList<>();
        //list.add("abc");

        //K:String V:Integer
        HashMap<String, Integer> map=new HashMap<>();
        map.put("Generic",123);

        //-------------ÇOK PARAMETRELİ GENERİC CLASS--------------

        //S:String I:Integer
        GenericClassTwoParam<String, Integer> obj = new GenericClassTwoParam<>("Generic", 123);
        //S:Integer I:Integer
        GenericClassTwoParam<Integer , Integer> obj2 = new GenericClassTwoParam<>(1,2);

    }
}
