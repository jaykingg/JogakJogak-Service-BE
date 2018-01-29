package com.github.unithon.unithon.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.SearchInfo;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public SearchAdapter() {

    }

    private List<SearchInfo> searchInfos = new ArrayList<>();

    //뷰홀더
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_search, parent, false);

        //final SearchViewHolder searchViewHolder = new SearchViewHolder(view);

        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((SearchViewHolder) holder).bind(searchInfos.get(0));
    }

    @Override
    public int getItemCount()
    {
        return searchInfos.size();
    }

    public void setSearchInfos(List<SearchInfo> searchInfos)
    {
        this.searchInfos = searchInfos;
        notifyDataSetChanged();
    }

}
