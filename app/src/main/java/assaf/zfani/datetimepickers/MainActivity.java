package assaf.zfani.datetimepickers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TextView tv;
    TimePicker tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp= (DatePicker)findViewById(R.id.datePicker);
        tp = (TimePicker)findViewById(R.id.timePicker2);
        tv= (TextView)findViewById(R.id.textView);
        dp.init(2017, 11, 26, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Date d = new Date(year-1900,monthOfYear,dayOfMonth);
                tv.setText(d.toString());
            }
        });

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                tv.setText(hourOfDay+": "+minute);
            }
        });
        Chronometer chronometer =(Chronometer)findViewById(R.id.chronometer2);
        chronometer.start();


    }
}
