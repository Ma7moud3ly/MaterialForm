package com.ma7moud3ly.material_form.storages;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = Form.TABLE_NAME)
public class Form {

    public static final String DB_NAME = "form_db";

    public static final String TABLE_NAME = "user_info";

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public long _id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "age")
    public int age;
    @ColumnInfo(name = "male")
    public boolean isMale;
    @ColumnInfo(name = "job")
    public String job;

    public Form(String name, String job, int age, boolean isMale) {
        this.name = name;
        this.job = job;
        this.age = age;
        this.isMale = isMale;
    }

}