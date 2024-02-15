package com.example.operatingsystems;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Stack;

public class EvaluateView {
    private Stack stack;
    public Button evaluateButton;
    public Label stepsLabel;
    public Label answerLabel;
    @FXML
    private TextField textInput;
    @FXML
    private Label outputLabel;

    public EvaluateView() //main constructor that initializes the stack used to pop/push the operands and numbers.
    {
        stack = new Stack(); //initializes stack.
    }

    @FXML
    protected void onEvaluateClick() {
        StringBuilder strBuilder = new StringBuilder();
        if(textInput.getText().equals("")) {
            outputLabel.setText("Enter something in the text box to begin!");
        }
        else {
            String expression = textInput.getText().trim();
            if (!((expression.contains("*")) || (expression.contains("/")) || (expression.contains("+"))
                || (expression.contains("-")) || (expression.contains(" ")))) {
                outputLabel.setText("Oops! That expression isn't quite right. Try again!");
            } else {
                ArrayList<String> expressionList = new ArrayList<>(
                        Arrays.asList(textInput.getText().split(" ")));
                for(int i = 0; i < expressionList.size(); i++) {
                    if(i % 2 == 0 && isNumber(expressionList.get(i))) {
                        strBuilder.append(expressionList.get(i));
                        if(!(i == expressionList.size())) {
                            strBuilder.append(" ");
                        }
                    }
                }

                for(int i = expressionList.size() - 1; i > 0; i--) { //similar loop to above in that it cycles through odd as ops and even as #s
                    //if-else statements check to see if there are operations in odd positions and numbers in even positions
                    if(i % 2 == 1 && (expressionList.get(i).equals("*") || expressionList.get(i).equals("/")
                            || expressionList.get(i).equals("+") || expressionList.get(i).equals("-"))) {
                        strBuilder.append(expressionList.get(i));
                        if(!(i == 1)) {
                            strBuilder.append(" ");
                        }
                    }
                }

                String newString = strBuilder.toString();


                answerLabel.setText(evaluate(newString));
                outputLabel.setText("Original expression: " + expression + " --> Array: " +
                        expressionList);
            }
        }
    }

    //Method checks to see if the particular item in the array is a number.
    public boolean isNumber(String arrayValue) { //takes an array value as a parameter
        try {
            Double.parseDouble(arrayValue);  //checks if the value can be converted properly to a double
            return true; //returns true if the above statement works (i.e., value is a number)
        }
        catch(NumberFormatException e) {  //catches exception in case value is not a number
            outputLabel.setText("Oops! Something isn't quite right. Try again!"); //print statement to re-prompt user
            return false;  //returns false if the item is not a number
        }
    }

    //method computes the expression to return a proper result
    public String evaluate(String expr)
    {
        //declare operands: op1 and op2 both integer
        //declare result variable
        double op1;
        double op2;
        double result;
        StringBuilder item = new StringBuilder();

        //declare next token as String
        String token;

        //declare a StringTokenizer
        StringTokenizer tokenizer = new StringTokenizer(expr);

        //while loop: loop through the expression, as long as there are more tokens then
        //step into the while loop
        while (tokenizer.hasMoreTokens())
        {
            token = tokenizer.nextToken();
            //System.out.println("*Number or operation? Currently evaluating: "  + token);
            //if it is an operator then first pop the right operand and pop the left operand
            //then push the evaluation result back into the stack
            if(isOperator(token))
            {
                op2 = (double) stack.pop();
                op1 = (double) stack.pop();
                result = evalSingleOp(token, op1, op2);
                item.append(op1).append(" ").append(token).append(" ").append(op2).append("\n");
                stack.push(result);
            }

            //else the stack will push the token into the stack (you might want to convert string to integer object)
            else
            {
                //System.out.println("Integer: " + token);
                stack.push(new Double(token));
            }
        }

        //pop the only value from the stack and return the result
        result = (double) stack.pop();
        return item + "\n" + "Result: " + result;
    }

    //evaluates a single operation, using cases to check whether the operation is multiplication, division, addition, or subtraction
    private double evalSingleOp(String operation, double op1, double op2)
    {
        //declare a variable to hold the final result
        double result = 0;

        //use switch statement to calculate the results
        switch(operation)
        {
            case "*" : result = op1 * op2;
                break;
            case "/" : result = op1 / op2;
                break;
            case "+" : result = op1 + op2;
                break;
            case "-" : result = op1 - op2;
                break;
        }

        //return the result in the form of an integer
        return result;
    }

    //method that checks whether a token in the stack is an operator, otherwise returns false
    private boolean isOperator(String token)
    {
        //if the token is "+" or "-" or "*" or "/" then return true
        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
        {
            return true;
        }
        else
            return false;
    }
}
