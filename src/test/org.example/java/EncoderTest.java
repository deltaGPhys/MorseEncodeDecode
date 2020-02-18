import junitparams.JUnitParamsRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class EncoderTest {

    Encoder basicEncoder;
    Encoder tripleEncoder;

    @Before
    public void before() {
        basicEncoder = new Encoder(1);
        tripleEncoder = new Encoder(3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void checkStringFormat() {
        String phrase = "AbsdDs DSFA0927451 kjashd";
        boolean expected = true;
        boolean actual = Encoder.checkStringFormat(phrase);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkStringFormatFail() {
        String phrase = "AbsdDs DS.FA0927451 kjashd";
        boolean expected = false;
        boolean actual = Encoder.checkStringFormat(phrase);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCharacter1() {
        String letter = "A";
        String expected = "XOXXXOOO";
        String actual = basicEncoder.addCharacter(letter);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCharacter2() {
        String letter = "3";
        String expected = "XOXOXOXXXOXXXOOO";
        String actual = basicEncoder.addCharacter(letter);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void encodeLetter() {
        String phrase = "D";
        String expected = "XXXOXOXOOO";
        String actual = basicEncoder.encode(phrase);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void encodeWord() {
        String phrase = "CAT";
        String expected = "XXXOXOXXXOXOOOXOXXXOOOXXXOOO";
        String actual = basicEncoder.encode(phrase);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void encodeTwoWords() {
        String phrase = "CAT HAT";
        String expected = "XXXOXOXXXOXOOOXOXXXOOOXXXOOOOOOOXOXOXOXOOOXOXXXOOOXXXOOO";
        String actual = basicEncoder.encode(phrase);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tripleEncodeLetter() {
        String phrase = "C";
        String expected = "XXXXXXXXXOOOXXXOOOXXXXXXXXXOOOXXXOOOOOOOOO";
        String actual = tripleEncoder.encode(phrase);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tripleEncodeWord() {
        String phrase = "CAT";
        String expected = "XXXXXXXXXOOOXXXOOOXXXXXXXXXOOOXXXOOOOOOOOOXXXOOOXXXXXXXXXOOOOOOOOOXXXXXXXXXOOOOOOOOO";
        String actual = tripleEncoder.encode(phrase);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tripleEncodeTwoWords() {
        String phrase = "CAT HAT";
        String expected = "XXXXXXXXXOOOXXXOOOXXXXXXXXXOOOXXXOOOOOOOOOXXXOOOXXXXXXXXXOOOOOOOOOXXXXXXXXXOOOOOOOOOOOOOOOOOOOOOXXXOOOXXXOOOXXXOOOXXXOOOOOOOOOXXXOOOXXXXXXXXXOOOOOOOOOXXXXXXXXXOOOOOOOOO";
        String actual = tripleEncoder.encode(phrase);

        Assert.assertEquals(expected, actual);
    }

}