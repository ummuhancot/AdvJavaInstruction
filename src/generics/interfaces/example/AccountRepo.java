package generics.interfaces.example;
//Account ile ilgili veritabanı(database) işlemleri bu classta yapılmalı
public class AccountRepo implements Repo<Account>{

    @Override
    public Account find() {
        return null;
    }

    @Override
    public void save(Account obj) {

    }




}
