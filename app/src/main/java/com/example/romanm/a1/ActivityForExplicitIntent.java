package com.example.romanm.a1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityForExplicitIntent extends AppCompatActivity {

    private static String ARG_NUMBER = "arg_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_explicit_intent);

        TextView text = (TextView) findViewById(R.id.text_explicit);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            text.setText(String.valueOf(bundle.getInt(ARG_NUMBER)));
        }
    }

    public static void Intent(Context context, int number) {
        Intent intent = new Intent(context, ActivityForExplicitIntent.class);
        intent.putExtra(ARG_NUMBER, number);
        context.startActivity(intent);
    }
}
