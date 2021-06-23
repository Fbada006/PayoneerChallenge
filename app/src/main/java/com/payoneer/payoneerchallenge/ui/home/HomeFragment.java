package com.payoneer.payoneerchallenge.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import com.payoneer.payoneerchallenge.R;
import com.payoneer.payoneerchallenge.databinding.FragmentHomeBinding;
import com.payoneer.payoneerchallenge.models.Product;
import com.payoneer.payoneerchallenge.utils.AdapterUtils.OnProductCheckListener;
import com.payoneer.payoneerchallenge.utils.FakeProductsGenerator;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        displayFakeProductList();
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        observeViewModel();

        binding.buttonCheckout.setOnClickListener(v -> {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(
                    R.id.action_homeFragment_to_paymentListFragment
            );
        });
    }

    private void observeViewModel() {
        homeViewModel.getProductsLiveData().observe(getViewLifecycleOwner(), list -> {
            boolean isEnabled = !(list.size() == 0);
            binding.buttonCheckout.setEnabled(isEnabled);
        });
    }

    private void displayFakeProductList() {
        OnProductCheckListener onProductCheckListener = new OnProductCheckListener() {
            @Override
            public void onItemCheck(Product product) {
                homeViewModel.addProductToFakeDb(product);
            }

            @Override
            public void onItemUncheck(Product product) {
                homeViewModel.removeProductFromFakeDb(product);
            }
        };

        ProductsAdapter adapter = new ProductsAdapter(onProductCheckListener);

        binding.productsRecyclerView.setAdapter(adapter);
        adapter.submitList(FakeProductsGenerator.generateFakeProducts());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}