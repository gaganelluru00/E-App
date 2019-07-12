package com.example.gagan.system;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Java extends AppCompatActivity {
    Button b1;
    TextView t1;
    int counter=-1;
    final String array[]={"Advantages-\n"+"1.Simple:  Java was designed to be easy to use, write, compile, debug, and learn than other programming languages. Java is much simpler than C++ because Java uses automatic memory allocation and garbage collection.\n" +

            "2.Object-Oriented: Object oriented programming is associated with concepts like class, object, inheritance, encapsulation, abstraction, polymorphism, etc. which allows you to create modular programs and reusable code. You can declare classes, create objects inside classes, and interact between two objects.\n" ,

            "3.Platform-Independent:  Java offers the comfort of write program once and run on any hardware and software platform and any Java compatible browser. This gives the ability to move easily from one computer system to another.\n" +

            "4.Distributed:  Java has great networking capability, it is designed to make distributed computing easy with the networking capability that is inherently integrated into it.\n" +

            "5.Secure:  Java is the first programming language to include security an integral part of the design. Java’s compiler, interpreter, and runtime environment were each developed with security in mind. Java Virtual Machine has a unique identifier that identifies the bytecode and verifies it before running it.\n" ,

            "6.Allocation: Java has the feature of Stack allocation system. It follows LIFO (Last in First Out) which helps the data to be stored and retrieved easily.\n" +

            "7.Multithreaded:  Java is one of the programming languages to support Multithreading. Multithreading is the capability for a program to perform several tasks simultaneously within a program.\n" +

            "8.Rich APIs: Java offers various APIs for application development. Java APIs (Application Programming Interface) is the set of commands or methods of communication among various activities like Database connection, networking, I/O, XML parsing, utilities, and much more.\n" ,

            "9.Powerful Opensource Rapid Development Tools: Over the year’s several open source development tools i.e., IDEs such as Eclipse and Netbeans, have been created with Java as a base which makes Java more powerful for application development. IDEs makes application development simpler with powerful coding and debugging features.\n" +

            "10.Robust: Java is one of the most robust programming languages, that is Java is more reliable. Java compilers can detect any errors in the coding. There are also other features like exception handling and garbage collection which makes Java more robust.",
            "Disadvantages-\n"+"1.Performance: SIgnificantly slower and more memory-consuming than natively compiled languages such as C or C++.\n" +

            "2.Look and feel: The default look and feel of GUI applications written in Java using the Swing toolkit is very different from native applications.\n" +

            "3.Single-paradigm language: The addition of static imports in Java 5.0 the procedural paradigm is better accommodated than in earlier versions of Java."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
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
