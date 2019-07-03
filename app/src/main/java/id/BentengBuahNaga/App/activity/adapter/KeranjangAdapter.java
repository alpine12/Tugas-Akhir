package id.BentengBuahNaga.App.activity.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.model.KeranjangFragmentModel;
import id.BentengBuahNaga.App.helper.FormatRp;
import id.BentengBuahNaga.App.network.InitRetrofit;

public class KeranjangAdapter extends BaseQuickAdapter<KeranjangFragmentModel, BaseViewHolder> {

    public KeranjangAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, KeranjangFragmentModel item) {
        Picasso.get().load(InitRetrofit.getIMAGEURL() + item.getGambar()).fit()
                .into(((ImageView) helper.getView(R.id.img_iconMenu)));
        ((TextView) helper.getView(R.id.tv_titleMenu)).setText(item.getNamaMenu());
        ((TextView) helper.getView(R.id.tv_jumlahPesan)).setText("Banyak "+item.getJumlah());
        helper.setText(R.id.tv_hargaMenu, FormatRp.FormatRp(item.getHarga()));
        helper.addOnClickListener(R.id.btn_edit).addOnClickListener(R.id.btn_delete);



    }
}
