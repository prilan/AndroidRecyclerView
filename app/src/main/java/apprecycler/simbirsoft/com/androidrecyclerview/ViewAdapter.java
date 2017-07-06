package apprecycler.simbirsoft.com.androidrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onClick(int position, String value);
    }

    private Data data;

    private final OnItemClickListener onItemClickListener;

    public ViewAdapter(Data data, OnItemClickListener onItemClickListener) {
        this.data = data;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String valueBase = data.dataBase.get(position);
        final String valueTime = data.dataTime.get(position);
        holder.setDataBase(valueBase);
        holder.setDataTime(valueTime);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(position, valueBase);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.dataBase.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewBase;
        private TextView textViewTime;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewBase = (TextView) itemView.findViewById(R.id.textViewBase);
            textViewTime = (TextView) itemView.findViewById(R.id.textViewTime);
        }

        public void setDataBase(String value) {
            textViewBase.setText(value);
        }

        public void setDataTime(String value) {
            textViewTime.setText(value);
        }
    }
}
