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
import timber.log.Timber;

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
                    Timber.e("We have data %s", paymentResource.data.toString());
                    StringBuilder builder = new StringBuilder();
                    paymentResource.data.getNetworks().getApplicable().forEach(applicableItem -> {
                        builder.append(applicableItem.getCode());
                        builder.append("\n");
                    });
                    binding.simpleText.setText(builder.toString());
                    break;
                case ERROR:
                    Timber.e("Generic error received %s", paymentResource.message);
                    break;
                case LOADING:
                    Timber.e("Loading");
                    break;
                case NOT_FOUND:
                    Timber.e("Not found");
                    break;
                case SERVER_ERROR:
                    Timber.e("Server error");
                    break;
                case N0_CONNECTION:
                    Timber.e("Pos6sibly no connection");
                    break;
                case UNKNOWN_CODE:
                    Timber.e("Unknown code ");
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