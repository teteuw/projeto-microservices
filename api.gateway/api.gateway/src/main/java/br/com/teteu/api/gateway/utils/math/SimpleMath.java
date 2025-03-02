package br.com.teteu.api.gateway.utils.math;

public class SimpleMath {
    
    public static Double sum(String numberOne, String numberTwo){
        return MathUtils.convertToDouble(numberOne) + MathUtils.convertToDouble(numberTwo);
    }
    public static Double sub(String numberOne, String numberTwo){
        return MathUtils.convertToDouble(numberOne) - MathUtils.convertToDouble(numberTwo);
    }
    public static Double mul(String numberOne, String numberTwo){
        return MathUtils.convertToDouble(numberOne) * MathUtils.convertToDouble(numberTwo);
    }
    public static Double div(String numberOne, String numberTwo){
        return MathUtils.convertToDouble(numberOne) / MathUtils.convertToDouble(numberTwo);
    }
}
