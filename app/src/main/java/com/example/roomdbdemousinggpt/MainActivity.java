package com.example.roomdbdemousinggpt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// MainActivity.java
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.lifecycle.ViewModelProvider;
// MainActivity.java
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextName = findViewById(R.id.editTextName);
        Button buttonAdd = findViewById(R.id.buttonAdd);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextName.getText().toString().trim();

                if (!userName.isEmpty()) {
                    User user = new User();
                    user.setName(userName);
                    Log.d("sdfghjklkjghfg", "onClick: "+userName);

                    userViewModel.insert(user);

                    editTextName.getText().clear();
                }
            }
        });
    }
}
