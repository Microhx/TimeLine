package com.vivian.timeline.inter;

import android.view.View;

/**
 * author : micro_hx <p>
 * desc : <p>
 * email: javainstalling@163.com <p>
 * date : 2017/6/23 - 10:57 <p>
 * interface :
 */

public interface ItemDecorationStateListener {

    /**
     *
     * @param targetView this is the targetView , in ItemViewHolder
     * @param position targetView's position
     */
    void onItemState(View targetView , int position);

}
