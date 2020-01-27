package com.example.ecommerceshop.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceshop.Interface.ItemClickListner;
import com.example.ecommerceshop.R;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
  public TextView textProductName, textProductPrice, textProductQuantity;
  private ItemClickListner itemClickListner;

  public CartViewHolder(View itemView){
    super(itemView);

    textProductName = itemView.findViewById(R.id.cart_product_name);
    textProductPrice = itemView.findViewById(R.id.cart_product_price);
    textProductQuantity = itemView.findViewById(R.id.cart_product_quantity);
  }
  @Override
  public void onClick(View view) {
    itemClickListner.onClick(view, getAdapterPosition(), false);
  }

  public void setItemClickListner(ItemClickListner itemClickListner){

    this.itemClickListner = itemClickListner;
  }
}
