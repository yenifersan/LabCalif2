package com.santiago.companylist.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.santiago.companylist.R;
import com.santiago.companylist.adapters.CompanyAdapter;
import com.santiago.companylist.models.Contact;
import com.santiago.companylist.repositories.CompanyRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    EditText textCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.contactlist);
        //
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        textCategory = findViewById(R.id.busqueda);

        CompanyAdapter adapter = new CompanyAdapter(this);

        List<Contact> contacts = CompanyRepository.getContacts();
        adapter.setContacts(contacts);

        recyclerView.setAdapter(adapter);

        //ccreamos nuestro adaptador
    }

    public void buscar(View view){
        Intent intent =new Intent(recyclerView.getContext(), SearchResultActivity.class);
        intent.putExtra("categoria", textCategory.getText().toString());
        startActivity(intent);
    }
}
