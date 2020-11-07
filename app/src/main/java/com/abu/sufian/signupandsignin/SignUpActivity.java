package com.abu.sufian.signupandsignin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.Date;
import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {
    private Spinner spnGender;
    private EditText edtDOB;
    private DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        spnGender = findViewById(R.id.spnGender);
        edtDOB = findViewById(R.id.edtDOB);

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, R.layout.custom_spinner_item,
                getResources().getStringArray(R.array.gender));
        genderAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        spnGender.setAdapter(genderAdapter);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                edtDOB.setText(date);

            }
        };

        edtDOB.setOnClickListener(v->{
            DatePickerDialog dialog = new DatePickerDialog(SignUpActivity.this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    setListener,
                    year,
                    month,
                    day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });








    }
}