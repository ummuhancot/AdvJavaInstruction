package generics.classes;

//amacımız: farklı fieldlarda farklı data tiplerini bağımsız olarak kullanma

public class GenericClassTwoParam<S, U> {//S:String U:Integer //<S,U,V>üçüncü parametrede verebilir mişiz V gibi

    private S anahtar;//tüm NON-PRİMİTİVE data tipleri

    private U deger;//tüm NON-PRİMİTİVE data tipleri


    //parametreli constructor ikisinide set etmek için yaptık

    public GenericClassTwoParam(S anahtar, U deger) {
        this.anahtar = anahtar;
        this.deger = deger;
    }


    //getter - setter


    public U getDeger() {
        return deger;
    }

    public void setDeger(U deger) {
        this.deger = deger;
    }

    public S getAnahtar() {
        return anahtar;
    }

    public void setAnahtar(S anahtar) {
        this.anahtar = anahtar;
    }
}
