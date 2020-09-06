package com.example.thirdclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.zip.Inflater;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button sampleBtn, customBtn, errorBtn, successBtn, infoBtn, warningBtn, snackbar;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sampleBtn = (Button) findViewById(R.id.sampleToastId);
        customBtn = (Button) findViewById(R.id.customToastId);
        errorBtn = (Button) findViewById(R.id.errorToastId);
        successBtn = (Button) findViewById(R.id.successToastId);
        infoBtn = (Button) findViewById(R.id.infoToastId);
        warningBtn = (Button) findViewById(R.id.warningToastId);
        snackbar = (Button) findViewById(R.id.snackBarId);

        linearLayout = findViewById(R.id.linearLayoutId);

        sampleBtn.setOnClickListener(this);
        customBtn.setOnClickListener(this);
        errorBtn.setOnClickListener(this);
        successBtn.setOnClickListener(this);
        infoBtn.setOnClickListener(this);
        warningBtn.setOnClickListener(this);
        snackbar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sampleToastId) {
            Toast.makeText(MainActivity.this, "Sample Toast", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.customToastId) {
            customToast();

        } else if (v.getId() == R.id.errorToastId) {
            Toasty.error(MainActivity.this, "This is an error Toast !", Toast.LENGTH_LONG).show();
        } else if (v.getId() == R.id.successToastId) {
            Toasty.success(MainActivity.this, "This is a success Toast !", Toast.LENGTH_LONG).show();
        } else if (v.getId() == R.id.infoToastId) {
            Toasty.info(MainActivity.this, "This is an info Toast !", Toast.LENGTH_LONG).show();
        } else if (v.getId() == R.id.warningToastId) {
            Toasty.warning(MainActivity.this, "This is a warning Toast !", Toast.LENGTH_LONG).show();
        } else if (v.getId() == R.id.snackBarId) {
            snackMethod();

        }

    }

    private void snackMethod() {
        Snackbar.make(linearLayout,"This Is SnackBar !",Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(linearLayout,"Undo is successful !",Snackbar.LENGTH_LONG).show();
            }
        })
                .show();
    }

    private void customToast() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.customViewId));

        TextView textView = view.findViewById(R.id.customTextId);
        textView.setText("   Time For Dinner !   ");

        Toast toast = new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();


    }
}
