package br.com.teteu.api.gateway.controller;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.teteu.api.gateway.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(
        @PathVariable(value = "numberOne")String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
                    throw new UnsupportedMathOperationException("Please set a valid number");
                }
            return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
                        
        
    private Double convertToDouble(String str) {
        if(str == null) return 0D;
        String number = str.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        else return 0D;
    }
    private boolean isNumeric(String str) {
        if(str == null) return false;
        String number = str.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+"); 
    }
}
