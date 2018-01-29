package com.github.unithon.unithon.mypage;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.MyPage;

public class MyPageViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_name)
    AppCompatTextView tvName;

    @BindView(R.id.tv_author)
    AppCompatTextView tvAuthor;

    @BindView(R.id.tv_content)
    AppCompatTextView tvContent;

    @BindView(R.id.iv_book)
    AppCompatImageView ivBook;

    private MyPage myPage;

    public MyPageViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(MyPage myPage) {
        this.myPage = myPage;
        tvName.setText(myPage.title);
        tvAuthor.setText(myPage.author);
        tvContent.setText(myPage.content);

        Glide.with(itemView.getContext())
                .load(myPage.image)
                .into(ivBook);
    }
}
