package com.example.foodapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.DBHelper;
import com.example.foodapp.Models.OrderModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder> {
    ArrayList<OrderModel> list;
    Context context;

    public OrdersAdapter(ArrayList<OrderModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.order_sample , parent , false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        try {
            final OrderModel model = list.get(position);
            holder.orderImage.setImageResource(model.getOrderImage());
            holder.itemName.setText(model.getItemName());
            holder.orderNumber.setText(model.getOrderNumber());
            holder.price.setText(model.getPrice());

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    DBHelper helper= new DBHelper(context);
                    if(helper.deleteOrder(model.getOrderNumber()) > 0) {
                        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                    }
                    return false;
                }
            });

        }
        catch (NullPointerException e)
         { }
        }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView  orderImage;
        TextView itemName, price,orderNumber;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage = itemView.findViewById(R.id.orderimage);
            itemName = itemView.findViewById(R.id.orderitemname);
            orderNumber = itemView.findViewById(R.id.ordernumber);
            price = itemView.findViewById(R.id.orderprice);
        }
    }
}
