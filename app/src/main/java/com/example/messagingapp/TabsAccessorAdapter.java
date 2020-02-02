package com.example.messagingapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabsAccessorAdapter extends FragmentStatePagerAdapter {

    int counttab;

    //Constructor
    public TabsAccessorAdapter(FragmentManager fm,int counttab) {
        super(fm);
        this.counttab = counttab;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                ChatsFragment chatsFragment = new ChatsFragment();
                return chatsFragment;
            case 1:
                PeopleFragment peopleFragment = new PeopleFragment();
                return peopleFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return counttab;
    }



}
