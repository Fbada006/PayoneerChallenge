package com.payoneer.payoneerchallenge.ui.home;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import com.jraska.livedata.TestObserver;
import com.payoneer.payoneerchallenge.models.Product;
import com.payoneer.payoneerchallenge.utils.FakeProductsGenerator;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;

public class HomeViewModelTest {

    private final HomeViewModel homeViewModel = new HomeViewModel();
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void insertDataShouldReturnCorrectValues() throws InterruptedException {
        homeViewModel.addProductToFakeDb(FakeProductsGenerator.generateFakeProducts().get(0));
        LiveData<List<Product>> productsLiveData = homeViewModel.getProductsLiveData();
        TestObserver.test(productsLiveData)
                .awaitValue()
                .assertHasValue()
                .assertValue(value -> value.size() == 1)
                .assertValue(value -> value.get(0).getId() == 1);
    }

    @Test
    public void removeDataShouldReturnCorrectValues() throws InterruptedException {
        homeViewModel.addProductToFakeDb(FakeProductsGenerator.generateFakeProducts().get(0));
        homeViewModel.addProductToFakeDb(FakeProductsGenerator.generateFakeProducts().get(1));
        homeViewModel.addProductToFakeDb(FakeProductsGenerator.generateFakeProducts().get(2));
        homeViewModel.removeProductFromFakeDb(FakeProductsGenerator.generateFakeProducts().get(0));

        LiveData<List<Product>> productsLiveData = homeViewModel.getProductsLiveData();
        TestObserver.test(productsLiveData)
                .awaitValue()
                .assertHasValue()
                .assertValue(value -> value.size() == 2)
                .assertValue(value -> {
                    Product product = value.get(1);
                    return product.getId() == 2;
                });
    }
}