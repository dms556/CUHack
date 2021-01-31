package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class set extends AppCompatActivity implements View.OnClickListener{

    private  int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        findViewById(R.id.ok).setOnClickListener(this);
        findViewById(R.id.cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        EditText editText = findViewById(R.id.editText);
        TimePicker timePicker = findViewById(R.id.time);

        //Set notificationID and text
        Intent intent = new Intent(set.this, AlarmReceiver.class);
        intent.putExtra("notificationID",notificationID);
        intent.putExtra("todo", editText.getText().toString());

        //getBroadcast(context, requestCode, intents flags
        PendingIntent alarmIntent = PendingIntent.getBroadcast(
                set.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT
        );

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        switch (v.getId()){
            case R.id.ok:
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                //Get time
                Calendar start = Calendar.getInstance();
                start.set(Calendar.HOUR_OF_DAY,hour);
                start.set(Calendar.MINUTE, minute);
                start.set(Calendar.SECOND,0);
                long alarmtime = start.getTimeInMillis();

                //Set alarm
                alarmManager.set(AlarmManager.RTC_WAKEUP, alarmtime, alarmIntent);
                Toast.makeText(this,"Done!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cancel:
                alarmManager.cancel(alarmIntent);
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT);
                break;
        }
    }
}