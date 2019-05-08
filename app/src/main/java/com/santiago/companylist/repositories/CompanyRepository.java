package com.santiago.companylist.repositories;

import com.santiago.companylist.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {
    //definirlo como statico que no depende del objeto ...estara disponible de manera global
    private static List<Contact> contacts = new ArrayList<>();
    private static List<Contact> contacts_tod = new ArrayList<>();
    //llamar a los elementos staticos
    //array de contactos
    static {
        //contacts_tod.add(new Contact(1,"apple","direccion","987546")
        // );

        contacts.add(new Contact(1,
                "restaurantes",
                "Cevichería arco Iris del Norte",
                "Avenida Universitaria 5356  Urb. Carabayllo",
                "988 890 900",
                "empresa@gmail.com",
                "http://www.restaurantarcoirisdelnorte.com",
                "ic_restau",
                "Especialidad en pescados y mariscos."));
        contacts.add(new Contact(2,
                "hoteles",
                "Hostal Payolk",
                "Jiron Derteano 249  Pueblo Joven - Bolivar Bajo - Chimbote",
                "985678931",
                "gurmet@gmail.com",
                "http://www.facebook.com/HostalPayolk/",
                "ic_pakyo",
                "cHostal Payolk a su comodidad y a su servicio."));
        contacts.add(new Contact(3,
                "supermercados",
                "Ejv E.I.R.L.",
                "Avenida Malecón García Ribeyro , 300",
                "987654000",
                "oriental@gmail.com",
                "http://www.ejvcorp.com",
                "ic_ijv",
                "Soluciones en proyectos de estructuras metálicas."));
        contacts.add(new Contact(4,
                "escuelas",
                "Colegio Nuestra Señora del Carmen",
                "Avenida 15 de Enero 330 San Antonio \n" +
                        "Miraflores - Lima",
                "987654555",
                "carmen@gmail.com",
                "http://www.carmelitas.edu.pe",
                "ic_esc1",
                "Carmelitas. Inicial - Primaria - Secundaria."));
        contacts.add(new Contact(5,
                "farmacias",
                "Clínica Americana de Juliaca",
                "Jiron Loreto 315 \n" +
                        "Juliaca - Puno",
                "010056344",
                "tecsup_tec@tecsup.edu.pe",
                "http://www.clinicaamericana.org.pe",
                "ic_farm1",
                "Transmitiendo por 94 años el amor de Jesús a través del cuidado de la salud de las personas."));
        contacts.add(new Contact(6,
                "restaurantes",
                "Restaurante Polleria el Crocante",
                "Avenida Colectora 11 Mza. L \n" +
                        "Santa Anita - Lima",
                "934567123",
                "tecno@gmail.com",
                "www.salud.com",
                "ic_rest2",
                "Disfruta en familia el mejor pollo extra grande, crocantes papitas y ensalada."));
        contacts.add(new Contact(7,
                "hoteles",
                "Hotel Britania",
                "Avenida San Borja Sur 653 \n" +
                        "San Borja - Lima",
                "987654555",
                "britanica@gmail.com",
                "http://www.hbritania.com",
                "ic_hot2",
                "Un hotel exclusivo como Usted: Elegancia, confort y modernidad en Miraflores y San Borja."));
        contacts.add(new Contact(8,
                "supermercados",
                "Milko Market",
                "Calle López de Zúñiga 449 \n" +
                        "Huaral - Lima",
                "987654555",
                "milko.mil@gmail.com",
                "https://www.facebook.com/pg/Milko-Minimarket-296523794187516/photos/",
                "ic_super2",
                "LO MEJOR EN MINIMARKET"));

        contacts.add(new Contact(10,
                "escuelas",
                "Colegio Magister",
                "Calle Francisco De Cuellar 686  Monterrico Norte",
                "987654555",
                "magister.escu@gmail.com",
                "http://www.magister.pe\n" +
                        "Colegios",
                "ic_esc2",
                "enseñanza de primer nivel"));
        contacts.add(new Contact(8,
                "farmacias",
                "\n" +
                        "Botica Roosevelt",
                "Calle Miguel Dasso 135 \n" +
                        "San Isidro - Lima",
                "987654555",
                "farm.roosvelth@gmail.com",
                "www.tecno.com",
                "ic_farm2",
                "Medicina, recetas, delivery."));
        contacts.add(new Contact(9,
                "restaurantes",
                "Pizzeria Marengo  ",
                "Avenida La Cultura 748",
                "987654555",
                "tecno@gmail.com",
                "http://www.marengopizzeria.com",
                "ic_rest3",
                "LA MEJOR PIZZA DEL CUSCO DESDE 1984"));
        contacts.add(new Contact(10,
                "hoteles",
                "Hotel Corregidor",
                "Calle San Pedro 139  Cercado",
                "987654555",
                "hutel.corerre@gmail.com",
                "http://www.corregidor.pe",
                "ic_hot3",
                "buen hotel"));



    }



    //como se declaro privado tenemos que dclara un metodo

    public static List<Contact> getContacts(){
        return contacts;
    }
    public static List<Contact> getContacts_tod(){return contacts_tod;}


    //para ver otro activity

    public static Contact getContactById(Integer id){
        for (Contact contact: contacts){
            if(contact.getId().equals(id)){
            return contact;
            }
        }
return null;
    }
    public static List<Contact> findCompanies(String category) {
        List<Contact> companiesByCategory= new ArrayList<>();
        for (Contact company: contacts) {
            if(company.getCategoria().toLowerCase().indexOf(category.toLowerCase())>-1) {
                companiesByCategory.add(new Contact(company.getId(), company.getCategoria(), company.getNombre(),
                        company.getDireccion(), company.getTelefono(), company.getEmail(), company.getPagina(), company.getPicture(),
                        company.getDetalle()));
            }
        }
        return companiesByCategory;
    }


  //  public static Contact getContactById(String categoria){
    //    for (Contact contact: contacts_tod){
      //      if(contact.getId().equals(categoria)){
          //return nombre de la lista
        //    }
        //}
        //return null;
    //}


}
