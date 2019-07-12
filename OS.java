package com.example.gagan.system;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OS extends AppCompatActivity {
    Button b1;
    TextView t1;
    int counter=-1;
    final String array[]={"Monday", "Tuesday","Wednesday","Thursday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os);
        b1=(Button)findViewById(R.id.b1);
        t1=(TextView)findViewById(R.id.t1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;

//If counter has come to end of array, set it to the first item.

                if(counter==array.length) counter=0;

                t1.setText(array[counter]);
            }
        });
    }
}
