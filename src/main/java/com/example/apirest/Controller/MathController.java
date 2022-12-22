package com.example.apirest.Controller;

import com.example.apirest.Exceptions.UnsupportedMathOperationsExeception;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method = RequestMethod.GET)
        public Double sum(@PathVariable("numberOne") String numberOne,
                          @PathVariable("numberTwo") String numberTwo){
            if(isNumeric(numberOne) && isNumeric(numberTwo)){
                Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
                return sum;
            }
            else{
                throw new UnsupportedMathOperationsExeception("Please set a numeric value!");
            }
    }

    private boolean isNumeric(String numberOne) {
        if(numberOne == null){
            return false;
        }
        String number = numberOne.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertToDouble(String numberOne) {
        if(numberOne == null) return 0D;
        String number = numberOne.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

}

