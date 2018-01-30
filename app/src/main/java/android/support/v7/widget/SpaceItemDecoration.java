package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * created by sfx on 2018/1/30.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    /**
     * dp转成px
     *
     * @param dipValue
     * @return
     */
    public static int dip2px(float dipValue, DisplayMetrics metrics) {
        return (int) (dipValue * metrics.density + 0.5f);
    }

    private int mSpace;

    public SpaceItemDecoration(Context context, int dpSpace) {
        mSpace = dip2px(dpSpace, context.getResources().getDisplayMetrics());
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
        //竖直方向的
        if (layoutManager.getOrientation() == LinearLayoutManager.VERTICAL) {
            outRect.top = mSpace;
            //最后一项需要 bottom
            if (parent.getChildAdapterPosition(view) == layoutManager.getItemCount() - 1) {
                outRect.bottom = mSpace;
            }
        } else {
            outRect.left = mSpace;
            //最后一项需要right
            if (parent.getChildAdapterPosition(view) == layoutManager.getItemCount() - 1) {
                outRect.right = mSpace;
            }
        }
    }

}
