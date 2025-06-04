package com.scheduler.schedulerTask;

import com.scheduler.constant.ApplicationConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationScheduler {
    private static final Logger _LOGGER = LoggerFactory.getLogger(ApplicationScheduler.class);

    @Autowired
    private  RestTemplate restTemplate;

    private int count = 0;

    //TODO: Scheduled method that runs based on cron
    @Scheduled(cron = "${scheduler.cron}")
    public void scheduledTask() {
        this.count++;
        try {
            _LOGGER.info("****************** Scheduler called... count = " + count);
             restTemplate.getForEntity(ApplicationConstant.GET_CURRENT_TIME_API, String.class);
        } catch (Exception e) {
            _LOGGER.error("Something went wrong: " + e.getMessage());
        }
    }
}
