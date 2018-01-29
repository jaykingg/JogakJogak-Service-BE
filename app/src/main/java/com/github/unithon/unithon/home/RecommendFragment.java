package com.github.unithon.unithon.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.book.BookActivity;
import com.github.unithon.unithon.model.RecommendBook;

public class RecommendFragment extends Fragment {

    public static final String KEY_RECOMMEND_BOOK = "recommend_book";

    @BindView(R.id.iv_recommend_book)
    AppCompatImageView ivRecommendBook;

    @BindView(R.id.tv_title)
    AppCompatTextView tvTitle;

    private RecommendBook recommendBook;

    public RecommendFragment() {
    }

    public static RecommendFragment newInstance(RecommendBook recommendBook) {
        RecommendFragment fragment = new RecommendFragment();
        Bundle args = new Bundle();
        args.putSerializable(KEY_RECOMMEND_BOOK, recommendBook);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            recommendBook = (RecommendBook) getArguments().getSerializable(KEY_RECOMMEND_BOOK);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);

        tvTitle.setText(recommendBook.getTitle());

        Glide.with(view)
                .load(recommendBook.getImage())
                .into(ivRecommendBook);

        ivRecommendBook.setOnClickListener(v -> {
            final Intent intent = new Intent(v.getContext(), BookActivity.class);
            intent.putExtra(KEY_RECOMMEND_BOOK, recommendBook);
            startActivity(intent);
        });

        return view;
    }

}
