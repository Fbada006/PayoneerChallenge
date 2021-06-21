package com.payoneer.payoneerchallenge.utils;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.bumptech.glide.Glide;
import com.payoneer.payoneerchallenge.R;
import com.payoneer.payoneerchallenge.network.models.ApplicableItem;

public class AdapterUtils {

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

    public static void loadLogo(String imageUrl, ImageView imagePaymentLogo) {
        Glide.with(imagePaymentLogo)
                .load(imageUrl)
                .placeholder(R.drawable.loading_placeholder)
                .error(R.drawable.ic_error)
                .into(imagePaymentLogo);
    }
}
