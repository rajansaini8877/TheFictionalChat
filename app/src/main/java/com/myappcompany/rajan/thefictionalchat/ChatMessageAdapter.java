package com.myappcompany.rajan.thefictionalchat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatMessageAdapter extends ArrayAdapter<ChatText> {

    ChatMessageAdapter(Context context, ArrayList<ChatText> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View currentView = convertView;
        if(currentView==null) {
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }
        ChatText chatText = getItem(position);

        TextView textView;
        textView = (TextView)currentView.findViewById(R.id.chat_text);
        LinearLayout textViewParent = (LinearLayout)currentView.findViewById(R.id.chat_text_parent);
        ImageView imageView = (ImageView)currentView.findViewById(R.id.chat_image);



        if(chatText.getMessageType().equals("PERSON_1")) {
            textViewParent.setGravity(Gravity.LEFT);
            imageView.setBackgroundResource(R.drawable.person1_background);
            textView.setBackgroundResource(R.drawable.person1_background);
            textView.setTextSize(16);
        }
        else if(chatText.getMessageType().equals("PERSON_2")) {
            textViewParent.setGravity(Gravity.RIGHT);
            imageView.setBackgroundResource(R.drawable.person2_background);
            textView.setBackgroundResource(R.drawable.person2_background);
            textView.setTextSize(16);
        }
        else {
            textViewParent.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setBackgroundResource(0);
            textView.setTextSize(12);
        }

        textView.setText(chatText.getMessage());

        if(chatText.getImageResource()!= -1) {

            imageView.setImageResource(chatText.getImageResource());
            textView.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            textView.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
        }

        return currentView;
    }
}
