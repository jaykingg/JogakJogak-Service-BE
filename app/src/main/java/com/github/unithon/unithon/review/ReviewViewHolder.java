package com.github.unithon.unithon.review;

import static com.github.unithon.unithon.review.ReviewActivity.KEY_ISBN;

import android.content.Intent;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.Review;
import com.github.unithon.unithon.network.UnithonService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_id)
    AppCompatTextView tvId;

    @BindView(R.id.tv_content)
    AppCompatTextView tvContent;

    @BindView(R.id.iv_like)
    AppCompatImageView ivLike;

    private Review review;

    public ReviewViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(v -> {
            final Intent intent = new Intent(v.getContext(), ReviewActivity.class);
            intent.putExtra(KEY_ISBN, review.getIsbn());
            v.getContext().startActivity(intent);
        });

        ivLike.setOnClickListener(v -> {
            if(review.isLike()) {
                UnithonService.getInstance().unLike(review.getId(), review.getIsbn(), "ojh102").enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.isSuccessful()) {
                            review.setLike(false);
                            drawLike();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            } else {
                UnithonService.getInstance().like(review.getId(), review.getIsbn(), "ojh102").enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.isSuccessful()) {
                            review.setLike(true);
                            drawLike();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }

        });
    }

    public void bind(Review review) {
        this.review = review;

        tvId.setText(review.getId());
        tvContent.setText(review.getContent());

        drawLike();
    }

    private void drawLike() {
        Glide.with(itemView.getContext())
                .load(review.isLike() ? R.drawable.heart_on : R.drawable.heart_off)
                .into(ivLike);
    }

}
