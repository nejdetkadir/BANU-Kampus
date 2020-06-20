package com.nejdetkadirr.banucampus.ui.notices;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nejdetkadirr.banucampus.ui.bustimes.BusTimesFragment;
import com.nejdetkadirr.banucampus.ui.communities.CommunitiesFragment;

public class NoticesPagerAdapter extends FragmentStatePagerAdapter {
    public NoticesPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment selectedFragment;
        switch (position) {
            case 0:
                selectedFragment = GeneralNoticesFragment.newInstance();
                break;
            case 1:
                selectedFragment =  FacultyNoticesFragment.newInstance();
                break;
            default:
                return null;
        }
        return selectedFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence selectedTitle;
        switch (position) {
            case 0:
                selectedTitle =  "GENEL";
                break;
            case 1:
                selectedTitle =  "FAKÜLTE & YÜKSEKOKUL";
                break;
            default:
                return null;
        }
        return selectedTitle;
    }
}
