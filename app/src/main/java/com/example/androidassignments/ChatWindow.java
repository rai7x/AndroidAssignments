package com.example.androidassignments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "ChatWindowActivity";
    ListView lv;
    EditText et;
    Button sb;
    ArrayList<String> chat_messages;
    ChatAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        lv = (ListView) findViewById(R.id.list_view);
        et = (EditText) findViewById(R.id.edit_text);
        sb = (Button) findViewById(R.id.send_button);

        chat_messages = new ArrayList<String>();
        //in this case, “this” is the ChatWindow, which is-A Context object
        messageAdapter = new ChatAdapter( this );
        lv.setAdapter (messageAdapter);

    }


    public String getItem(int position) {
        return chat_messages.get(position);
    }



    public void sendMessage(View view) {
        chat_messages.add(et.getText().toString());
        et.setText("");
        messageAdapter.notifyDataSetChanged(); //this restarts the process of getCount()/getView()
    }

    private class ChatAdapter extends ArrayAdapter<String>
    {
        public int getCount() {
            return chat_messages.size();
        }
        public ChatAdapter(@NonNull Context context) {
            super(context, 0);
        }
        public String getItem(int position) {
            return chat_messages.get(position);
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null;
            TextView message;
            if(position%2 == 1) {
                result = inflater.inflate(R.layout.chat_row_incoming, null);
                message = (TextView) result.findViewById(R.id.message_text_in);
            }
            else {
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
                message = (TextView) result.findViewById(R.id.message_text);
            }
            message.setText(getItem(position)); // get the string at position
            return result;
        }
    }
}