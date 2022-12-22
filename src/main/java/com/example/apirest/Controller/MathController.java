package com.example.apirest.Controller;

import com.example.apirest.Exceptions.UnsupportedMathOperationsExeception;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController extends ValidationsController {

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
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo){
        if(isNumeric(numberOne) && isNumeric(numberTwo)){

            Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
            return sub;
        }
        else{
            throw new UnsupportedMathOperationsExeception("Please set a numeric value!");
        }
    }
    @RequestMapping(value = "/mul/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double mul(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo){
        if(isNumeric(numberOne) && isNumeric(numberTwo)){
            Double mul = convertToDouble(numberOne) * convertToDouble(numberTwo);
            return mul;
        }
        else{
            throw new UnsupportedMathOperationsExeception("Please set a numeric value!");
        }
    }
    @RequestMapping(value = "/div/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo){
        if(isNumeric(numberOne) && isNumeric(numberTwo)){
            return convertToDouble(numberOne) / convertToDouble(numberTwo);

        }
        else{
            throw new UnsupportedMathOperationsExeception("Please set a numeric value!");
        }
    }

    @RequestMapping(value = "/sqrt/{numberOne}",method = RequestMethod.GET)
    public Double sqrt(@PathVariable("numberOne") String numberOne){
        if(isNumeric(numberOne)){
            Double number = convertToDouble(numberOne);
            return Math.sqrt(number);
        }
        else{
            throw new UnsupportedMathOperationsExeception("Please set a numeric value!");
        }
    }

}

