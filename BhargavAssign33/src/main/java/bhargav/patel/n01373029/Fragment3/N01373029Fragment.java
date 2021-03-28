//BhargavPatel N01373029 SectionB
package bhargav.patel.n01373029.Fragment3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import bhargav.patel.n01373029.R;

public class N01373029Fragment extends Fragment {


    Button btnRotate, btnCancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_n01373029, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnRotate = view.findViewById(R.id.BhargavStartBtn2);
        btnCancel = view.findViewById(R.id.BhargavStopBtn2);

        LinearLayout layoutToAnimate = view.findViewById(R.id.BhargavLL);
        Animation an = AnimationUtils.loadAnimation(getActivity(), R.anim.tweening_transformations);
        layoutToAnimate.startAnimation(an);


        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutToAnimate.startAnimation(an);
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutToAnimate.clearAnimation();
            }
        });
    }
}