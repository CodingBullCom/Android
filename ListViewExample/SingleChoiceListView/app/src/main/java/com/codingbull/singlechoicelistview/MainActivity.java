package com.codingbull.singlechoicelistview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String [] friends = {"Blueberry", "Blue Moon", "Butter Pecan","Chocolate", "Mango", "Kesar-Pista", "Strawberry", "Vanila"};
        listView = (ListView)findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, friends);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String frindName = ((CheckedTextView)view).getText().toString();
                Toast.makeText(MainActivity.this, "Hi " +frindName, Toast.LENGTH_SHORT);
            }
        });
    }

    public void inviteButtonClick(View view){

        int count = listView.getCheckedItemCount();
        String title = "You have" + (count > 0 ? " "  : " not ") + "selected your ice cream.";

        String messageText = "";
        if (count > 0) {
            String[] selectedFriends = selectedFriends();
            for (String friend : selectedFriends) {
                messageText += friend + ", ";
            }
            messageText = messageText.substring(0, messageText.length()-2);
        } else {
            messageText = "Please select your ice cream to order.";
        }

        showAlert(title, messageText);
    }

    private String [] selectedFriends() {

        SparseBooleanArray checked = listView.getCheckedItemPositions();
        ArrayList<String> selectedItems = new ArrayList<String>();
        for (int i = 0; i < checked.size(); i++) {
            // Item position in adapter
            int position = checked.keyAt(i);
            // Add sport if it is checked i.e.) == TRUE!
            if (checked.valueAt(i))
                selectedItems.add(((ArrayAdapter<String>)listView.getAdapter()).getItem(position));
        }

        String[] outputStrArr = new String[selectedItems.size()];

        for (int i = 0; i < selectedItems.size(); i++) {
            outputStrArr[i] = selectedItems.get(i);
        }

        return outputStrArr;
    }

    private void showAlert(String title, String message) {

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);

        // Setting OK Button
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Showing Alert Message
        alertDialog.show();

    }
}
