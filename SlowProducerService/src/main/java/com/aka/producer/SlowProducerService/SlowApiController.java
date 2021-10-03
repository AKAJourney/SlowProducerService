package com.aka.producer.SlowProducerService;

import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlowApiController {

    private Integer number = 0;

    @GetMapping
    public String serviceStatus() {
        number++;
        return "Slow API is up and running!";
    }

    @RequestMapping("/numOfHits")
    public String getNumberOfHits(){
        return "Total Number of Hits for this API is "+number;
    }

    @RequestMapping("/slowAPI")
    public String slowResponseAPI(){

    	StopWatch stopwatch = new StopWatch();
    	
    	stopwatch.start();
    	
        complexProcess();
        
        stopwatch.stop();

        return "Total Time Taken for responding on this :"+stopwatch.getTotalTimeSeconds();
    }

    private void complexProcess() {
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
