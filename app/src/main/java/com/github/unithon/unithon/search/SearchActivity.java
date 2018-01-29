package com.github.unithon.unithon.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.SearchInfo;
import com.github.unithon.unithon.network.UnithonService;
import com.github.unithon.unithon.network.model.SearchResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity{
    //카드 클릭시 -> bookActivity로
    //Search View
    EditText editText;
    Button searchButton;
    Button XButton;

    //book title
    String Booktitle = null;

    //RecyclerView
    //@BindView(R.id.search_recycler_view)
    private RecyclerView mRecyclerView;


    private final SearchAdapter mAdapter = new SearchAdapter();
    private RecyclerView mLayoutManager;
    //private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = (EditText)findViewById(R.id.SearchText);
        searchButton = (Button)findViewById(R.id.SearchButton);
        XButton = (Button)findViewById(R.id.Xbutton);

        mRecyclerView = (RecyclerView) findViewById(R.id.search_recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

        //여기가 문제
        mRecyclerView.setAdapter(mAdapter);


        ButterKnife.bind(this);
        //settingview();

        //Button
        searchButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Booktitle = editText.getText().toString();
                //if(Booktitle != null) {
                    //Toast.makeText(getApplicationContext(), Booktitle, Toast.LENGTH_LONG).show();
                    //값은 여기서  날릴거임
                    //settingview();
                    bindSearchInfo();
                //}
            }
        });

        //Button
        XButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });

    }

    private void settingview()
    {
        //mRecyclerView = (RecyclerView) findViewById(R.id.search_recycler_view);
        //mRecyclerView.setHasFixedSize(true);//옵션
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //mRecyclerView.setLayoutManager(mLayoutManager);
        //mRecyclerView.setAdapter(mAdapter);

    }


    private void bindSearchInfo()
    {
        UnithonService.getInstance().getSearchResponse("클린 코드").enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if(response.isSuccessful()) {
                    final SearchResponse mySearchResponse = response.body();


                    final List<SearchInfo> searchInfos = mySearchResponse.items;

                    //Toast.makeText(getApplicationContext(), searchInfos.get(1).title, Toast.LENGTH_LONG).show();

                    if(searchInfos != null && searchInfos.size() > 0) {
                        final List<SearchInfo> searchInfoList = searchInfos.subList(0,1);
                        mAdapter.setSearchInfos(searchInfoList);
//                        if(searchInfos.size() > 5) {
//                            mAdapter.setSearchInfos(searchInfos.subList(0, 4));
//                        } else {
//                            mAdapter.setSearchInfos(searchInfos);
//                        }
                        //Toast.makeText(getApplicationContext(), searchInfos.get(0).getIsbn().toString(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {

            }
        });
    }
}