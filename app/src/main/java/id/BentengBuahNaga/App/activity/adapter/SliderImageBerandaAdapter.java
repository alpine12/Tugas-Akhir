package id.BentengBuahNaga.App.activity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

import id.BentengBuahNaga.App.R;
import id.BentengBuahNaga.App.activity.model.BerandaFragmentModel;
import id.BentengBuahNaga.App.network.InitRetrofit;

public class SliderImageBerandaAdapter extends SliderViewAdapter<SliderImageBerandaAdapter.viewHolder> {

    private Context context;
    private List<BerandaFragmentModel> item;

    public SliderImageBerandaAdapter(Context context, List<BerandaFragmentModel> item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public SliderImageBerandaAdapter.viewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SliderImageBerandaAdapter.viewHolder viewHolder, final int position) {
       viewHolder.loadBanner(item.get(position));

    }

    @Override
    public int getCount() {
        return item.size();
    }

    public class viewHolder extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public viewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }

        public void loadBanner(BerandaFragmentModel item){
            Picasso.get().load(InitRetrofit.getImageurlBanner()+item.getGambar())
                        .fit().into(imageViewBackground);
            textViewDescription.setTextSize(16);
            textViewDescription.setTextColor(Color.WHITE);
            textViewDescription.setText(item.getJudulBanner());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, item.getDeskripsi(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
