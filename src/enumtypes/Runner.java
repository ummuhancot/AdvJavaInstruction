package enumtypes;
//1-uygulamada içerdiği karakterlere göre password gücü belirleniyor:HIGH, MEDIUM, LOW
//2-kullanıcıya mesaj verilecek:
//LOW:Dikkat şifreniz yetersiz seviyededir!!!
//MEDIUM:Şifre gücünüz orta düzeydedir.
//HIGH:Tebrikler, şifre gücünüz yüksek düzeydedir:)
//--benim notum
//uygulamada içerdiği karakterlere göre password gücü belirleniyor:HIGH(EN GÜÇLÜ),MEDİUM(ORTA),LOW(DÜŞÜK)
//password seviyesi belirlendikten sonra kullanıcıya besaj verilecek
//LOW:Dikkat şifreniz yetersiz seviyededir!!!
//MEDIUM:Şifregücünüz orta seviyededir
//HING:Tebrikler, şifre gücünüz yüksek seviyededir :)
//mesajlar vericez.
public class Runner {

    public static void main(String[] args) {

        printMessage("LOW");//Dikkat şifreniz yetersiz seviyededir!!!
        printMessage("MEDİUM");//Tebrikler, şifre gücünüz yüksek seviyededir :)
        printMessage("HING");//Şifregücünüz orta seviyededir
        //printMessage("hinh");COMPAL TİME Exception yok ve RUN TİME Exception yok ama method beklenen işlevi yerine getirmedi!!!
        printMessage("HINH ");//uygulama beklendiği gibi çalışmadı
        printMessage("........");
        printMessage("high");//CTE yok,RTE yok AMAAAAA metod beklenen ilevi gerçekleştirmedi!!!


        //-----------------------------------------------
        printMessageEnum(PasswordStrengthEnum.LOW);
        printMessageEnum(PasswordStrengthEnum.MEDIUM);
        printMessageEnum(PasswordStrengthEnum.HIGH);




    }



    //ÇÖZÜM:metodun parametresine argüman olarak sadece belirlediğimiz
    //sabit değişkenler verilmeli--->Enum Type


    //kullanıcıya parametrede verilen password gücüne göre
    //mesaj gösteren bir metod yazalım.
    //----benim notlar
    //kullanıcıya parametrede verilen password gücüne göre
    //mesaj gösteren method yazalım
    //enum typ tanımlamadığımzda ne oluyor
    public static void printMessage(String strength){

        //if (strength.equals("low")){ bunun tedbiri için böyle sabit değişken kullandık
        if (strength.equals(PasswordStrength.LOW)){
            System.out.println("Dikkat şifreniz yetersiz seviyededir!!!");
        } else if (strength.equals(PasswordStrength.HING)) {
            System.out.println("Şifregücünüz orta seviyededir");
        } else if (strength.equals(PasswordStrength.MEDİUM)) {
            System.out.println("Tebrikler, şifre gücünüz yüksek seviyededir :)");
        }


    }


    //kullanıcıya parametrede Enum ile verilen password gücüne göre
    //mesaj gösteren bir metod yazalım.
    public static void printMessageEnum(PasswordStrengthEnum strength){

        if (strength.equals(PasswordStrengthEnum.LOW)){

        //}if (strength.ordinal()==0){
            System.out.println("Dikkat şifreniz yetersiz seviyededir!!!");
        } else if (strength.equals(PasswordStrengthEnum.MEDIUM)) {
            System.out.println("Şifre gücünüz orta düzeydedir.");
        } else if (strength.equals(PasswordStrengthEnum.HIGH)) {
            System.out.println("Tebrikler, şifre gücünüz yüksek düzeydedir:)");
        }
        System.out.println("Enum sırası " + strength.ordinal());//enum typein sırası
        System.out.println("Enum ismi" + strength.name());//enum typın ismini gösterir
    }
}
