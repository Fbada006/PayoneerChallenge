package com.payoneer.payoneerchallenge.ui.paymentdetails;

import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.payoneer.payoneerchallenge.databinding.FragmentPaymentDetailsBinding;
import com.payoneer.payoneerchallenge.models.ApplicableItem;
import com.payoneer.payoneerchallenge.models.InputElementsItem;
import com.payoneer.payoneerchallenge.ui.payments.PaymentsViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

@AndroidEntryPoint
public class PaymentDetailsFragment extends Fragment {

    private PaymentsViewModel paymentsViewModel;
    private ApplicableItem item;
    private FragmentPaymentDetailsBinding binding;
    private List<EditText> displayedPaymentFields = new ArrayList<>();

    public PaymentDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPaymentDetailsBinding.inflate(getLayoutInflater(), container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        paymentsViewModel = new ViewModelProvider(this).get(PaymentsViewModel.class);
        item = PaymentDetailsFragmentArgs.fromBundle(getArguments()).getApplicableitem();
        populateLayout(item);
        initListeners();
    }

    private void initListeners() {
        binding.buttonSubmitPayment.setOnClickListener(v -> {
            try {
                postPaymentDetails();
            } catch (JSONException e) {
                Timber.e(e);
                e.printStackTrace();
            }
        });
    }

    private void postPaymentDetails() throws JSONException {
        String paymentsJson = generatePaymentsJson();
        paymentsViewModel.postPaymentJson(item.getLinks().getOperation(),
                paymentsJson).observe(getViewLifecycleOwner(), postPaymentResponseResource -> {
            Timber.d(postPaymentResponseResource.status.toString());
        });
    }

    private String generatePaymentsJson() throws JSONException {
        JSONObject paymentsJson = new JSONObject();
        for (EditText editText : displayedPaymentFields) {
            String currentText = editText.getText().toString();
            if (!currentText.isEmpty()) {
                paymentsJson.putOpt(editText.getHint().toString(), currentText);
            }
        }

        return paymentsJson.toString();
    }

    private void populateLayout(ApplicableItem item) {
        for (InputElementsItem inputElementsItem : item.getInputElements()) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            EditText editText = new EditText(requireContext());
            editText.setHint(inputElementsItem.getName());
            editText.setLayoutParams(params);
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
            editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            displayedPaymentFields.add(editText);
            binding.layoutPaymentDetails.addView(editText);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
