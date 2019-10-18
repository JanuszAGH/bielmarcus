package pl.janusz.greencroft.isbntools;

/**
 * Created by Janusz Kacki on 17/10/2019. Project; bielmarcus
 */
public class ValidateISBN {

    private static final int SHORT_ISBN = 10;
    private static final int LONG_ISBN = 13;

    public boolean checkISBN(String isbn) {

        checkFormat(isbn);

        boolean result;

        if (isbn.length() == SHORT_ISBN) {
            result = tenDigitsCheck(isbn);
        } else {
            result = thirteenDigitsCheck(isbn);
        }

        return result;
    }

    private void checkFormat(String isbn) {

        if (isbn == null) {
            throw new NumberFormatException("non 10 or 13 digits ISBN");
        }

        if (!(isbn.length() == SHORT_ISBN || isbn.length() == LONG_ISBN)) {

            throw new NumberFormatException("non 10 or 13 digits ISBN");
        }

        if (isbn.length() == SHORT_ISBN && !isbn.matches("^[0-9]{9}[0-9X]$")) {
            throw new IllegalArgumentException(" Non digit ISBN");
        }

        if (isbn.length() == LONG_ISBN && !isbn.matches("^[0-9]{12}[0-9X]$")) {
            throw new IllegalArgumentException(" Non digit ISBN");
        }
    }

    private boolean thirteenDigitsCheck(String isbn) {

        int sumSoFar = 0;
        int digit;

        for (int i = 0; i < LONG_ISBN; i++) {
            digit = Integer.parseInt(String.valueOf(isbn.charAt(i)));
            if (i % 2 == 0) {
                sumSoFar += digit;
            } else {
                sumSoFar += 3 * digit;
            }
        }

        return sumSoFar % 10 == 0;
    }

    private boolean tenDigitsCheck(String isbn) {

        int sumSoFar = 0;
        int digit;
        int weight;

        for (int i = 0; i < SHORT_ISBN - 1; i++) {
            digit = Integer.parseInt(String.valueOf(isbn.charAt(i)));
            weight = 10 - i;
            sumSoFar += digit * weight;
        }

        if (isbn.charAt(9) == 'X') {
            sumSoFar += 10;
        } else {
            sumSoFar += Integer.parseInt(String.valueOf(isbn.charAt(9)));
        }

        return sumSoFar % 11 == 0;
    }
}
