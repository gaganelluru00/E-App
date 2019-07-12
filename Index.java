package com.example.gagan.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class Index extends AppCompatActivity {

    int[] images={ R.drawable.c,R.drawable.cplus,R.drawable.java,R.drawable.python,R.drawable.os,R.drawable.cd};
    String[] names={"C","C++","JAVA","PYTHON","OS","COMPILER DESIGN"};
    ListView l1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        l1=(ListView)findViewById(R.id.l1);
        CustomAdapter customAdapter=new CustomAdapter();
        l1.setAdapter(customAdapter);
      l1.setOnItemClickListener(new CustomAdapter());

    }
    class CustomAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.custlist,null);
          ImageView  i1=(ImageView)view.findViewById(R.id.i1);
            TextView  t1=(TextView)view.findViewById(R.id.t1);
            i1.setImageResource(images[i]);
            t1.setText(names[i]);;
            return view;
        }
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if(i==0){
                Intent q=new Intent(Index.this,C.class);
                startActivity(q);
            }
            if(i==1){
                Intent q1=new Intent(Index.this,Cplus.class);
                startActivity(q1);
            }
            if(i==2){
                Intent q2=new Intent(Index.this,Java.class);
                startActivity(q2);
            }
            if(i==3){
                Intent q3=new Intent(Index.this,Python.class);
                startActivity(q3);
            }
            if(i==4){
                Intent q4=new Intent(Index.this,OS.class);
                startActivity(q4);
            }
            if(i==5){
                Intent q5=new Intent(Index.this,CD.class);
                startActivity(q5);
            }
        }


    }

}
