package com.example.ecommerceshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ecommerceshop.Admin.AdminAddNewProductActivity;

public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView tshirt, sshirt, wdresses, sweater;
    private ImageView glasses, bags, caps, trainers;
    private ImageView web, laptop, watch, mobilephone;

    private Button LogoutBtn, CheckOrdersBtn, maintainProductsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        LogoutBtn = (Button)findViewById(R.id.admin_logout_btn);
        CheckOrdersBtn = (Button)findViewById(R.id.check_orders_btn);

        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        CheckOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminNewOrdersActivity.class);
                startActivity(intent);
                finish();
            }
        });


        tshirt = (ImageView) findViewById(R.id.tshirt);
        sshirt = (ImageView) findViewById(R.id.sshirt);
        wdresses = (ImageView) findViewById(R.id.wdresses);
        sweater = (ImageView) findViewById(R.id.sweater);

        glasses = (ImageView) findViewById(R.id.glasses);
        bags = (ImageView) findViewById(R.id.bags);
        caps = (ImageView) findViewById(R.id.caps);
        trainers = (ImageView) findViewById(R.id.trainers);

        web = (ImageView) findViewById(R.id.web);
        laptop = (ImageView) findViewById(R.id.laptop);
        watch = (ImageView) findViewById(R.id.watch);
        mobilephone = (ImageView) findViewById(R.id.mobilephone);

        LogoutBtn = (Button) findViewById(R.id.admin_logout_btn);
        CheckOrdersBtn = (Button) findViewById(R.id.check_orders_btn);
        maintainProductsBtn = (Button) findViewById(R.id.maintain_btn);


        maintainProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, HomeActivity.class);
               // intent.putExtra("category", "tShoes1");
                intent.putExtra("Admin", "Admin");
                startActivity(intent);
            }
        });
           /*  maintainProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });*/
        tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "tShoes1");
                startActivity(intent);
            }
        });
        tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "tShoes1");
                startActivity(intent);
            }
        });




        tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "tShoes1");
                startActivity(intent);
            }
        });

        sshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "sshirt");
                startActivity(intent);
            }
        });


        sweater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "sweater");
                startActivity(intent);
            }
        });


        wdresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "wdresses");
                startActivity(intent);
            }
        });


        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "glasses");
                startActivity(intent);
            }
        });

        bags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "bags");
                startActivity(intent);
            }
        });

        caps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "caps");
                startActivity(intent);
            }
        });


        trainers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "trainers");
                startActivity(intent);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "web");
                startActivity(intent);
            }
        });


        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "laptop");
                startActivity(intent);
            }
        });


        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "watch");
                startActivity(intent);
            }
        });


        mobilephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "mobilephone");
                startActivity(intent);
            }
        });


    }
}
