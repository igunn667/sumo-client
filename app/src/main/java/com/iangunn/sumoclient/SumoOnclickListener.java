package com.iangunn.sumoclient;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TableLayout;

import org.json.JSONException;

/**
 * Created by iangunn on 6/4/16.
 */
public class SumoOnclickListener implements View.OnClickListener {


        TableLayout tableLayout;
        Context context;
        public SumoOnclickListener(TableLayout tableLayout, Context context) {
        this.context = context;
        this.tableLayout = tableLayout;


    }

        @Override
        public void onClick(View view)

        {
            SumoRestClient restClient = new SumoRestClient(tableLayout, context);
            try {
                restClient.getPublicTimeline();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }


}
