package pl.janusz.greencroft.isbntools;

/**
 * Created by Janusz Kacki on 17/10/2019. Project; bielmarcus
 */
public class ValidateISBN {

    public boolean checkISBN(String isbn) {

        if (isbn.charAt(9) != 'X' || isbn.matches("^[0-9]{10}$")) {
            throw new IllegalArgumentException(" Non digit ISBN");
        }

        if (isbn == null || isbn.length() != 10) {
            throw new NumberFormatException("non 10-digits ISBN");
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
