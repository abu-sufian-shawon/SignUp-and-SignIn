package com.abu.sufian.signupandsignin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView txtSignUp, txtReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.txtSignUp).setOnClickListener(v->{
            startActivity(new Intent(this, SignUpActivity.class));
        });

        findViewById(R.id.txtForgotRight).setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Code Sent", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel", null);
            builder.setCancelable(false);

            AlertDialog dialog = builder.create();
            LayoutInflater inflater = this.getLayoutInflater();
            View alertLayout = inflater.inflate(R.layout.reset_layout, null);
            dialog.setView(alertLayout);
            dialog.show();

        });
    }
}