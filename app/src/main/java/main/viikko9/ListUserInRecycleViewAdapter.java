package main.viikko9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListUserInRecycleViewAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public ListUserInRecycleViewAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.textFirstName.setText(users.get(position).getFirstName());
        holder.textLastName.setText(users.get(position).getLastName());
        holder.textEmail.setText(users.get(position).getEmail());
        holder.textDegreeProgram.setText(users.get(position).getDegreeProgram());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
