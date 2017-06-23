# TimeLine
This project aims to provide a easy to use *Staggered TimeLine* implementation.

## Usage
If you want to use this *TimeLine*  in your project, you have to do the following.

- Set the `StaggeredGridLayoutManager` to your `RecyclerView`
```
mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
```

- Use the `ItemDecoration` of this project <a href="https://github.com/Microhx/TimeLine/blob/master/app/src/main/java/com/vivian/timeline/itemdecoration/StaggeredGridItemDecoration.java">StaggeredGridItemDecoration.java<a/>

```
    StaggeredGridItemDecoration itemDecoration = new StaggeredGridItemDecoration.
                                                        Builder(this).
                                                        setTopDistance(50).
                                                        setItemInterval(10).
                                                        setLineWidth(2).
                                                        setDotRadius(4).
                                                        setDotOffset(8).
                                                        setBottomTextOffset(25).
                                                        setLineColor(Color.RED).
                                                        setDotColor(Color.BLUE).
                                                        setTextColor(Color.GREEN).
                                                        setTextSize(40).
                                                        setTextEnd("Micro").
                                                        create();
                                                        

```

- Also, this is listener for the callback ,named for ItemDecorationStateListener:
```

   public interface ItemDecorationStateListener {

    /**
     *
     * @param targetView this is the targetView , in ItemViewHolder
     * @param span Index
     */
    void onItemState(View targetView , int index);

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

    Copyright 2017 Vivian

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
