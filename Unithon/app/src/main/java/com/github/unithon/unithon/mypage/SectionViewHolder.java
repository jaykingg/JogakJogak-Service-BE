package com.github.unithon.unithon.mypage;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;

public class SectionViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_section)
    AppCompatTextView tvSection;

    private String sectionText;

    public SectionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String sectionText) {
        this.sectionText = sectionText;
        tvSection.setText(sectionText);
    }
}
