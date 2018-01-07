package com.example.repository;
import com.example.Domain.Menu_card;
import org.springframework.data.repository.CrudRepository;

public interface MenuRespository extends CrudRepository<Menu_card,Integer> {
}
