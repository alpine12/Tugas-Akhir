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

import id.BentengBuahNaga.App.R;

public class SliderImageBerandaAdapter extends SliderViewAdapter<SliderImageBerandaAdapter.viewHolder> {

    private Context context;
    private int mCount;

    public SliderImageBerandaAdapter(Context context) {
        this.context = context;
        notifyDataSetChanged();
    }

    public void setCount(int count) {
        this.mCount = count;
        notifyDataSetChanged();
    }

    @Override
    public SliderImageBerandaAdapter.viewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SliderImageBerandaAdapter.viewHolder viewHolder, final int position) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });

        switch (position) {
            case 0:
                viewHolder.textViewDescription.setText("This is slider item " + position);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Picasso.get().load("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
                        .fit().into(viewHolder.imageViewBackground);
                break;

            case 2:
                viewHolder.textViewDescription.setText("This is slider item " + position);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Picasso.get().load("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260")
                        .fit().into(viewHolder.imageViewBackground);
                break;

            case 4:
                viewHolder.textViewDescription.setText("This is slider item " + position);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Picasso.get().load("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
                        .fit().into(viewHolder.imageViewBackground);
                break;

            default:
                viewHolder.textViewDescription.setTextSize(29);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setText("Ohhhh! look at this!");
                viewHolder.imageGifContainer.setVisibility(View.VISIBLE);
                Picasso.get().load(R.drawable.puma_offer)
                        .fit()
                        .into(viewHolder.imageViewBackground);
                Picasso.get().load(R.drawable.oh_look_at_this)
                        .fit()
                        .into(viewHolder.imageGifContainer);

                break;
        }

    }

    @Override
    public int getCount() {
        return 10;
    }

    public class viewHolder extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public viewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }
}
