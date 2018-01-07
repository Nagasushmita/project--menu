package com.example.controller;


import com.example.Domain.Menu_card;
import com.example.Domain.Menucardelasticsearch;
import com.example.repository.MenuRepositoryelastic;
import com.example.repository.MenuRespository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuController {
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    MenuRespository menuRepository;

    @Autowired
    MenuRepositoryelastic menuRepositoryelastic;

@RequestMapping("/")
        public List<Menucardelasticsearch> getAllItems(){
    List<Menucardelasticsearch> arrayList=new ArrayList<Menucardelasticsearch>();
     menuRepositoryelastic.findAll().forEach(arrayList::add);
    return arrayList;
}
@RequestMapping(method = RequestMethod.POST,path="/")
public void addItemToMenu(@RequestBody Menu_card menu_card){
            menuRepository.save(menu_card);
            Menucardelasticsearch menucardelasticsearch=modelMapper.map(menu_card,Menucardelasticsearch.class);
            menuRepositoryelastic.save(menucardelasticsearch);
}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Integer id) {
        menuRepository.delete(id);
        menuRepositoryelastic.delete(id);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    Menucardelasticsearch findById(@PathVariable("id") int id){
    return menuRepositoryelastic.findOne(id);
    }

/*@RequestMapping(value = "/",method = RequestMethod.PUT)
Menu_card update(@RequestBody Menu_card menu_card){
        return menuRepository.updateMenu_card(menu_card);
}
*/
@RequestMapping(method = RequestMethod.GET,value="/{min}/{max}")
    public List<Menucardelasticsearch>getitems(@PathVariable int min,@PathVariable int max) {
    List<Menucardelasticsearch> arrayList=new ArrayList<Menucardelasticsearch>();
    //arrayList.addAll(menuRepositoryelastic.findMenucardelasticsearchByPrice(min,max));
    menuRepositoryelastic.findMenucardelasticsearchByPrice(min,max).forEach(arrayList::add);
    return arrayList;
}

}
