package com.scheduler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalTime;

@RestController
@RequestMapping("/rest")
public class GoogleController {

    private static final Logger _LOGGER = LoggerFactory.getLogger(GoogleController.class);

    //TODO: REST endpoint to return current time
    @GetMapping("/get-time")
    public ResponseEntity<String> getCurrentTime() {
        _LOGGER.info("**********************  getCurrentDateAndTime method called..");
        return ResponseEntity.ok("Current Time: " + LocalTime.now().toString());
    }



}
