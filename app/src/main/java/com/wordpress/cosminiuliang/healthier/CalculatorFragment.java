package com.wordpress.cosminiuliang.healthier;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorFragment extends Fragment {

    private TextView calculatorTextView;
    private EditText inaltimeEditText;
    private EditText varstaEditText;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button calculatorBtn;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

                final View viewCalc = inflater.inflate(R.layout.calculator_fragment, container, false);

                radioGroup = (RadioGroup) viewCalc.findViewById(R.id.radioGroup);
                calculatorTextView = (TextView) viewCalc.findViewById(R.id.calculatorTextView);
                varstaEditText = (EditText) viewCalc.findViewById(R.id.varstaEditText);
                inaltimeEditText = (EditText) viewCalc.findViewById(R.id.inaltimeEditText);
                calculatorBtn = (Button) viewCalc.findViewById(R.id.calculatorBtn);

                calculatorBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                         Animation animation1 = AnimationUtils.loadAnimation(getActivity()
                                 .getBaseContext().getApplicationContext(), R.anim.fadein);
                         calculatorBtn.startAnimation(animation1);
                         Animation animation2 = AnimationUtils.loadAnimation(getActivity()
                                 .getBaseContext().getApplicationContext(), R.anim.bounce);

                        try{

                            int inaltime = Integer.parseInt(inaltimeEditText.getText().toString());
                            int varsta = Integer.parseInt(varstaEditText.getText().toString());
                            int radioId = radioGroup.getCheckedRadioButtonId();
                            radioButton = viewCalc.findViewById(radioId);
                            String sexChoice = (String) radioButton.getText();

                            if (sexChoice.contains("Feminin")) {
                                calculatorTextView.startAnimation(animation2);
                                int greutateIdeala = (int) ((50 + 0.75 * (inaltime - 150) + (varsta - 20) / 4) * 0.9);
                                calculatorTextView.setText("Greutatea dvs. ideala este de:\n" + greutateIdeala + "kg");


                            } else if (sexChoice.contains("Masculin")) {
                                   calculatorTextView.startAnimation(animation2);
                                   int greutateaIdeala = (int) (50 + 0.75 * (inaltime - 150) + (varsta - 20) / 4);
                                   calculatorTextView.setText("Greutatea dvs. ideala este de:\n" + greutateaIdeala + "kg");
                            }

                        }catch (Exception e){Toast.makeText(getActivity().getApplicationContext(),"Completeaza toate spatiile!",Toast.LENGTH_LONG).show();}
                    }
                });


            return viewCalc;

        }
}

