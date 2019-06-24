package com.example.demodecontentprovider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    Estudiante estudiante;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(FirebaseReference.Estudiante_Reference);
        //Log.i("Key",myRef.getKey() );

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String Nombre = dataSnapshot.child("User").getValue().toString();
                //Log.i("Nombre", Nombre+"");
                String Carrera = dataSnapshot.child("Carrera").getValue().toString();
                //Log.i("Carrera", Carrera+"");

                estudiante = new Estudiante(Nombre, Carrera);
                //Log.i("Estudiante", estudiante.getNombre() + " "+ estudiante.getCarrera());

                pantalla(estudiante);


            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Error", databaseError.getMessage());
            }
        });
    }
        public void pantalla(Estudiante estu){
            TextView textView = findViewById(R.id.textView);
            Log.i("Estudiante", estu.getNombre() + " "+ estu.getCarrera());
            textView.setText("Hola " + estu.getNombre() + " estudiante de la carrera de " + estu.getCarrera() );
        }







}
