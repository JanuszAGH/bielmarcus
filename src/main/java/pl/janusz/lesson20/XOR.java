package pl.janusz.lesson20;

/**
 * Created by Janusz Kacki on 15/10/2019. Project; bielmarcus
 */
public class XOR {

    public static String mirrorBinaryNumber(String binary) {

        if (binary == null || "".equals(binary)) {
            return binary;
        }

        return recTailReverse(binary, binary.length() - 1, "");
    }

    private static String recTailReverse(String binary, int position, String acc) {

        if (position < 0) {
            return acc;
        } else {
            return recTailReverse(binary, position - 1, acc + binary.charAt(position));
        }
    }

}
