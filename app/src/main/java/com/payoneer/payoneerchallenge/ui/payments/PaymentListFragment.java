package com.payoneer.payoneerchallenge.ui.payments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.payoneer.payoneerchallenge.R;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PaymentListFragment extends Fragment {

    public PaymentListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_list, container, false);
    }
}