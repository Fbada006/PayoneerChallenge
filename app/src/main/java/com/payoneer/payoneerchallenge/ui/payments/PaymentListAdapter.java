package com.payoneer.payoneerchallenge.ui.payments;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.payoneer.payoneerchallenge.R;
import com.payoneer.payoneerchallenge.databinding.ItemPaymentMethodBinding;
import com.payoneer.payoneerchallenge.network.models.ApplicableItem;

public class PaymentListAdapter extends ListAdapter<ApplicableItem, PaymentListAdapter.PaymentListViewHolder> {

    public static final DiffUtil.ItemCallback<ApplicableItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ApplicableItem>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull ApplicableItem oldUser, @NonNull ApplicableItem newUser) {
                    return oldUser.getCode().equals(newUser.getCode());
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull ApplicableItem oldUser, @NonNull ApplicableItem newUser) {
                    return oldUser.equals(newUser);
                }
            };

    public PaymentListAdapter() {
        super(DIFF_CALLBACK);
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
            loadLogo(applicableItem.getLinks().getLogo());
        }

        private void loadLogo(String imageUrl) {
            Glide.with(binding.imagePaymentLogo)
                    .load(imageUrl)
                    .placeholder(R.drawable.loading_placeholder)
                    .error(R.drawable.ic_error)
                    .into(binding.imagePaymentLogo);
        }
    }
}
