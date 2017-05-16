package www.projetotaurus.com.br.taurusfinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LuaNote on 16/05/2017.
 */

public class AdapterMarcas extends RecyclerView.Adapter<AdapterMarcas.ViewHolder> {

    private List<ListMarca> listMarcas;
    private Context context;

    public AdapterMarcas(List<ListMarca> listMarcas, Context context) {
        this.listMarcas = listMarcas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListMarca listMarca = listMarcas.get(position);

        holder.nome.setText(listMarca.getNome());
        holder.datacad.setText(listMarca.getDatacadastro());
    }

    @Override
    public int getItemCount() {
        return listMarcas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nome;
        public TextView datacad;


        public ViewHolder(View itemView) {
            super(itemView);
            nome = (TextView)itemView.findViewById(R.id.textViewMarca);
            datacad = (TextView)itemView.findViewById(R.id.textViewDataCadastro);
        }
    }
}
