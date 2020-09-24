package com.ma7moud3ly.material_form.storages;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


public class FormRepository {

    private FormDao dao;
    private LiveData<List<Form>> list;
    private MutableLiveData<Boolean> exists = new MutableLiveData<>();

    public FormRepository(Application application) {
        FormRoomDatabase db = FormRoomDatabase.getDatabase(application);
        dao = db.dao();
        list = dao.getAll();
    }

    public LiveData<List<Form>> getAll() {
        return list;
    }


    public void insert(Form row) {
        FormRoomDatabase.databaseWriteExecutor.execute(() -> {
            dao.insert(row);
        });
    }

    public void clear() {
        FormRoomDatabase.databaseWriteExecutor.execute(() -> {
            dao.deleteAll();
        });
    }

    public void clearAndInsert(Form row) {
        FormRoomDatabase.databaseWriteExecutor.execute(() -> {
            dao.deleteAll();
            dao.insert(row);
        });
    }

    public void update(Form row) {
        FormRoomDatabase.databaseWriteExecutor.execute(() -> {
            dao.update(row);
        });
    }

}
