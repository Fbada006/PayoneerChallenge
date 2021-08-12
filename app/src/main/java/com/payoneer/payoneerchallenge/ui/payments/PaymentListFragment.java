package com.payoneer.payoneerchallenge.ui.payments;

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
import com.payoneer.payoneerchallenge.databinding.FragmentPaymentListBinding;
import com.payoneer.payoneerchallenge.models.ApplicableItem;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;

@AndroidEntryPoint
public class PaymentListFragment extends Fragment {

    private PaymentsViewModel paymentsViewModel;
    private FragmentPaymentListBinding binding;
    private PaymentListAdapter paymentListAdapter;

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
        paymentListAdapter = new PaymentListAdapter(this::openPaymentDetailsFragment);
        initRecyclerView();
        observePaymentData();
    }

    private void openPaymentDetailsFragment(ApplicableItem item) {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(
                PaymentListFragmentDirections.actionDestPaymentListFragmentToPaymentDetailsFragment(item)
        );
    }

    private void initRecyclerView() {
        binding.rvPaymentList.setAdapter(paymentListAdapter);
    }

    private void observePaymentData() {
        paymentsViewModel.getPayments().observe(getViewLifecycleOwner(), paymentResource -> {
            switch (paymentResource.status) {
                case SUCCESS:
                    if (paymentResource.data != null) {
                        showData(paymentResource.data.getNetworks().getApplicable());
                    }
                    break;
                case ERROR:
                    showError(getString(R.string.generic_error_message));
                    break;
                case LOADING:
                    showLoading();
                    break;
                case NOT_FOUND:
                    showError(getString(R.string.not_found_error));
                    break;
                case SERVER_ERROR:
                    showError(getString(R.string.server_error));
                    break;
                case N0_CONNECTION:
                    showError(getString(R.string.no_connection_error));
                    break;
                case UNKNOWN_CODE:
                    showError(getString(R.string.unexpected_error));
                    break;
            }
        });
    }

    private void showData(List<ApplicableItem> applicableItemList) {
        binding.tvError.setVisibility(View.GONE);
        binding.progressLoading.setVisibility(View.GONE);
        binding.rvPaymentList.setVisibility(View.VISIBLE);
        paymentListAdapter.submitList(applicableItemList);
    }

    private void showError(String errorMessage) {
        binding.rvPaymentList.setVisibility(View.GONE);
        binding.progressLoading.setVisibility(View.GONE);
        binding.tvError.setVisibility(View.VISIBLE);
        binding.tvError.setText(errorMessage);
    }

    private void showLoading() {
        binding.rvPaymentList.setVisibility(View.GONE);
        binding.tvError.setVisibility(View.GONE);
        binding.progressLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}