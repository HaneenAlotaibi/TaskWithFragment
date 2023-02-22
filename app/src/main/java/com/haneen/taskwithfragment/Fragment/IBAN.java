package com.haneen.taskwithfragment.Fragment;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.haneen.taskwithfragment.R;



public class IBAN extends Fragment {
    TextView IBAN;
    String url;
    EditText Edit;
    Button Button;
    TextView text;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view= inflater.inflate(R.layout.fragment_iban, container, false);
        Button=view.findViewById(R.id.button);
        Edit = view.findViewById(R.id.IBANID);
        IBAN = view.findViewById(R.id.textView2);
        text = view.findViewById(R.id.text);
        Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("mEdit: " + Edit.getText().toString());
                url = "https://api.apilayer.com/bank_data/iban_validate?iban_number=" + Edit.getText().toString() + "&apikey=PkxRBFn5iSacIOm9eTDSPvfbSENIGBGn";
                System.out.println("URL: " + url);
                Json(url);
            }
        });

        return view;
    }
    public void Json(String url1) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String iban = response.getString("message");
                    IBAN.setVisibility(View.VISIBLE);
                    IBAN.setText(iban);
                } catch (JSONException e) {
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                IBAN.setVisibility(View.VISIBLE);
                IBAN.setText("IBAN number is invalid");

            }
        });
        System.out.println(IBAN.getText().toString());
        Volley.newRequestQueue(getActivity().getApplicationContext()).add(request);    }

}
