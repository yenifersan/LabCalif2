package com.santiago.companylist.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.santiago.companylist.R;
import com.santiago.companylist.models.Contact;
import com.santiago.companylist.repositories.CompanyRepository;

public class DetailCompanyActivity extends AppCompatActivity {
    private static final int CALL_PERMISSION_REQUEST = 100;


    private Integer id;
    private ImageView picture;
    private TextView categoria;
    private TextView nombre;
    private TextView direccion;
    private TextView telefono;
    private TextView email;
    private TextView pagina;
    private TextView detalle;
    Contact contact;


    //programar los iconos
    //web
    private ImageView webButton;
    //email
    private ImageView emailButton;
    //sms
    private ImageView smsButton;
    //contac
    private ImageView compartButton;
    //call
    private ImageView callButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_company);

        picture = findViewById(R.id.picture_image);
        nombre = findViewById(R.id.txt_nombre);
        direccion= findViewById(R.id.txt_direccion);
        telefono= findViewById(R.id.txt_telefono);
        categoria=findViewById(R.id.txt_categoria);
        detalle=findViewById(R.id.txt_detalle);
        email=findViewById(R.id.txt_email);
        pagina=findViewById(R.id.txt_pagina);





        this.id= getIntent().getExtras().getInt("id");
        //recuperar el contacto
        contact = CompanyRepository.getContactById(id);
        if (contact !=null){
            int resourceid = getResources().getIdentifier(
                    contact.getPicture(),
                    "drawable",
                    getPackageName()
            );
            picture.setImageResource(resourceid);
            nombre.setText(contact.getNombre());
            direccion.setText(contact.getDireccion());
            telefono.setText(contact.getTelefono());
            categoria.setText(contact.getCategoria());
            detalle.setText(contact.getDetalle());
            email.setText(contact.getEmail());
            pagina.setText(contact.getPagina());



        }

        //llamar

        telefono = findViewById(R.id.txt_telefono);
        callButton = findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });

        //web

        pagina = findViewById(R.id.txt_pagina);
        webButton = findViewById(R.id.webButton);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view();
            }
        });


        //email
       email= findViewById(R.id.txt_email);
        emailButton= findViewById(R.id.emailButton);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email();
            }
        });

        //sms
        smsButton = findViewById(R.id.smsButton);
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sms();
            }
        });

        //Compartir
        compartButton = findViewById(R.id.compartButton);
        compartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compart();
            }
        });





    }

    //creando metodo call
    private void call(){

        // Verificar si tengo permiso de CALL_PHONE
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},CALL_PERMISSION_REQUEST);
            return;
        }

        String phonenumber =  telefono.getText().toString();

        if(phonenumber.isEmpty()){
            Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phonenumber));

        // Si el intent puede ser resuelto por el SO se iniciará
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

//creando el metodo view

    private void view(){
        String url = pagina.getText().toString();

        if(url.isEmpty()) {
            Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!url.startsWith("http://") || !url.startsWith("https://")) {
            url = "http://" + url;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    // metodo para enviar email

    private void email(){

        String recipientList = email.getText().toString();
        String[] recipients = recipientList.split(",");
        //example

        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);

        intent.setType("message/rfc234");
        startActivity(Intent.createChooser(intent,"choose an email client"));

    }


    // metoso para enviar mensaje

    private void sms(){
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.putExtra("cuerpo_sms", "default content");
        sendIntent.setType("vnd.android-dir/mms-sms");
        startActivity(sendIntent);
    }


// metodo para compartir


    private void compart(){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "mejor"+contact.getCategoria()+":"+"http//"+ contact.getPagina());
        startActivity(Intent.createChooser(intent, "Share with"));

    }


    //request
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CALL_PERMISSION_REQUEST) {
            if(permissions[0].equals(Manifest.permission.CALL_PHONE)) {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permisos otorgados!!!", Toast.LENGTH_SHORT).show();
                    call();
                }
            }
        }
    }

}


