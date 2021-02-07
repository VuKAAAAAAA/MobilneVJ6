package com.example.firebasejetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    myAdapter adapter;

    private FirebaseDatabase bazaPodataka;
    private FirebaseAuth autentifikacija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bazaPodataka = FirebaseDatabase.getInstance();
        autentifikacija = FirebaseAuth.getInstance();

        FirebaseRecyclerOptions<Predavanje> options =
                new FirebaseRecyclerOptions.Builder<Predavanje>().setQuery(FirebaseDatabase.getInstance().getReference().child("predmeti"), Predavanje.class).build();

        adapter=new myAdapter(options);
        recyclerView.setAdapter(adapter);

        Button logout = (Button) findViewById(R.id.button3);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autentifikacija.signOut();
                finish();
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
