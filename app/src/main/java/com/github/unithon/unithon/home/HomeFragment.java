package com.github.unithon.unithon.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.BookInfo;
import com.github.unithon.unithon.model.RecommendBook;
import com.github.unithon.unithon.model.Review;
import com.github.unithon.unithon.network.UnithonService;
import com.github.unithon.unithon.network.model.RecommendResponse;
import com.github.unithon.unithon.network.model.RecommendReviewResponse;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    public static final String TAG = HomeFragment.class.getName();

    @BindView(R.id.rv_home)
    RecyclerView rvHome;

    private HomeAdapter homeAdapter;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        initView();

        return view;
    }

    private void initView() {
        homeAdapter = new HomeAdapter(getFragmentManager());
        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHome.setAdapter(homeAdapter);

        UnithonService.getInstance().getRecommendResponse().enqueue(new Callback<RecommendResponse>() {
            @Override
            public void onResponse(Call<RecommendResponse> call, Response<RecommendResponse> response) {
                if(response.isSuccessful()) {
                    final RecommendResponse recommendResponse = response.body();
                    final List<RecommendBook> recommendBooks = recommendResponse.response;

                    if(recommendBooks != null && recommendBooks.size() > 0) {
                        homeAdapter.setRecommendBookList(recommendBooks);
                    }
                }
            }

            @Override
            public void onFailure(Call<RecommendResponse> call, Throwable t) {

            }
        });

        UnithonService.getInstance().getRecommendReviewResponse().enqueue(new Callback<RecommendReviewResponse>() {
            @Override
            public void onResponse(Call<RecommendReviewResponse> call, Response<RecommendReviewResponse> response) {
                if(response.isSuccessful()) {
                    final RecommendReviewResponse recommendReviewResponse = response.body();

                    if(recommendReviewResponse != null) {
                        homeAdapter.setReviewList(recommendReviewResponse.response);
                    }
                }
            }

            @Override
            public void onFailure(Call<RecommendReviewResponse> call, Throwable t) {

            }
        });
    }
}
