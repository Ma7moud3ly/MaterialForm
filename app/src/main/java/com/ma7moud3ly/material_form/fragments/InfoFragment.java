package com.ma7moud3ly.material_form.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ma7moud3ly.material_form.MainActivity;
import com.ma7moud3ly.material_form.databinding.FragmentInfoBinding;
import com.ma7moud3ly.material_form.models.FormViewModel;
import com.ma7moud3ly.material_form.storages.Form;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class InfoFragment extends Fragment {

    private FragmentInfoBinding binding;
    private FormViewModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentInfoBinding.inflate(inflater, container, false);
        //attach FormViewModel to observe database changes
        model = new ViewModelProvider(this, ViewModelProvider.
                AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(FormViewModel.class);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //observe fetched data from database to update the from with user info
        model.userInfo.observe(getViewLifecycleOwner(), list -> {
            if (list != null && list.size() > 0) {
                Form userInfo = list.get(0);
                binding.setForm(userInfo);
            } else {
                //if user has never saved info,the navigate to form fragment
                navigateToForm();
            }
        });

        //listen to edit info button
        binding.edit.setOnClickListener(v -> navigateToForm());
    }

    private void navigateToForm() {
        ((MainActivity) getActivity()).navigateTo(new FormFragment(), null, false);
    }
}