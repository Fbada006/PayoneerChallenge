package com.payoneer.payoneerchallenge.utils;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.bumptech.glide.Glide;
import com.payoneer.payoneerchallenge.R;
import com.payoneer.payoneerchallenge.models.ApplicableItem;
import com.payoneer.payoneerchallenge.models.Product;

public class AdapterUtils {

    public static final DiffUtil.ItemCallback<ApplicableItem> APPLICABLE_ITEM_ITEM_CALLBACK =
            new DiffUtil.ItemCallback<ApplicableItem>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull ApplicableItem oldItem, @NonNull ApplicableItem newItem) {
                    return oldItem.getCode().equals(newItem.getCode());
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull ApplicableItem oldItem, @NonNull ApplicableItem newItem) {
                    return oldItem.equals(newItem);
                }
            };

    public static final DiffUtil.ItemCallback<Product> PRODUCT_ITEM_CALLBACK =
            new DiffUtil.ItemCallback<Product>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull Product oldItem, @NonNull Product newItem) {
                    return oldItem.getCode().equals(newItem.getCode());
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull Product oldItem, @NonNull Product newItem) {
                    return oldItem.equals(newItem);
                }
            };
    
    public static void loadLogo(String imageUrl, ImageView imagePaymentLogo) {
        Glide.with(imagePaymentLogo)
                .load(imageUrl)
                .placeholder(R.drawable.loading_placeholder)
                .error(R.drawable.ic_error)
                .into(imagePaymentLogo);
    }
}
