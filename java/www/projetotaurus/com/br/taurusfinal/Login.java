package www.projetotaurus.com.br.taurusfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener{

    public static final String LOGIN_URL = "https://projetotaurus.com/Taurus/Niveis/Consulta/loginjson.php";

    public static final String KEY_USERNAME="email";
    public static final String KEY_PASSWORD="senha";

    private EditText edtTextEmail;
    private EditText edtTextSenha;
    private Button   login;
    private Button mudaaa;

    private String email;
    private String senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        getSupportActionBar().hide();

        edtTextEmail = (EditText)findViewById(R.id.edtEmail);
        edtTextSenha = (EditText)findViewById(R.id.edtSenha);

        login        = (Button)findViewById(R.id.btnEntrar);
        mudaaa = (Button)findViewById(R.id.testaofertas);

        login.setOnClickListener(this);
        mudaaa.setOnClickListener(this);
    }

    private void userLogin(){
        email = edtTextEmail.getText().toString().trim();
        senha = edtTextSenha.getText().toString().trim();

        if(email.equals("")){
            edtTextEmail.setError("Preencha este campo");
        }
        StringRequest strreq = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("sucesso")) {
                    abrirperfil();
                } else {
                    Toast.makeText(Login.this, "Dados incorretos!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put(KEY_USERNAME, email);
                map.put(KEY_PASSWORD, senha);
                return map; // 3 min de video https://www.youtube.com/watch?v=KU1osfgDOqU

            }

        };
        RequestQueue request = Volley.newRequestQueue(this);
        request.add(strreq);
    }
    private void abrirperfil(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    private void testarofertas(){
        Intent tess = new Intent(this, Enviodeofertas.class);
        startActivity(tess);
    }

    @Override
    public void onClick(View v) {
      userLogin();
    }
}
