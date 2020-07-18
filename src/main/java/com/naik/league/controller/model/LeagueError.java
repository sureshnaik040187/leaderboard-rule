package com.naik.league.controller.model;

import java.util.function.Supplier;

public class LeagueError extends RuntimeException {
    String message;

    public LeagueError(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LeagueError{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
