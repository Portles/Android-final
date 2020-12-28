package com.h5190001.nizamet_ozkan_final.Activitiy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.h5190001.nizamet_ozkan_final.Adapters.ViewHolders.ListItemAdapter;
import com.h5190001.nizamet_ozkan_final.Models.ListItems;
import com.h5190001.nizamet_ozkan_final.R;
import com.h5190001.nizamet_ozkan_final.Services.Service;
import com.h5190001.nizamet_ozkan_final.Utils.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imgMainHeader;
    String imageUrl ="https://raw.githubusercontent.com/Portles/Android-final/main/GithubAssest/gameforge.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getHeaderImage();
        getItemList();
    }

    private  void getHeaderImage()
    {
        imgMainHeader =findViewById(R.id.imgMainHeader);
        GlideUtil.downloadPicAndShow(getApplicationContext(),imageUrl,imgMainHeader);
    }

    void  getItemList()
    {

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
                    }
                });
    }


    private  void  initRecycleView(List<ListItems> hocaList)
    {
        recyclerView =findViewById(R.id.rcvListItems);
        ListItemAdapter listItemAdapter =new ListItemAdapter(hocaList,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(listItemAdapter);
    }
}