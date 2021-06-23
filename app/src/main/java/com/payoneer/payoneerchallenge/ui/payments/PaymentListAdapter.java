package com.payoneer.payoneerchallenge.ui.payments;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.payoneer.payoneerchallenge.databinding.ItemPaymentMethodBinding;
import com.payoneer.payoneerchallenge.models.ApplicableItem;
import com.payoneer.payoneerchallenge.utils.AdapterUtils;

public class PaymentListAdapter extends ListAdapter<ApplicableItem, PaymentListAdapter.PaymentListViewHolder> {

    public PaymentListAdapter() {
        super(AdapterUtils.APPLICABLE_ITEM_ITEM_CALLBACK);
    }

    @NonNull
    @Override
    public PaymentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPaymentMethodBinding binding =
                ItemPaymentMethodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PaymentListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentListViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class PaymentListViewHolder extends RecyclerView.ViewHolder {
        private final ItemPaymentMethodBinding binding;

        public PaymentListViewHolder(ItemPaymentMethodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ApplicableItem applicableItem) {
            binding.tvPaymentName.setText(applicableItem.getLabel());
            AdapterUtils.loadLogo(applicableItem.getLinks().getLogo(), binding.imagePaymentLogo);
        }
    }
}
