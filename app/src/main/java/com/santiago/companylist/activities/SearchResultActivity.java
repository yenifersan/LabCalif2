package com.santiago.companylist.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.santiago.companylist.R;
import com.santiago.companylist.adapters.CompanyAdapter;
import com.santiago.companylist.models.Contact;
import com.santiago.companylist.repositories.CompanyRepository;

import java.util.List;

public class SearchResultActivity extends AppCompatActivity {
    private String categoria;
    private RecyclerView recyclerView;
    private CompanyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);


        this.categoria= getIntent().getExtras().getString("categoria");
        List<Contact> companiesResult= CompanyRepository.findCompanies(categoria);
        recyclerView=findViewById(R.id.contactlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new CompanyAdapter(this);
        adapter.setContacts(companiesResult);

        recyclerView.setAdapter(adapter);





    }
}
