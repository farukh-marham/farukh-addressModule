package com.example.myapplication.Factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Respository.DataRepository;
import com.example.myapplication.ViewModels.MainActivityViewModel;
import com.example.myapplication.ViewModels.MapsActivityViewModel;

public class SingletonNameViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    //TODO dagger (DI)
    private DataRepository dataRepository = new DataRepository();

    MainActivityViewModel t;

    public SingletonNameViewModelFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        modelClass.isAssignableFrom(MainActivityViewModel.class);

        if (modelClass == MainActivityViewModel.class) {
            return (T) new MainActivityViewModel(dataRepository);
        }
        else if(modelClass== MapsActivityViewModel.class) {
            return (T) new MapsActivityViewModel();
        }
        return null;
    }


}
