public class CalcString extends CalcEngine{
    public CalcString(){
        super();
    }

    //TODO test cases

    public String evaluateInfix(String infix)
    {
        String postFix = infixToPostFix(infix);
        if(postFix.equals("Bad Input"))
        {
            return "Bad Input";
        }
        else
        {
            return String.valueOf(evaluatePostfix(postFix));
        }
    }


    //copied from the last lab
    private String infixToPostFix(String ifx)
    {
         Stack<Character> stackChar = new StackAsList();
        String result="";
        if(ifx.length() <= 2)
        {
            return "Bad Input";
        }else {
        for (int i =0; i<ifx.length() ;i++)
        {
            if(ifx.charAt(i) == ' ' )
                continue;
            else if(isOperator(ifx.charAt(i)) && !isOperator(ifx.charAt(i+1)) &&
                    result.length() >=1 && !isOperator(ifx.charAt(ifx.length()-1))) //2++2  //+2+2 //2+2+
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
            else if(ifx.charAt(i) == '(' && isBracketsChecked(ifx)) //()2+2
            {
                stackChar.push(ifx.charAt(i));
            }
            else if(ifx.charAt(i) == ')' && isBracketsChecked(ifx))
            {
                while (!stackChar.isEmpty() && stackChar.peek() !='(')
                {
                    result +=  stackChar.pop();
                }
                stackChar.pop();
            }
            else
            {
                return "Bad Input";
            }
        }}
        while (!stackChar.isEmpty())
        {
            result += stackChar.pop();
        }
        return result;
    }

    //copied from the last lab
    private double evaluatePostfix(String pfx)
    {
        Stack<Double> stack = new StackAsList();

        for(int i = 0;i < pfx.length();  i++)
        {
            if(isOperand(pfx.charAt(i)))
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

    private boolean isBracketsChecked(String infex)
    {
        Stack<Character> stackBrackets = new StackAsList();
        int count=0;
        for (int h =0; h<infex.length();h++)
        {
            if(infex.charAt(h) == '(')
            {
                count++;
                stackBrackets.push(infex.charAt(h));
            }
            else
            {
                if (infex.charAt(h) == ')')
                {
                    count++;
                    if(!stackBrackets.isEmpty())
                    {
                        stackBrackets.pop();
                    }
                }
            }

        }
        return stackBrackets.isEmpty() && count % 2 == 0;
    }


    //copied from last lab
    private boolean isOperand(char c)
    {
        return (c >= '0' && c <= '9') || (c>='A' && c<='F')  ;
    }

    public boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private int getOperatorWeight(char operator)
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
