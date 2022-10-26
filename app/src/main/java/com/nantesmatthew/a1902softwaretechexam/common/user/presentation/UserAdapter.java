package com.nantesmatthew.a1902softwaretechexam.common.user.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nantesmatthew.a1902softwaretechexam.R;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;
import com.nantesmatthew.a1902softwaretechexam.databinding.ItemUserBinding;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private ArrayList<User> users = new ArrayList<>();
    private OnUserSelect onUserSelect;

    public void setOnUserSelect(OnUserSelect onUserSelect){
        this.onUserSelect = onUserSelect;
    }
    public void setUsers(List<User> users) {
        this.users.clear();
        this.users.addAll(users);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        ItemUserBinding binder = ItemUserBinding.bind(view);
        return new UserViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.tvUserFullName.setText(user.getFullName());
        holder.tvUserInfo.setText(user.getInformation());

        holder.bind(user);
    }

    @Override
    public int getItemCount(){
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tvUserFullName;
        private TextView tvUserInfo;
        private ImageButton btnDelete;
        public UserViewHolder(@NonNull ItemUserBinding binder) {
            super(binder.getRoot());
            tvUserFullName = binder.tvFullName;
            tvUserInfo = binder.tvUserInfo;
            btnDelete = binder.btnDelete;
        }

        public void bind(User user){
            itemView.setOnClickListener(view -> {
                onUserSelect.onSelect(user);
            });
            btnDelete.setOnClickListener(btn->{
                onUserSelect.onDelete(user);
            });

        }
    }
}

