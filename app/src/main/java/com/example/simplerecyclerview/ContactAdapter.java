package com.example.simplerecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    //array of contacts
    private List<Contact> listContact = new ArrayList<>();

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // create a new view
        View vh = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_contact, viewGroup, false);

        ContactViewHolder viewHolder = new ContactViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        // get position
        Contact item = listContact.get(i);

        // set values
        contactViewHolder.txtPhone.setText(item.getPhone());
        contactViewHolder.txtName.setText(item.getName());

        Picasso.get().load(item.getImageUrl()).into(contactViewHolder.imageContact);
    }

    // get size of list
    @Override
    public int getItemCount() {
        return listContact.size();
    }

    // contactviewholder
    public class ContactViewHolder extends RecyclerView.ViewHolder {
        // variables declaration
        TextView txtName, txtPhone;
        ImageView imageContact;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            // initialize variables
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            imageContact = itemView.findViewById(R.id.imageContact);

            // onclicklistener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v, getAdapterPosition());
                }
            });
        }
    }


    // constructor
    public ContactAdapter(List<Contact> listContact) {
        this.listContact = listContact;
    }

    private OnContactClickListener listener;

    // interface
    public interface OnContactClickListener {
        void onClick(View view, int position);
    }

    // listener
    public void setListener(OnContactClickListener listener) {
        this.listener = listener;
    }
}
