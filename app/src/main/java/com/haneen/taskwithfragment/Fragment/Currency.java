package com.haneen.taskwithfragment.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.haneen.taskwithfragment.R;

import org.json.JSONException;
import org.json.JSONObject;


public class Currency extends Fragment {
    EditText amount;
    TextView EUR,AED,USD,GBP;
    String url;
    Button Convert;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_currency, container, false);
        amount = view.findViewById(R.id.editTextNumber);
        Convert = view.findViewById(R.id.button2);
        EUR =view.findViewById(R.id.EURValue);
        AED =view.findViewById(R.id.AEDValue);
        USD =view.findViewById(R.id.USDValue);
        GBP =view.findViewById(R.id.GBPValue);
        Convert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//
                System.out.println("URL: " + url);
                url = "https://api.apilayer.com/fixer/convert?to=EUR&from=KWD&amount=" + amount.getText().toString() + "&apikey=PkxRBFn5iSacIOm9eTDSPvfbSENIGBGn";
                Json(url,EUR);
                System.out.println("URL: " + url);

                url = "https://api.apilayer.com/fixer/convert?to=AED&from=KWD&amount=" + amount.getText().toString() + "&apikey=PkxRBFn5iSacIOm9eTDSPvfbSENIGBGn";
                Json(url,AED);
                System.out.println("URL: " + url);
                url = "https://api.apilayer.com/fixer/convert?to=USD&from=KWD&amount=" + amount.getText().toString() + "&apikey=PkxRBFn5iSacIOm9eTDSPvfbSENIGBGn";
                Json(url,USD);
                System.out.println("URL: " + url);
                url = "https://api.apilayer.com/fixer/convert?to=GBP&from=KWD&amount=" + amount.getText().toString() + "&apikey=PkxRBFn5iSacIOm9eTDSPvfbSENIGBGn";
                Json(url,GBP);

            }
        });
        return view;
    }
    public void Json(String url1,TextView Currency ) {

        // System.out.println("inside json");

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println("inside ");
                    System.out.println("Currency" +Currency);

                    String result = response.getString("result");
                    System.out.println(result);
                    Currency.setVisibility(View.VISIBLE);
                    Currency.setText(result);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        Volley.newRequestQueue(getActivity().getApplicationContext()).add(request);
    }

}