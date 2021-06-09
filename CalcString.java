import java.util.Stack;

public class CalcString extends CalcEngine{
    public CalcString(){
        super();
    }
    //TODO test cases

    public double evaluateInfix(String infix){
        String postFix = infixToPostFix(infix);
        return evaluatePostfix(postFix);
    }

    //copied from the last lab
    private String infixToPostFix(String ifx){
         Stack<Character> stackChar = new Stack();
        String result="";
        for (int i =0; i<ifx.length() ;i++)
        {
            if(ifx.charAt(i) == ' ' )
                continue;
            else if(isOperator(ifx.charAt(i)) )
            {
                while (!stackChar.isEmpty() && getOperatorWeight(ifx.charAt(i)) <= getOperatorWeight(stackChar.peek()) )
                {
                    result += stackChar.pop();
                }
                stackChar.push(ifx.charAt(i));
            }
            else if(isOperand(ifx.charAt(i)))
            {
                result += ifx.charAt(i);
            }
            else if(ifx.charAt(i) == '(')
            {
                stackChar.push(ifx.charAt(i));
            }
            else if(ifx.charAt(i) == ')')
            {
                while (!stackChar.isEmpty() && stackChar.peek() !='(')
                {
                    result +=  stackChar.pop();
                }
                stackChar.pop();
            }
            else
            {
                System.out.println("your input is not well-formed.");
                break;
            }
        }
        while (!stackChar.isEmpty())
        {
            result += stackChar.pop();
        }
        return result;
    }

    //copied from the last lab
    private Double evaluatePostfix(String pfx){
        Stack<Double> stack = new Stack();

        for(int i = 0;i < pfx.length();  i++)
        {
            if(!isOperator(pfx.charAt(i)))
            {
                double number = Character.getNumericValue(pfx.charAt(i));
                stack.push(number);
            }
            if( isOperator(pfx.charAt(i)) )
            {
                double result;
                switch (pfx.charAt(i))
                {
                    case '+' -> {
                        result = stack.pop() + stack.pop();
                        stack.push(result);
                    }
                    case '-' -> {
                        double a = stack.pop();
                        double b = stack.pop();
                        result = b - a;
                        stack.push(result);
                    }
                    case '*' -> {
                        result = stack.pop() * stack.pop();
                        stack.push(result);
                    }
                    case '/' -> {
                        double a = stack.pop();
                        double b = stack.pop();
                        result = b / a;
                        stack.push(result);
                    }
                    case '^' -> {
                        double a = stack.pop();
                        double b = stack.pop();
                        result = Math.pow(b,a);
                        stack.push(result);
                    }
                }
            }
        }
        return stack.pop();

    }




    //copied from last lab
    private static boolean isOperand(char c)
    {
        return c >= '0' && c <= '9';
    }

    public static boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static int getOperatorWeight(char operator)
    {
        return switch (operator)
                {
                    case '+', '-' -> 1;
                    case '*', '/' -> 2;
                    case '^' -> 3;
                    default -> 0;
                };
    }


}
