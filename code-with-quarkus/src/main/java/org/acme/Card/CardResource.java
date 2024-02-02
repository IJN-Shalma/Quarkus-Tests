package org.acme.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;

@Path("/cards")
public class CardResource{
    
    @Inject
    CardRepository cardRepository;

    @GET
    @Path("/{cardId}")
    public Response getCard(@PathParam("cardId") Int cardId){
        Card card = cardRepository.findById(cardId);
        return Response.ok(card).build();
    }

    // TODO: Continue at minute 6:10 of  https://www.youtube.com/watch?v=HTmecFdixgg

    /* 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCards(){
        return Response.ok(cards).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCard(Card newCard){
        cards.add(newCard);
        return Response.ok(cards).build();
    }

    
    @PUT
    @Path("{cardIdToUpdate}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCard(@PathParam("cardIdToUpdate") int cardIdToUpdate, Card updateCard){

        cards = cards.stream().map(
            card -> {
                return card.getId() == cardIdToUpdate ? updateCard : card;
            }
        ).collect(Collectors.toList());

        return Response.ok(cards).build();
    }

    @DELETE
    @Path("{cardIdToDelete}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCard(@PathParam("cardIdToDelete") int cardIdToDelete){

        // Find (if exists) card to delte. findFirst() returns and Optional
        Optional<Card> cardToDelete =  cards.stream().filter(
            card -> {
                return card.getId() == cardIdToDelete;
            }
        ).findFirst();

        if(cardToDelete.isPresent()){
            cards.remove(cardToDelete.get());
            return Response.ok(cards).build();
        }
        else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/size")
    public Integer countCards(){
        return cards.size();
    }
    */
}