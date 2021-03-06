package com.example.ass2androidnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainNews extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_news);

        GetDataTask getDataTask = new GetDataTask();
        getDataTask.execute("https://vtc.vn/rss/kinh-te.rss");
    }

    class GetDataTask extends AsyncTask<String, Long, List<TinTuc>> {

        @Override
        protected List<TinTuc> doInBackground(String... strings) {
            List<TinTuc> tinTucs = new ArrayList<>();
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                // khoi tao xmlpullparser
                XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
                xmlPullParserFactory.setNamespaceAware(false);
                XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
                // truyen du lieu vao xmlpullparser roi boc tach
                xmlPullParser.setInput(inputStream, "utf-8");
                int eventType = xmlPullParser.getEventType();

                TinTuc tinTuc = null;
                String text = "";

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String name = xmlPullParser.getName();
                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            if (name.equalsIgnoreCase("item")) {
                                tinTuc = new TinTuc();
                            }
                            break;
                        case XmlPullParser.TEXT:
                            text = xmlPullParser.getText();
                            break;

                        case XmlPullParser.END_TAG:

                            if (tinTuc != null && name.equalsIgnoreCase("title")) {
                                tinTuc.title = text;
                            } else if (tinTuc != null && name.equalsIgnoreCase("description")) {
                                tinTuc.des = text;
                            } else if (tinTuc != null && name.equalsIgnoreCase("link")) {
                                tinTuc.id = text;
                            } else if (tinTuc != null && name.equalsIgnoreCase("pubDate")) {
                                tinTuc.pubDate = text;
                            } else if (name.equalsIgnoreCase("item")) {
                                tinTucs.add(tinTuc);
                            }

                            break;
                    }

                    eventType = xmlPullParser.next();
                }

            } catch (Exception e) {
            }
            return tinTucs;
        }

        @Override
        protected void onPostExecute(List<TinTuc> tinTucs) {
            super.onPostExecute(tinTucs);
            ArrayAdapter arrayAdapter = new ArrayAdapter(MainNews.this, android.R.layout.simple_list_item_1, getTitle(tinTucs));
            listView = findViewById(R.id.listView);
            listView.setAdapter(arrayAdapter);

            Toast.makeText(MainNews.this, "size  " + tinTucs.size(), Toast.LENGTH_SHORT).show();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Toast.makeText(MainActivity.this, "id : "+tinTucs.get(position).getId(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainNews.this, WebView.class);
                    intent.putExtra("link", tinTucs.get(position).getId());
                    startActivity(intent);
                }
            });
        }
    }

    List<String> getTitle(List<TinTuc> tinTucs) {
        List list = new ArrayList();
        for (int i = 0; i < tinTucs.size(); i++) {
            String a = tinTucs.get(i).getTitle() + "\n\n" + tinTucs.get(i).getPubDate();
            list.add(a);
        }
        return list;
    }
}