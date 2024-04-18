package com.example.operatingsystems;

//Import statements for the JavaFX application, buttons, labels, text fields, arrays, Strings, and stacks.
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Stack;

/**
 * @author Mia Watts
 * This program takes an expression and evaluates it based on the order of operations methods.
 * Stacks are used to evaluate expressions that are converted to postfix form after they are
 * added to the application in the form of text input.
 */
public class EvaluateView {
    //Declares six private variables that will be used in the program.
    private Stack stack;
    public Button evaluateButton;
    public Label stepsLabel;
    public Label answerLabel;
    @FXML
    private TextField textInput;
    @FXML
    private Label outputLabel;

    /**
     * Constructor that initializes the stack.
     */
    public EvaluateView() //main constructor that initializes the stack used to pop/push the operands and numbers.
    {
        stack = new Stack(); //initializes stack.
    }

    /**
     * This method is run every time the evaluation button is clicked, regardless of whether the
     * user has added anything into the text box or not. If they haven't, the user is prompted
     * to enter something into the box to start using the application.
     */
    @FXML
    protected void onEvaluateClick() {
        StringBuilder strBuilder = new StringBuilder();
        //Checks to see if something has been entered. If not, the user is prompted to enter something.
        if(textInput.getText().equals("")) {
            outputLabel.setText("Enter something in the text box to begin!");
        }
        //If the user has entered something, the program checks to see if what they entered is
        //a proper mathematical expression. If it isn't, the user must try again.
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

                //Creates new String variable that will be evaluated in postfix form after conversion.
                String newString = strBuilder.toString();

                //Sets the answer label to the result
                answerLabel.setText(evaluate(newString));
                //Shows the original expression and the array
                outputLabel.setText("Original expression: " + expression + " --> Array: " +
                        expressionList);
            }
        }
    }

    /**
     * This method checks to see if the particular item in the array is a number.
     * @param arrayValue - value to be checked.
     * @return true if it is a number, and false otherwise.
     */
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

    /**
     * This method computes the expression given as a parameter to return a result.
     * @param expr - math expression that is to be evaluated.
     * @return the result of the calculation.
     */
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

    /**
     * Evaluates a single operation, using cases  to check whether the operation is multiplication,
     * division, addition, or subtraction.
     * @param operation - operation to be performed on the two numbers.
     * @param op1 - first number to be multiplied, divided, added, or subtracted.
     * @param op2 - second number to be multiplied, divided, added, or subtracted.
     * @return the result of the single evaluation of two numbers and an operation.
     */
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

    /**
     * Method that checks whether a String token in the stack is an operator.
     * @param token - String value to be checked.
     * @return true if the token is an operation, and false otherwise.
     */
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
