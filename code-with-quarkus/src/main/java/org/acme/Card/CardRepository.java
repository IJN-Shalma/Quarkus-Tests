package org.acme.Card;

import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CardRepository implements PanacheMongoRepository<Card>{
    public List<Card> findOrderedById(){
        return listAll(Sort.by("_id"));
    }

    public Card findByName(String name) {
        return find("name", name).firstResult(); 
    }

    public Card findById(int id){
        return find("_id", id).firstResult(); // "id" doesn't work, use _id
    }
}
