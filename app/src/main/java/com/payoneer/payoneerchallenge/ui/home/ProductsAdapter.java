package com.payoneer.payoneerchallenge.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.payoneer.payoneerchallenge.databinding.ProductItemViewBinding;
import com.payoneer.payoneerchallenge.models.Product;
import com.payoneer.payoneerchallenge.utils.AdapterUtils;

public class ProductsAdapter extends ListAdapter<Product, ProductsAdapter.ProductListViewHolder> {

    public ProductsAdapter() {
        super(AdapterUtils.PRODUCT_ITEM_CALLBACK);
    }

    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemViewBinding binding =
                ProductItemViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class ProductListViewHolder extends RecyclerView.ViewHolder {
        private final ProductItemViewBinding binding;

        public ProductListViewHolder(ProductItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Product product) {
            binding.tvProductName.setText(product.getProductName());
            binding.tvProductPrice.setText(product.getProductPrice());
        }
    }
}

