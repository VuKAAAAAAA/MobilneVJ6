package com.example.firebasejetpack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private String userId;
    EditText editIme, editGodina, editPredmet;
    DatabaseReference reference;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editIme = findViewById(R.id.editTest11);
        editGodina = findViewById(R.id.editText33);
        editPredmet = findViewById(R.id.editText22);
        saveButton = findViewById(R.id.editButton);

        Toast.makeText(this, "User ID:  " + userId, Toast.LENGTH_SHORT).show();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child(userId).child("predavac").setValue(editIme.getText().toString());
                reference.child(userId).child("godina").setValue(Integer.parseInt(editGodina.getText().toString()));
                reference.child(userId).child("ime").setValue(editPredmet.getText().toString());


            }
        });


        userId = getIntent().getExtras().get("id").toString();
        reference = FirebaseDatabase.getInstance().getReference().child("predmeti");


        reference.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String nastavnik = snapshot.child("predavac").getValue().toString();
                    String godina = snapshot.child("godina").getValue().toString();
                    String ime = snapshot.child("ime").getValue().toString();

                    editIme.setText(nastavnik);
                    editGodina.setText(godina);
                    editPredmet.setText(ime);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}