package com.github.unithon.unithon.book;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.BookInfo;
import com.github.unithon.unithon.model.Review;
import com.github.unithon.unithon.review.ReviewViewHolder;
import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter {

    private static final int SIZE_OF_HEADER = 1;

    private static final int VIEW_TYPE_BOOK_INFO = 100;
    private static final int VIEW_TYPE_REVIEW = 101;

    private BookInfo bookInfo;
    private List<Review> reviewList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view;
        if(viewType == VIEW_TYPE_BOOK_INFO) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_book_info, parent, false);

            return new BookInfoViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_review, parent, false);

            return new ReviewViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch(getItemViewType(position)) {
            case VIEW_TYPE_BOOK_INFO:
                ((BookInfoViewHolder) holder).bind(bookInfo);
                break;
            case VIEW_TYPE_REVIEW:
                ((ReviewViewHolder) holder).bind(reviewList.get(position - SIZE_OF_HEADER));
                break;
            default:
                throw new IllegalArgumentException("is invalid type");
        }
    }

    @Override
    public int getItemCount() {
        return reviewList.size() + SIZE_OF_HEADER;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return VIEW_TYPE_BOOK_INFO;
        } else {
            return VIEW_TYPE_REVIEW;
        }
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
        notifyDataSetChanged();
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
        notifyDataSetChanged();
    }

}
