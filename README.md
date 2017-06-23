# TimeLine
This project aims to provide a easy to use *Staggered TimeLine* implementation.

## Usage
If you want to use this *TimeLine*  in your project, you have to do the following.

- Set the `StaggeredGridLayoutManager` to your `RecyclerView`
```
mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
```

- Use the `ItemDecoration` of this project <a href="https://github.com/Microhx/TimeLine/blob/master/app/src/main/java/com/vivian/timeline/itemdecoration/StaggeredGridItemDecoration.java">StaggeredGridItemDecoration.java<a/>
  Use the 'ItemDecorationStateListener' <a href="https://github.com/Microhx/TimeLine/blob/master/app/src/main/java/com/vivian/timeline/inter/ItemDecorationStateListener.java">ItemDecorationStateListener</a>
  Use the 'Utils' <a href="https://github.com/Microhx/TimeLine/blob/master/app/src/main/java/com/vivian/timeline/util/Util.java">Utils</a>
```
    StaggeredGridItemDecoration itemDecoration = new StaggeredGridItemDecoration.
                                                        Builder(this).
                                                        setTopDistance(50).    //for the top distance
                                                        setItemInterval(10).   //for the each item interval
                                                        setLineWidth(2).       //the center line width [dp]
                                                        setDotRadius(4).       //the dot radius [dp]
                                                        setDotOffset(8).       //the dot and the itemView offset [dp]
                                                        setBottomTextOffset(25).   //the bottom text offset [dp]
                                                        setLineColor(Color.RED).   //the center line color
                                                        setDotColor(Color.BLUE).   //the dot background color
                                                        setTextColor(Color.GREEN).  //the bottom text color
                                                        setTextSize(40).            //the bottom text size [sp]
                                                        setTextEnd("Micro").        //the bottom text default is "end"
                                                        create();
                                                        

```

- Also, this is listener for the callback ,named for ItemDecorationStateListener:
```

   public interface ItemDecorationStateListener {

    /**
     *
     * @param targetView this is the targetView
     * @param span Index
     *
     * the spanIndex is between 0 - spanCount-1 , we can use the index
     * to judge the targetView is on the left or on the right , or on
     * other somewhere....
     *
     */
    void onItemState(View targetView , int index);
   }

   this example use :

   @Override
   public void onItemState(View targetView, int position) {
     if (position % 2 == 0) {  //on the left
        targetView.setBackgroundResource(R.drawable.pop_left);
     } else {  //on the right
        targetView.setBackgroundResource(R.drawable.pop_right);
     }
   }


```

- Use with RecyclerView:
```
 mRecyclerView.addItemDecoration(itemDecoration);
```



## Example
<div>
    <image src="https://github.com/Microhx/TimeLine/blob/master/art/Screenshot_for_result.png?raw=true" width=40% height=40%/>
</div>

# License

    Copyright 2017 Micro

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
