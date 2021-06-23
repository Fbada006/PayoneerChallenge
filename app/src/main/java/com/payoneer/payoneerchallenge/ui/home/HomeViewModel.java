package com.payoneer.payoneerchallenge.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.payoneer.payoneerchallenge.models.Product;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/**
 * This class serves no major purpose really beyond simulating some kind of "db"
 * behavior.
 */
@HiltViewModel
public class HomeViewModel extends ViewModel {

    private final MutableLiveData<List<Product>> productsLiveData = new MutableLiveData<>();
    private final Set<Product> products = new HashSet<>();

    @Inject
    public HomeViewModel() {
        productsLiveData.setValue(new ArrayList<>(products));
    }

    public void addProductToFakeDb(Product product) {
        products.add(product);
        productsLiveData.setValue(new ArrayList<>(products));
    }

    public void removeProductFromFakeDb(Product product) {
        products.remove(product);
        productsLiveData.setValue(new ArrayList<>(products));
    }

    public LiveData<List<Product>> getProductsLiveData() {
        return productsLiveData;
    }
}
