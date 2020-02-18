import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Encoder {

    private int timeUnit;
    private String soundChar;
    private String silenceChar;
    private double noiseProb;
    private String noiseChar;
    private int prefixLength;
    private int suffixLength;

    private static final int DIT = 1;
    private static final int DAH = 3;
    private static final int SOUND_SPACE = 1;
    public static final int CHAR_SPACE = 3;
    public static final int WORD_SPACE = 7;



    public Encoder(int timeUnit) {
        this.timeUnit = timeUnit;
        this.silenceChar = "O";
        this.soundChar = "X";
        this.noiseProb = 0;
        this.noiseChar = "z";
        this.prefixLength = 0;
        this.suffixLength = 0;
    }

    public Encoder(int timeUnit, String soundChar, String silenceChar, double noiseProb, String noiseChar, int prefixLength, int suffixLength) {
        this.timeUnit = timeUnit;
        this.soundChar = soundChar;
        this.silenceChar = silenceChar;
        this.noiseProb = noiseProb;
        this.noiseChar = noiseChar;
        this.prefixLength = prefixLength;
        this.suffixLength = suffixLength;
    }

    public static boolean checkStringFormat(String phrase) {
        List<String> validChars = Arrays.asList(CodeKey.values()).stream().map(CodeKey::getCharacter).collect(Collectors.toList());

        for (String letter : phrase.split("")) {
            if (!validChars.contains(letter.toUpperCase()) && !letter.equals(" ")) {
               return false;
            }
        }
        return true;
    }

    public String addCharacter(String letter) {
        String output = "";
        String code = CodeKey.encode(letter);
        for (String element : code.split("")) {
            if (element.equals(".")) {
                output += this.soundChar.repeat(DIT);
                output += this.silenceChar.repeat(DIT);
            } else if (element.equals("-")) {
                output += this.soundChar.repeat(DAH);
                output += this.silenceChar.repeat(DIT);
            }
        }
        output += this.silenceChar.repeat(CHAR_SPACE-1);

        return output;
    }

    public String encode (String phrase) {
        if (!checkStringFormat(phrase)) {
            throw new IllegalArgumentException();
        }

        String output = "";
        // prefix (silence)
        output += this.silenceChar.repeat(prefixLength);

        for (String letter : phrase.split("")) {
            if (letter.equals(" ")) { // add word space
                output += this.silenceChar.repeat(WORD_SPACE-CHAR_SPACE);
            } else {
                output += addCharacter(letter);
            }
        }

        // suffix (silence)
        output += String.valueOf(this.silenceChar).repeat(suffixLength);

        // extend the time unit
        String extendedOutput = "";
        for (String letter : output.split("")) {
            extendedOutput += letter.repeat(timeUnit);
        }
        output = extendedOutput;

        // noise

        return output;
    }
}