package id.BentengBuahNaga.App.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.model.DaftarPesananModel;
import id.BentengBuahNaga.App.helper.FormatRp;

public class DaftarPesananAdapter extends RecyclerView.Adapter<DaftarPesananAdapter.viewHolder> {

    private List<DaftarPesananModel> item;
    private Context context;
    private onItemClickListerner mListener;
    private DaftarPesananModel model;

    public DaftarPesananAdapter(List<DaftarPesananModel> item, Context context) {
        this.item = item;
        this.context = context;
    }

    public void setOnItemClick(onItemClickListerner listerner) {
        mListener = listerner;
    }

    @NonNull
    @Override
    public DaftarPesananAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout_daftarpesanan, parent, false);
        viewHolder holder = new viewHolder(view, mListener, model);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarPesananAdapter.viewHolder holder, int position) {
        holder.bindItem(item.get(position));
        holder.onItemClick(item.get(position));
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        private TextView kodeTrans;
        private TextView total;
        private TextView tggljam;
        private TextView status;
        private View v;
        private onItemClickListerner listener;

        public viewHolder(@NonNull View v, onItemClickListerner listener, DaftarPesananModel item) {
            super(v);
            this.v = v;
            this.listener = listener;
            kodeTrans = v.findViewById(R.id.tv_kodeTransaksi);
            total = v.findViewById(R.id.tv_totalBayar);
            tggljam = v.findViewById(R.id.tv_tggljamPesan);
            status = v.findViewById(R.id.tv_statusBayar);
        }

        public void bindItem(DaftarPesananModel item) {
            kodeTrans.setText(item.getKodeTransaksi());
            total.setText(FormatRp.FormatRp(item.getTotalPembayaran()));
            tggljam.setText(item.getWaktuTransaksi());
            if (item.getStatusBayar().equals("0")) {
                status.setText("Menunggu Pembayaran");
            } else {
                status.setText("Pembayaran Telah Diterima");
            }
        }

        public void onItemClick(DaftarPesananModel item) {
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onClick(position, item);
                        }
                    }
                }
            });
        }
    }

    public interface onItemClickListerner {
        void onClick(int Position, DaftarPesananModel model);
    }
}
