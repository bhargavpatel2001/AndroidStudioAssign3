//BhargavPatel N01373029 SectionB
package bhargav.patel.n01373029.Fragment1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import bhargav.patel.n01373029.BhargavCanvas;
import bhargav.patel.n01373029.R;

public class BhargavFragment extends Fragment {

    BhargavCanvas customCanvas;
    Button btn;
    ImageButton btn2,btn3,btn4,btn5,btn6,btn7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bhargav, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        customCanvas = view.findViewById(R.id.BhargavDrawCanvas);
        btn = view.findViewById(R.id.BhargavClearBtn);
        btn2 = view.findViewById(R.id.BhargavCOptions1);
        btn3 = view.findViewById(R.id.BhargavCOptions2);
        btn4 = view.findViewById(R.id.BhargavCOptions3);
        btn5 = view.findViewById(R.id.BhargavSOptions1);
        btn6 = view.findViewById(R.id.BhargavSOptions2);
        btn7 = view.findViewById(R.id.BhargavSOptions3);

        //Button on click listener calling clearCanvas;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCanvas();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color1();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color2();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color3();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stroke1();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stroke2();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stroke3();
            }
        });
    }

    public void clearCanvas(){
        customCanvas.resetPath();
    }

    public void color1(){
        customCanvas.color1();
    }

    public void color2(){
        customCanvas.color2();
    }

    public void color3(){
        customCanvas.color3();
    }

    public void stroke1(){
        customCanvas.stroke1();
    }

    public void stroke2(){
        customCanvas.stroke2();
    }

    public void stroke3(){
        customCanvas.stroke3();
    }

}