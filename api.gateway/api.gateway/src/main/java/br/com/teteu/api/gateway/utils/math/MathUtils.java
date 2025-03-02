package br.com.teteu.api.gateway.utils.math;
public class MathUtils {
    public static Double convertToDouble(String str) {
        if(str == null) return 0D;
        String number = str.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        else return 0D;
    }
    public static boolean isNumeric(String str) {
        if(str == null) return false;
        String number = str.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+"); 
    }
}
