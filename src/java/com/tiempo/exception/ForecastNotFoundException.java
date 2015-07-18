package com.tiempo.exception;

/**
 * Created by vit on 18.07.2015.
 */
public class ForecastNotFoundException extends Exception {

    public ForecastNotFoundException() {
    }

    public ForecastNotFoundException(String message) {
        super(message);
    }

    public ForecastNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForecastNotFoundException(Throwable cause) {
        super(cause);
    }
}
