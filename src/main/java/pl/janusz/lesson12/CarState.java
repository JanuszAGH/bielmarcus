package pl.janusz.lesson12;

import java.util.EnumSet;
import java.util.HashSet;

/**
 * Created by Janusz Kacki on 09/10/2019. Project; bielmarcus
 */
public enum CarState {
    DRIVING, WAITING, PARKING;

    public static CarState from(String state) throws Exception {

        String trimmed = state.toUpperCase().trim();

        CarState result = null;
        try {
            result = CarState.valueOf(trimmed);
        } catch (IllegalArgumentException e) {
            throw new Exception("Unknown state: " + state);
        }

        return result;
    }
}
