package com.example.gagan.system;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Python extends AppCompatActivity {
    Button b1;
    TextView t1;
    int counter=-1;
    final String array[]={"Features-\n"+"1.Interactive\n" +
            "2.Interpreted\n" +
            "3.Modular\n" +
            "4.Dynamic\n" +
            "5.Object-oriented\n" +
            "6.Portable\n" +
            "7.High level\n" +
            "8.Extensible in C++ & C",
            "Advantages-\n"+"The Python language has diversified application in the software development companies such as in gaming, web frameworks and applications, language development, prototyping, graphic design applications, etc. This provides the language a higher plethora over other programming languages used in the industry. Some of its advantages are-\n" +

            "1.Extensive Support Libraries-" +
            "It provides large standard libraries that include the areas like string operations, Internet, web service tools, operating system interfaces and protocols. Most of the highly used programming tasks are already scripted into it that limits the length of the codes to be written in Python.\n" ,

            "2.Integration Feature-" +
            "Python integrates the Enterprise Application Integration that makes it easy to develop Web services by invoking COM or COBRA components. It has powerful control capabilities as it calls directly through C, C++ or Java via Jython. Python also processes XML and other markup languages as it can run on all modern operating systems through same byte code.\n" ,

            "3.Improved Programmer’s Productivity-" +
            "The language has extensive support libraries and clean object-oriented designs that increase two to ten fold of programmer’s productivity while using the languages like Java, VB, Perl, C, C++ and C#.\n" ,

            "4.Productivity-" +
            "With its strong process integration features, unit testing framework and enhanced control capabilities contribute towards the increased speed for most applications and productivity of applications. It is a great option for building scalable multi-protocol network applications." ,

            "Limitations or Disadvantages of Python-\n" +

            "Python has varied advantageous features, and programmers prefer this language to other programming languages because it is easy to learn and code too. However, this language has still not made its place in some computing arenas that includes Enterprise Development Shops. Therefore, this language may not solve some of the enterprise solutions, and limitations include-\n" ,

            "1.Difficulty in Using Other Languages-" +
            "The Python lovers become so accustomed to its features and its extensive libraries, so they face problem in learning or working on other programming languages. Python experts may see the declaring of cast “values” or variable “types”, syntactic requirements of adding curly braces or semi colons as an onerous task.\n" ,

            "2.Weak in Mobile Computing-" +
            "Python has made its presence on many desktop and server platforms, but it is seen as a weak language for mobile computing. This is the reason very few mobile applications are built in it like Carbonnelle.\n" +

            "3.Gets Slow in Speed-" +
            "Python executes with the help of an interpreter instead of the compiler, which causes it to slow down because compilation and execution help it to work normally. On the other hand, it can be seen that it is fast for many web applications too.\n" ,

            "4.Run-time Errors-" +
            "The Python language is dynamically typed so it has many design restrictions that are reported by some Python developers. It is even seen that it requires more testing time, and the errors show up when the applications are finally run.\n" +

            "5.Underdeveloped Database Access Layers-" +
            "As compared to the popular technologies like JDBC and ODBC, the Python’s database access layer is found to be bit underdeveloped and primitive. However, it cannot be applied in the enterprises that need smooth interaction of complex legacy data." ,

            "Conclusion-\n" +

            "Python is a robust programming language and provides an easy usage of the code lines, maintenance can be handled in a great way, and debugging can be done easily too. It has gained importance across the globe as computer giant Google has made it one of its official programming languages."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);
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
