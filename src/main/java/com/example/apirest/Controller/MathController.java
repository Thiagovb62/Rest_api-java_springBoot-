package com.example.apirest.Controller;

import com.example.apirest.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method = RequestMethod.GET)
        public Double sum(@PathVariable("numberOne") String numberOne,
                          @PathVariable("numberTwo") String numberTwo){
        return 1D;
    }

}

