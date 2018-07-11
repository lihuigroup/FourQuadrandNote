package com.android.app;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.util.Util;

import org.json.JSONObject;

/**
 * Created by ty on 2018/7/11.
 */

public class MyAipSpeech {
    private static AipSpeech aipSpeech;
    public static final String APP_ID = "11522774";
    public static final String API_KEY = "uhXcGh3nqZCEDGHlUAhf4mKB";
    public static final String SECRET_KEY = "ZML6pcVjmGItGipwT8uup10fV9v1mmqp";

    public static AipSpeech getAipSpeech() {
        if (aipSpeech == null) {
            aipSpeech = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        }
        return aipSpeech;
    }
}
