package com.github.unithon.unithon.model;

import java.io.Serializable;
import java.util.List;

public class HomeData implements Serializable {

    private List<RecommendBook> recommendBookList;
    private List<Review> reviewList;

    public List<RecommendBook> getRecommendBookList() {
        return recommendBookList;
    }

    public void setRecommendBookList(List<RecommendBook> recommendBookList) {
        this.recommendBookList = recommendBookList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
