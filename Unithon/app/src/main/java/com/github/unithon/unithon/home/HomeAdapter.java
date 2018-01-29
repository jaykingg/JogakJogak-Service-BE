package com.github.unithon.unithon.home;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.RecommendBook;
import com.github.unithon.unithon.model.Review;
import com.github.unithon.unithon.mypage.SectionViewHolder;
import com.github.unithon.unithon.review.ReviewViewHolder;
import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_SECTION = 100;
    private static final int TYPE_RECOMMEND_PAGER = 101;
    private static final int TYPE_REVIEW = 102;

    private List<Review> reviewList = new ArrayList<>();
    private List<RecommendBook> recommendBookList = new ArrayList<>();

    private FragmentManager fragmentManager;

    public HomeAdapter(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view;

        if(viewType == TYPE_SECTION) {
            view = layoutInflater.inflate(R.layout.view_section, parent, false);
            return new SectionViewHolder(view);
        } else if(viewType == TYPE_RECOMMEND_PAGER) {
            view = layoutInflater.inflate(R.layout.view_recommend_pager, parent, false);
            return new RecommendPagerViewHolder(fragmentManager, view);
        } else {
            view = layoutInflater.inflate(R.layout.view_review, parent, false);
            return new ReviewViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch(getItemViewType(position)) {
            case TYPE_SECTION:
                ((SectionViewHolder) holder).bind("오늘의 리뷰");
                break;
            case TYPE_RECOMMEND_PAGER:
                ((RecommendPagerViewHolder)holder).bind(recommendBookList);
                break;
            case TYPE_REVIEW:
                ((ReviewViewHolder) holder).bind(reviewList.get(position - 2));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return reviewList.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        switch(position) {
            case 0:
                return TYPE_RECOMMEND_PAGER;
            case 1:
                return TYPE_SECTION;
            default:
                return TYPE_REVIEW;
        }
    }

    public void setRecommendBookList(List<RecommendBook> recommendBookList) {
        this.recommendBookList = recommendBookList;
        notifyDataSetChanged();
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
        notifyDataSetChanged();
    }
}
