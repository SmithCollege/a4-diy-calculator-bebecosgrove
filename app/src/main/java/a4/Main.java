package a4;

import java.util.ArrayDeque;

class Main {
  /**
   * Main method
   * @param args arguments
   */
  public static void main(String[] args) {
    // ArrayDeque<Object> tokens = Tokenizer.readTokens("28 1 4 / *");
    ArrayDeque<Object> infix = Tokenizer.readTokens("(3.5*4)*0.5");
    System.out.println(Infix.infixToPostfix(infix));
    // System.out.println(Tokenizer.readTokens("28 1 4 / *"));
    // System.out.println(Postfix.postfix(tokens));
    // System.out.println("Calls from the command line:");
    // System.out.println("    java Postfix <postfix-expr>");
    // System.out.println("    java Calculate <infix-expr>");
  }
}