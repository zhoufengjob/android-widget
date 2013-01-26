ishiisoft-android-widget
=
I publish the widgets i made for android.

requirements
-
- android2.2 and up
- uses android-support-v4.jar

how to use
-
- read that jar file

 - ishiisoft-android-widget-v1.jar  

- or use following sources

 - jp.gr.java_conf.ishiisoft.android.adapter  
 - jp.gr.java_conf.ishiisoft.android.widget

sample program
-
- jp.gr.java_conf.ishiisoft.android.sample.SampleActivity.java  

swipe selector
-
### about
it is a widget that you select in the list swipe right or left.  
this widget is the same as spinner.  
but when list is few, this widget operate intuitive.

1.this is widget's image.
in this example has three items.  
![image1](http://ishiisoft.appspot.com/android/image/swipe1.png "image1")

2.you can swipe left with the first item.  
![image2](http://ishiisoft.appspot.com/android/image/swipe2.png "image2")

3.you can swipe left or right with the middle item.  
![image3](http://ishiisoft.appspot.com/android/image/swipe3.png "image3")

4.you can swipe right with the last item .  
![image4](http://ishiisoft.appspot.com/android/image/swipe4.png "image4")

5.you can touch < or >, and item is changed.

### usage
    // get swipe selector
    SwipeSelector ss = (SwipeSelector)findViewById(R.id.swipeSelector);
    
    // select list
    final String[] SS_TEXT = {"0.swipe left", "1.swipe left or right", "2.swipe right"};
    
    // set select list
    ss.setText(SS_TEXT);
    
    // get selected index
    int selected = ss.getCurrentItem();

countup timer
-
### about
it is a widget that count up time with millisecond.  
I made this widget because Chronometer display only second.

1.this is widget's image.  
![image1](http://ishiisoft.appspot.com/android/image/timer1.png "image1")

### usage
    // get countup timer
    CountupTimer countupTimer = (CountupTimer)findViewById(R.id.countupTimer);
    
    // countup start
    countupTimer.start();
    
    // countup stop
    countupTimer.stop();
    
    // countup restart
    countupTimer.restart();

    // get millisecond text
    String millisecStr = countupTimer.getMillisecText();
    
    // get millisecond
    long millisec = countupTimer.getMillisec();

license
-
MIT License

special thanks
-
this manual uses emStudio's free material.  
<http://www.emstudio.jp/>
