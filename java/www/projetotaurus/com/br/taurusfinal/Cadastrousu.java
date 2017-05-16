package www.projetotaurus.com.br.taurusfinal;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
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

public class Cadastrousu extends AppCompatActivity implements View.OnClickListener{
    public static final String CADASTRO_URL = "https://projetotaurus.com/Taurus/Niveis/Consulta/cadastrousuariojson.php";

    //KEYS referenciando arquivo php
    public static final String KEY_NOME="cadastronome";
    public static final String KEY_EMAIL="cadastroemail";
    public static final String KEY_SENHA="cadastrosenha";
    public static final String KEY_TELEFONE = "cadastrotelefone";
    public static final String KEY_CPF = "cadastrocpf";
    public static final String KEY_CEP = "cadastrocep";
    public static final String KEY_TIPO = "tipousuario";
    public static final String KEY_PROMO = "promo";

    private EditText nome;
    private EditText telefone;
    private EditText email;
    private EditText senha;
    private EditText cpf;
    private EditText cep;
    private RadioButton tipoGerente;
    private RadioButton tipoVendedor;
    private RadioButton tipoCliente;
    private CheckBox ofertas;
    private Button cadastrar;

    private String nomevalue;
    private String telefonevalue;
    private String emailvalue;
    private String senhavalue;
    private String cpfvalue;
    private String cepvalue;
    private String tipovalue;
    private String ofertasvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrousu);

        nome = (EditText)findViewById(R.id.nomeu);
        telefone = (EditText)findViewById(R.id.telefoneu);
        email = (EditText)findViewById(R.id.emailu);
        senha = (EditText)findViewById(R.id.senhau);
        cpf = (EditText)findViewById(R.id.cpfu);
        cep = (EditText)findViewById(R.id.cepu);
        tipoGerente = (RadioButton)findViewById(R.id.gerenteu);
        tipoVendedor = (RadioButton)findViewById(R.id.vendedoru);
        tipoCliente = (RadioButton)findViewById(R.id.clienteu);
        ofertas    = (CheckBox)findViewById(R.id.ofertasu);
        cadastrar = (Button)findViewById(R.id.cad);

        cadastrar.setOnClickListener(this);
    }

    private void cadastrarUsuario(){
        nomevalue = nome.getText().toString().trim();
        telefonevalue = telefone.getText().toString().trim();
        emailvalue = email.getText().toString().trim();
        senhavalue = senha.getText().toString().trim();
        cpfvalue = cpf.getText().toString().trim();
        cepvalue = cep.getText().toString().trim();
        if(tipoGerente.isChecked()){
            tipovalue = "Gerente";
        }
        if(tipoVendedor.isChecked()){
            tipovalue = "Vendedor";
        }
        if(tipoCliente.isChecked()){
            tipovalue = "Cliente";
        }

        if(ofertas.isChecked()){
            ofertasvalue = "Sim";
        }else{
            ofertasvalue = "Nao";
        }

        StringRequest str = new StringRequest(Request.Method.POST, CADASTRO_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("sucesso")) {
                    Toast.makeText(getApplicationContext(), "Usuário cadastrado com sucesso",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Erro",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put(KEY_NOME, nomevalue);
                map.put(KEY_EMAIL, emailvalue);
                map.put(KEY_SENHA, senhavalue);
                map.put(KEY_TELEFONE, telefonevalue);
                map.put(KEY_CPF, cpfvalue);
                map.put(KEY_CEP, cepvalue);
                map.put(KEY_TIPO, tipovalue);
                map.put(KEY_PROMO, ofertasvalue);
                return map;
            }
        };
        RequestQueue request = Volley.newRequestQueue(this);
        request.add(str);
    }

    public void onClick(View v){cadastrarUsuario();}

}
