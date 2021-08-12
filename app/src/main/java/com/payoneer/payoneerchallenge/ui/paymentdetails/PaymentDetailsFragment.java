package com.payoneer.payoneerchallenge.ui.paymentdetails;

import android.os.Bundle;
import android.text.InputFilter;
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
import com.payoneer.payoneerchallenge.R;
import com.payoneer.payoneerchallenge.models.ApplicableItem;
import com.payoneer.payoneerchallenge.models.InputElementsItem;

public class PaymentDetailsFragment extends Fragment {

    private ApplicableItem item;
    private LinearLayout linearLayoutparent;

    public PaymentDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayoutparent = view.findViewById(R.id.layout_payment_details);
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
            linearLayoutparent.addView(edittTxt);
        }
    }
}
