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
import id.BentengBuahNaga.App.activity.model.DetailDaftarPesananModel;
import id.BentengBuahNaga.App.network.InitRetrofit;

public class DaftarDetailPesananAdapter extends RecyclerView.Adapter<DaftarDetailPesananAdapter.viewHolder> {

    private static final String TAG = "DaftarDetailPesananAdap";
    private Context mContext;
    private List<DetailDaftarPesananModel> item;

    public DaftarDetailPesananAdapter(Context mContext, List<DetailDaftarPesananModel> item) {
        this.mContext = mContext;
        this.item = item;
    }

    @NonNull
    @Override
    public DaftarDetailPesananAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout_detailpesanan, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarDetailPesananAdapter.viewHolder holder, int position) {
        holder.bindItem(item.get(position));
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        private ImageView imgTitle;
        private TextView tv_title;
        private TextView tv_status;

        public viewHolder(@NonNull View v) {
            super(v);

            imgTitle = v.findViewById(R.id.img_iconMenu);
            tv_title = v.findViewById(R.id.tv_titleMenu);
            tv_status = v.findViewById(R.id.tv_status);
        }

        void bindItem(DetailDaftarPesananModel item) {
            Picasso.get().load(InitRetrofit.getIMAGEURL() + item.getGambar()).fit()
                    .into(imgTitle);
            tv_title.setText(item.getNamaMenu());
            if (item.getSelesaiMasak().equals("0")) {
                tv_status.setText("Masih Dalam Proses");
            } else {
                tv_status.setText("Pesanan Telah Selesai");
            }
        }
    }
}
