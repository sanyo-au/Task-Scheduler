package com.example.sanyo.hw2_groups24;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    public static final String RES_KEY_EDIT = "Result From Edit";
    EditText editDate;
    EditText editTime;
    EditText editTitle;
    RadioGroup radioGroup;
    
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        setTitle("Edit Activity");

        if(getIntent() != null && getIntent().getExtras() != null) {
            task = (Task)getIntent().getExtras().getSerializable(MainActivity.TASK_KEY);
            editTitle = findViewById(R.id.etTitle);
            editTitle.setText(task.title);

            editDate = findViewById(R.id.etDate);
            editDate.setText(task.month+"/"+task.day+"/"+task.year);

            editTime = findViewById(R.id.etTime);
            editTime.setText(task.hour+":"+task.minutes);

            radioGroup = findViewById(R.id.radioGroup);

            if(task.priority.equals("High")){
                RadioButton rb = findViewById(R.id.rbHigh);
                rb.setChecked(true);
            }else if(task.priority.equals("Medium")){
                RadioButton rb = findViewById(R.id.rbMedium);
                rb.setChecked(true);
            }else if(task.priority.equals("Low")){
                RadioButton rb = findViewById(R.id.rbLow);
                rb.setChecked(true);
            }
            editDate.setKeyListener(null);
            editTime.setKeyListener(null);

            datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        task.year = i;
                        task.month = i1 + 1;
                        task.day = i2;
                        editDate.setText(task.month + "/" + task.day + "/" + task.year);

                }
            }, 2018, 1, 1);


            timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    task.hour = i;
                    task.minutes = i1;
                    editTime.setText(task.hour + ":" + task.minutes);


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

                    int i = radioGroup.getCheckedRadioButtonId();
                    if (i == R.id.rbHigh) {
                        task.priority = "High";
                    } else if (i == R.id.rbMedium) {
                        task.priority = "Medium";
                    } else if (i == R.id.rbLow) {
                        task.priority = "Low";
                    }
                    task.setDate();


                    Intent intent = new Intent();
                    intent.putExtra(RES_KEY_EDIT, task);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        } 

    }
}
