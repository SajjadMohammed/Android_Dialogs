package com.sajjad.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.service.quicksettings.TileService;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar mainToolbar;
    ListView checkedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainToolbar=findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);

        checkedList=findViewById(R.id.checkedList);
    }

    public void defaultDialog(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Title");
        builder.setMessage("Message");
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void themedDialog(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this,R.style.ThemedDialog);
        builder.setTitle("Title");
        builder.setMessage("Message");
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void customDialog(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Title");
        builder.setIcon(R.mipmap.ic_launcher);

        View customView= LayoutInflater.from(this).inflate(R.layout.custom_dialog,null,false);
        builder.setView(customView);

        EditText userName=customView.findViewById(R.id.userName);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void listDialog(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Title");
        builder.setIcon(R.mipmap.ic_launcher);


        // Setting Items to dialog
//        builder.setItems(R.array.languages, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(),which+"",Toast.LENGTH_LONG).show();
//            }
//        });

        // Single Choice Dialog List
//        builder.setSingleChoiceItems(R.array.languages, 2, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });

        boolean[] defaultChecked = new boolean[]{false, true, true, false};
        final String []items=getResources().getStringArray(R.array.languages);
        final List<String> checkedItems=new ArrayList<>();

        builder.setMultiChoiceItems(items, defaultChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    checkedItems.add(items[which]);
                }else{
                    checkedItems.remove(items[which]);
                }
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_expandable_list_item_1,checkedItems);
                checkedList.setAdapter(arrayAdapter);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
