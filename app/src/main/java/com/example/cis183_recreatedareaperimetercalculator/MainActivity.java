package com.example.cis183_recreatedareaperimetercalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_j_circlego;
    Button btn_j_trianglego;
    Button btn_j_squarego;
    Button btn_j_rectanglego;

    Spinner spn_j_shapes;

    SpinnerAdapter spinnerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        String[] shapes = new String[]{"Square", "Rectangle", "Circle", "Triangle"};
        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, shapes);
        spn_j_shapes.setAdapter(spinnerAdapter);

        btn_j_circlego = findViewById(R.id.btn_v_circlego);
        btn_j_rectanglego = findViewById(R.id.btn_v_rectanglego);
        btn_j_squarego = findViewById(R.id.btn_v_squarego);
        btn_j_trianglego = findViewById(R.id.btn_v_trianglego);

        spinnerChangeListener();
    }

    public void spinnerChangeListener()
    {
        spn_j_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    //Square
                    showButton(btn_j_squarego);
                    //not showing for circle and triangle
                    hideButton(btn_j_rectanglego);
                    hideButton(btn_j_circlego);
                    hideButton(btn_j_trianglego);

                }
                else if (position == 1)
                {
                    //Rectangle
                    showButton(btn_j_rectanglego);
                    //not showing for circle and triangle
                    hideButton(btn_j_circlego);
                    hideButton(btn_j_trianglego);
                    hideButton(btn_j_squarego);


                }
                else if (position == 2)
                {
                    //Circle
                    showButton(btn_j_circlego);

                    //not showing for triangle or rectangle
                    hideButton(btn_j_rectanglego);
                    hideButton(btn_j_trianglego);
                    hideButton(btn_j_squarego);

                }
                else if (position == 3)
                {
                    //Triangle
                    showButton(btn_j_trianglego);
                    //not showing for circle or rectangle
                    hideButton(btn_j_rectanglego);
                    hideButton(btn_j_circlego);
                    hideButton(btn_j_squarego);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void showButton(Button btn)
    {
        btn.setVisibility(View.VISIBLE);
    }

    public void hideButton(Button btn)
    {
        btn.setVisibility(View.INVISIBLE);
    }


}