package id.BentengBuahNaga.App.activity.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.model.DaftarPesananModel;
import id.BentengBuahNaga.App.helper.FormatRp;

public class HistoryTransaksiAdapter extends BaseQuickAdapter<DaftarPesananModel, BaseViewHolder> {
    public HistoryTransaksiAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, DaftarPesananModel item) {
        helper.setText(R.id.tv_tggljamPesan, item.getWaktuTransaksi());
        helper.setText(R.id.tv_kodeTransaksi, item.getKodeTransaksi());
        helper.setText(R.id.tv_jumlahPesanan, "0");
        helper.setText(R.id.tv_totalBayar, FormatRp.FormatRp(item.getTotalPembayaran()));
        helper.setText(R.id.tv_statusBayar, "Pembayaran Telah Selesai");
    }
}
