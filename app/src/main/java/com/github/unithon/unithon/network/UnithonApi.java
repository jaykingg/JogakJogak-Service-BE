package com.github.unithon.unithon.network;

import com.github.unithon.unithon.model.MyPage;
import com.github.unithon.unithon.model.SearchInfo;
import com.github.unithon.unithon.network.model.BookResponse;
import com.github.unithon.unithon.network.model.MyPageResponse;
import com.github.unithon.unithon.network.model.RecommendResponse;
import com.github.unithon.unithon.network.model.RecommendReviewResponse;
import com.github.unithon.unithon.network.model.SearchResponse;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface UnithonApi {
  
    @GET("/recommend_book")
    Call<RecommendResponse> getRecommendRespose();

    @GET("/great_review")
    Call<RecommendReviewResponse> getRecommendReviewResponse();

    @GET("/search_book/search/book")
    Call<SearchResponse> getSearchResponse(@Query("query") String title);

    @FormUrlEncoded
    @POST("/get_my_review")
    Call<MyPageResponse> getMyPages(@Field("id") String id);

    @FormUrlEncoded
    @POST("/get_book_review")
    Call<BookResponse> getBookResponse(@Field("isbn") String isbn);

    @FormUrlEncoded
    @PUT("/push_like")
    Call<Void> like(
            @Field("id") String id,
            @Field("isbn") String isbn,
            @Field("member_id") String memberId
    );

    @FormUrlEncoded
    @PUT("/remove_like")
    Call<Void> unLike(
            @Field("id") String id,
            @Field("isbn") String isbn,
            @Field("member_id") String name //접속 회원
    );

}
