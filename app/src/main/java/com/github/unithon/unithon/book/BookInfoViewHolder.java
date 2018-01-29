package com.github.unithon.unithon.book;

import static com.github.unithon.unithon.review.ReviewActivity.KEY_ISBN;

import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.BookInfo;
import com.github.unithon.unithon.review.ReviewActivity;

public class BookInfoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_title)
    AppCompatTextView tvTitle;

    @BindView(R.id.tv_author)
    AppCompatTextView tvAuthor;

    @BindView(R.id.iv_book)
    AppCompatImageView ivBook;

    @BindView(R.id.btn_review)
    AppCompatButton btnReview;

    @BindView(R.id.tv_review_count)
    AppCompatTextView tvReviewCount;

    @BindView(R.id.tv_like_count)
    AppCompatTextView tvLikeCount;

    @BindView(R.id.tv_hate_count)
    AppCompatTextView tvHateCount;

    private BookInfo bookInfo;

    public BookInfoViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(BookInfo bookInfo) {
        this.bookInfo = bookInfo;

        if(bookInfo == null) {
            return;
        }

        tvTitle.setText(bookInfo.getTitle());
        tvAuthor.setText(bookInfo.getAuthor());

        Glide.with(itemView.getContext())
                .load(bookInfo.getImage())
                .into(ivBook);

        tvReviewCount.setText(String.valueOf(bookInfo.getReviews()));
        tvLikeCount.setText(String.valueOf(bookInfo.getLikes()));
        tvHateCount.setText(String.valueOf(bookInfo.getHates()));

        btnReview.setOnClickListener(v -> {
            final Intent intent = new Intent(v.getContext(), ReviewActivity.class);
            intent.putExtra(KEY_ISBN, bookInfo.getIsbn());
            v.getContext().startActivity(intent);
        });

    }
}
