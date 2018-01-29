package com.github.unithon.unithon.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.book.BookActivity;
import com.github.unithon.unithon.model.BookInfo;
import com.github.unithon.unithon.model.MyPage;
import com.github.unithon.unithon.model.RecommendBook;
import com.github.unithon.unithon.model.SearchInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.github.unithon.unithon.home.RecommendFragment.KEY_RECOMMEND_BOOK;

public class SearchViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.search_Bookname)
    AppCompatTextView Bookname;

    @BindView(R.id.search_writer)
    AppCompatTextView Writer;

    @BindView(R.id.search_Book)
    AppCompatImageView BookImg;

    private SearchInfo searchInfo;

   // public static final String KEY_VALUE = "key_value";

    public SearchViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(SearchInfo searchInfo) {
        this.searchInfo = searchInfo;
        if(searchInfo == null)
        {
            return;
        }
        Bookname.setText(searchInfo.getTitle());
        Writer.setText(searchInfo.getAuthor());

        Glide.with(itemView.getContext())
                .load(searchInfo.getImage())
                .into(BookImg);

        /*
        *     private String isbn;
    private String title;
    private String author;
    private String image;*/
        final RecommendBook rmb = new RecommendBook();
        rmb.setIsbn(searchInfo.getIsbn());
        rmb.setTitle(searchInfo.getTitle());
        rmb.setAuthor(searchInfo.getAuthor());
        rmb.setImage(searchInfo.getImage());


        //List<RecommendBook> intentinfo = new ArrayList<>();

        //intentinfo.add(rmb);

        BookImg.setOnClickListener(v -> {
            final Intent intent = new Intent(v.getContext(), BookActivity.class);
            //Bundle bundle = new Bundle();
            //bundle.putSerializable(KEY_RECOMMEND_BOOK,rmb);
            //intent.putExtras(bundle);

            intent.putExtra(KEY_RECOMMEND_BOOK,rmb);
            v.getContext().startActivity(intent);
        });
    }
}
