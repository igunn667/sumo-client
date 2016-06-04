package com.iangunn.sumoclient;

import android.content.Context;
import android.graphics.Color;
import android.preference.PreferenceActivity;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import cz.msebera.android.httpclient.Header;

/**
 * Created by iangunn on 6/4/16.
 */
public class SumoRestClient {
    private static final String TAG = "SumoRestClient";

//    TextView text;
 TableLayout table;
    Context context;
    public SumoRestClient(TableLayout layout, Context contxt) {
        this.context = contxt;
        this.table = layout;
    }


    public void getPublicTimeline() throws JSONException {
        RestHelper.get("/", null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d(TAG,"I got a succesfull json object!");
                // If the response is JSONObject instead of expected JSONArray
            }
            @Override
            public void onFailure(int statusCode, Header[] headers,Throwable throwable, JSONObject response) {
                Log.d(TAG,"I failed to get json object!");

                boolean t = false;

                // If the response is JSONObject instead of expected JSONArray
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray dashboards) {
                Log.d(TAG,"I  got a json Array!");
                String t = "";
                try {
                    for(int i =0; i < dashboards.length(); i++){
                        JSONObject dashboard = dashboards.getJSONObject(i);
                        String  dashboardString =  dashboard.getString("title");
                        if(dashboardString.length() >20){
                            dashboardString = dashboardString.substring(0,20);

                        }
                        TableRow tableRow = new TableRow(context);
                        TextView dashText = new TextView(context);
                        Button button = new Button(context);
                        button.setText("Go!");
                        button.setTextColor(Color.BLACK);
                        dashText.setText( dashboardString);
                        dashText.setTextColor(Color.BLACK);
                        tableRow.addView(dashText);
                        tableRow.addView(button);
                        table.addView(tableRow);

                        JSONArray monitors = (JSONArray) dashboard.get("monitors");
                        for(int j =0; j < monitors.length() ; j++ ){
                            try {
                                JSONObject monitor = (JSONObject) monitors.get(i);
                                String monitorString = monitor.getString("title");
                                String query = monitor.getString("query");
                                Log.d(TAG, "Dashboard  " + dashboardString);
                                Log.d(TAG, "Moitor  " + monitorString);
                                Log.d(TAG, "Query  " + query);


//                                TextView monitorText = new TextView(context);
//                                monitorText.setText("Montor " + monitorString);
//                                monitorText.setTextColor(Color.BLACK);

//                                tableRow.addView(monitorText);

                                t = t + "Dashboard  " + dashboardString;
                            }
                            catch (Exception e){

                            }
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                // Do something with the response

            }
        });
    }
}
