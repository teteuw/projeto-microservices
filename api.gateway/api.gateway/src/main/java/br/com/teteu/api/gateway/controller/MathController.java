package br.com.teteu.api.gateway.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.teteu.api.gateway.exceptions.UnsupportedMathOperationException;
import br.com.teteu.api.gateway.utils.math.MathUtils;

@RestController
public class MathController {
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(
        @PathVariable(value = "numberOne")String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)){
                    throw new UnsupportedMathOperationException("Please set a valid number");
                }
            return MathUtils.convertToDouble(numberOne) + MathUtils.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mul(
        @PathVariable(value = "numberOne")String numberOne,
        @PathVariable(value = "numberTwo")String numberTwo) throws Exception{
            if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)){
                throw new UnsupportedMathOperationException("Please set a valid number");
            }
            return MathUtils.convertToDouble(numberOne) * MathUtils.convertToDouble(numberTwo);
        }
    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
            if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)){
                throw new UnsupportedMathOperationException("Please set a valid number");
            }
            return MathUtils.convertToDouble(numberOne) / MathUtils.convertToDouble(numberTwo);
        }
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
            if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)){
                throw new UnsupportedMathOperationException("Please set a valid number");
            }
            return MathUtils.convertToDouble(numberOne) - MathUtils.convertToDouble(numberTwo);
        }
    
}
