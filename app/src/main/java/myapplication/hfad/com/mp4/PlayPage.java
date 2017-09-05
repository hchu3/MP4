package myapplication.hfad.com.mp4;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PlayPage extends AppCompatActivity {

    TextView txtTittle, txtTime, txtTotal;
    SeekBar sk;
    ImageButton play, previous, forward, shuffle, repeat;
    int position = 0;
    MediaPlayer mp;
    MediaPlayer mp1;
    ArrayList<Song> arraySong;
    Animation animation;
    ImageView hinhcd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_page);

        animation = AnimationUtils.loadAnimation(this,R.anim.cd_rotate);
        Log.d("AAA", "BBB");


        Choi();
        Thembaihat();

        khoitaoMediaPlayer();

        // Method play
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // dng choi -> pause->pause thanh play

                if (mp.isPlaying()){
                   mp.pause(); // dang la nut pause
                    hinhcd.clearAnimation();
                    play.setImageResource(R.drawable.pause);// pause thanh play
                }
                // dang dung -> pause -> muon choi thanh -> pause ra  play
                else{

                    mp.start(); //chuyen thanh play
                    hinhcd.startAnimation(animation);
                    play.setImageResource(R.drawable.play1);// play thanh pause
                }
                setTimeTotal();
                //updateTime();
                // k lap = co ve dung
//                if ((!mp.isLooping() && mp.isPlaying()) ) {
//                   play.setImageResource(R.drawable.repeat_pause);
//                    updateTime2();
//
//                }
//                // k lap
//                if (!mp.isLooping() && !mp.isPlaying()){
//                    play.setImageResource(R.drawable.shuffle);
//                    updateTime2();
//                }
//
//                //lap
//               if ((mp.isLooping() && mp.isPlaying())) {
//                    play.setImageResource(R.drawable.repeat_run);
//                    updateTime();
//                }
//
//                // lap
//                if (mp.isLooping() && !mp.isPlaying()){
//                    play.setImageResource(R.drawable.forward);
//                    updateTime();
//                }

                if (!mp.isLooping()){
                    //play.setImageResource(R.drawable.repeat_pause);
                    updateTime();
                }

                //lap
                if ((mp.isLooping()) ){
                    play.setImageResource(R.drawable.playblue);
                    updateTime2();
                }



            }
        });

        // Method previous



        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



              position++;
                if (position > arraySong.size()- 1){
                    position = 0;
                }

                if (mp.isPlaying()){
                    mp.stop();
                }
                khoitaoMediaPlayer();
                mp.start();
                setTimeTotal();
                //updateTime();
                updateTime2();


            }


        });




        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position--;
                if ( position < 0){
                        position = arraySong.size() - 1;
                }

                if (mp.isPlaying()){
                    mp.stop();
                }
                khoitaoMediaPlayer();
                mp.start();
                setTimeTotal();
                //updateTime();
                updateTime2();


            }
        });


         repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (sk.getMax() > mp.getDuration()){
//                    position = mp.getCurrentPosition();
//                }
//
//
//               khoitaoMediaPlayer();

//                if(mp.isPlaying()) {
//                    // Pause the music player
//
//                    mp.setLooping(true);
//                    repeat.setImageResource(R.drawable.repeat);}
//                // If it's not playing
//                else {
//                    // Resume the music player
//
//                    mp.setLooping(true);
//                   repeat.setImageResource(R.drawable.repeat_run);}
//
//                setTimeTotal();
//                updateTime2();



//                if(mp.isPlaying() ) {
//                    // Pause the music player
//                    if (mp.isLooping()){
//                        mp.setLooping(false);
//                        repeat.setImageResource(R.drawable.repeat_pause);}
//                    else if (!mp.isLooping()){
//                        mp.setLooping(true);
//                        repeat.setImageResource(R.drawable.repeat_run);}
//                    }
//                // If it's not playing
//                  else if (!mp.isPlaying()){
//                    // Resume the music player
//                    if (mp.isLooping()){
//                        mp.setLooping(false);
//                        repeat.setImageResource(R.drawable.repeat_pause);}
//                    else if (!mp.isLooping()){
//                        mp.setLooping(true);
//                        repeat.setImageResource(R.drawable.repeat_run);}
//                  }

                // chay +  lap = k lap
//                if(mp.isPlaying() && mp.isLooping() )
//                {
//                    // Pause the music player
//                        mp.setLooping(false);
//                        repeat.setImageResource(R.drawable.playblue);}
//                // chay + k lap = lap
//                 if  (mp.isPlaying() && !mp.isLooping() ) {
//                        mp.setLooping(true);
//                        repeat.setImageResource(R.drawable.play1);
//                }
//                // pause+loop = k lap
//                if (!mp.isPlaying() && mp.isLooping() ){
//                    // Resume the music player
//                        mp.setLooping(false);
//                        repeat.setImageResource(R.drawable.previous);
//               }
//               //pause + k loop = lap
//                if (!mp.isPlaying() && !mp.isLooping()) {
//                        mp.setLooping(true);
//                        repeat.setImageResource(R.drawable.forward);
//                }


                    mp.setLooping(true);
                    repeat.setImageResource(R.drawable.repeat_run);


//                if (mp.isLooping()){
//                    mp.setLooping(false);
//                    repeat.setImageResource(R.drawable.repeat_pause);
//                }





            }
        });





        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
         @Override
         public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // i: Giá trị của sk

        }

        @Override
         public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo(sk.getProgress());
                TimeRun();

        }
        });


    }




    private void khoitao2(int position){
        mp = MediaPlayer.create(PlayPage.this, arraySong.get(position).getFile());
        txtTittle.setText(arraySong.get(position).getSongTittle());
    }

    private void khoitaoMediaPlayer(){
        mp = MediaPlayer.create(PlayPage.this, arraySong.get(position).getFile());
        txtTittle.setText(arraySong.get(position).getSongTittle());


    }

    private void Thembaihat() {

        arraySong = new ArrayList<>();
        arraySong.add(new Song("A Whole New World", R.raw.a_whole_new_world));
        arraySong.add(new Song("I am the one", R.raw.im_the_one));
        arraySong.add(new Song("Wild", R.raw.wild));

    }

    private void Choi() {

        txtTime     = (TextView)findViewById(R.id.textviewTime);
        txtTotal   = (TextView)findViewById(R.id.textviewTotal);
        txtTittle   = (TextView)findViewById(R.id.textviewTitle);
        sk          = (SeekBar)findViewById(R.id.SeekBar);

        play        = (ImageButton)findViewById(R.id.play);
        previous    = (ImageButton)findViewById(R.id.previous) ;
        forward     =  (ImageButton)findViewById(R.id.forward);
        shuffle     = (ImageButton)findViewById(R.id.shuffle);
        repeat      = (ImageButton)findViewById(R.id.repeat);
        hinhcd = (ImageView)findViewById(R.id.cdDisk);
    }

  private void setTimeTotal(){

      SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
      txtTotal.setText(dinhDangGio.format(mp.getDuration()));

      sk.setMax(mp.getDuration());


  }

    private void TimeRun(){

        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        txtTime.setText(dinhDangGio.format(mp.getCurrentPosition()));



    }


    private void updateTime() {

        // Hang lap di lap lai
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                txtTime.setText(dinhDangGio.format(mp.getCurrentPosition()));
                //  update seekbar progress
                sk.setProgress(mp.getCurrentPosition());


                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp1) {

                        position++;
                        if (position > arraySong.size()- 1){
                            position = 0;
                        }

                        if (mp.isPlaying()){
                            mp.stop();
                        }
                        khoitaoMediaPlayer();
                        mp.start();
                        setTimeTotal();

                    }
                });


                handler.postDelayed(this,100);


            }
        } ,100);

    }

    private void updateTime2() {

        // Hang lap di lap lai
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                txtTime.setText(dinhDangGio.format(mp.getCurrentPosition()));
                //  update seekbar progress
                sk.setProgress(mp.getCurrentPosition());

                handler.postDelayed(this,100);


            }
        } ,100);

    }

    private void updateTime3() {

        // Hang lap di lap lai
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                txtTime.setText(dinhDangGio.format(mp.getCurrentPosition()));
                //  update seekbar progress
                sk.setProgress(mp.getCurrentPosition());

                // k loop -> thi tu dong chuyen bai
                if(!mp.isLooping()) {

                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp1) {

                            position++;
                            if (position > arraySong.size() - 1) {
                                position = 0;
                            }

                            if (mp.isPlaying()) {
                                mp.stop();
                            }
                            khoitaoMediaPlayer();
                            mp.start();
                            setTimeTotal();

                        }
                    });
                }

                handler.postDelayed(this,100);


            }
        } ,100);

    }

}



//        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//@Override
//public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//        // i: Giá trị của sk
//        Log.d("HHH", "Gia tri cua i:" + progress);
//        }
//
//@Override
//public void onStartTrackingTouch(SeekBar seekBar) {
//        Log.d("SSS", "Start");
//        }
//
//@Override
//public void onStopTrackingTouch(SeekBar seekBar) {
//        Log.d("LLL", "Stop");
//        }
//        });
