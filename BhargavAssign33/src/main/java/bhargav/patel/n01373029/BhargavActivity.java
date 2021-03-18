//BhargavPatel N01373029 SectionB
package bhargav.patel.n01373029;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

public class BhargavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //OnBackKeyPressed
        @Override
        public void onBackPressed() {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("BhargavPatel N01373029")
                    .setMessage("Are you sure you want to close the application?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //Closes the current Activity and cannot be accessed by other pages.
                            finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
}