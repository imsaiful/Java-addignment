package com.app3.imsaiful.hashmap;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringDef;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText low,up,ran;
    Button gen,reset;
    TextView tv;
    HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        low= (EditText) findViewById(R.id.lower);
        up= (EditText) findViewById(R.id.upper);
        ran= (EditText) findViewById(R.id.random);
        gen= (Button) findViewById(R.id.generate);
        tv= (TextView)findViewById(R.id.gview);
        reset= (Button) findViewById(R.id.reset);
        gen.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int x=0,y=0,z=0;
                        try
                        {
                            gen.setEnabled(false);
                            x=Integer.parseInt(low.getText().toString());
                            y=Integer.parseInt(up.getText().toString());
                            z=Integer.parseInt(ran.getText().toString());

                            int i=0;
                            while(i<z)
                            {
                                boolean flag=false;
                                Random r=new Random();
                                int randomNum=r.nextInt((y - x) + 1) + x;
                                for(Map.Entry m:map.entrySet())
                                {
                                    if(randomNum==(int)m.getKey())
                                    {
                                        int val= (int) m.getValue()+1;
                                        map.put(randomNum, val);
                                        flag=true;
                                    }

                                }
                                if(flag==false)
                                {

                                    map.put(randomNum,1);
                                }
                                i++;
                            }
                            String text="Random Number      "+"  Frequency \n";
                            for(Map.Entry m:map.entrySet())
                            {
                                String key = m.getKey().toString();
                                String value = m.getValue().toString();
                                text+=key+"                       "+ value+"\n";
                            }
                            tv.setText(text);

                        }
                        catch(Exception e)
                        {
                            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                        }


                    }
                }

        );
        reset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        gen.setEnabled(true);
                        startActivity(new Intent(MainActivity.this,MainActivity.class));
                    }
                }
        );

    }
}
