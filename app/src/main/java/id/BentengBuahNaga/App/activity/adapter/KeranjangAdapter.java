package id.BentengBuahNaga.App.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.model.KeranjangFragmentModel;
import id.BentengBuahNaga.App.helper.FormatRp;
import id.BentengBuahNaga.App.network.InitRetrofit;

public class KeranjangAdapter extends RecyclerView.Adapter<KeranjangAdapter.viewHolder> {
    private List<KeranjangFragmentModel> item;
    private Context mContext;

    public KeranjangAdapter(List<KeranjangFragmentModel> item, Context mContext) {
        this.item = item;
        this.mContext = mContext;
        notifyDataSetChanged();
    }

    public void clearItem(){
        item.clear();
    }

    @NonNull
    @Override
    public KeranjangAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_daftar_keranjang, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KeranjangAdapter.viewHolder holder, int position) {
        holder.bindItem(item.get(position));
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        private ImageView imgIcon;
        private TextView titleMenu;
        private TextView jumlah;
        private TextView harga;

        public viewHolder(@NonNull View v) {
            super(v);

            imgIcon = v.findViewById(R.id.img_iconMenu);
            titleMenu = v.findViewById(R.id.tv_titleMenu);
            jumlah = v.findViewById(R.id.tv_jumlahPesan);
            harga = v.findViewById(R.id.tv_harga);
        }

        public void bindItem(KeranjangFragmentModel model) {
            Picasso.get().load(InitRetrofit.getIMAGEURL() + model.getGambar()).fit().into(imgIcon);
            titleMenu.setText(model.getNamaMenu());
            jumlah.setText(model.getJumlah());
            harga.setText(FormatRp.FormatRp(model.getHarga()));
        }
    }
}
