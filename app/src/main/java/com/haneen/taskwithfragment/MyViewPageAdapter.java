package com.haneen.taskwithfragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.haneen.taskwithfragment.Fragment.Currency;
import com.haneen.taskwithfragment.Fragment.IBAN;

public class MyViewPageAdapter extends FragmentStateAdapter {
    public MyViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Currency();
            case 1:
                return new IBAN();
            default:
                return new Currency();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
