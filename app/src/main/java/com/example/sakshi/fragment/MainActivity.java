package com.example.sakshi.fragment;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import org.json.JSONObject;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    String headline;
    String article;


    Fragment head, Fragment_container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.article_layout);
        Fragment rel=(Fragment)findViewById(R.id.fragment1);

        String json = null;
        try {
            InputStream is = getApplication().getAssets().open("news.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Log.d("TEST",json);
            JSONObject obj = new JSONObject(json);

            article=obj.getString("news");
            headline=obj.getString("headline");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        final FragmentHeadline fragmentHeadline=new FragmentHeadline();

        Bundle bundle = new Bundle();
        bundle.putString("headline",headline);
        fragmentHeadline.setArguments(bundle);
        android.app.FragmentManager fragmentManager = getFragmentManager();
        int commit = fragmentManager.beginTransaction().replace(R.id.fragment1, fragmentHeadline).commit();
        fragmentHeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_Article fragmentNews=new Fragment_Article();
                Bundle bundle = new Bundle();
                Fragment fragment=fragmentNews;
                bundle.putString("news",article);
                fragmentNews.setArguments(bundle);
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment2,fragmentNews).commit();


    }
        });
    }
}






//        FragmentManager fragmentManager = getSupportFragmentManager();
//         fragmentManager.beginTransaction().add(R.id.fragment1,headline).commit();


//    }
//}
