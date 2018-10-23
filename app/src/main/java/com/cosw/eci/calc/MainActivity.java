
package com.cosw.eci.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Float> operands;
    private List<String> operators;
    private float current=0;
    private String currentString = "0";
    private boolean charPressed = false;
    private Button b1 =  findViewById(R.id.b1);
    private Button b2 =  findViewById(R.id.b2);
    private Button b3 =  findViewById(R.id.b3);
    private Button b4 =  findViewById(R.id.b4);
    private Button b5 =  findViewById(R.id.b5);
    private Button b6 =  findViewById(R.id.b6);
    private Button b7 =  findViewById(R.id.b7);
    private Button b8 =  findViewById(R.id.b8);
    private Button b9 =  findViewById(R.id.b9);
    private Button b0 =  findViewById(R.id.b0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private  String stringValue( float a){
        return "'"+a+"'";
    }

    private void setDisplayNUmber(){
        TextView tv = findViewById(R.id.textview);
        if (operators.size()==0){
            currentString = stringValue(current);
        }else if (operators.size()==operands.size()){
            for (int i=0; i<operators.size();i++){
                currentString += stringValue(operands.get(i)) + " " +operators.get(i);
            }
        }else if (operators.size()-1 == operands.size()){
            for (int i=0; i<operators.size();i++){
                currentString += stringValue(operands.get(i)) + " " + operators.get(i);
            }
            currentString += stringValue(operands.get(operands.size()-1));
        }
        tv.setText(currentString);
    }

    public void clickedNumber(View view){
        if (! (charPressed && currentString=="")){
            if (view == b1) {
                current = current*10 + 1;
            } else if (view == b2) {
                current = current*10 + 2;
            } else if (view == b3) {
                current = current*10 + 3;
            } else if (view == b4) {
                current = current*10 + 4;
            } else if (view == b5) {
                current = current*10 + 5;
            } else if (view == b6) {
                current = current*10 + 6;
            } else if (view == b7) {
                current = current*10 + 7;
            } else if (view == b8) {
                current = current*10 + 8;
            } else if (view == b9) {
                current = current*10 + 9;
            } else {
                current = current*10;
            }
            charPressed = false;
            setDisplayNUmber();
        }
    }

    public void multiply(View view){
        if (charPressed) {
            operators.set(operators.size()-1,"*");
        }
        else {
            charPressed = !charPressed;
            operands.add(current);
            operators.add("*");
            current = 0;
        }
        setDisplayNUmber();
    }

    public void sum(View view){
        if (charPressed) {
            operators.set(operators.size()-1,"+");
        }
        else {
            charPressed = !charPressed;
            operands.add(current);
            operators.add("+");
            current = 0;
        }
        setDisplayNUmber();
    }

    public void rest(View view){
        if (charPressed) {
            operators.set(operators.size()-1,"-");
        }
        else {
            charPressed = !charPressed;
            operands.add(current);
            operators.add("-");
            current = 0;
        }
        setDisplayNUmber();
    }

    public void divide(View view){
        if (charPressed) {
            operators.set(operators.size()-1,"/");
        }
        else {
            charPressed = !charPressed;
            operands.add(current);
            operators.add("/");
            current = 0;
        }
        setDisplayNUmber();
    }

    public void result(View view){
        for (int i=0; i<operands.size(); i++){

        }
    }

    public void ac(View view){
        charPressed = false;
        current = 0;
        currentString="0";
        operators.clear();
        operands.clear();
    }

}
