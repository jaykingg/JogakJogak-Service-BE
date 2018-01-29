package com.github.unithon.unithon.review;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.network.UnithonService;
import com.github.unithon.unithon.network.model.BookResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewActivity extends AppCompatActivity {

    public static final String KEY_ISBN = "key_isbn";

    @BindView(R.id.rv_review)
    RecyclerView rvReview;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private final ReviewAdapter reviewAdapter = new ReviewAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ButterKnife.bind(this);
        initializeToolbar();

        final String isbn = getIntent().getStringExtra(KEY_ISBN);

        rvReview.setLayoutManager(new LinearLayoutManager(this));
        rvReview.setAdapter(reviewAdapter);

        UnithonService.getInstance().getBookResponse(isbn).enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                if(response.isSuccessful()) {
                    final BookResponse bookResponse = response.body();

                    if(bookResponse != null && bookResponse.review != null && bookResponse.review.size() > 0) {
                        reviewAdapter.setReviewList(bookResponse.review);
                    }
                }
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {

            }
        });

    }


    private void initializeToolbar() {
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
