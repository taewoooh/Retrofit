package com.example.taewoo.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHub {
    // GET/POST/DELETE/PUT 메소드들을 인터페이스에 구현하여 사용할 수 있다.
    @GET("/mysqlexport2.php")
    // JSON Array를 리턴하므로 List<>가 되었다
    Call<List<Contributor>> contributors(@Query("naljja") String naljja);
}