package com.example.Domain;

//import javax.persistence.Id;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "hit",type="food",shards=1,replicas=0)
public class Menucardelasticsearch {
@Id
    private int id;
    private String name;
    private int price;

    public Menucardelasticsearch() {
    }

    public Menucardelasticsearch(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }












}
