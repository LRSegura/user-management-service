package com.electronixmarket.rest;

import com.electronixmarket.model.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path( "/user")
public class RestUser {

    @GET
    @Produces("application/json")
    public Response getAllUsers() {
        return Response.ok(User.listAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getUserById(@PathParam(value = "id") Long id) {
        return Response.ok(User.findById(id)).build();
    }

    @GET
    @Path("/username/{username}")
    @Produces("application/json")
    public Response getUserByUsername(@PathParam(value = "username") String username) {
        return Response.ok(User.findByUsername(username)).build();
    }

    @POST
    @Consumes("application/json")
    public Response addUser(User user) {
        user.persist();
        return Response.ok().status(201).build();
    }
}
