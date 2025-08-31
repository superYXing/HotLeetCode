package heima;

import java.util.ArrayList;
import java.util.LinkedList;

//中缀表达式转后缀表达式
public class InfixToSuffix {
    public static int priority(char c){
        switch(c) {
            case '+' , '-' ->{
                return 1;
            }
            case '*' , '/' ->{
                return 2;
            }
            case '(',')' -> {
                return 0;
            }
            default -> {
                return -1;
        }
        
    }
}
    public static String convert(String exp){
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);
            switch (c) {
                case '+','-','*','/' ->{
                    while(!stack.isEmpty()&&priority(c)<=priority(stack.peek())){
                    sb.append(stack.pop());
                    }
                    stack.push(c);                  
                }
                case '('->{
                    stack.push(c);
                }
                case ')'->{
                    while(stack.peek()!='('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default->{
                    sb.append(c);
                }
      
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    } 
    public static void main(String[] args) {
        String exp = "a*(b+c)";
        String res = convert(exp);
        System.out.println(res);
    }
}
