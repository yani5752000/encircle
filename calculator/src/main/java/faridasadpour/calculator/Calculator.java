/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faridasadpour.calculator;

/**
 *
 * @author faridasadpour
 */
public class Calculator {
    public static void main(String[] args) {
        
        System.out.println(process(args[0]));
    }
    
    public static int op(String operation, int a, int b){
        int output = -1;
        switch (operation) {
            case "add":
                output = a + b;
                break;
            case "multiply":
                output =  a * b;
                break;
            default: break;
        }
        return output;
    }
    
    public static int process(String input) {
        if(input.contains("(")){
            if(numOfParentheses(input) == 1){
                String input1 = input.substring(1, input.length() - 1);
                String [] tokens = input1.split(" ");

                return op(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            }
            int intercept1, intercept2;
            
            String input1 = input.substring(1, input.length() - 1);
            int i = 0;
            while(input1.charAt(i) != ' '){
                i++;
            }
            intercept1 = i;
            
            if(input1.charAt(i + 1) != '('){
                i++;
                while(input1.charAt(i) != ' '){
                    i++;
                }
                intercept2 = i;
            } else {
                i++;
                int parity = 1;
                while(parity != 0){
                    i++;
                    if(input1.charAt(i) == ')'){
                        parity--;
                    }
                    if(input1.charAt(i) == '('){
                        parity++;
                    }
                        
                }
                intercept2 = i + 1;
                
            }
            String token1 = input1.substring(0, intercept1);
            String token2 = input1.substring(intercept1 + 1, intercept2);
            String token3 = input1.substring(intercept2 + 1);
            return op(token1, process(token2), process(token3));
        } else {
            return Integer.parseInt(input);
        }
        
    }
    
    public static int numOfParentheses(String str) {
        int num = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                num++;
            }
        }
        return num;
    }
}
