package com.github.unithon.unithon.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.github.unithon.unithon.model.RecommendBook;
import java.util.ArrayList;
import java.util.List;

public class RecommendPagerAdapter extends FragmentPagerAdapter {

    private List<RecommendBook> recommendBookList = new ArrayList<>();

    public RecommendPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setRecommendBookList(List<RecommendBook> recommendBookList) {
        this.recommendBookList = recommendBookList;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        final Fragment fragment = RecommendFragment.newInstance(recommendBookList.get(position));
        return fragment;
    }

    @Override
    public int getCount() {
        return recommendBookList.size();
    }
}
