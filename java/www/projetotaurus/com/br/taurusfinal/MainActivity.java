package www.projetotaurus.com.br.taurusfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        
        Thread mythread = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(), Menu.class);
                    startActivity(intent);
                    finish();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        mythread.start();
    }

}
