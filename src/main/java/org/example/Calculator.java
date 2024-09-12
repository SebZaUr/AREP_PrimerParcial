package org.example;

import java.lang.reflect.Method;
import java.util.Objects;

public class Calculator {
    public static double[] getMethod(String method, double[] operators) throws Exception {
        double[] answer = new double[0];
        Class<Math> math = Math.class;
        Method[] methods = math.getDeclaredMethods();
        if(Objects.equals(method, "bbl")){
            while(!isInOrder(operators)){
                for(int i=0; i< operators.length -1; i++){
                    if(operators[i] > operators[i+1]){
                        double min = operators[i+1];
                        double max = operators[i];
                        operators[i] = min;
                        operators[i+1] = max;
                    }
                }
            }
            answer = operators;
        }
        return answer;
    }

    private static boolean isInOrder(double[] list){
        for(int i =0; i<list.length-1;i++){
            if(list[i] > list[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] agrs) throws Exception {
        double[] list = {5.0, 4.5, 4.0, 3.0, 2.0};
        list = getMethod("bbl",list);
        for(double num:list){
            System.out.println(Double.toString(num));
        }
    }
}
