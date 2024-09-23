package com.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private Button buttonNumber0;

    @FXML
    private TextField textResult;

    private boolean result = false;

    private double resultNumber = 0;

    private String onScreenNumber = "";

    private String operator = "";

    private String hiddenNumber = "";

    @FXML
    private void actionAdd(ActionEvent event) {
        if(result == true && hiddenNumber.isEmpty() && operator.isEmpty()){
            onScreenNumber = "";
            result = false;
            onScreenNumber += ((Button) event.getSource()).getText();
            updateTextResult();
        }else{
            onScreenNumber += ((Button) event.getSource()).getText();
            updateTextResult();
        }
    };

    @FXML
    private void updateTextResult() {
        textResult.setText(onScreenNumber);
    };

    @FXML
    private void addOperator(ActionEvent event) {
        if (onScreenNumber != "" && operator.isEmpty() && result == false) {
            hiddenNumber = onScreenNumber;
            onScreenNumber = "";
            operator = ((Button) event.getSource()).getText();
            textResult.setText(operator);
        } else if (result == true && !onScreenNumber.isEmpty() && operator.isEmpty()) {
            hiddenNumber = onScreenNumber;
            operator = ((Button) event.getSource()).getText();
            textResult.setText(operator);
        }
    }

    @FXML
    private void equals() {
        if (!operator.isEmpty() && !onScreenNumber.isEmpty()) {

            double firstNumber = Double.parseDouble(hiddenNumber);
            double secondNumber = Double.parseDouble(onScreenNumber);

            if (operator.equals("+")) {
                resultNumber = firstNumber + secondNumber;
            } else if (operator.equals("-")) {
                resultNumber = firstNumber - secondNumber;
            } else if (operator.equals("x")) {
                resultNumber = firstNumber * secondNumber;
            } else {
                resultNumber = firstNumber / secondNumber;
            }
            onScreenNumber = String.valueOf(resultNumber);
            result = true;
            hiddenNumber = "";
            operator = "";
            textResult.setText(String.valueOf(resultNumber));
        }
    }

    @FXML
    private void clear() {
        onScreenNumber = "";
        hiddenNumber = "";
        operator = "";
        resultNumber = 0;
        updateTextResult();
    }

    @FXML
    private void clearEntry() {
        if (onScreenNumber.length() >= 1 && result == false) {
            onScreenNumber = onScreenNumber.substring(0, onScreenNumber.length() - 1);
            updateTextResult();
        }
    }

    @FXML
    private void actionAddDot(ActionEvent event) {
        if (!onScreenNumber.isEmpty() && onScreenNumber.indexOf(".") == -1) {
            onScreenNumber += ((Button) event.getSource()).getText();
            updateTextResult();
        }

    }
}
