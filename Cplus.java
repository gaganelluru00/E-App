package com.example.gagan.system;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cplus extends AppCompatActivity {
    Button b1;
    TextView t1;
    int counter=-1;
    final String array[]={"Features-\n"+"1.Object-oriented: C++ is an object-oriented programming language. This means that the focus is on “objects” and manipulations around these objects. Information about how these manipulations work is abstracted out from the consumer of the object.\n" +
            "2.Rich library support: Through C++ Standard Template Library (STL) many functions are available that help in quickly writing code. For instance, there are standard libraries for various containers like sets, maps, hash tables, etc.\n" ,
            "3.Speed: C++ is the preferred choice when latency is a critical metric. The compilation, as well as the execution time of a C++ program, is much faster than most other general purpose programming languages.\n" +
            "4.Compiled: A C++ code has to be first compiled into low-level code and then executed, unlike interpreted programming languages where no compilation is needed.\n" +
            "5.Pointer Support: C++ also supports pointers which are widely used in programming and are often not available in several programming languages.","Advantages-\n"+"1.Object oriented\n" +
            "2.Portable language (writing a program irrespective of operating system as well as Hardware)\n" +
            "3.Low-level language like Assembly language on Machine language called portable.\n" +
            "4.C++ use multi-paradigm programming. The Paradigm means the style of programming .paradigm concerned about logics, structure, and procedure of the program. C++ is multi-paradigm means it follows three paradigm Generic, Imperative, Object Oriented.\n" ,
            "5.It is useful for the low-level programming language and very efficient for general purpose.\n" +
            "6.C++ provide performance and memory efficiency.\n" +
            "7.It provides a high-level abstraction.\n" +
            "8.In the language of the problem domain.\n" +
            "9.C++ is compatible with  C.\n" +
            "10.C++ used reusability of code.\n" +
            "11.C++ used inheritance, polymorphism.","Disadvantages-\n"+"1.It has no security\n" +
            "2.Complex in a very large high-level program.\n" +
            "3.Used for platform specific application commonly.\n" +
            "4.For a particular operating system or platform, the library set has usually chosen that locks.\n" +
            "5.When C++ used for web applications complex and difficult to debug.\n" +
            "6.C++ can't support garbage collection.\n" +
            "7.C++ is not secure because it has a pointer, friend function, and global variable.\n" +
            "8.No support for threads built in."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplus);
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
