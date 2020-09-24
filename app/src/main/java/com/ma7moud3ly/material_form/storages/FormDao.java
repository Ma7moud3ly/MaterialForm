package com.ma7moud3ly.material_form.storages;

import android.database.Cursor;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


/**
 * Data access object for Students.
 */
@Dao
public interface FormDao {


    @Query("SELECT COUNT(*) FROM " + Form.TABLE_NAME)
    int count();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Form row);

    @Insert
    long[] insertAll(Form[] rows);

    @Query("SELECT * FROM " + Form.TABLE_NAME)
    Cursor selectAll();

    @Query("DELETE FROM " + Form.TABLE_NAME)
    int deleteAll();


    //@Query("SELECT * FROM " + FavBooks.TABLE_NAME + " ORDER BY " + FavBooks.COLUMN1 + " DESC")
    @Query("SELECT * FROM " + Form.TABLE_NAME)
    LiveData<List<Form>> getAll();

    @Update
    int update(Form row);


}