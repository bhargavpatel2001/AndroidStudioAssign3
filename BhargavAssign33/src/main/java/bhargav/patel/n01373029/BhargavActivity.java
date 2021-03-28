//BhargavPatel N01373029 SectionB
package bhargav.patel.n01373029;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import bhargav.patel.n01373029.Fragment1.BhargavFragment;
import bhargav.patel.n01373029.Fragment2.PatelFragment;
import bhargav.patel.n01373029.Fragment3.N01373029Fragment;


public class BhargavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.BhargavFContainer, new BhargavFragment())
                .commit();

        BottomNavigationView botNavView = findViewById(R.id.Bhargav_bottom_navigation);
        botNavView.setOnNavigationItemSelectedListener(botNavListener);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener botNavListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragmentSelected = null;

                    switch(item.getItemId()){
                        case R.id.BhargavFM3Icon1:
                            fragmentSelected = new BhargavFragment();
                            break;
                        case R.id.BhargavFM3Icon2:
                            fragmentSelected = new PatelFragment();
                            break;
                        case R.id.BhargavFM3Icon3:
                            fragmentSelected = new N01373029Fragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.BhargavFContainer, fragmentSelected)
                            .commit();

                    return true;
                }
            };

    //OnBackKeyPressed
        @Override
        public void onBackPressed() {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.AlertTitle)
                    .setMessage(R.string.AlertMessage)
                    .setPositiveButton(R.string.AlertYes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //Closes the current Activity and cannot be accessed by other pages.
                            finish();
                        }
                    })
                    .setNegativeButton(R.string.AlertNo, null)
                    .show();
        }
}