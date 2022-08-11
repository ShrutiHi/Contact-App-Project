package com.example.contactappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddContact extends AppCompatActivity {
    EditText etName, etLocation, etWebsite, etContact;
    ImageView ivHappy, ivSad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        etName = findViewById(R.id.etName);
        etContact = findViewById(R.id.etContact);
        etWebsite = findViewById(R.id.etWebsite);
        etLocation = findViewById(R.id.etLocation);
        ivHappy = findViewById(R.id.ivHappy);
        ivSad = findViewById(R.id.ivSad);

        ivHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().isEmpty() || etContact.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty() || etWebsite.getText().toString().isEmpty()){
                    Toast.makeText(AddContact.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(AddContact.this, com.example.contactappproject.MainActivity.class);
                    intent.putExtra("contact", etContact.getText().toString());
                    intent.putExtra("website", etWebsite.getText().toString());
                    intent.putExtra("location", etLocation.getText().toString());

                    setResult(RESULT_OK, intent);
                    AddContact.this.finish();
                }
            }
        });

        ivSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().isEmpty() || etContact.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty() || etWebsite.getText().toString().isEmpty()){
                    Toast.makeText(AddContact.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(AddContact.this, com.example.contactappproject.MainActivity.class);
                    intent.putExtra("contact", etContact.getText().toString());
                    intent.putExtra("website", etWebsite.getText().toString());
                    intent.putExtra("location", etLocation.getText().toString());

                    setResult(RESULT_CANCELED, intent);
                    AddContact.this.finish();
                }
            }
        });
    }
}