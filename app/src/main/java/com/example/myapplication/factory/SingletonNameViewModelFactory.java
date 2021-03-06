package com.example.myapplication.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.models.AddAddressActivityViewModel;
import com.example.myapplication.models.AddressAndCitiesActivityViewModel;
import com.example.myapplication.models.MapsActivityViewModel;
import com.example.myapplication.repository.DataRepository;

public class SingletonNameViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    //TODO dagger (DI)
    private DataRepository dataRepository = new DataRepository();

    AddressAndCitiesActivityViewModel t;

    public SingletonNameViewModelFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        modelClass.isAssignableFrom(AddressAndCitiesActivityViewModel.class);

        if (modelClass == AddressAndCitiesActivityViewModel.class) {
            return (T) new AddressAndCitiesActivityViewModel(dataRepository);
        }
        else if(modelClass== MapsActivityViewModel.class) {
            return (T) new MapsActivityViewModel();
        }

        else if(modelClass== AddAddressActivityViewModel.class){
            return (T) new AddAddressActivityViewModel();
        }
        return null;
    }


}
