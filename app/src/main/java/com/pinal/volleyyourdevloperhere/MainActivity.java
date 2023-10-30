package com.pinal.volleyyourdevloperhere;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String api = "https://jsonplaceholder.typicode.com/photos";
    List<UserModel> list = new ArrayList<>();
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerview);
        getData();
    }

    public void getData() {
        RequestQueue queue = Volley.newRequestQueue(this);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, api,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.e("error", "onErrorResponse: " + response.toString());

                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject singleObject = jsonArray.getJSONObject(i);
                                int albumid = singleObject.getInt("albumId");
                                int id = singleObject.getInt("id");
                                String title = singleObject.getString("title");
                                String url = singleObject.getString("url");
                                String thumbnailUrl = singleObject.getString("thumbnailUrl");
                                UserModel userModel = new UserModel(albumid, id, title, url, thumbnailUrl);

                                list.add(userModel);

                                recyclerview.setAdapter(new AdapterClass(list,MainActivity.this));

                                Log.e("userlist", "onResponse: " + list.size());
                                Toast.makeText(MainActivity.this, list.size(), Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            Log.e("api", "onResponse: " + e.getMessage());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "onErrorResponse: ");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}