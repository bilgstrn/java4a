package com.tobeto.java4a.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController
{
    @GetMapping
    public String sayHello(@RequestParam String name) //Parametreden okur
    {
        //DB'e bağlanıp veri ekle, veri sorgula, veri güncelle
        return "Merhaba "+name;
    }
    // http://localhost:8080/products?name=Bilge => Merhaba Bilge çıktısı alırız.
    
    /*
    @PostMapping
    public String sayGoodBye(@RequestBody Product product)
    {
        return "Eklenen ürün bilgileri id:"+product.getId() +" name:"+product.getName()+" fiyat:"+product.getUnitPrice();
    }
    */
    /*
    Requestin bodysinden okur. Classı okur.
    Webden JSON gönderilir.
    Webden productın bilgilerini("id":1,"name":"Ürün 1","unitPrice":500) gönderelim.
    Spring bunu JSONdan Java classına çevirebilir.
    Eklenen ürün bilgileri id:1 name:Ürün 1 fiyat:500.0 çıktısı alınır.
    */
    /*
    @PostMapping
    public Product sayGoodBye(@RequestBody Product product) //Bodye girdiğim çıktıları alırım.
    {
        return product;
    }
    */
    /*
    {"id": 1,
    "name": "Ürün 1",
    "unitPrice": 500.0} çıktısını alırız.
     Cevap olarak JSON vermiş oldu.
     */
    @PutMapping
    public String saySomething()
    {
        return "Bla bla...";
    }
}