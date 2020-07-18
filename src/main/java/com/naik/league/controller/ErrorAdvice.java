package com.naik.league.controller;

import com.naik.league.controller.model.LeagueError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler({LeagueError.class})
    public ResponseEntity handleLeagueException(LeagueError error){
        return ResponseEntity.ok().body(error.getMessage());
    }
}
