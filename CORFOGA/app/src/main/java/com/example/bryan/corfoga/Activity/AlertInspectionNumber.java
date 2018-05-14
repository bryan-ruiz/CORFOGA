package com.example.bryan.corfoga.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.bryan.corfoga.Class.Global;
import com.example.bryan.corfoga.R;

public class AlertInspectionNumber extends AppCompatActivity{
    private Button inspectionOne, inspectionTwo, inspectionThree,inspectionFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_inspection_number_view);

        inspectionOne = (Button) findViewById(R.id.inspectionOne);
        inspectionTwo = (Button) findViewById(R.id.inspectionTwo);
        inspectionThree = (Button) findViewById(R.id.inspectionThree);
        inspectionFour = (Button) findViewById(R.id.inspectionFour);

        inspectionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.getInstance().setVisitNumber(1);
                Intent intent = new Intent(getBaseContext(), InspectionActivity.class);
                startActivity(intent);
            }
        });
        inspectionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.getInstance().setVisitNumber(2);
                Intent intent = new Intent(getBaseContext(), InspectionActivity.class);
                startActivity(intent);
            }
        });
        inspectionThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.getInstance().setVisitNumber(3);
                Intent intent = new Intent(getBaseContext(), InspectionActivity.class);
                startActivity(intent);
            }
        });
        inspectionFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.getInstance().setVisitNumber(4);
                Intent intent = new Intent(getBaseContext(), InspectionActivity.class);
                startActivity(intent);
            }
        });

    }

}
