package com.example.ocpizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.ocpizza.model.DeliveryMan;
import com.example.ocpizza.model.Manager;
import com.example.ocpizza.model.Pizzaiolo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Manager manager = new Manager();
        Pizzaiolo pizzaiolo = new Pizzaiolo();
        DeliveryMan deliveryMan = new DeliveryMan();

        Log.d("POSITION", "onCreate: " + manager.getPosition() + "/" + pizzaiolo.getPosition() + "/" + deliveryMan.getPosition());

    }
}