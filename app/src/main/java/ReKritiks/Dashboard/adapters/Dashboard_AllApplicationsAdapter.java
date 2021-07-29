package ReKritiks.Dashboard.adapters;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import ReKritiks.Dashboard.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Dashboard_AllApplicationsAdapter extends RecyclerView.Adapter<Dashboard_AllApplicationsAdapter.MyViewHolder> {
    private List<ResolveInfo> applications = new ArrayList<>();
    private PackageManager packageManager;
    private Context context;

    public Dashboard_AllApplicationsAdapter(Context context, List<ResolveInfo> applications, PackageManager packageManager){
        this.applications = applications;
        this.packageManager = packageManager;
        this.context = context;
    }

    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_allapplications_item_layout, parent, false);
        return new  MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        int appCategory = applications.get(position).activityInfo.applicationInfo.category;
        String categoryTitle = (String) ApplicationInfo.getCategoryTitle(context, appCategory);
        holder.appName.setText(applications.get(position).activityInfo.loadLabel(packageManager));
        holder.appCategory.setText(categoryTitle);
        holder.appCategory.setText(appCategory + "");
        holder.appIcon.setImageDrawable(applications.get(position).activityInfo.loadIcon(packageManager));

    }

    @Override
    public int getItemCount() {
        return applications.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView appName, appCategory;
        ImageView appIcon;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            appName =  itemView.findViewById(R.id.appName);
            appCategory =  itemView.findViewById(R.id.appCategory);
            appIcon =  itemView.findViewById(R.id.appIcon);
        }
    }
}
