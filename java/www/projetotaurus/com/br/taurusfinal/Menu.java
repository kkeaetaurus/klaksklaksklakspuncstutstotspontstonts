package www.projetotaurus.com.br.taurusfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    TextView ofer;
    TextView cadmarc;
    TextView cadusu;
    TextView consulfil;
    TextView listarmarca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ofer = (TextView)findViewById(R.id.of);
        cadmarc = (TextView)findViewById(R.id.cadmarc);
        cadusu  = (TextView)findViewById(R.id.cadusu);
        consulfil = (TextView)findViewById(R.id.consulfil);
        listarmarca = (TextView)findViewById(R.id.listmarca);

        ofer.setOnClickListener(this);
        cadmarc.setOnClickListener(this);
        cadusu.setOnClickListener(this);
        consulfil.setOnClickListener(this);
        listarmarca.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.of:
                Intent tela = new Intent(this,Enviodeofertas.class);
                startActivity(tela);
                break;
            case R.id.cadmarc:
                Intent tela2 = new Intent(this, Indexpage.class);
                startActivity(tela2);
                break;
            case R.id.cadusu:
                Intent tela3 = new Intent(this, Cadastrousu.class);
                startActivity(tela3);
                break;
            case R.id.consulfil:
                Intent tela4 = new Intent(this, MapsActivity.class);
                startActivity(tela4);
                break;
            case R.id.listmarca:
                Intent tela5 = new Intent(this, Listarmarcas.class);
                startActivity(tela5);
                break;
          
        }
    }
}
