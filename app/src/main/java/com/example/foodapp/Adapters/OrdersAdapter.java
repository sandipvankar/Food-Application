package com.example.foodapp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

            final OrderModel model = list.get(position);
            holder.orderImage.setImageResource(model.getOrderImage());
            holder.itemName.setText(model.getItemName());
            holder.orderNumber.setText(model.getOrderNumber());
            holder.price.setText(model.getPrice());

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                         new AlertDialog.Builder(context)
                           //Set Title Delete Item
                           .setTitle("Delete Item")

                           //Set the message show  for delete item
                            .setMessage("Are you sure to delete this Item?")

                           //Set Cancelable false
                           .setCancelable(false)

                           // // Set the positive button with yes name
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    DBHelper helper=new DBHelper(context);
                                    if (helper.deleteOrder(model.getOrderNumber()) > 0) {
                                        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            })

                             // Set the Negative button with No Name
                           .setNegativeButton("No", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialogInterface, int i) {

                               }
                           }).show();


                    return false;
                }
            });



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
