package com.github.unithon.unithon.mypage;


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
import com.github.unithon.unithon.model.MyPage;
import com.github.unithon.unithon.network.UnithonService;
import com.github.unithon.unithon.network.model.MyPageResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPageFragment extends Fragment {

    public static final String TAG = MyPageFragment.class.getName();

    @BindView(R.id.rv_mypage)
    RecyclerView rvMyPage;

    private final MyPageAdapter myPageAdapter = new MyPageAdapter();

    public MyPageFragment() { }

    public static MyPageFragment newInstance() {
        MyPageFragment fragment = new MyPageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_mypage, container, false);

        ButterKnife.bind(this, view);

        initializeView();
        bindReview();

        return view;
    }

    private void initializeView() {
        rvMyPage.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMyPage.setAdapter(myPageAdapter);
    }

    private void bindReview() {
        UnithonService.getInstance().getMyPages("ojh102").enqueue(new Callback<MyPageResponse>() {

            @Override
            public void onResponse(Call<MyPageResponse> call, Response<MyPageResponse> response) {
                if(response.isSuccessful()) {
                    final MyPageResponse myPageResponse = response.body();
                    final List<MyPage> myPages = myPageResponse.response;

                    if(myPages != null && myPages.size() > 0) {
                        myPageAdapter.setMyPageList(myPages);
                    }
                }
            }

            @Override
            public void onFailure(Call<MyPageResponse> call, Throwable t) {

            }
        });
    }
}
