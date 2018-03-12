package com.example.sanyo.hw2_groups24;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TaskActivity extends AppCompatActivity {
    public static final String RES_KEY = "Result";
    EditText editDate;
    EditText editTime;
    EditText editTitle;
    RadioGroup radioGroup;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    String priority;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        setTitle("Create Task");
        editTitle = findViewById(R.id.etTitle);
        editDate= findViewById(R.id.    etDate);
        editTime = findViewById(R.id.etTime);
        radioGroup = findViewById(R.id.radioGroup);
        editDate.setKeyListener(null);
        editTime.setKeyListener(null);
        task = new Task();
        datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                task.year = i;
                task.month= i1 + 1;
                task.day = i2;
                editDate.setText(task.month+"/"+task.day+"/"+task.year);
            }
        },2018, 1,1);
        
          timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                task.hour = i;
                task.minutes = i1;
                editTime.setText(task.hour+":"+task.minutes);


            }
        }, 12, 0, false);
        
        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        editTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();

            }
        });

        findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editTitle.getText().toString().equals("") || editDate.getText().toString().equals("")
                        || editTime.getText().toString().equals("")){
                    Toast.makeText(TaskActivity.this, "Missing Values", Toast.LENGTH_SHORT).show();
                }else {
                    task.title = editTitle.getText().toString();
                    int i = radioGroup.getCheckedRadioButtonId();
                    if (i == R.id.rbHigh) {
                        task.priority = "High";
                    } else if (i == R.id.rbMedium) {
                        task.priority = "Medium";
                    } else if (i == R.id.rbLow) {
                        task.priority = "Low";
                    }
                    task.setDate();
                    Log.d("demo", task.toString());

                    Intent intent = new Intent();
                    intent.putExtra(RES_KEY, task);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

    }
}

