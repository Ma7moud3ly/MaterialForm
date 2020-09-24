/*
 * Material Form
 * By:Mahmoud Aly
 * engma7moud3ly@gmail.com
 */
package com.ma7moud3ly.material_form.models;

import android.app.Application;

import com.ma7moud3ly.material_form.storages.Form;
import com.ma7moud3ly.material_form.storages.FormRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class FormViewModel extends AndroidViewModel {
    private FormRepository repo;
    public LiveData<List<Form>> userInfo;

    public FormViewModel(Application app) {
        super(app);
        this.repo = new FormRepository(app);
        userInfo = repo.getAll();
    }

    public void saveToDatabase(Form form) {
        repo.clearAndInsert(form);
    }

}
