package com.wordpress.cosminiuliang.healthier;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class InformationFragment extends Fragment {


    private Button proteineBtn;
    private Button caloriiBtn;
    private Button carbohidratiBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View viewInfo = inflater.inflate(R.layout.information_fragment, container, false);

        proteineBtn = (Button) viewInfo.findViewById(R.id.proteineBtn);
        proteineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity()
                        .getBaseContext().getApplicationContext(), R.anim.fadein);
                proteineBtn.startAnimation(animation);

                String proteineSite =
                        "https://ro.wikipedia.org/wiki/Protein%C4%83";

                Intent intent = new Intent(getActivity().getApplicationContext(), WebView.class);
                intent.putExtra("webview", proteineSite);
                intent.putExtra("titleBar", "Proteine Info");
                startActivity(intent);
            }
        });

        caloriiBtn = (Button) viewInfo.findViewById(R.id.caloriiBtn);
        caloriiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity()
                        .getBaseContext().getApplicationContext(), R.anim.fadein);
                caloriiBtn.startAnimation(animation);

                String caloriiSite =
                        "https://ro.wikipedia.org/wiki/Calorie";

                Intent intent = new Intent(getActivity().getApplicationContext(), WebView.class);
                intent.putExtra("webview", caloriiSite);
                intent.putExtra("titleBar", "Calorii Info");
                startActivity(intent);
            }
        });
        carbohidratiBtn = (Button) viewInfo.findViewById(R.id.carbohidratiBtn);
        carbohidratiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getActivity()
                        .getBaseContext().getApplicationContext(), R.anim.fadein);
                carbohidratiBtn.startAnimation(animation);

                String carbohidratiSite =
                        "https://ro.wikipedia.org/wiki/Glucid%C4%83";

                Intent intent = new Intent(getActivity().getApplicationContext(), WebView.class);
                intent.putExtra("webview", carbohidratiSite);
                intent.putExtra("titleBar", "Carbohidrati Info");
                startActivity(intent);

            }
        });


        return viewInfo;
    }
}

