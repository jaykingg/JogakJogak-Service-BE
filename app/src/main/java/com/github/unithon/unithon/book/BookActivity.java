package com.github.unithon.unithon.book;

import static com.github.unithon.unithon.home.RecommendFragment.KEY_RECOMMEND_BOOK;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.BookInfo;
import com.github.unithon.unithon.model.BookSentiment;
import com.github.unithon.unithon.model.RecommendBook;
import com.github.unithon.unithon.model.Review;
import com.github.unithon.unithon.network.UnithonService;
import com.github.unithon.unithon.network.model.BookResponse;
import com.github.unithon.unithon.util.PollyHelper;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookActivity extends AppCompatActivity {

    @BindView(R.id.rv_book)
    RecyclerView rvBook;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private BookAdapter bookAdapter = new BookAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        ButterKnife.bind(this);

        initializeToolbar();
        initializeRecyclerView();
        bindData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeToolbar() {
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
    }

    private void initializeRecyclerView() {
        rvBook.setLayoutManager(new LinearLayoutManager(this));
        rvBook.setAdapter(bookAdapter);
    }

    private void bindData() {

        final RecommendBook recommendBook = (RecommendBook) getIntent().getSerializableExtra(KEY_RECOMMEND_BOOK);

        UnithonService.getInstance().getBookResponse(recommendBook.getIsbn()).enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                if(response.isSuccessful()) {
                    final BookResponse bookResponse = response.body();

                    final BookSentiment bookSentiment = bookResponse.response;
                    final BookInfo bookInfo = new BookInfo();

                    bookInfo.setIsbn(recommendBook.getIsbn());
                    bookInfo.setTitle(recommendBook.getTitle());
                    bookInfo.setAuthor(recommendBook.getAuthor());
                    bookInfo.setImage(recommendBook.getImage());
                    bookInfo.setReviews(bookSentiment.total);
                    bookInfo.setLikes(bookSentiment.like);
                    bookInfo.setHates(bookSentiment.hate);

                    bookAdapter.setBookInfo(bookInfo);

                    final List<Review> reviewList = bookResponse.review;

                    if(reviewList != null && reviewList.size() > 0) {
                        if(reviewList.size() > 5) {
                            bookAdapter.setReviewList(reviewList.subList(0, 4));
                        } else {
                            bookAdapter.setReviewList(reviewList);
                        }
                    }

                    PollyHelper.getInstance().playPolly(recommendBook.getTitle());

                }
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {

            }
        });
    }
}
