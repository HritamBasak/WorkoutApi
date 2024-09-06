package com.example.workoutapi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.util.UnstableApi;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.workoutapi.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adapter.Adapter;
import Model.Model;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Adapter adapter;
    String url="https://work-out-api1.p.rapidapi.com/search?Muscles=biceps";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getData();
    }
    public void getData() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{
                            ArrayList<Model> list=new ArrayList<>();
                            for(int i=0;i<response.length();i++){
                                JSONObject jsonObject=response.getJSONObject(i);
                                String muscles=jsonObject.getString("Muscles");
                                String workout=jsonObject.getString("WorkOut");
                                String intensity=jsonObject.getString("Intensity_Level");
                                String beginnersets=jsonObject.getString("Beginner Sets");
                                String intermediatesets=jsonObject.getString("Intermediate Sets");
                                String expertsets=jsonObject.getString("Expert Sets");
                                String equipment=jsonObject.getString("Equipment");
                                String explanation=jsonObject.getString("Explaination");
                                String longexplanation=jsonObject.getString("Long Explanation");
                                String link=jsonObject.getString("Video");
                                list.add(new Model(muscles,workout,intensity,beginnersets,intermediatesets,expertsets,equipment,explanation,longexplanation,link));
                            }
                            adapter = new Adapter(list, MainActivity.this);
                            binding.recyclerView.setAdapter(adapter);
                            binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @OptIn(markerClass = UnstableApi.class)
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VolleyError", error.toString());
                Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        }) {
            // Add headers if required (as in the previous response)
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("X-RapidAPI-Key", "17585a0949msh450614c5ce486b9p1b6d50jsn658b28a29cf1"); // Replace with your actual key
                headers.put("X-RapidAPI-Host", "work-out-api1.p.rapidapi.com");
                return headers;
            }
        };
        queue.add(request);
    }
}