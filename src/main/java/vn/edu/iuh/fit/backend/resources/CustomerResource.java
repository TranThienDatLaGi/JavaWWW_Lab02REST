package vn.edu.iuh.fit.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.services.CustomerService;

import java.util.List;

@Path("/customers")
public class CustomerResource {
    private final CustomerService customerService = new CustomerService();

    public CustomerResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(Customer customer) {
        customerService.insertCustomer(customer);
        return Response.ok(customer).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, Customer customer) {
        Customer cus = customerService.finCustomer(id).get();
        if (cus == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        boolean update = customerService.updateCustomer(customer);
        if (!update)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(customer).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByID(@PathParam("id") long id) {
        Customer customer = customerService.finCustomer(id).get();
        if (customer == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(customer).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Customer> list = customerService.getAllCusTomer();
        return Response.ok(list).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {
        boolean delete = customerService.deleteCustomer(id);
        if (!delete)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(id).build();
    }
}
