package com.h5190001.nizamet_ozkan_final.Activitiy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190001.nizamet_ozkan_final.Models.ListItems;
import com.h5190001.nizamet_ozkan_final.R;
import com.h5190001.nizamet_ozkan_final.Utils.Constants;
import com.h5190001.nizamet_ozkan_final.Utils.GlideUtil;
import com.h5190001.nizamet_ozkan_final.Utils.Objects;

import static com.h5190001.nizamet_ozkan_final.Utils.Constants.SELECTED_ITEM_IMAGE_URL;

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
        String carriedInfo = getIntent().getStringExtra(Constants.SELECTED_ITEM);
        ListItems listItem = Objects.jsonStringToListItem(carriedInfo);

        Header = findViewById(R.id.Header);
        About = findViewById(R.id.About);
        HeaderImg =findViewById(R.id.HeaderImg);

        getHeaderImage(listItem.getBigPic());
        Header.setText(listItem.getName());
        About.setText(listItem.getDetail());
    }
    private  void getHeaderImage(String logo)
    {
        GlideUtil.downloadPicAndShow(getApplicationContext(),logo,HeaderImg);
    }
}