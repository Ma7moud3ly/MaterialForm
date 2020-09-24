/*
 * MADARSOFT job TASK
 * By:Mahmoud Aly
 * engma7moud3ly@gmail.com
 * */
package com.ma7moud3ly.material_form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.ma7moud3ly.material_form.fragments.InfoFragment;

public class MainActivity extends AppCompatActivity implements NavigationHost {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //show user info fragment
        navigateTo(new InfoFragment(), null, false);
    }

    //navigate between fragments
    public void navigateTo(Fragment fragment, Bundle bundle, boolean addToBackstack) {
        if (bundle != null) fragment.setArguments(bundle);
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment);

        if (addToBackstack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }

}