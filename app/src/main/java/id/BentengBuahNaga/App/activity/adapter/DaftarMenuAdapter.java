package id.BentengBuahNaga.App.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.model.DaftarMenuModel;
import id.BentengBuahNaga.App.helper.FormatRp;
import id.BentengBuahNaga.App.network.InitRetrofit;

public class DaftarMenuAdapter extends RecyclerView.Adapter<DaftarMenuAdapter.viewHolder> {
    private List<DaftarMenuModel> item;
    private Context context;
    private onClickListerner listerner;


    public DaftarMenuAdapter(List<DaftarMenuModel> item, Context context, onClickListerner clickListerner) {
        this.item = item;
        this.context = context;
        listerner = clickListerner;
    }

    @NonNull
    @Override
    public DaftarMenuAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_layout_daftarmenu, parent, false);


        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarMenuAdapter.viewHolder holder, int position) {
        holder.bindItem(item.get(position), listerner);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder {
        private ImageView iconMenu;
        private TextView tittleMenu;
        private TextView hargaMenu;

        public viewHolder(@NonNull View v) {
            super(v);
            v.setTag(this);
            iconMenu = v.findViewById(R.id.iconMenu);
            tittleMenu = v.findViewById(R.id.titleMmenu);
            hargaMenu = v.findViewById(R.id.hargaMenu);
        }

        private void bindItem(DaftarMenuModel menu, onClickListerner listerner) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listerner.onItemClick(menu);
                }
            });

            Picasso.get().load(InitRetrofit.getIMAGEURL() + menu.getGambar())
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).into(iconMenu);
            tittleMenu.setText(menu.getNamaMenu());
            hargaMenu.setText(FormatRp.FormatRp(menu.getHarga()));
        }
    }

    public interface onClickListerner {
        void onItemClick(DaftarMenuModel item);
    }
}
