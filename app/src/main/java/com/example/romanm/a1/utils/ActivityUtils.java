package com.example.romanm.a1.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by RomanM on 14.10.2017.
 */

public class ActivityUtils {
    public static void setFragment(FragmentManager fragmentManager, Fragment fragment, int idContainer) {
        fragmentManager
                .beginTransaction()
                .replace(idContainer, fragment)
                .commit();
    }

    public static void setFragmentWithBack(FragmentManager fragmentManager, Fragment fragment, int idContainer) {
        fragmentManager
                .beginTransaction()
                .replace(idContainer, fragment)
                .addToBackStack("fragment")
                .commit();
    }
}
