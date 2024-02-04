package org.acme.Card;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.core.Response.Status;

@Path("/cards")
public class CardResource {

    @Inject
    CardRepository cardRepository;

    /**
     * Retrieve all card documents
     * 
     * @return A list of Card documents
     */
    @GET
    @Path("/")
    @Operation(summary = "Retrieve all card documents", description = "Returns a list of all Card documents.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "OK - Cards retrieved successfully"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public Response getCards() {
        try {
            List<Card> cards = cardRepository.findOrderedById();
            return Response.ok(cards).build(); // 200
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error retrieving cards: " + e.getMessage())
                    .build();
        }
    }

    /**
     * Find card Document by Name
     * 
     * @param cardName Name of the card
     * @return Card document
     */
    @GET
    @Path("/{cardName}")
    @Operation(summary = "Get Card document by Card name", description = "Returns a Card document by its name.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "OK - Card found"),
            @APIResponse(responseCode = "404", description = "Card not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public Response getCard(@PathParam("cardName") String cardName) {
        try {
            Card card = cardRepository.findByName(cardName);
            if (card != null) {
                return Response.ok(card).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Card not found").build(); // 404
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving card").build();
        }
    }

    /**
     * Add a new card to the collection
     * 
     * @param newCard The new card to be added, received in body in JSON format
     * @return Response indicating the status of the operation
     */
    @POST
    @Path("/")
    @Operation(summary = "Add a new card to the collection", description = "Adds a new card to the collection.")
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "New card resource created successfully"),
            @APIResponse(responseCode = "409", description = "Conflict - Card with the same name already exists"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public Response addCard(Card newCard) {
        try {
            if (cardRepository.findByName(newCard.getName()) == null) {
                cardRepository.persist(newCard);
                return Response.status(Status.CREATED).entity(newCard).build(); // 201
            } else {
                return Response.status(Status.CONFLICT).entity("Card already exists, try editing or removing it first.")
                        .build();
            }

        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error adding card: " + e.getMessage()).build();
        }
    }

    /**
     * Upload multiple cards from a JSON array
     * 
     * @param deck Array of cards in JSON format
     * @return Response indicating the status of the deck upload
     */
    @POST
    @Path("/upload")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Upload multiple cards", description = "Uploads multiple cards from JSON array.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Deck uploaded successfully"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public Response uploadDeck(List<Card> deck) {
        for (Card card : deck) {
            cardRepository.persist(card);
        }
        return Response.ok("Deck uploaded successfully").build();
    }

    /**
     * Delete card document by name
     * 
     * @param cardName Name of the card to be deleted
     * @return Response indicating the status of the card deletion
     */
    @DELETE
    @Path("/{cardName}")
    @Operation(summary = "Delete card by name", description = "Deletes a card document by its name.")
    @APIResponses(value = {
            @APIResponse(responseCode = "204", description = "Card deleted successfully"),
            @APIResponse(responseCode = "404", description = "Card not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public Response deleteCard(@PathParam("cardName") String cardName) {
        Card card = cardRepository.findByName(cardName);

        if (card == null) {
            return Response.status(Status.NOT_FOUND).entity("Card with name " + cardName + " not found").build(); // 404
        }

        try {
            cardRepository.delete(card);
            return Response.noContent().build(); // 204
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error deleting card with name " + cardName)
                    .build();
        }
    }

}