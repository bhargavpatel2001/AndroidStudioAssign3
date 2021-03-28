//BhargavPatel N01373029 SectionB
package bhargav.patel.n01373029.Fragment2;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import bhargav.patel.n01373029.BhargavActivity;
import bhargav.patel.n01373029.R;

public class PatelFragment extends Fragment {

    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS= 7;
    private int STORAGE_PERMISSION_CODE = 1;
    AnimationDrawable mframeAnimation = null;

    Button btnCam,starter,stopper;
    Button btnSpeed1, btnSpeed2, btnSpeed3, btnSpeed4;
    ImageView image;
    int reasonableDuration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCam = view.findViewById(R.id.BhargavCamBtn);
        image = view.findViewById(R.id.BhargavGifImg);
        starter = view.findViewById(R.id.BhargavStartBtn);
        stopper = view.findViewById(R.id.BhargavStopBtn);
        btnSpeed1 = view.findViewById(R.id.BhargavSpeedBtn1);
        btnSpeed2 = view.findViewById(R.id.BhargavSpeedBtn2);
        btnSpeed3 = view.findViewById(R.id.BhargavSpeedBtn3);
        btnSpeed4 = view.findViewById(R.id.BhargavSpeedBtn4);


        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        stopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimation();
            }
        });

        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

                    // To Show a Toast
                    Toast toast = Toast.makeText(getActivity(), "Permission has been granted", Toast.LENGTH_LONG);
                    toast.show();
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivity(intent);
                }
                else {
                    requestStrongPermission();
                }
            }
        });

        btnSpeed1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //If you want the frame to be per second set reasonableDuration = 1000 the frames will be 1 second;
                reasonableDuration = 1;
                stopAnimation();
                startAnimation();
            }
        });

        btnSpeed2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                reasonableDuration = 80;
                stopAnimation();
                startAnimation();
            }
        });

        btnSpeed3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                reasonableDuration = 300;
                stopAnimation();
                startAnimation();
            }
        });

        btnSpeed4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                reasonableDuration = 250;
                stopAnimation();
                startAnimation();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                // To Show a Toast
                Toast toast = Toast.makeText(getActivity(),"Permission has been granted",Toast.LENGTH_LONG);
                toast.show();
            }
            else {
                // To Show a Toast
                Toast toast = Toast.makeText(getActivity(),"Permission has been Denied",Toast.LENGTH_LONG);
                toast.show();
            }

        }
    }
    private void requestStrongPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.READ_EXTERNAL_STORAGE)){

            new AlertDialog.Builder(getActivity())
                    .setTitle("Required Permissions")
                    .setMessage("Try again to grant permission ?")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(getActivity(),new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        }

        else {
            ActivityCompat.requestPermissions(getActivity(),new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }

    private void startAnimation()
    {
        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.framesharingan0);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.framesharingan1);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.framesharingan2);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.framesharingan3);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.framesharingan4);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.framesharingan5);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.framesharingan6);

        // Get the background, which has been compiled to an AnimationDrawable object.
        reasonableDuration = 2500;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);
        mframeAnimation.addFrame(frame7, reasonableDuration);

        image.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }
}


