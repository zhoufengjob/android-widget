ishiisoft-android-widget
=
android向けに作成したウィジェットを公開します。

動作環境
-
- android2.2以上
- android-support-v4.jarを使用

利用方法
-
- jarファイルを読み込む

 - ishiisoft-android-widget-v1.jar  

- または、以下のソースを直接取り込む

 - jp.gr.java_conf.ishiisoft.android.adapter  
 - jp.gr.java_conf.ishiisoft.android.widget

サンプルプログラム
-
- jp.gr.java_conf.ishiisoft.android.sample.SampleActivity.java  

swipe selector
-
### 説明
リストを左右スワイプで選択する部品です。  
いわゆるSpinnerなんですが、リストが少ない場合は、直感的に操作できて良いのではないかしら。

1.部品のイメージです。この例では項目が３コあります。  
![画像1](http://ishiisoft.appspot.com/android/image/swipe1.png "画像1")

2.最初の項目は左にスワイプできます。  
![画像2](http://ishiisoft.appspot.com/android/image/swipe2.png "画像2")

3.中間の項目は左右にスワイプできます。  
![画像3](http://ishiisoft.appspot.com/android/image/swipe3.png "画像3")

4.最後の項目は右にスワイプできます。  
![画像4](http://ishiisoft.appspot.com/android/image/swipe4.png "画像4")

5.< >をタッチしても項目が変わります。

### 利用方法
    // swipe selectorを取得
    SwipeSelector ss = (SwipeSelector)findViewById(R.id.swipeSelector);
    
    // 選択リスト
    final String[] SS_TEXT = {"0.swipe left", "1.swipe left or right", "2.swipe right"};
    
    // 選択リスト設定
    ss.setText(SS_TEXT);
    
    // 選択インデックス取得
    int selected = ss.getCurrentItem();

countup timer
-
### 説明
ミリ秒単位でカウントアップするタイマーです。  
Chronometerが秒しか表示してくれないので作りました。

1.部品のイメージです。  
![画像1](http://ishiisoft.appspot.com/android/image/timer1.png "画像1")

### 利用方法
    // countup timerを取得
    CountupTimer countupTimer = (CountupTimer)findViewById(R.id.countupTimer);
    
    // 開始
    countupTimer.start();
    
    // 終了
    countupTimer.stop();
    
    // 再開
    countupTimer.restart();

    // ミリ秒テキスト取得
    String millisecStr = countupTimer.getMillisecText();
    
    // ミリ秒取得
    long millisec = countupTimer.getMillisec();

ライセンス
-
MIT License

謝辞
-
マニュアルを作成するにあたり、emStudio様の素材を利用させていただきました。  
<http://www.emstudio.jp/>
