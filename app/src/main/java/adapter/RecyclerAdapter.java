package adapter;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.freshmaninandroid.app_programmierung.newproject.R;
import de.freshmaninandroid.app_programmierung.newproject.object.User;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PersonViewHolder> {

    Context context;
    ArrayList<User> users;


    public RecyclerAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public RecyclerAdapter.PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater ltInflater = LayoutInflater.from(parent.getContext()); // Implement LI
        View v = ltInflater.inflate(R.layout.recycler_item, parent, false); // Implement method inflater
        PersonViewHolder pvh = new PersonViewHolder(v); // Create an object of PVH and give him v as parameter.
        context = parent.getContext();

        return pvh; // return personal view holder
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.PersonViewHolder holder, int position) {
        holder.userName.setText(users.get(position).getUserName());
        holder.userDescription.setText(users.get(position).getUserDescription());
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    Toast.makeText(context, "Long Click", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Short Click", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView userName;
        ImageView personPhoto;
        TextView userDescription;
        CardView cardView;
        private ItemClickListener clickListener;

        public PersonViewHolder(final View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.user_name);
            personPhoto = (ImageView) itemView.findViewById(R.id.recycler_image);
            userDescription = (TextView) itemView.findViewById(R.id.user_description);
            cardView = (CardView) itemView.findViewById(R.id.card);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnClickListener(this);


        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            clickListener.onClick(view, position, false);

        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition();
            clickListener.onClick(view, position, true);
            return true;
        }
    }


}






