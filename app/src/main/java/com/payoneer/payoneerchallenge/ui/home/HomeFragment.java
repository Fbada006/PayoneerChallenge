package com.payoneer.payoneerchallenge.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.payoneer.payoneerchallenge.R;
import com.payoneer.payoneerchallenge.databinding.FragmentHomeBinding;
import com.payoneer.payoneerchallenge.utils.FakeProductsGenerator;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

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
        binding.buttonCheckout.setOnClickListener(v -> Navigation.findNavController(view).navigate(
                R.id.action_homeFragment_to_paymentListFragment
        ));
        displayFakeProductList();
    }

    private void displayFakeProductList() {
        ProductsAdapter adapter = new ProductsAdapter();
        binding.productsRecyclerView.setAdapter(adapter);
        adapter.submitList(FakeProductsGenerator.generateFakeProducts());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}