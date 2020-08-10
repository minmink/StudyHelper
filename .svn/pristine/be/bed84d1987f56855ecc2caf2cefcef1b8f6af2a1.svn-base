package edu.skku.finalproject.studyhelper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.skku.finalproject.studyhelper.dto.MapJsonData;

public class ScrollingActivity extends AppCompatActivity {
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvResult = findViewById(R.id.tv_result);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                // 중간 위경도
                LatLng latLng = getCenterLatLng();  //todo: 위경도 입력받아 리스트로 전달하게 바꿔야함
                String latLngStr = latLng.latitude + "," + latLng.longitude;
                new HttpThread(1, "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+latLngStr+"&radius=2000&type=cafe&key=AIzaSyC-3hf2hNZk89OQcXeoIbZvUcYXN0Jg5LI&language=ko").start();
            }
        });
    }

    private LatLng getCenterLatLng(){
        LatLngBounds.Builder builder = LatLngBounds.builder();
        LatLng[] latLngs = {new LatLng(37.588212, 126.994176), new LatLng(37.588484, 126.997738),new LatLng(37.586988, 126.997877),new LatLng(37.584199, 126.996493)};
        for (LatLng latlng : latLngs){
            builder.include(latlng);
        }
        LatLngBounds bounds = builder.build();
        return bounds.getCenter();
    }


    private class HttpThread extends Thread {
        int code;
        String urlString;

        public HttpThread(int code, String urlString) {
            this.code = code;
            this.urlString = urlString;
        }

        @Override
        public void run() {
            Message msg = new Message();
            try {
                URL url = new URL(urlString);

                HttpURLConnection http = (HttpURLConnection) url.openConnection();

                http.setConnectTimeout(5 * 1000);
                http.setReadTimeout(5 * 1000);

                BufferedReader in = new BufferedReader(new InputStreamReader(
                        http.getInputStream(), "utf-8"));
                StringBuffer sb = new StringBuffer();

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    Log.d("inputline", inputLine);
                    sb.append(inputLine);
                }

                msg.what = code;
                msg.obj = sb.toString();
                handler.sendMessage(msg);

                Log.d("response", sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
                msg.what = 0;
                msg.obj = e.getLocalizedMessage();
                handler.sendMessage(msg);
            }

        }
    }//HttpThread

    Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case 0: {
                   break;
                }
                case 1: {
                    String jsonString = (String) msg.obj;
                    Gson gson = new Gson();
                    MapJsonData mapJsonData = gson.fromJson(jsonString, MapJsonData.class);
                    MapJsonData.ResultClass[] results = mapJsonData.results;
                    String names = "";
                    String[] urls = new String[results.length];
                    // todo: 리사이클러뷰로 카페 목록 리스트로 보여주고, 지도보기 누르면 지도로 띄워주고, 자세히 보기를 누르면 url로 place 창 띄워줌. 장소 선택 기능도 만들어야함
                    for (int idx = 0; idx < results.length; idx++) {
                        names += results[idx].name + "\n";
                        urls[idx] = "https://www.google.com/maps/search/?api=1&query=" + results[idx].name +"&query_place_id=" + results[idx].place_id;
                    }
//                    MapJsonData.WeatherClass[] weatherArr = mapJsonData.getWeather();
//                    MapJsonData.WeatherClass weather = weatherArr[0];
//                    int iconId = weather.getId();
//                    int iconResourceId = getResources().getIdentifier("wi_owm_day_" + iconId, "string", getPackageName());
//                    String iconResourceString = getString(iconResourceId);
//                    String wDescription = weather.getDescription();
//                    double wTemp = mapJsonData.getMain().getTemp();
//                    tvWeatherDescription.setText(wDescription.toUpperCase());
//                    tvWeatherTemp.setText(wTemp + " °C");
//                    iconWeather.setText(iconResourceString);
//
                    tvResult.setText(urls[0]);
                    break;
                }
                case 2: {

                    break;
                }
            }
        }
    };

}
