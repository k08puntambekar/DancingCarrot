package ReKritiks.Dashboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ReKritiks.Dashboard.R;

public class Leaderboard_RecyclerViewAdaptercall extends RecyclerView.Adapter<Leaderboard_RecyclerViewAdaptercall.MyViewHolder> {
    Context mContext;
    List<Leaderboard_Call> mData;

    public Leaderboard_RecyclerViewAdaptercall(Context context, List<Leaderboard_Call> lstContact) {
        this.mContext = context;
        this.mData = lstContact;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.leaderboard_item_contact,parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String votes = String.valueOf(mData.get(position).getVotes());

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_votes.setText(votes);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private TextView tv_votes;

        public MyViewHolder( View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.textViewTitle);
            tv_votes = (TextView) itemView.findViewById(R.id.textViewDesc);
        }
    }
}
