package com.myappcompany.rajan.thefictionalchat;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyFragment extends Fragment {
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        TextView textView = (TextView)view.findViewById(R.id.frag_text);
        textView.setText("No Internet Connection");

        button = (Button)view.findViewById(R.id.frag_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ChatActivity.isInternetOn(getActivity())) {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    MyFragment f = (MyFragment) fm.findFragmentByTag("MY_FRAGMENT");
                    ft.remove(f);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                    ChatActivity.parentLayout.setClickable(true);
                    ft.commit();

                }
                else {
                    Toast.makeText(getActivity(), "Internet connectivity not available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
