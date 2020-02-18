public class Encoder {

    private int timeUnit;
    private char soundChar;
    private char silenceChar;
    private double noiseProb;
    private char noiseChar;
    private int prefixLength;
    private int suffixLength;

    private static final int DIT = 1;
    private static final int DAH = 3;
    private static final int SOUND_SPACE = 1;
    public static final int CHAR_SPACE = 3;
    public static final int WORD_SPACE = 7;



    public Encoder(int timeUnit) {
        this.timeUnit = timeUnit;
        this.silenceChar = 'O';
        this.soundChar = 'X';
        this.noiseProb = 0;
        this.noiseChar = 'z';
        this.prefixLength = 0;
        this.suffixLength = 0;
    }

    public Encoder(int timeUnit, char soundChar, char silenceChar, double noiseProb, char noiseChar, int prefixLength, int suffixLength) {
        this.timeUnit = timeUnit;
        this.soundChar = soundChar;
        this.silenceChar = silenceChar;
        this.noiseProb = noiseProb;
        this.noiseChar = noiseChar;
        this.prefixLength = prefixLength;
        this.suffixLength = suffixLength;
    }

    public String encode (String phrase) {
        String output = "";


        return output;
    }
}