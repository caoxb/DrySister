package com.coderpig.drysister;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.coderpig.drysister.bean.Sister;
import com.coderpig.drysister.db.SisterDBHelper;
import com.coderpig.drysister.imgloader.SisterLoader;
import com.coderpig.drysister.service.SisterApi;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button showBtn;
    private Button refreshBtn;
    private ImageView showImg;

    private ArrayList<Sister> data;
    private int curPos = 0; //当前显示的是哪一张
    private int page = 1;   //当前页数
    //private PictureLoader loader;
    private SisterApi sisterApi;
    private SisterTask sisterTask;
    private SisterLoader mLoader;
    private SisterDBHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sisterApi = new SisterApi();
        //loader = new PictureLoader();
        mLoader = SisterLoader.getInstance(MainActivity.this);
        mDbHelper = SisterDBHelper.getInstance();
        initData();
        initUI();
    }

    private void initUI() {
        showBtn = findViewById(R.id.btn_show);
        refreshBtn = findViewById(R.id.btn_refresh);
        showImg = findViewById(R.id.img_show);

        showBtn.setOnClickListener(this);
        refreshBtn.setOnClickListener(this);
    }

    private void initData() {
        data = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show:
                if (data != null && !data.isEmpty()) {
                    if (curPos > 9) {
                        curPos = 0;
                    }
                    //loader.load(showImg, data.get(curPos).getUrl());
                    mLoader.bindBitmap(data.get(curPos).getUrl(), showImg, 400, 400);
                    curPos++;
                }
                break;
            case R.id.btn_refresh:
                page++;
                sisterTask = new SisterTask();
                sisterTask.execute();
                curPos = 0;
                break;
        }
    }

    private class SisterTask extends AsyncTask<Void, Void, ArrayList<Sister>> {

        public SisterTask() {
        }

        @Override
        protected ArrayList<Sister> doInBackground(Void... params) {
            ArrayList<Sister> result = new ArrayList<>();
            Log.v("MainActivity", mDbHelper.getSistersCount() + "");
            if (mDbHelper.getSistersCount() < page * 10) {
                result = sisterApi.fetchSister(10, page);
                mDbHelper.insertSisters(data);
            } else {
                result.clear();
                result.addAll(mDbHelper.getSistersLimit(page, 10));
            }
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Sister> sisters) {
            super.onPostExecute(sisters);
            data.clear();
            data.addAll(sisters);
            mDbHelper.insertSisters(sisters);
            page++;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            sisterTask.cancel(true);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sisterTask != null) {
            sisterTask.cancel(true);
        }
    }
}
