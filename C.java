package com.example.gagan.system;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class C extends AppCompatActivity {
    Button b1;
    TextView t1;
    int counter=-1;
    final String array[]={"Important Points-\n"+"1.One of the early programming languages.\n"+
            "2.Still, the best programming language to learn quickly.\n"+
            "3.C language is reliable, simple and easy to use.\n"+
            "4.C language is a structured language.\n"+
            "5.Modern programming concepts are based on C.\n"+
            "6.It can be compiled on a variety of computer platforms.\n" +
            "7.Universities preferred to add C programming in their courseware.","Advantages-\n"+"1.C is very suitable for system programming\n"+
    "2.C encourages the code reusability\n"+
    "3.C encourages the structured programming.\n"+
    "4.The different modules can be present in different source files and they can be compiled separately.\n"+
    "5.C is one of the most portable languages.\n"+
    "6.C supports a number of data types.\n","Disadvantages-\n"+"1.C does not provide Object Oriented Programming (OOP) concepts.\n"+
            "2.There are no concepts of Namespace in C.\n"+
            "3.C does not provide binding or wrapping up of data in a single unit.\n"+
            "4.C does not provide Constructor and Destructor.\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
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
