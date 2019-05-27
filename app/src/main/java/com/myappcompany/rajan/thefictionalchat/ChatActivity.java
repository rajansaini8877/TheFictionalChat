package com.myappcompany.rajan.thefictionalchat;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class ChatActivity extends AppCompatActivity {

    public static final String p1 = "PERSON_1";
    public static final String p2 = "PERSON_2";
    public static final String t = "TIME";

    ListView chatList;
    ChatMessageAdapter adapter;
    int i=0;
    ArrayList<ChatText> list;
    public static boolean isInternetOn(Context context)
    {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo)
        {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
    public FragmentTransaction fragmentTransaction;
    public MyFragment myFragment;
    public static LinearLayout parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ArrayList<ChatText> tempList = new ArrayList<>();

        list = new ArrayList<>();
        list.add(new ChatText("25th November, 2007", t));
        list.add(new ChatText("Yoooo", p1));
        list.add(new ChatText("Hi", p2));
        list.add(new ChatText("Did you do that assignment for english?", p1));
        list.add(new ChatText("Yaad mat dilao yaar", p2));
        list.add(new ChatText("We have to submit it tomorrow only", p1));
        list.add(new ChatText("Ugh fine I'll go do that rn", p2));
        list.add(new ChatText("15th April, 2008", t));
        list.add(new ChatText("This creepy guy is staring at me", p1));
        list.add(new ChatText("What", p2));
        list.add(new ChatText(R.drawable.image, p2));
        list.add(new ChatText("I'm pretending to be busy", p1));
        list.add(new ChatText("Girl get outta there", p2));
        list.add(new ChatText("Lmao he just came over", p1));
        list.add(new ChatText("Whattt", p2));
        list.add(new ChatText("He knew me from primary school yaar", p1));
        list.add(new ChatText("Faltu me dara diya LOL", p2));
        list.add(new ChatText("Gotta go bye", p1));
        list.add(new ChatText("30th May, 2008", t));
        list.add(new ChatText(R.drawable.image, p1));
        list.add(new ChatText("I'm going to see him again", p1));
        list.add(new ChatText("Who? The creepy guy?", p2));
        list.add(new ChatText("He wasn't creepy", p1));
        list.add(new ChatText("Khud hi kha tha tumne", p2));
        list.add(new ChatText("Oh my god sushi", p1));
        list.add(new ChatText("3 hours later", t));
        list.add(new ChatText("How was your date?", p2));
        list.add(new ChatText("It wasn't a date", p1));
        list.add(new ChatText("Kha gye the?", p2));
        list.add(new ChatText("Eiffel Cafe", p1));
        list.add(new ChatText("It was a date dude", p2));
        list.add(new ChatText("Shut up", p1));
        list.add(new ChatText("Tell me everything!", p2));
        list.add(new ChatText("He was so sweet yaar", p1));
        list.add(new ChatText("I can't believe someone can be this cute!", p1));
        list.add(new ChatText("Stop gushing, date ke baare me batao", p2));
        list.add(new ChatText("Arey, so he picked me up and took me to the cafe", p1));
        list.add(new ChatText("I was so nervous and yaar itni hansi aa rhi thi", p1));
        list.add(new ChatText("Hansi aa rhi thi? LOL what", p2));
        list.add(new ChatText("Pehli baar date pe gyi thi yaar, nervous laughter", p1));
        list.add(new ChatText("Accha fine fine phir?", p2));
        list.add(new ChatText("Phir we just sat and talked kaafi der tak", p1));
        list.add(new ChatText("He asked me just random crap haha", p1));
        list.add(new ChatText("Lagta h uska bhi pehla date tha", p2));
        list.add(new ChatText("Maybe", p1));
        list.add(new ChatText("Arey aise suspense bann rha h na jab type kr rhi ho", p2));
        list.add(new ChatText("Wait, I'll call", p2));
        list.add(new ChatText("23rd January 2009", t));
        list.add(new ChatText("I am late for school", p1));
        list.add(new ChatText("I can see", p2));
        list.add(new ChatText("There is so much traffic damn", p1));
        list.add(new ChatText("Upretti ma'am is going to kill you", p2));
        list.add(new ChatText("Don't remind me", p1));
        list.add(new ChatText("Why do we have to have her for first class", p2));
        list.add(new ChatText("Din khraab ho jata h omg", p1));
        list.add(new ChatText("Ikr", p2));
        list.add(new ChatText("So, I am going with Ashan after school", p1));
        list.add(new ChatText("Who is Ashan?", p2));
        list.add(new ChatText("Ugh! You know who", p1));
        list.add(new ChatText("I don't know", p2));
        list.add(new ChatText("That creepy dude", p1));
        list.add(new ChatText("Oooooohh haha creepy dude", p2));
        list.add(new ChatText("He is not though, he is so sweet", p1));
        list.add(new ChatText("We'll see", p2));

        chatList = findViewById(R.id.chat_list);


        adapter = new ChatMessageAdapter(ChatActivity.this, tempList);

        chatList.setAdapter(adapter);

        RelativeLayout listLayout = (RelativeLayout)findViewById(R.id.list_layout);
        listLayout.setClickable(true);

        parentLayout = (LinearLayout)findViewById(R.id.parent_layout);
        parentLayout.setClickable(true);

    }

    public void addMessage(View view) {

        boolean connected = isInternetOn(this);

        if(connected) {
            try {
                adapter.add(list.get(i));
                i++;
                chatList.post(new Runnable() {
                    @Override
                    public void run() {
                        chatList.setSelection(adapter.getCount() - 1);
                    }
                });
            } catch (Exception e) {
                Toast.makeText(this, "Reached to the end", Toast.LENGTH_SHORT).show();
            }
        }
        else {

            FragmentManager fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            myFragment = new MyFragment();
            fragmentTransaction.add(R.id.list_layout, myFragment, "MY_FRAGMENT");
            LinearLayout parentLayout = (LinearLayout)findViewById(R.id.parent_layout);
            parentLayout.setClickable(false);
            fragmentTransaction.commit();

        }
    }
}
