package com.santiago.companylist.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.santiago.companylist.R;
import com.santiago.companylist.activities.DetailCompanyActivity;
import com.santiago.companylist.models.Contact;

import java.util.ArrayList;
import java.util.List;

//el adaptador  viewhodlder representa al xml
public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder>{

    private static final String TAG = CompanyAdapter.class.getSimpleName();

    private AppCompatActivity activity;

    private List<Contact> contacts;


    public CompanyAdapter(AppCompatActivity activity){
        //vista pricipal
        this.activity= activity;
        contacts= new ArrayList<>();

    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_company,viewGroup, false);
        return  new ViewHolder(view);
    }

    //primera vista
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Contact contact= this.contacts.get(position);

        viewHolder.txt_nombre.setText(contact.getNombre());
        viewHolder.txt_direccion.setText(contact.getDireccion());
        viewHolder.txt_telefono.setText(contact.getTelefono());


        //imagen
        Context context= viewHolder.itemView.getContext();

        int resourceid = context.getResources().getIdentifier(
                contact.getPicture(),"drawable", context.getPackageName()
        );
        viewHolder.pictureImage.setImageResource(resourceid);

        // definiendo el evento onclick
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onclick" + contact);

                Intent intent = new Intent(v.getContext(), DetailCompanyActivity.class);
                intent.putExtra("id",contact.getId());

                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder{

    ImageView pictureImage;
    TextView txt_nombre;
    TextView txt_direccion;
    TextView txt_telefono;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        pictureImage= itemView.findViewById(R.id.picture_image);
     txt_nombre= itemView.findViewById(R.id.txt_categoria);
     txt_direccion= itemView.findViewById(R.id.txt_direccion);
     txt_telefono=itemView.findViewById(R.id.txt_telefono);



    }
}
}
