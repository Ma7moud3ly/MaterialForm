/*
* MADARSOFT job TASK
* By:Mahmoud Aly
* engma7moud3ly@gmail.com
* */

package com.ma7moud3ly.material_form.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ma7moud3ly.material_form.MainActivity;
import com.ma7moud3ly.material_form.databinding.FragmentFormBinding;
import com.ma7moud3ly.material_form.models.FormObserver;
import com.ma7moud3ly.material_form.models.FormViewModel;
import com.ma7moud3ly.material_form.storages.Form;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FormFragment extends Fragment {

    private FragmentFormBinding binding;
    private FormViewModel model;
    private FormObserver observer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater, container, false);
        //attach FormViewModel to observe database changes
        model = new ViewModelProvider(this, ViewModelProvider.
                AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(FormViewModel.class);
        //pass observable object to the view to observe the input changes
        observer = new FormObserver();
        binding.setObserver(observer);
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
                observer.setForm(userInfo);
            }
        });
        //when user click save ,store data to the database and navigate to info fragment
        binding.save.setOnClickListener(v -> {
            model.saveToDatabase(observer.toForm());
            ((MainActivity) getActivity()).navigateTo(new InfoFragment(), null, false);
            Toast.makeText(getContext(), "user info saved..", Toast.LENGTH_SHORT).show();
        });
    }
}