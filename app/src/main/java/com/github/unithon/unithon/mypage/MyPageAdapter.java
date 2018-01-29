package com.github.unithon.unithon.mypage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.MyPage;
import java.util.ArrayList;
import java.util.List;

public class MyPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int SIZE_OF_HEADER = 1;

    private static final int VIEW_TYPE_SECTION = 100;
    private static final int VIEW_TYPE_PAGE = 101;

    private List<MyPage> myPageList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view;

        if(viewType == VIEW_TYPE_SECTION) {
            view = layoutInflater.inflate(R.layout.view_section, parent, false);
            final SectionViewHolder sectionViewHolder = new SectionViewHolder(view);
            return sectionViewHolder;
        } else {
            view = layoutInflater.inflate(R.layout.view_mypage, parent, false);
            final MyPageViewHolder myPageViewHolder = new MyPageViewHolder(view);
            return myPageViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch(getItemViewType(position)) {
            case VIEW_TYPE_SECTION:
                ((SectionViewHolder)holder).bind("마이페이지");
                break;
            case VIEW_TYPE_PAGE:
                ((MyPageViewHolder) holder).bind(myPageList.get(position - SIZE_OF_HEADER));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return myPageList.size() + SIZE_OF_HEADER;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return VIEW_TYPE_SECTION;
        } else {
            return VIEW_TYPE_PAGE;
        }
    }

    public void setMyPageList(List<MyPage> myPageList) {
        this.myPageList = myPageList;
        notifyDataSetChanged();
    }
}
