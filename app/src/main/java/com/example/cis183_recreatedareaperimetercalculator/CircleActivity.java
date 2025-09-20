package com.example.cis183_recreatedareaperimetercalculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CircleActivity extends AppCompatActivity {

    Button btn_j_circle_gohome;
    EditText et_j_circle_radius;
    TextView tv_j_circle_computedvalues;
    Intent mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_circle);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainActivity = new Intent(CircleActivity.this, MainActivity.class);
        tv_j_circle_computedvalues = findViewById(R.id.tv_v_circle_computedvalues);
        et_j_circle_radius = findViewById(R.id.et_v_circle_radius);
        btn_j_circle_gohome = findViewById(R.id.btn_v_circle_gohome);

        textChangeListener();
        buttonClickListener();
    }

    public void buttonClickListener()
    {
        btn_j_circle_gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivity);
            }
        });
    }

    public void textChangeListener()
    {
        et_j_circle_radius.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaPerimeter(et_j_circle_radius.getText().toString());
            }
        });
    }

    public void setAreaPerimeter(String radiusS)
    {
        if (radiusS.isEmpty())
        {
            return;
        }

        double pi = Math.PI;
        double radius = Double.parseDouble(radiusS);
        double rSquared = Math.pow(radius, 2);

        double area = pi * rSquared;
        double perimeter = 2 * pi * radius;

        tv_j_circle_computedvalues.setText("Area = " + area + "\nCircumference = " + perimeter);
    }
}