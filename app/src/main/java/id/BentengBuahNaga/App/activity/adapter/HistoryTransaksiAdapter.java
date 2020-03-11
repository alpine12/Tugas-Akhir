package id.BentengBuahNaga.App.activity.adapter;

import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.model.DaftarPesananModel;
import id.BentengBuahNaga.App.helper.FormatRp;

public class HistoryTransaksiAdapter extends BaseQuickAdapter<DaftarPesananModel, BaseViewHolder> {
    private static final String TAG = "HistoryTransaksiAdapter";
    public HistoryTransaksiAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, DaftarPesananModel item) {
        helper.setText(R.id.tv_tggljamPesan, " : " + item.getWaktuTransaksi());
        helper.setText(R.id.tv_kodeTransaksi, " : " + item.getKodeTransaksi());

        int potongan = 0;
        if (item.getKodePromo().equals("0")) {
            potongan = Integer.valueOf(item.getTotalPembayaran());
        } else {
            int total_bayar = Integer.parseInt(item.getTotalPembayaran());
            int diskon = Integer.parseInt(item.getPotongan());
            potongan = (total_bayar - ((total_bayar * diskon) / 100));
        }

        helper.setText(R.id.tv_totalBayar, " : " + FormatRp.FormatRp(String.valueOf(potongan)));
        helper.setText(R.id.tv_statusBayar, " : " + "Pembayaran Telah Selesai");
    }
}
