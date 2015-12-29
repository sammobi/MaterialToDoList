package com.example.simpalm.materialtodolist;

import android.app.ActionBar;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoListActivity extends ActionBarActivity {

    private EditText item;
    private ImageButton add;
    private ListView dynamicListView;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        item = (EditText) findViewById(R.id.itemEditText);
        add = (ImageButton) findViewById(R.id.add_item_button);
        dynamicListView = (ListView) findViewById(R.id.itemsListView);

        // initialize the list and add item

        list = new ArrayList<String>();
        list.add("Android");

        // initialize the arrayadapter

        adapter = new ArrayAdapter<String>(ToDoListActivity.this, android.R.layout.simple_list_item_1, list);
        // setting the adapter to the listview
        dynamicListView.setAdapter(adapter);


        // add item to the ListView on click button (add)

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoItem = item.getText().toString();
                if (todoItem.length() > 0) {
                    // add edittext vakue to the list
                    list.add(todoItem);
                    // apply changes on the adapter to referesh the listview

                    adapter.notifyDataSetChanged();
                    // clear the edittext for the new item

                    item.setText("");
                }
            }
        });

        // delete item on the long click on tje item

        dynamicListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                // remove the item from list

                list.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }

        });


    }
}
