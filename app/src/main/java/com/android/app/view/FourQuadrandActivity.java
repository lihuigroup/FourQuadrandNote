package com.android.app.view;

import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.app.MyAipSpeech;
import com.android.app.fourquadrantnote.R;
import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.util.Util;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechListener;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.speech.RecognizerResult;
import com.iflytek.speech.SynthesizerListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FourQuadrandActivity extends AppCompatActivity {
    private Context context;

    private TextView text_back;
    private TextView quard_u_i;
    private TextView quard_u_ui;
    private TextView quard_uu_i;
    private TextView quard_uu_ui;
    private Button btn_u_i;
    private Button btn_u_ui;
    private Button btn_uu_i;
    private Button btn_uu_ui;
    private Boolean isRecording;
    File file;



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_quadrand);

        context=this;

        text_back=findViewById(R.id.text_back);
        text_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        quard_u_i=findViewById(R.id.quard_urgent_important);
        quard_u_ui=findViewById(R.id.quard_urgent_unimportant);
        quard_uu_i=findViewById(R.id.qurad_unurgent_important);
        quard_uu_ui=findViewById(R.id.quard_unurgent_unimportant);

        btn_u_i=findViewById(R.id.btn_ui);
        btn_u_ui=findViewById(R.id.btn_u_ui);
        btn_uu_i=findViewById(R.id.btn_uu_i);
        btn_uu_ui=findViewById(R.id.btn_uu_ui);

        quard_u_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FourQuadrandActivity.this, NewNoteActivity.class);
                intent.putExtra("type",0);
                startActivity(intent);
                finish();
            }
        });

        quard_uu_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FourQuadrandActivity.this, NewNoteActivity.class);
                intent.putExtra("type",1);
                startActivity(intent);
                finish();
            }
        });

        quard_u_ui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FourQuadrandActivity.this, NewNoteActivity.class);
                intent.putExtra("type",2);
                startActivity(intent);
                finish();
            }
        });

        quard_uu_ui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FourQuadrandActivity.this, NewNoteActivity.class);
                intent.putExtra("type",3);
                startActivity(intent);
                finish();
            }
        });

        btn_u_i.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //按下操作
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    Log.i("kaishi","开始录音");
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            StartRecord();
                        }
                    });
                    thread.start();
                    Log.i("kaishi","开始录音");
                }
                //抬起操作
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    isRecording=false;
                    Log.i("jieshu","结束录音");
                }
                //移动操作
                if(motionEvent.getAction()==MotionEvent.ACTION_MOVE){

                }

                return false;
            }
        });

        btn_u_ui.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //按下操作
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    Log.i("kaishi","开始录音");
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            StartRecord();
                        }
                    });
                    thread.start();
                    Log.i("kaishi","开始录音");
                }
                //抬起操作
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    isRecording=false;
                    Log.i("jieshu","结束录音");
                }
                //移动操作
                if(motionEvent.getAction()==MotionEvent.ACTION_MOVE){

                }

                return false;
            }
        });

        btn_uu_i.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //按下操作
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    Log.i("kaishi","开始录音");
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            StartRecord();
                        }
                    });
                    thread.start();
                    Log.i("kaishi","开始录音");
                }
                //抬起操作
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    isRecording=false;
                    Log.i("jieshu","结束录音");
                }
                //移动操作
                if(motionEvent.getAction()==MotionEvent.ACTION_MOVE){

                }

                return false;
            }
        });

        btn_uu_ui.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //按下操作
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    Log.i("kaishi","开始录音");
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            StartRecord();
                        }
                    });
                    thread.start();
                    Log.i("kaishi","开始录音");
                }
                //抬起操作
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    isRecording=false;
                    Log.i("jieshu","结束录音");
                }
                //移动操作
                if(motionEvent.getAction()==MotionEvent.ACTION_MOVE){

                }

                return false;
            }
        });
    }

    //开始录音
    public void StartRecord() {
        //16K采集率
        int frequency = 16000;
        //格式
        int channelConfiguration = AudioFormat.CHANNEL_CONFIGURATION_MONO;
        //16Bit
        int audioEncoding = AudioFormat.ENCODING_PCM_16BIT;
        //生成PCM文件Environment.getExternalStorageDirectory().getAbsolutePath()
        file = new File( this.getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/reverseme.pcm");
        //如果存在，就先删除再创建
        if (file.exists())
            file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new IllegalStateException("未能创建" + file.toString());
        }
        try {
            //输出流
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);
            int bufferSize = AudioRecord.getMinBufferSize(frequency, channelConfiguration, audioEncoding);
            AudioRecord audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, frequency, channelConfiguration, audioEncoding, bufferSize);

            short[] buffer = new short[bufferSize];
            audioRecord.startRecording();
            isRecording = true;
            while (isRecording) {
                int bufferReadResult = audioRecord.read(buffer, 0, bufferSize);
                for (int i = 0; i < bufferReadResult; i++) {
                    dos.writeShort(buffer[i]);
                }
            }
            audioRecord.stop();
            dos.close();
            Log.i("dos",String.valueOf(dos.size()));
/*
            byte[] data = Util.readFileByBytes(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)+ "/reverseme.pcm");
            JSONObject asrRes = MyAipSpeech.getAipSpeech().asr(data, "pcm", 16000, null);
            Log.i("yuyin",asrRes.toString());*/
            PlayRecord();
        } catch (Throwable t) {
            Log.e("TAG", "录音失败");
        }
    }

    //播放文件
    public void PlayRecord() {
        if(file == null){
            return;
        }
        //读取文件
        int musicLength = (int) (file.length() / 2);
        short[] music = new short[musicLength];
        try {
            InputStream is = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            int i = 0;
            while (dis.available() > 0) {
                music[i] = dis.readShort();
                i++;
            }
            dis.close();
            AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                    16000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
                    AudioFormat.ENCODING_PCM_16BIT,
                    musicLength * 2,
                    AudioTrack.MODE_STREAM);
            audioTrack.play();
            audioTrack.write(music, 0, musicLength);
            audioTrack.stop();
        } catch (Throwable t) {
            Log.i("TAG", "播放失败");
        }
    }
}
