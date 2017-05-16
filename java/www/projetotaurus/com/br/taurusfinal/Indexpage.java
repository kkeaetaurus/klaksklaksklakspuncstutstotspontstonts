package www.projetotaurus.com.br.taurusfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Indexpage extends AppCompatActivity implements View.OnClickListener{

    private static final String URL_REGISTRO = "https://projetotaurus.com/Taurus/Niveis/Consulta/marcasjson.php";

    public static final String KEY_MARCA = "marca";

    private EditText nomemarca;
    private Button   botaocadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexpage);

        nomemarca = (EditText)findViewById(R.id.marcanome);

        botaocadastro = (Button) findViewById(R.id.cadastramarca);

        botaocadastro.setOnClickListener(this);
    }

    private void InsertMarca(){
        final String marquinha = nomemarca.getText().toString().trim();

        StringRequest reqq = new StringRequest(Request.Method.POST, URL_REGISTRO,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Indexpage.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){
                Toast.makeText(Indexpage.this, error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String,String>();
                params.put(KEY_MARCA,marquinha);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(reqq);
    }

    public void onClick(View v){
        if(v==botaocadastro){
            InsertMarca();
        }
    }
}
