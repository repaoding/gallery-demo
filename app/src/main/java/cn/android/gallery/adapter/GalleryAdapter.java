package cn.android.gallery.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;

import cn.android.gallery.R;

/**
 * created by sfx on 2017/9/4.
 */

public abstract class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryHolder> {

    private final List<String> data;

    public GalleryAdapter() {
        this.data = new ArrayList<>();
        data.add("http://img3.redocn.com/tupian/20150430/mantenghuawenmodianshiliangbeijing_3924704.jpg");
        data.add("http://img.taopic.com/uploads/allimg/120727/201995-120HG1030762.jpg");
        data.add("http://pic39.nipic.com/20140312/18085061_092729513131_2.jpg");
        data.add("http://pic23.photophoto.cn/20120530/0020033092420808_b.jpg");
        data.add("http://img01.taopic.com/150508/318763-15050PU9398.jpg");
        data.add("http://img1.3lian.com/2015/a1/84/d/95.jpg");
        data.add("http://img.taopic.com/uploads/allimg/110915/29-11091512035335.jpg");
        data.add("http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=1682a2cca76eddc432eabcb851b2dc88/50da81cb39dbb6fd4a10690f0324ab18972b374b.jpg");
    }

    @Override
    public GalleryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if (mParent == null) {
//            mParent = parent;
//        }
        return new GalleryHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_gallery_item, parent, false));
    }

    private ViewGroup mParent;
    private int parentWidth = -1;

    @Override
    public void onBindViewHolder(GalleryHolder holder, int position) {
        final String uri = getItem(position);
        if (uri != null && holder.image != null) {
            loadImage(holder.image, uri);
        }

//        if (holder.itemView != null) {
//            if (parentWidth <= 0) {
//                parentWidth = mParent != null ? (mParent.getWidth() - 48) / 3 : parentWidth;
//            }
//            final ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
//            if (parentWidth != params.width && parentWidth >= 1) {
//                params.width = parentWidth;
//                holder.itemView.setLayoutParams(params);
//            }
//
//        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public String getItem(int position) {
        if (position >= 0 && position <= getItemCount() - 1) {
            return data.get(position);
        }
        return null;
    }

    public abstract void loadImage(ImageView view, String url);

    final class GalleryHolder extends RecyclerView.ViewHolder {
        final ImageView image;

        GalleryHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.image);
        }

    }

//    public interface IGallery {
//        String uri();
//    }
}
