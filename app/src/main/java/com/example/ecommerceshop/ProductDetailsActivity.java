package com.example.ecommerceshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.ecommerceshop.Model.Products;
import com.example.ecommerceshop.Prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.FloatingActionButton;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.SimpleTimeZone;

public class ProductDetailsActivity extends AppCompatActivity {

    //  private FloatingActionButton addToCartBtn;
    private Button addToCartButton;
    private ImageView productImage;
    private ElegantNumberButton numberButton;
    private android.widget.TextView productPrice, productDescription, productName;
    private String productID = "", state = "Normal";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        addToCartButton = (Button) findViewById(R.id.pd_add_to_cart_button);

        productID = getIntent().getStringExtra("pid");

        numberButton = (ElegantNumberButton) findViewById(R.id.number_btn);
        productImage = (ImageView) findViewById(R.id.product_image_details);
        productName = (android.widget.TextView) findViewById(R.id.product_name_details);
        productDescription = (TextView) findViewById(R.id.product_description_details);
        productPrice = (TextView) findViewById(R.id.product_price_details);
        getProductDetails(productID);


        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addingToCartList();

                if (state.equals("Order Placed") || state.equals("Order Shipped")){
                    Toast.makeText(ProductDetailsActivity.this, "you can add purchase more products, once your order is shipped  or confirmed", Toast.LENGTH_LONG).show();
                }else
                {
                    addingToCartList();
                }

            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        CheckOrderState();
    }

    private void addingToCartList() {
        String saveCurrentTime, saveCurrentDate;

        Calendar calFordate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyyy");
        saveCurrentDate = currentDate.format(calFordate.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calFordate.getTime());

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart List");
        final HashMap<String, Object> cartMap = new HashMap<>();

        cartMap.put("pid", productID);
        cartMap.put("pname", productName.getText().toString());
        cartMap.put("price", productPrice.getText().toString());
        cartMap.put("time", saveCurrentTime);
        cartMap.put("date", saveCurrentDate);
        cartMap.put("quantity", numberButton.getNumber());
        cartMap.put("discount", "");

        cartListRef.child("User View").child(Prevalent.currentOnlineUser.getPhone())
                .child("Products").child(productID)
                .updateChildren(cartMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            cartListRef.child("Admin View").child(Prevalent.currentOnlineUser.getPhone())
                                    .child("Products").child(productID)
                                    .updateChildren(cartMap)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful())
                                            {
                                                Toast.makeText(ProductDetailsActivity.this, "Added to Cart List.", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(ProductDetailsActivity.this, HomeActivity.class);
                                                startActivity(intent);
                                            }
                                        }
                                    });
                        }
                    }
                });


    }

    private void getProductDetails(final String productID) {

        DatabaseReference productRef = FirebaseDatabase.getInstance().getReference().child("Products");
        productRef.child(productID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Products products = dataSnapshot.getValue(Products.class);

                    productName.setText(products.getPname());
                    productPrice.setText(products.getPrice());
                    productDescription.setText(products.getDescription());

                    Picasso.get().load(products.getImage()).into(productImage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void CheckOrderState() {
        DatabaseReference ordersRef;
        ordersRef = FirebaseDatabase.getInstance().getReference().child("Order").child(Prevalent.currentOnlineUser.getPhone());

        ordersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String shippingState = dataSnapshot.child("state").getValue().toString();


                    if (shippingState.equals("shipped")) {
                        state = "Order Shipped";

                        }
                    else if (shippingState.equals("not shipped")) {
                        state = "Order Shipped";
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
