package p1;
import java.util.*;

public class Etree
{
    private String infixExpression, postfixExpression;
    private Node tree;
    private Stack< Character > stack;
    public String getPostfix(){ return postfixExpression; }
    
    public Etree()
    {
        infixExpression = new String("");
        postfixExpression = new String("");
    }

    public boolean setInfixExpression (String a) 
    { 
        infixExpression = a; 
        postfixExpression = "";
        return infixToPostfix();
    }

    private boolean infixToPostfix()
    {
        boolean isOperators = true;
        char c;
        stack = new Stack<>();
        int i, k, n;
        for(i = 0, k = 0, n = infixExpression.length(); i < n; ++i)
        {
            c = infixExpression.charAt(i);
            if (Character.isLetter(c))
            {
                if(checkFormat(i, n) == false)
                    return false;
                postfixExpression += c + " ";
                isOperators = true;
                ++i;
            }
            else if( Character.isDigit(c) )
            {
                if(isOperators == true)
                {
                    isOperators = false;
                    k = i;
                }
            }
            else if(c == ' ' && isOperators == false)
            {
                postfixExpression += infixExpression.substring(k, i) + " ";
                isOperators = true;
            }
            else if(c == '(')
                stack.push(c);
            else if(operandCheck(c))
            {
                if(checkFormat(i, n) == false)
                    return false;
                while(stack.isEmpty() == false)
                    if(precedence(c) > precedence(stack.peek()) )
                        break;
                    else
                        postfixExpression += stack.pop() + " ";
                stack.push(c);
                isOperators = true;
            }
        }
        if(isOperators == false)
        	postfixExpression += infixExpression.substring(k, i);
        while(stack.isEmpty() == false)
            postfixExpression += " " + stack.pop();
        return true;
    }
    
    private boolean checkFormat(int i, int n)
    {
        if(i > 0)
            if(infixExpression.charAt(i - 1) != ' ')
                return false;
        if(i + 1 != n)
            if(infixExpression.charAt(i + 1) != ' ')
                return false;
        return true;
    }
    private boolean operandCheck(char c)
    {
    	switch (c)
        {
    		case '+':
    		case '-':
    		case '*':
    		case '/':
            case '^':
            	return true;
            default:
                return false;
        }
    }
    
    private int precedence(char c)
    {
        switch (c)
        {
            case '+':
            case '-':
                return 1;
      
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
}