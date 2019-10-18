package pl.janusz.greencroft.isbntools;

/**
 * Created by Janusz Kacki on 17/10/2019. Project; bielmarcus
 */
public class ValidateISBN {

    public boolean checkISBN(String isbn) {

        if (isbn == null) {
            throw new NumberFormatException("non 10 or 13 digits ISBN");
        }

        if (!(isbn.length() == 10 || isbn.length() == 13)) {

            throw new NumberFormatException("non 10 or 13 digits ISBN");
        }

        boolean result = false;

        if (isbn.length() == 10) {
            result = tenDigitsCheck(isbn);
        } else {
            result = thirteenDigitsCheck(isbn);
        }

        return result;
    }

    private boolean thirteenDigitsCheck(String isbn) {

        if (!isbn.matches("^[0-9]{12}[0-9X]$")) {
            throw new IllegalArgumentException(" Non digit ISBN");
        }

        int sumSoFar = 0;
        int digit;

        for (int i = 0; i < 13; i++) {
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

        if (!isbn.matches("^[0-9]{9}[0-9X]$")) {
            throw new IllegalArgumentException(" Non digit ISBN");
        }

        int sumSoFar = 0;
        int digit;
        int weight;

        for (int i = 0; i < 9; i++) {
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
