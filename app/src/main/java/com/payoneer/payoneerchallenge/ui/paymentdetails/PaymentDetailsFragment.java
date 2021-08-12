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
import com.payoneer.payoneerchallenge.databinding.FragmentPaymentDetailsBinding;
import com.payoneer.payoneerchallenge.models.ApplicableItem;
import com.payoneer.payoneerchallenge.models.InputElementsItem;

public class PaymentDetailsFragment extends Fragment {

    private ApplicableItem item;
    private FragmentPaymentDetailsBinding binding;

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
        super.onViewCreated(view, savedInstanceState);
        item = PaymentDetailsFragmentArgs.fromBundle(getArguments()).getApplicableitem();
        populateLayout(item);
    }

    private void populateLayout(ApplicableItem item) {
        for (InputElementsItem inputElementsItem : item.getInputElements()) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            EditText edittTxt = new EditText(requireContext());
            edittTxt.setHint(inputElementsItem.getName());
            edittTxt.setLayoutParams(params);
            edittTxt.setInputType(InputType.TYPE_CLASS_TEXT);
            edittTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            binding.layoutPaymentDetails.addView(edittTxt);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
