/*
 * MADARSOFT job TASK
 * By:Mahmoud Aly
 * engma7moud3ly@gmail.com
 * */

package com.ma7moud3ly.material_form.models;

import com.ma7moud3ly.material_form.storages.Form;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;

/*
* two way data binding observable to observe the user input
* */

public class FormObserver extends BaseObservable {
    private ObservableField<String> job = new ObservableField<>();
    private ObservableField<String> name = new ObservableField<>();
    private ObservableField<Integer> age = new ObservableField<>();
    private ObservableField<Boolean> isMale = new ObservableField<>();


    public FormObserver() {
        job.set("");
        name.set("");
        age.set(0);
        isMale.set(true);
    }

    //convert form input to form object to store it in room database
    public Form toForm() {
        //Log.i("HINT", job.get() + " : " + name.get() + " : " + age.get() + " : " + isMale.get());
        Form myForm = new Form(name.get(), job.get(), age.get(), isMale.get());
        return myForm;
    }

    //update the form inputs with a form object fetched from the database
    public void setForm(Form userInfo) {
        setJob(userInfo.job);
        setName(userInfo.name);
        setAge(userInfo.age);
        setMale(userInfo.isMale);
    }

    //user job input
    public void setJob(String job) {
        this.job.set(job);
        notifyPropertyChanged(BR.job);
    }

    @Bindable
    public String getJob() {
        return job.get();
    }

    //user name input
    public void setName(String name) {
        this.name.set(name);
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getName() {
        return name.get();
    }

    //user age input
    public void setAge(int age) {
        this.age.set(age);
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public int getAge() {
        return age.get();
    }

    //user gender
    public void setMale(boolean is_male) {
        this.isMale.set(is_male);
        notifyPropertyChanged(BR.male);
    }

    @Bindable
    public boolean getMale() {
        return isMale.get();
    }


}
