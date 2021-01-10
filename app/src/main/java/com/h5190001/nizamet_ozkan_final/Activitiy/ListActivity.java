package com.h5190001.nizamet_ozkan_final.Activitiy;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.h5190001.nizamet_ozkan_final.Adapters.ViewHolders.ListItemAdapter;
import com.h5190001.nizamet_ozkan_final.Models.ListItems;
import com.h5190001.nizamet_ozkan_final.R;
import com.h5190001.nizamet_ozkan_final.Services.Service;
import com.h5190001.nizamet_ozkan_final.Utils.AlertboxUtil;
import com.h5190001.nizamet_ozkan_final.Utils.Constants;
import com.h5190001.nizamet_ozkan_final.Utils.GlideUtil;
import com.h5190001.nizamet_ozkan_final.Utils.Objects;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.h5190001.nizamet_ozkan_final.Utils.Constants.MAIN_HEADER_IMAGE_URL;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imgMainHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();
    }

    private void init(){
        getHeaderImage();
        getItemList();
    }

    @Override
    public void onBackPressed() {
        AlertboxUtil.QuitAlertDialog(getApplicationContext(), ListActivity.this);
    }

    private  void getHeaderImage()
    {
        imgMainHeader =findViewById(R.id.imgMainHeader);
        GlideUtil.downloadPicAndShow(getApplicationContext(),MAIN_HEADER_IMAGE_URL,imgMainHeader);
    }

    void  getItemList()
    {
        ProgressDialog progressDialog = new ProgressDialog(ListActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.loading_items));
        progressDialog.show();

        new Service().getServiceApi().GetListItems().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ListItems>>() {

                    List<ListItems> items=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<ListItems> ListItems) {
                        Log.e("RETROFIT","onNext : ");
                        items=ListItems;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(items.size()>0) {

                            initRecycleView(items);
                        }
                        progressDialog.dismiss();
                    }
                });
    }


    private  void  initRecycleView(List<ListItems> itemList)
    {
        recyclerView =findViewById(R.id.rcvListItems);
        ListItemAdapter listItemAdapter = new ListItemAdapter(itemList, getApplicationContext(), new ListItemAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                ListItems clickedItem = itemList.get(position);
                SetDetailedItem(clickedItem);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(listItemAdapter);
    }

    private void SetDetailedItem(ListItems clicked){
        Intent detailsActivityIntent = new Intent(getApplicationContext(),DetailsActivity.class);
        String clickedItemString = Objects.ListItemToJsonString(clicked);
        detailsActivityIntent.putExtra(Constants.SELECTED_ITEM,clickedItemString);
        startActivity(detailsActivityIntent);

    }
}