package com.example.romanm.a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.romanm.a1.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity implements FragmentRecycler.OnFragmentInteractionListener {

    private ConstraintLayout container;

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initContainer();
        initFragment();
    }

    private void initContainer() {
        container = (ConstraintLayout) findViewById(R.id.container_fragment);
    }

    private void initFragment() {
        fragment = getSupportFragmentManager().findFragmentById(R.id.container_fragment);
        if (fragment == null) {
            ActivityUtils.setFragment(getSupportFragmentManager(), FragmentRecycler.newInstance(), R.id.container_fragment);
        }
    }


    @Override
    public void implicitItemClick(int id) {
        ActivityForImplicitIntent.Intent(this,id);
    }

    @Override
    public void explicitItemClick(int id) {
        ActivityForExplicitIntent.Intent(this, id);
    }
}
