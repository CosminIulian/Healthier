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

public class GoToListFragment extends Fragment {

       private Button goToListBtn;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            final View viewList = inflater.inflate(R.layout.go_to_list_fragment, container, false);


            goToListBtn = (Button) viewList.findViewById(R.id.goToListBtn);
            goToListBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation animation = AnimationUtils.loadAnimation(getActivity()
                            .getBaseContext().getApplicationContext(), R.anim.fadein);
                    goToListBtn.startAnimation(animation);

                    Intent intent = new Intent(getActivity(), ListAliments.class);
                    startActivity(intent);
                }
            });



            return viewList;
        }
    }

