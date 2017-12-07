package com.example.dimaculangan.labquiz;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etName, etQuotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.et_Name);
        etQuotes = (EditText) findViewById(R.id.et_Quote);
    }

    public void saveQuote (View view){
        File folder = getCacheDir();
        File file = new File(folder, "data1.txt");
        String name = etName.getText().toString();
        String quote = etQuotes.getText().toString();
        String message = name + " said, \n\n      \"" + quote + "\"";
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void nextPage(View view){

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


}
