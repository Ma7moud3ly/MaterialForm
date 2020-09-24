package com.ma7moud3ly.material_form;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

/**
 * A host (typically an {@code Activity}} that can display fragments and knows how to respond to
 * navigation events.
 */
public interface NavigationHost {
    void navigateTo(Fragment fragment, Bundle bundle, boolean addToBackstack);
}
