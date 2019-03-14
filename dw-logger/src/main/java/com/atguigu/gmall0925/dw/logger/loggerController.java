package com.atguigu.gmall0925.dw.logger;


import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loggerController {

    private static final  org.slf4j.Logger logger = LoggerFactory.getLogger(loggerController.class) ;
    @GetMapping("/testlog")
    public String logger() {
        return "success";
    }
        @PostMapping("log")
    public String putlog(@RequestParam("log") String log) {

        logger.info(log);
       return  "successfjkfk";
    }
}
