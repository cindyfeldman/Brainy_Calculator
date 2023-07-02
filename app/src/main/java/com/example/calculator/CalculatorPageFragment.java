package com.example.calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import com.example.calculator.databinding.CalculatorPageFragmentBinding;
import com.google.android.material.button.MaterialButton;

public class CalculatorPageFragment extends Fragment  {
    private CalculatorPageFragmentBinding binding;
    private TextView resultDisplayTextView;
    private String resultText = "  ";
    private String firstNumber = "";
    private String secondNumber = "";
    private double resultNumber = 0;
    private boolean isAdd = false;
    private boolean isSubtraction = false;
    private boolean isMultiply = false;
    private boolean isDivide = false;
    private boolean isPercent = false;
    private boolean isNegative = false;
    private MaterialButton[] buttons;
    Color color;
    TextView txtData;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view2 = container.getChildAt(0);
        txtData = view2.findViewById(R.id.resultDisplayTextView);
        binding = CalculatorPageFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttons = new MaterialButton[19];
        buttons[0]  = view.findViewById(R.id.zeroButton);
        buttons[1] = view.findViewById(R.id.oneButton);
        buttons[2] = view.findViewById(R.id.number2Button);
        buttons[3]  = view.findViewById(R.id.number3Button);
        buttons[4] = view.findViewById(R.id.number4Button);
        buttons[5] = view.findViewById(R.id.number5Button);
        buttons[6] = view.findViewById(R.id.number6Button);
        buttons[7] = view.findViewById(R.id.number7Button);
        buttons[8] = view.findViewById(R.id.number8Button);
        buttons[9] = view.findViewById(R.id.number9button);
        buttons[10] = view.findViewById(R.id.decimalPointButton);
        buttons[11] = view.findViewById(R.id.clearButton);
        buttons[12] = view.findViewById(R.id.negativeButton);
        buttons[13] = view.findViewById(R.id.percentButton);
        buttons[14] = view.findViewById(R.id.divideButton);
        buttons[15] = view.findViewById(R.id.multiplyButton);
        buttons[16] = view.findViewById(R.id.subtractionButton);
        buttons[17] = view.findViewById(R.id.plusButton);
        buttons[18] = view.findViewById(R.id.equalButton);
        resultDisplayTextView = view.findViewById(R.id.resultDisplayTextView);
        binding.clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText = "  ";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText += "0";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText += "1";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.number2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText += "2";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.number3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText += "3";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.number4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText += "4";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.number5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText += "5";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.number6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText += "6";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.number7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText += "7";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.number8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText += "8";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.number9button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText += "9";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.decimalPointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText += ".";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPercent = false;
                isAdd = false;
                isSubtraction = false;
                isDivide = false;
                isMultiply = false;
                isNegative = true;
                if (resultText.trim().length() == 0)
                    resultText += "-";
                else
                    resultText = String.valueOf(Double.parseDouble(resultText) * -1);
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.percentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText += "%";
                isPercent = true;
                isAdd = false;
                isSubtraction = false;
                isDivide = false;
                isMultiply = false;
                isNegative = false;

                resultDisplayTextView.setText(resultText);

            }
        });
        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAdd = true;
                isSubtraction = false;
                isDivide = false;
                isMultiply = false;
                isNegative = false;
                isPercent = false;
                firstNumber = resultText.trim();
                resultText += "+";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.subtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAdd = false;
                isSubtraction = true;
                isDivide = false;
                isMultiply = false;
                isNegative = false;
                isPercent = false;
                firstNumber = resultText.trim();
                resultText += "-";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAdd = false;
                isSubtraction = false;
                isDivide = false;
                isMultiply = true;
                isNegative = false;
                isPercent = false;
                firstNumber = resultText.trim();
                resultText += "*";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAdd = false;
                isSubtraction = false;
                isDivide = true;
                isMultiply = false;
                isNegative = false;
                isPercent = false;
                firstNumber = resultText.trim();
                resultText += "\u00F7";
                resultDisplayTextView.setText(resultText);
            }
        });
        binding.equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAdd) {
                    secondNumber = resultText.substring(resultText.indexOf("+") + 1);
                    System.out.println("first: " + firstNumber + " second: " + secondNumber);
                    resultNumber = Double.parseDouble(addition(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber)));
                    resultText += " = " + resultNumber;
                } else if (isSubtraction) {
                    secondNumber = resultText.substring(resultText.indexOf("-") + 1);
                    System.out.println("first: " + firstNumber + " second: " + secondNumber);
                    resultText += " = " + subtraction(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber));
                } else if (isMultiply) {
                    secondNumber = resultText.substring(resultText.indexOf("*") + 1);
                    System.out.println("first: " + firstNumber + " second: " + secondNumber);
                    resultText += " = " + multiply(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber));
                } else if (isDivide) {
                    secondNumber = resultText.substring(resultText.indexOf("\u00F7") + 1);
                    System.out.println("first: " + firstNumber + " second: " + secondNumber);
                    resultText += " = " + divide(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber));
                } else if (isPercent) {
                    firstNumber = resultText.substring(0, resultText.indexOf("%"));
                    resultText += "= " + percent(Double.parseDouble(firstNumber));
                    System.out.println("first: " + firstNumber);
                } else if (isNegative) {
                    firstNumber = resultText;
                    double negated = Double.parseDouble(firstNumber) * -1;
                    resultText += "=" + firstNumber;
                    System.out.println("first: " + firstNumber);
                }
                resultDisplayTextView.setText(resultText);
            }
        });

        Bundle args = getArguments();
        if (args != null) {
            int buttonColors = args.getInt("buttonColors");
            int backgroundColor = args.getInt("backgroundColors");
            int textViewColor = args.getInt("textViewColor");
            // Use the received data as needed
            System.out.println(buttonColors);
            for(int i = 0; i< buttons.length; i++)
                buttons[i].setBackgroundColor(buttonColors);
            view.setBackgroundColor(backgroundColor);
            resultDisplayTextView.setBackgroundColor(textViewColor);
        }
    }

    public String addition(double firstNum, double secondNum) {

        return Double.toString(firstNum + secondNum);
    }

    public String subtraction(double firstNum, double secondNum) {

        return Double.toString(firstNum - secondNum);
    }

    public String multiply(double firstNum, double secondNum) {

        return Double.toString(firstNum * secondNum);
    }

    public String divide(double firstNum, double secondNum) {

        return Double.toString(firstNum / secondNum);
    }

    public String percent(double firstNum) {

        return Double.toString(firstNum / 100);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}