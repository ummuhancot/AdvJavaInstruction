package enumtypes;

public enum PasswordStrengthEnum {

    FAIL(0),//Ordinal:0
    LOW(10),//ordinal:0-->1
    MEDIUM(50),//ordinal:2
    HIGH(100);//ordinal:3

    private final int level;//field

    //paramli const
    PasswordStrengthEnum(int level) {
        this.level = level;
    }

    //getter
    public int getLevel() {
        return level;
    }
}