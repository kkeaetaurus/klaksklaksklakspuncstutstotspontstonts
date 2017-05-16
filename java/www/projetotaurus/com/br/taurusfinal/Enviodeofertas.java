package www.projetotaurus.com.br.taurusfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Enviodeofertas extends AppCompatActivity implements View.OnClickListener{

    private static final String URL_REGISTRO = "https://projetotaurus.com/Taurus/Niveis/Consulta/ofertasjson.php";

    public static final String KEY_MENSAGEM = "mensagem";

    private EditText mensagem;
    private Button enviarmens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviodeofertas);

        mensagem = (EditText)findViewById(R.id.edtMensagem);
        enviarmens = (Button)findViewById(R.id.btnEnviar);

        enviarmens.setOnClickListener(this);
    }

    private void EnviaEmail(){
        final String mensagenzinha = mensagem.getText().toString().trim();

        StringRequest reqq = new StringRequest(Request.Method.POST, URL_REGISTRO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Enviodeofertas.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){
                Toast.makeText(Enviodeofertas.this, error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String,String>();
                params.put(KEY_MENSAGEM,mensagenzinha);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(reqq);
    }

    public void onClick(View v){
        if(v==enviarmens){
            if(mensagem.getText().equals("")){
                mensagem.setError("Preencha o campo");
            }else {
                EnviaEmail();
            }
        }
    }
}
