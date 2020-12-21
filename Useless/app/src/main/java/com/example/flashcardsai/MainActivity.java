package com.example.flashcardsai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//API AI
import com.google.gson.JsonElement;

import java.util.Map;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class MainActivity extends AppCompatActivity implements AIListener, View.OnClickListener {

    private Button btnVoice;
    private TextView tvResult;
    private AIService aiService;
    private static final int REQUEST_INTERNET = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVoice = (Button)findViewById(R.id.btn_voice);
        tvResult = (TextView)findViewById(R.id.tv_result_main);

        validarPermisos();

        final AIConfiguration config = new AIConfiguration("AIzaSyAjxDzQz6i_T1aazeyLPtli8QegPB5G4YA",
                AIConfiguration.SupportedLanguages.Spanish,
                AIConfiguration.RecognitionEngine.System);

        aiService = AIService.getService(this, config);
        aiService.setListener(this);

        btnVoice.setOnClickListener(this);
    }

    public void validarPermisos(){
        int permisosAudio = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECORD_AUDIO);
        int permisosInternet = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.INTERNET);

        if(permisosAudio != PackageManager.PERMISSION_GRANTED || permisosInternet != PackageManager.PERMISSION_GRANTED){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.INTERNET}, REQUEST_INTERNET);
            }
        }
    }

    @Override
    public void onResult(AIResponse response) {
        Result result = response.getResult();

        //Get parameters
        String parametros = "";
        if(result.getParameters() != null && !result.getParameters().isEmpty()){
            for(final Map.Entry<String, JsonElement> entry : result.getParameters().entrySet()) {
                parametros += "(" + entry.getKey() + ", " + entry.getValue();
            }
        }

        tvResult.setText("Query" + result.getResolvedQuery() +
                "\nParametros: " + parametros);

    }

    @Override
    public void onError(AIError error) {
        tvResult.setText(error.toString());

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_voice:
                aiService.startListening();
                break;
        }

    }
}
