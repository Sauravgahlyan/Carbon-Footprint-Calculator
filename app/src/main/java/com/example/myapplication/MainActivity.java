package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button Submit = findViewById(R.id.Submit);
        TextView gas = findViewById(R.id.gas);
        TextView number = findViewById(R.id.number);
        TextView electric = findViewById(R.id.electric);
        TextView totalFootprintView = findViewById(R.id.totalFootprint);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
double gasValue = Double.parseDouble(gas.getText().toString());
double gasFootprint = gasValue *5.40;


double numberValue = Double.parseDouble(number.getText().toString());
                double numberFootprint = numberValue *59.52;
double electricValue = Double.parseDouble(electric.getText().toString());
double electricFootprint = (electricValue/16.63)*0.992;
double totalFootprint = gasFootprint + numberFootprint + electricFootprint;
totalFootprintView.setText(String.format("Total footprint genrated by you in a month approx is %.2f", totalFootprint));






            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}