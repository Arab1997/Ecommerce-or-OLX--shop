package com.example.ecommerceshop.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceshop.Interface.ItemClickListner;
import com.example.ecommerceshop.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

  public TextView txtProductName, txtProductDescription, txtProductPrice;
  public ImageView imageView;
  public ItemClickListner listner;

  public ProductViewHolder(@NonNull View itemView) {
    super(itemView);

    imageView = (ImageView) itemView.findViewById(R.id.product_image);
    txtProductName = (TextView) itemView.findViewById(R.id.product_name);
    txtProductDescription = (TextView) itemView.findViewById(R.id.product_description);
    txtProductPrice = (TextView) itemView.findViewById(R.id.product_price);
  }
  public void setItemClickListener(ItemClickListner listener){
    this.listner = listener;
  }

  @Override
  public void onClick(View view) {
    listner.onClick(view, getAdapterPosition(), false);
  }
}
