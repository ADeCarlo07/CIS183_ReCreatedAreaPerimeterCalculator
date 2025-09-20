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

public class SquareActivity extends AppCompatActivity {

    Button btn_j_square_gohome;
    EditText et_j_square_length;
    EditText et_j_square_width;
    TextView tv_j_square_computedvalues;

    Intent mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_square);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_j_square_gohome = findViewById(R.id.btn_v_square_gohome);
        et_j_square_length = findViewById(R.id.et_v_square_length);
        et_j_square_width = findViewById(R.id.et_v_square_width);
        tv_j_square_computedvalues = findViewById(R.id.tv_v_square_computedvalues);

        mainActivity = new Intent(SquareActivity.this, MainActivity.class);

        textChangeListener();
        buttonClickListener();

    }

    public void textChangeListener()
    {
        et_j_square_width.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaPerimeter(et_j_square_length.getText().toString(), et_j_square_width.getText().toString());
            }
        });

        et_j_square_length.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaPerimeter(et_j_square_length.getText().toString(), et_j_square_width.getText().toString());
            }
        });
    }

    public void setAreaPerimeter(String lengthS, String widthS)
    {
        if (lengthS.isEmpty() || widthS.isEmpty())
        {
            return;
        }

        double length = Double.parseDouble(lengthS);
        double width = Double.parseDouble(widthS);

        double perimeter = length + length + width + width;
        double area = length * width;

        tv_j_square_computedvalues.setText("Area = " + area + "\nPerimeter = " + perimeter);
    }

    public void buttonClickListener()
    {
        btn_j_square_gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivity);
            }
        });
    }

}