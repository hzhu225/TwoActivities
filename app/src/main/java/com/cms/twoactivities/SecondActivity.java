package com.cms.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    private EditText replyBox;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        replyBox = findViewById(R.id.editText_second);

        Intent intent = getIntent();
        String messageFromMain= intent.getStringExtra("MainMessage");
        TextView textView = findViewById(R.id.text_message);
        textView.setText(messageFromMain);
    }

    public void returnReply(View view)
    {
        String reply = replyBox.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra("ReplyMessage", reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}
