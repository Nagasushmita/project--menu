package com.example.repository;
//import org.springframework.boot.autoconfigure.data.elasticsearch.Repository;
import com.example.Domain.Menucardelasticsearch;
import java.util.List;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.Domain.Menucardelasticsearch;

public interface MenuRepositoryelastic extends ElasticsearchRepository<Menucardelasticsearch,Integer> {

//@Query("SELECT * FROM  restaurant WHERE price between min and max")
public List<Menucardelasticsearch> findMenucardelasticsearchByPrice(int min,int max);






}
