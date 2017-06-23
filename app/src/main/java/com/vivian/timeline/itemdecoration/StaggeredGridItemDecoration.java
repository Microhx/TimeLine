package com.vivian.timeline.itemdecoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.vivian.timeline.inter.ItemDecorationStateListener;
import com.vivian.timeline.util.Util;


public class StaggeredGridItemDecoration extends RecyclerView.ItemDecoration {

    //the top item
    private int mTopDistance = 50;

    //the interval between items
    private int mItemInterval = 20;

    //the default line width
    private int mLineWidth = 4;

    //the dot radius
    private int mDotRadius = 5;

    //the default dotOffset
    private int mDotOffset = 10;

    //the bottom text offset
    private int mBottomTextOffset = 30;

    //the line color
    private int mLineColor = Color.WHITE;

    //the dot color
    private int mDotColor = Color.WHITE;

    //the text color
    private int mTextColor = Color.WHITE;

    //the text size
    private int mTextSize = 18;

    //the mEndText String
    String mEndText = "END";

    //the TextPaint
    Paint mTextPaint;

    //the drawer Paint
    private Paint mDrawablePaint;

    //the drawer Rect
    private Rect mDrawableRect ;

    private ItemDecorationStateListener mItemDecorationStateListener;

    private StaggeredGridItemDecoration() {
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        mDrawableRect = new Rect();
        mDrawablePaint = new Paint();
        mDrawablePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = mItemInterval;
        outRect.right = mItemInterval;
        outRect.bottom = mTopDistance;

        int position = parent.getChildLayoutPosition(view);
        if (position == 0) {
            outRect.top = 0;
        } else if (position == 1) {
            outRect.top = 2 * mTopDistance;
        }

        if (null != mItemDecorationStateListener) {
            mItemDecorationStateListener.onItemState(view, position);
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawHorizontal(c, parent);
        drawVertical(c, parent);
        drawTheEndView(c, parent);

    }

    private void drawTheEndView(Canvas c, RecyclerView parent) {
        mDrawablePaint.setColor(mDotColor);
        View lastView = parent.getChildAt(parent.getChildCount() - 1);
        c.drawCircle(parent.getWidth() / 2, lastView.getBottom() - mDotRadius, mDotRadius, mDrawablePaint);

        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
        if (!TextUtils.isEmpty(mEndText)) {
            c.drawText(mEndText, parent.getWidth() / 2, lastView.getBottom() + mBottomTextOffset, mTextPaint);
        }
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int parentWidth = parent.getMeasuredWidth();

        final int childCount = parent.getChildCount();
        View lastChild = parent.getChildAt(childCount - 1);
        mDrawableRect.set(parentWidth / 2 - mLineWidth / 2, top, parentWidth / 2 + mLineWidth / 2, lastChild.getBottom());
        mDrawablePaint.setColor(mLineColor);
        c.drawRect(mDrawableRect, mDrawablePaint);
    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        final int parentWidth = parent.getMeasuredWidth();
        final int childCount = parent.getChildCount();

        mDrawablePaint.setColor(mDotColor);
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            c.drawCircle(parentWidth / 2, child.getTop() + mDotOffset - mDotRadius/2, mDotRadius, mDrawablePaint);
        }
    }

    public void setItemDecorationStateListener(ItemDecorationStateListener listener) {
        this.mItemDecorationStateListener = listener;
    }


    public static class Builder {
        private Context mContext;

        private StaggeredGridItemDecoration decoration = new StaggeredGridItemDecoration();

        public Builder(Context context) {
            this.mContext = context;
        }

        /**
         *
         * @param distance dp
         * @return
         */
        public Builder setTopDistance(int distance) {
            decoration.mTopDistance = Util.dip2px(mContext,distance);
            return this;
        }

        public Builder setItemInterval(int interval) {
            decoration.mItemInterval = Util.dip2px(mContext,interval);
            return this;
        }

        public Builder setLineWidth(int lineWidth) {
            decoration.mLineWidth = Util.dip2px(mContext,lineWidth);
            return this;
        }

        public Builder setDotRadius(int radius) {
            decoration.mDotRadius = Util.dip2px(mContext,radius);
            return this;
        }

        public Builder setDotOffset(int offset) {
            decoration.mDotOffset = Util.dip2px(mContext,offset);
            return this;
        }

        public Builder setBottomTextOffset(int offset) {
            decoration.mBottomTextOffset = Util.dip2px(mContext,offset);
            return this;
        }

        public Builder setLineColor(int lineColor) {
            decoration.mLineColor = lineColor;
            return this;
        }

        public Builder setDotColor(int dotColor) {
            decoration.mDotColor = dotColor;
            return this;
        }

        public Builder setTextColor(int textColor) {
            decoration.mTextColor = textColor;
            return this;
        }

        public Builder setTextSize(int textSize) {
            decoration.mTextSize = Util.dip2sp(mContext,textSize);
            return this;
        }

        public Builder setTextEnd(String textEnd) {
            decoration.mEndText = textEnd;
            return this;
        }

        public StaggeredGridItemDecoration create(){
            return decoration;
        }

    }


}