package com.h5190001.nizamet_ozkan_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190001.nizamet_ozkan_final.models.ListItems;
import com.h5190001.nizamet_ozkan_final.R;
import com.h5190001.nizamet_ozkan_final.utils.Constants;
import com.h5190001.nizamet_ozkan_final.utils.GlideUtil;
import com.h5190001.nizamet_ozkan_final.utils.Objects;

public class DetailsActivity extends AppCompatActivity {

    ImageView HeaderImg;
    TextView Header, About;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
    }

    private void init(){
        Header = findViewById(R.id.Header);
        About = findViewById(R.id.About);
        HeaderImg =findViewById(R.id.HeaderImg);

        ListItems listItem = getItemInfo();

        getHeaderImage(listItem.getBigPic());
        Header.setText(listItem.getName());
        About.setText(listItem.getDetail());
    }
    private  void getHeaderImage(String logo)
    {
        GlideUtil.downloadPicAndShow(getApplicationContext(),logo,HeaderImg);
    }

    private ListItems getItemInfo(){
        String carriedInfo = getIntent().getStringExtra(Constants.SELECTED_ITEM);
        return Objects.jsonStringToListItem(carriedInfo);
    }
}