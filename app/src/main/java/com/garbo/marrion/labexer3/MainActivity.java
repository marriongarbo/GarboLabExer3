package com.garbo.marrion.labexer3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.Subject1);
        input = findViewById(R.id.Subject2);
        input = findViewById(R.id.Subject3);
        input = findViewById(R.id.Subject4);
        input = findViewById(R.id.Subject5);
        input = findViewById(R.id.Subject6);
        input = findViewById(R.id.Subject7);
        input = findViewById(R.id.Subject8);
    }

    public void writeData(View v) {
        String data = input.getText().toString();
        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data.txt", MODE_PRIVATE);
            writer.write(data.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "file not found...");
        } catch (IOException e) {
            Log.d("error", "IO error...");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "file not found...");
            }
        }
        Toast.makeText(this, "data saved...", Toast.LENGTH_LONG).show();
    }

    public void showData(View v) {
        FileInputStream reader = null;
        String data = "";

        try {
            reader = openFileInput("data.txt");
            int token;

            while ((token = reader.read()) != -1) {
                data = data + (char) token;
            }

        } catch (FileNotFoundException e) {
            Log.d("error", "file not found..");

        } catch (IOException e) {
            Log.d("error", "IO error...");
        }

        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

}