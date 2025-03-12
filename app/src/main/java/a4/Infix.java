package a4;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Infix {

    /**
     * Takes in tokens in infix expression and converts it to postfix and returns answer
     * @param tokens tokenized arraydeque
     * @return double of computer answer through postfix
     */
    public static Double infixToPostfix(ArrayDeque<Object> tokens) {
        ArrayDeque<Object> stack = new ArrayDeque<>(); // stack used for operators
        ArrayDeque<Object> queue = new ArrayDeque<>(); // queue used for numbers 
        int num = tokens.size();
        HashMap<Character, Integer> operator_precedence = new HashMap<>(); // creates precedence values for different operators

        operator_precedence.put('(', 5);
        operator_precedence.put('^', 4);
        operator_precedence.put('*', 3);
        operator_precedence.put('/', 3);
        operator_precedence.put('+', 2);
        operator_precedence.put('-', 2);


        for (int i = 0; i < num; i++) {
            if (tokens.getFirst() instanceof Double){
                queue.addLast((Double) tokens.getFirst()); // pushes token onto end of queue if it is number
                tokens.removeFirst();
            }
            else if ((Character) tokens.getFirst() == '('){
                stack.push(tokens.getFirst());
                System.out.println(stack);
                tokens.removeFirst();
            }
            else if ((Character) tokens.getFirst() == ')') {
                System.out.println(stack);
                while (stack.size() > 0 && (Character) stack.peek() != '('){
                    Object operator = stack.pop(); //pops elements that aren't left parenthesis
                    queue.add(operator); // pushes popped onto queue
                }
                if (stack.size() < 1){ // if stack is empty without finding left parentheses
                    System.out.println("Mismatched parenthesis2");
                }
                else if ((Character) stack.peek() == '('){
                    stack.pop(); // pop left parentheses from stack
                }
                tokens.removeFirst();
                }
            else if ((Character) tokens.getFirst() == '^' ||  (Character) tokens.getFirst() == '*' || (Character) tokens.getFirst() == '/' || (Character) tokens.getFirst() == '+' || (Character) tokens.getFirst() == '-'){
                while (stack.peek() instanceof Character && operator_precedence.get(stack.peek()) >= operator_precedence.get(tokens.getFirst())){
                    Object stack_operator = stack.pop(); // pops last element on stack
                    queue.addLast(stack_operator); 
                }
                stack.push(tokens.getFirst());
                tokens.removeFirst();
                }
            
            }
            while (stack.size() > 0){
                if ((Character) stack.peek() == '(' || (Character) stack.peek() == ')'){
                    System.out.println("Mismatched parentheses1");
                }
                else if (stack.peek() instanceof Character){
                    Object operator = stack.pop();
                    queue.addLast(operator);
                }
            }


            
        return(Postfix.postfix(queue)); // returns the postfix of the queue, which is a double
    }



    
}



