package muslim_simpleby.huda;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAyatAdapter extends RecyclerView.Adapter<ListAyatAdapter.AyatHolder> {
    private ArrayList<Ayat> listayat;

    public ListAyatAdapter(ArrayList<Ayat> listayat) {
        this.listayat = listayat;
    }

    @NonNull
    @Override
    public AyatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new AyatHolder(inflater.inflate(R.layout.item_surat, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListAyatAdapter.AyatHolder holder, int position) {
        holder.mnomor.setText(listayat.get(position).getNomor());
        holder.mnama.setText(listayat.get(position).getNama());
        holder.masma.setText(listayat.get(position).getAsma());
        holder.mname.setText(listayat.get(position).getName());
        holder.mstart.setText(listayat.get(position).getStart());
        holder.mayat.setText(listayat.get(position).getAyat());
        holder.mtype.setText(listayat.get(position).getType());
        holder.murut.setText(listayat.get(position).getUrut());
        holder.mrukuk.setText(listayat.get(position).getRukuk());
        holder.marti.setText(listayat.get(position).getArti());
    }

    @Override
    public int getItemCount() {
        return listayat.size();
    }

    public class AyatHolder extends RecyclerView.ViewHolder {
        private TextView mnomor;
        private TextView mnama;
        private TextView masma;
        private TextView mname;
        private TextView mstart;
        private TextView mayat;
        private TextView mtype;
        private TextView murut;
        private TextView mrukuk;
        private TextView marti;


        public AyatHolder(@NonNull View itemView) {
            super(itemView);
            mnomor = (TextView) itemView.findViewById(R.id.tv_nomer);
            mnama = (TextView) itemView.findViewById(R.id.tv_nama_surat);
            masma = (TextView) itemView.findViewById(R.id.tv_asma);
            mname = (TextView) itemView.findViewById(R.id.tv_name);
            mstart = (TextView) itemView.findViewById(R.id.tv_start);
            mayat = (TextView) itemView.findViewById(R.id.tv_ayat);
            mtype = (TextView) itemView.findViewById(R.id.tv_type);
            murut = (TextView) itemView.findViewById(R.id.tv_urut);
            mrukuk = (TextView) itemView.findViewById(R.id.tv_rukuk);
            marti = (TextView) itemView.findViewById(R.id.tv_arti);
        }
        public void bind(Ayat ayat) {
            mnomor.setText(ayat.nomor);
            mnama.setText(ayat.nama);
            masma.setText(ayat.asma);
            mname.setText(ayat.name);
            mstart.setText(ayat.start);
            mayat.setText(ayat.ayat);
            mtype.setText(ayat.type);
            murut.setText(ayat.urut);
            mrukuk.setText(ayat.rukuk);
            marti.setText(ayat.arti);
        }
    }
}
