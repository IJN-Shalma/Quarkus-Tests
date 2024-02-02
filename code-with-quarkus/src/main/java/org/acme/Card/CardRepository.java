package org.acme.Card;

import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CardRepository implements PanacheMongoRepository<Card>{
    public Card findById(int id){
        return find("id", id).firstResult();
    }

    public List<Card> findOrderedName(){
        return listAll(Sort.by("name"));
    }
}
