package com.example.sanyo.hw2_groups24;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    public static final int REQ_CODE = 100;
    public static final int REQ_CODE2 = 101;
    public static final String VALUE_KEY = "value";
    public static final String TASK_KEY = "TASK";
    TextView title;
    TextView date;
    TextView time;
    TextView priority;
    TextView number;
    Task task;
    LinkedList<Task> linkedList = new LinkedList<Task>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("View Tasks");
        ImageButton add = findViewById(R.id.ibAdd);
        ImageButton delete = findViewById(R.id.ibDelete);
        ImageButton edit = findViewById(R.id.ibEdit);
        ImageButton first = findViewById(R.id.ibFirst);
        ImageButton last = findViewById(R.id.ibLast);
        ImageButton next = findViewById(R.id.ibNext);
        ImageButton previous = findViewById(R.id.ibPrevious);

        title = findViewById(R.id.tvTaskTitle);
        date = findViewById(R.id.tvTaskDate);
        time = findViewById(R.id.tvTaskTime);
        priority = findViewById(R.id.tvTaskPriority);
        number = findViewById(R.id.tvTaskNo);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TaskActivity.class);
                startActivityForResult(intent, REQ_CODE);
            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(linkedList.size() == 0){
                    Toast.makeText(getApplicationContext(),"No Tasks Added!",Toast.LENGTH_SHORT).show();
                    title.setText("Title");
                    date.setText("Task Date");
                    time.setText("Task Minutes");
                    priority.setText("Task Priority");
                    number.setText("Task 0 of 0");
                }else if(linkedList.size() == 1) {
                    Toast.makeText(MainActivity.this, "There is only one task", Toast.LENGTH_SHORT).show();
                }else {

                    Log.d("demo", "size" + linkedList.size());
                    task = linkedList.getFirst();
                    title.setText(task.title);
                    date.setText(task.month+"/"+task.day+"/"+task.year);
                    time.setText(task.hour+":"+task.minutes);
                    priority.setText(task.priority);
                    number.setText("Task "+(linkedList.indexOf(task)+1)+" of "+linkedList.size());

                }
            }
        });

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(linkedList.size() == 0){
                    Toast.makeText(getApplicationContext(),"No Tasks Added!",Toast.LENGTH_SHORT).show();
                    title.setText("Title");
                    date.setText("Task Date");
                    time.setText("Task Minutes");
                    priority.setText("Task Priority");
                    number.setText("Task 0 of 0");
                }else if(linkedList.size() == 1) {
                    Toast.makeText(MainActivity.this, "There is only one task", Toast.LENGTH_SHORT).show();
                }else {

                    Log.d("demo", "size" + linkedList.size());
                    task = linkedList.getLast();
                    title.setText(task.title);
                    date.setText(task.month+"/"+task.day+"/"+task.year);
                    time.setText(task.hour+":"+task.minutes);
                    priority.setText(task.priority);
                    number.setText("Task "+(linkedList.indexOf(task)+1)+" of "+linkedList.size());

                }

            }
        });
        int i = 0;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(linkedList.size() == 0){
                    Toast.makeText(getApplicationContext(),"No Tasks Added!",Toast.LENGTH_SHORT).show();
                    title.setText("Title");
                    date.setText("Task Date");
                    time.setText("Task Minutes");
                    priority.setText("Task Priority");
                    number.setText("Task 0 of 0");
                }else if(linkedList.size() == 1) {
                    Toast.makeText(MainActivity.this, "No next task", Toast.LENGTH_SHORT).show();
                }else {

                    if(linkedList.indexOf(task) == linkedList.size() - 1){
                        task = linkedList.getFirst();
                    }  else {
                        task = linkedList.get(linkedList.indexOf(task) + 1);
                    }
                    title.setText(task.title);
                    date.setText(task.month + "/" + task.day + "/" + task.year);
                    time.setText(task.hour + ":" + task.minutes);
                    priority.setText(task.priority);
                    number.setText("Task " + (linkedList.indexOf(task) + 1) + " of " + linkedList.size());

                }


            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linkedList.size() == 0){
                    Toast.makeText(getApplicationContext(),"No Tasks Added!",Toast.LENGTH_SHORT).show();
                    title.setText("Title");
                    date.setText("Task Date");
                    time.setText("Task Minutes");
                    priority.setText("Task Priority");
                    number.setText("Task 0 of 0");
                }else if(linkedList.size() == 1) {
                    Toast.makeText(MainActivity.this, "No previous task", Toast.LENGTH_SHORT).show();
                }else {

                    if(linkedList.indexOf(task) == 0){
                        task = linkedList.getLast();
                    }  else {
                        task = linkedList.get(linkedList.indexOf(task) - 1);
                    }
                    title.setText(task.title);
                    date.setText(task.month + "/" + task.day + "/" + task.year);
                    time.setText(task.hour + ":" + task.minutes);
                    priority.setText(task.priority);
                    number.setText("Task " + (linkedList.indexOf(task) + 1) + " of " + linkedList.size());
                }

                }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(linkedList.size() == 0){
                    Toast.makeText(getApplicationContext(),"All Tasks are deleted",Toast.LENGTH_SHORT).show();
                    title.setText("Title");
                    date.setText("Task Date");
                    time.setText("Task Minutes");
                    priority.setText("Task Priority");
                    number.setText("Task 0 of 0");
                }else if(linkedList.size() == 1) {
                    linkedList.remove(linkedList.indexOf(task));
                    title.setText("Title");
                    date.setText("Task Date");
                    time.setText("Task Minutes");
                    priority.setText("Task Priority");
                    number.setText("Task 0 of 0");
                }else{
                    linkedList.remove(linkedList.indexOf(task));
                    Log.d("demo", "size" + linkedList.size());
                    task = linkedList.get(0);
                    title.setText(task.title);
                    date.setText(task.month+"/"+task.day+"/"+task.year);
                    time.setText(task.hour+":"+task.minutes);
                    priority.setText(task.priority);
                    number.setText("Task "+(linkedList.indexOf(task)+1)+" of "+linkedList.size());

                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linkedList.size() == 0){
                    Toast.makeText(getApplicationContext(),"No tasks to Edit",Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(MainActivity.this, EditActivity.class);
                    i.putExtra(TASK_KEY, task);
                    startActivityForResult(i, REQ_CODE2);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE){

            task = (Task) data.getExtras().getSerializable(TaskActivity.RES_KEY);
            linkedList.add(task);
            Collections.sort(linkedList);
            title.setText(task.title);
            date.setText(task.month+"/"+task.day+"/"+task.year);
            time.setText(task.hour+":"+task.minutes);
            priority.setText(task.priority);
            number.setText("Task "+(linkedList.indexOf(task)+1)+" of "+linkedList.size());
        }else if(requestCode == REQ_CODE2){

            linkedList.remove(task);
            task = (Task) data.getExtras().getSerializable(EditActivity.RES_KEY_EDIT);
            linkedList.add(task);
            Collections.sort(linkedList);
            title.setText(task.title);
            date.setText(task.month+"/"+task.day+"/"+task.year);
            time.setText(task.hour+":"+task.minutes);
            priority.setText(task.priority);
            number.setText("Task "+(linkedList.indexOf(task)+1)+" of "+linkedList.size());
            
        }
        
    }
}
