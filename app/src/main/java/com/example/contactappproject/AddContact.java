package com.example.contactappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddContact extends AppCompatActivity implements View.OnClickListener{
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

        ivHappy.setOnClickListener(this);
        ivSad.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(etName.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty() ||
                etWebsite.getText().toString().isEmpty() || etContact.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        else{
            if(etContact.getText().toString().trim().length()!=10){
                Toast.makeText(this, "Please enter valid contact", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent();
                intent.putExtra("name", etName.getText().toString().trim());
                intent.putExtra("contact", etContact.getText().toString().trim());
                intent.putExtra("website", etWebsite.getText().toString().trim());
                intent.putExtra("location", etLocation.getText().toString().trim());


                if (view.getId() == R.id.ivHappy) {
                    intent.putExtra("mood", "happy");
                } else {
                    intent.putExtra("mood", "sad");
                }

                setResult(RESULT_OK, intent);
                AddContact.this.finish();
            }
        }
    }
}