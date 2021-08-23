package com.example.retrofit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private final String BASE_URL = "https://taewoooh88.cafe24.com/";
    Retrofit retrofit;

    ArrayList<ListViewItem> listViewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewItems = new ArrayList<>();


        //Tongsin("DAY20210821");
        Tongsin("은마","76.79","11680");

    }


    public void init() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        // GSON 컨버터를 사용하는 REST 어댑터 생성
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public void Tongsin(String name,String area, String jiyeokcode) { // 서버 데이터를 가지고 온다 파라미터는 불러올 테이블 이름


        init();
        GitHub gitHub = retrofit.create(GitHub.class);
        Call<List<ListViewItem>> call = gitHub.contributors(name,area,jiyeokcode);
        call.enqueue(new Callback<List<ListViewItem>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            // 성공시
            public void onResponse(Call<List<ListViewItem>> call, Response<List<ListViewItem>> result) {
                List<ListViewItem> contributors = result.body();
                // 받아온 리스트를 순회하면서

                Log.e("Test888", result.body().toString());

                for (ListViewItem contributor : contributors) {


                    String name = contributor.name;
                    String price = contributor.price;
                    String area = contributor.area;
                    String year = contributor.year;
                    String month = contributor.month;
                    String day = contributor.day;
                    String high = contributor.high;
                    String doromyung = contributor.doromyung;
                    String jibun = contributor.jibun;
                    String geunmulcode = contributor.geunmulcode;
                    String jiyeokcode = contributor.jiyeokcode;
                    String bupjungdong = contributor.bupjungdong;
                    String gunchukyear = contributor.gunchukyear;
                    String today = contributor.today;

//                    String hightprice = contributor.hightprice;
//                    String hightyear = contributor.hightyear;
//                    String hightmonth = contributor.hightmonth;
//                    String hightday = contributor.hightday;
//                    String chaik = contributor.chaik;
//
//                    String pyungmyuendo = contributor.pyungmyuendo;
//                    String chongdongsu = contributor.chongdongsu;
//                    String chongsedaesu = contributor.chongsedaesu;
//                    String juchadaesu = contributor.juchadaesu;
//                    String pyungeunjucha = contributor.pyungeunjucha;
//                    String yongjeukryul = contributor.yongjeukryul;
//                    String gunpaeyul = contributor.gunpaeyul;
//                    String ganrisamuso = contributor.ganrisamuso;
//                    String nanbang = contributor.nanbang;
//                    String gunseoulsa = contributor.gunseoulsa;
//                    String jihachul = contributor.jihachul;
//                    String mart = contributor.mart;
//                    String hospital = contributor.hospital;
//                    String park = contributor.park;
//                    String cho = contributor.cho;
//                    String jung = contributor.jung;
//                    String go = contributor.go;
//                    String arin = contributor.arin;
//                    String you = contributor.you;


                    Log.e("dhxodn88",""+name+" / "+price+" / "+area+" / "+year+"."+month+"."+day+" / "+high+" / "+doromyung+" / "+jibun+" / " +
                            " / "+geunmulcode+" / "+jiyeokcode+" / "+bupjungdong+" / "+gunchukyear +" / "+today);










                    month = month.replace(",", "");

                    listViewItems.add(new ListViewItem(name, price, area, year, month, day,
                            high, doromyung, jibun, geunmulcode,
                            jiyeokcode, bupjungdong, gunchukyear, today));
                    Collections.sort(listViewItems);




                }


            }

            @Override
            public void onFailure(Call<List<ListViewItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "정보받아오기 실패 "+t, Toast.LENGTH_LONG)
                        .show();

                Log.e("onFailure","- > "+t);

            }
        });


    }
}