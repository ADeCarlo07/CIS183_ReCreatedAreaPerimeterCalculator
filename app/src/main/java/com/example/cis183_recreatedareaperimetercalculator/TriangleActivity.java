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

public class TriangleActivity extends AppCompatActivity {

    Button btn_j_triangle_gohome;
    TextView tv_j_triangle_computedvalues;
    EditText et_j_triangle_sidea;
    EditText et_j_triangle_sideb;
    EditText et_j_triangle_sidec;
    EditText et_j_triangle_height;

    Intent mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_triangle);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        mainActivity = new Intent(TriangleActivity.this, MainActivity.class);
        btn_j_triangle_gohome = findViewById(R.id.btn_v_triangle_gohome);
        tv_j_triangle_computedvalues = findViewById(R.id.et_v_triangle_computedvalues);
        et_j_triangle_height = findViewById(R.id.et_v_triangle_height);
        et_j_triangle_sidea = findViewById(R.id.et_v_triangle_sidea);
        et_j_triangle_sideb = findViewById(R.id.et_v_triangle_sideb);
        et_j_triangle_sidec = findViewById(R.id.et_v_triangle_sidec);

        buttonClickListener();
        textChangeListener();
    }

    public void buttonClickListener()
    {
        btn_j_triangle_gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivity);
            }
        });
    }

    public void textChangeListener()
    {
        et_j_triangle_height.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaPerimeter(et_j_triangle_height.getText().toString(), et_j_triangle_sidea.getText().toString(), et_j_triangle_sideb.getText().toString(), et_j_triangle_sidec.getText().toString());
            }
        });

        et_j_triangle_sidea.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaPerimeter(et_j_triangle_height.getText().toString(), et_j_triangle_sidea.getText().toString(), et_j_triangle_sideb.getText().toString(), et_j_triangle_sidec.getText().toString());
            }
        });

        et_j_triangle_sideb.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaPerimeter(et_j_triangle_height.getText().toString(), et_j_triangle_sidea.getText().toString(), et_j_triangle_sideb.getText().toString(), et_j_triangle_sidec.getText().toString());
            }
        });

        et_j_triangle_sidec.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaPerimeter(et_j_triangle_height.getText().toString(), et_j_triangle_sidea.getText().toString(), et_j_triangle_sideb.getText().toString(), et_j_triangle_sidec.getText().toString());
            }
        });
    }

    public void setAreaPerimeter(String heightS, String sideAS, String sideBS, String sideCS)
    {
        if (heightS.isEmpty() || sideAS.isEmpty() || sideBS.isEmpty() || sideCS.isEmpty())
        {
            return;
        }

        double height = Double.parseDouble(heightS);
        double sideA = Double.parseDouble(sideAS);
        double sideB = Double.parseDouble(sideBS);
        double sideC = Double.parseDouble(sideCS);

        double area = 0.5 * sideB * height;
        double perimeter = sideA + sideB + sideC;

        tv_j_triangle_computedvalues.setText("Area = " + area + "\nPerimeter = " + perimeter);
    }

}