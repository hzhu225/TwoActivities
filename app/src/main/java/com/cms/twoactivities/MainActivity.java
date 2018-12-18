package com.cms.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public static final int TEXT_REQUEST = 1;
    private EditText messageBox;
    private TextView headerText;
    private TextView replyText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageBox = findViewById(R.id.editText_main);
        headerText = findViewById(R.id.text_header_reply);
        replyText = findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = messageBox.getText().toString();
        intent.putExtra("MainMessage", message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST && resultCode == RESULT_OK)
        {
            String reply = data.getStringExtra("ReplyMessage");
            headerText.setVisibility(View.VISIBLE);
            replyText.setText(reply);
            replyText.setVisibility(View.VISIBLE);
        }


    }
}
