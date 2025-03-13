package a4;

import java.util.ArrayDeque;
import java.lang.Math;

public class Postfix {

    /**
     * Takes in postfix expression and returns answer as a double
     * @param tokens postfix expression inputted
     * @return double of computer answer
     */
    public static Double postfix(ArrayDeque<Object> tokens) {
        ArrayDeque<Double> stack = new ArrayDeque<>(); // creates stack
        int num = tokens.size();
        for (int index = 0; index < num; index++) {
            if (tokens.getFirst() instanceof Double){
                stack.push((Double) tokens.getFirst()); // pushes first item in deque onto stack
                System.out.println((Double) tokens.getFirst());
                tokens.removeFirst(); // removes first item from deque

            }
            else if (tokens.getFirst() instanceof Character){ 
                if (stack.size() >= 2){
                    Double second_element = stack.pop(); // second number in equation
                    System.out.println(second_element);
                    Double first_element = stack.pop(); // first number in equation
                    System.out.println(first_element);
                    Double result = operator((Character) tokens.getFirst(), first_element, second_element); // calls operator to do operation on two numbers
                    stack.push(result); // pushes result onto stack
                    tokens.removeFirst(); // removes first item from deque
                }
                else{
                    throw new IllegalArgumentException("Failed for expression");
                }
                
            }
    
        }
        if (stack.size() > 1){
            throw new IllegalArgumentException("Failed for expression:");
        }
        
    
    return stack.getFirst(); // returns the result in the stack as a double
        

}


    

    /**
     * Method for different operations on two numbers
     * @param operator operator for operation
     * @param number_1 number 1
     * @param number_2 number 2
     * @return result of operation on number 1 and number 2
     */
    public static Double operator(Character operator, double number_1, double number_2){
        Double result = 0.0;
        if (operator == '+'){
            result = number_1 + number_2;
        }
        if (operator == '-'){
            result = number_1 - number_2;
        }
        if (operator == '*'){
            result = number_1 * number_2;
        }
        if (operator == '/'){
            result = number_1 / number_2;
        }
        if (operator == '%'){
            result = number_1 % number_2;
        }
        if (operator == '^'){
            result = Math.pow(number_1, number_2);
        }
        return result;

    }

}


        
    



