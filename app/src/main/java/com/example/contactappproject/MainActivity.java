package com.example.contactappproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvAppName;
    ImageView ivResult, ivCallIcon, ivMapIcon, ivWebIcon;
    Button btnAddContact;

    String location, contact, website, mood;
    final int ADD_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAppName = findViewById(R.id.tvAppName);
        ivResult = findViewById(R.id.ivResult);
        ivCallIcon = findViewById(R.id.ivCallIcon);
        ivMapIcon = findViewById(R.id.ivMapIcon);
        ivWebIcon = findViewById(R.id.ivWebIcon);
        btnAddContact = findViewById(R.id.btnAddContact);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddContact.class);
                startActivityForResult(intent, ADD_CONTACT);
            }
        });

        ivCallIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(contact!=null) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+contact));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "No Contact Available", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ivMapIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(location!=null){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+location));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "No Location Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ivWebIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(website!=null){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + website));
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_CONTACT){
            if(resultCode == RESULT_OK) {
                ivCallIcon.setVisibility(View.VISIBLE);
                ivWebIcon.setVisibility(View.VISIBLE);
                ivMapIcon.setVisibility(View.VISIBLE);
                ivResult.setVisibility(View.VISIBLE);

                contact = data.getStringExtra("contact");
                location = data.getStringExtra("location");
                website = data.getStringExtra("website");
                mood = data.getStringExtra("mood");

                if(mood.equals("happy")){
                    ivResult.setImageResource(R.drawable.happy);
                }
                else{
                    ivResult.setImageResource(R.drawable.sad);
                }
            }
            else{
                Toast.makeText(this, "No data received!", Toast.LENGTH_SHORT).show();
            }
        }
    }


}