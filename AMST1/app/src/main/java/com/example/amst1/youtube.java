package com.example.amst1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Vector;

public class youtube extends AppCompatActivity {
    private EditText txtLink;
    private Button btnBuscar;
    private LinearLayout layout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        //Referencias a los controles
        btnBuscar = (Button) findViewById(R.id.btnBuscar);

        txtLink= (EditText)findViewById(R.id.txtLink);
        layout= (LinearLayout)findViewById(R.id.layoutPrincipal);







        btnBuscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String link = txtLink.getText().toString();
                if(link.equals("")){
                    Toast toast=Toast.makeText(getApplicationContext(),"Pegar URL !!!",Toast.LENGTH_SHORT);
                    toast.show();
                }else{

                        YouTubePlayerView youTubePlayerView = new YouTubePlayerView(getApplicationContext());
                        youTubePlayerView.getYouTubePlayerWhenReady(youTubePlayer -> {
                            // do stuff with it
                            try {

                                youTubePlayer.loadVideo(obtenerIdVideo(link), 0);
                                layout.addView(youTubePlayerView);


                            }catch (Exception e){
                                Toast toast=Toast.makeText(getApplicationContext(),"Pegar URL válida !!!",Toast.LENGTH_SHORT);
                                toast.show();
                            }

                        });






                }
            }
        });

    }

    public String obtenerIdVideo(String link){
        // link que llega: https://youtu.be/bSMZknDI6bg
        String nueva="";
        String[] parts = link.split("//");

        //parts[1]: youtu.be/bSMZknDI6bg
        String[]parts2= parts[1].split("/");

        // parts2[1]: bSMZknDI6bg
        nueva=parts2[1];

        return  nueva;
    }


}