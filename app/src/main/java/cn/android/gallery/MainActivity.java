package cn.android.gallery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GalleryLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.SpaceItemDecoration;
import android.widget.ImageView;

import cn.android.gallery.adapter.GalleryAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView large_photo;
    private RecyclerView list_photo;

    private GlideRequests glideRequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        glideRequests = GlideApp.with(MainActivity.this);
        initView();
        initLayoutManager();
        initAdapter();
    }

    private void initView() {
        large_photo = findViewById(R.id.large_photo);
        list_photo = findViewById(R.id.list_photo);
        final SpaceItemDecoration itemDecoration = new SpaceItemDecoration(getApplicationContext(), 6);
        large_photo.addItemDecoration(itemDecoration);
        list_photo.addItemDecoration(itemDecoration);
    }

    private void initLayoutManager() {
        final RecyclerView.LayoutManager verticalManager = new GalleryLayoutManager(this, LinearLayoutManager.VERTICAL, false, 3, 24);
        large_photo.setLayoutManager(verticalManager);
        final RecyclerView.LayoutManager linearManager = new GalleryLayoutManager(this, LinearLayoutManager.HORIZONTAL, false, 3, 24);
        list_photo.setLayoutManager(linearManager);
        final SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(list_photo);
    }

    private void initAdapter() {
        large_photo.setAdapter(new GalleryAdapter() {
            @Override
            public void loadImage(ImageView view, String url) {
                glideRequests.load(url).into(view);
            }
        });
        list_photo.setAdapter(new GalleryAdapter() {
            @Override
            public void loadImage(ImageView view, String url) {
                glideRequests.load(url).centerCrop().into(view);
            }
        });

        list_photo.setHasFixedSize(true);

    }


}
