package com.payoneer.payoneerchallenge.ui.payments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.payoneer.payoneerchallenge.databinding.FragmentPaymentListBinding;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PaymentListFragment extends Fragment {

    private PaymentsViewModel paymentsViewModel;
    private FragmentPaymentListBinding binding;

    public PaymentListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPaymentListBinding.inflate(getLayoutInflater(), container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        paymentsViewModel = new ViewModelProvider(this).get(PaymentsViewModel.class);
        observePaymentData();
    }

    private void observePaymentData() {
        paymentsViewModel.getPayments().observe(getViewLifecycleOwner(), paymentResource -> {
            switch (paymentResource.status) {
                case SUCCESS:
                    break;
                case ERROR:
                    break;
                case LOADING:
                    break;
                case NOT_FOUND:
                    break;
                case SERVER_ERROR:
                    break;
                case N0_CONNECTION:
                    break;
                case UNKNOWN_CODE:
                    break;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}