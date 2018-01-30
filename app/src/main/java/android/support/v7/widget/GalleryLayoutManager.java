package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;

import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import static android.support.v7.widget.SpaceItemDecoration.dip2px;


/**
 * created by sfx on 2017/9/5.
 */

public class GalleryLayoutManager extends LinearLayoutManager {
    private final int visitableCount;
    private final int diffWidth;
    private int diff = 0;

    public GalleryLayoutManager(Context context, int visitableCount, int diffDp) {
        super(context);
        this.visitableCount = visitableCount;
        this.diffWidth = dip2px(diffDp, context.getResources().getDisplayMetrics());
    }


    public GalleryLayoutManager(Context context, int orientation, boolean reverseLayout, int visitableCount, int diffDp) {
        super(context, orientation, reverseLayout);
        this.visitableCount = visitableCount;
        this.diffWidth = dip2px(diffDp, context.getResources().getDisplayMetrics());
    }

    public GalleryLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, int visitableCount, int diffDp) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.visitableCount = visitableCount;
        this.diffWidth = dip2px(diffDp, context.getResources().getDisplayMetrics());
    }


    @Override
    public int getDecoratedMeasuredWidth(View child) {
        if (mOrientation == HORIZONTAL) {
            final Rect insets = ((RecyclerView.LayoutParams) child.getLayoutParams()).mDecorInsets;
            if (diff <= 0) {
                diff = (getWidth() - diffWidth) / visitableCount;
            }
            return diff + insets.left + insets.right;
        } else {
            return super.getDecoratedMeasuredWidth(child);
        }
    }

    @Override
    public int getDecoratedMeasuredHeight(View child) {
        if (mOrientation == VERTICAL) {
            final Rect insets = ((RecyclerView.LayoutParams) child.getLayoutParams()).mDecorInsets;
            if (diff <= 0) {
                diff = (getHeight() - diffWidth) / visitableCount;
            }
            return diff + insets.top + insets.bottom;
        } else {
            return super.getDecoratedMeasuredHeight(child);
        }
    }
}