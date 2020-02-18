

public enum CodeKey {

    A(".-"),
    B("-..."),
    C("-.-."),
    D("-.."),
    E("."),
    F("..-."),
    G("--."),
    H("...."),
    I(".."),
    J(".---"),
    K("-.-"),
    L(".-.."),
    M("--"),
    N("-."),
    O("---"),
    P(".--."),
    Q("--.-"),
    R(".-."),
    S("..."),
    T("-"),
    U("..-"),
    V("...-"),
    W(".--"),
    X("-..-"),
    Y("-.--"),
    Z("--.."),
    ZERO("0", "-----"),
    ONE("1", ".----"),
    TWO("2", "..---"),
    THREE("3", "...--"),
    FOUR("4", "....-"),
    FIVE("5", "....."),
    SIX("6", "-...."),
    SEVEN("7", "--..."),
    EIGHT("8", "---.."),
    NINE("9", "----.");

    private String character;
    private String code;

    private CodeKey(String character, String code) {
        this.character = character;
        this.code = code;
    }

    private CodeKey(String code) {
        this.character = String.valueOf(this.name().charAt(0));
        this.code = code;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static String decode(String s) {
        for(CodeKey mCode : CodeKey.values()) {
            if(mCode.code.equals(s)) {
                return mCode.character;
            }
        }
        throw new IllegalArgumentException("s is not a valid Morse Code");
    }

    public static String encode(String letter) {
        for(CodeKey mCode : CodeKey.values()) {
            if(mCode.character.equals(letter.toUpperCase())) {
                return mCode.code;
            }
        }
        throw new IllegalArgumentException(letter + " cannot be found");
    }
}
