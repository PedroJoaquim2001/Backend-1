package com.SpringTest.Final.controller.forms;

import com.SpringTest.Final.models.AdminsModel;
import com.SpringTest.Final.models.ClientsModel;
import com.SpringTest.Final.models.ProductsModel;
import com.SpringTest.Final.models.RequestsModel;
import com.SpringTest.Final.services.AdminsService;
import com.SpringTest.Final.services.ClientsService;
import com.SpringTest.Final.services.ProductsService;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class RequestsForm {
    @NotNull
    private UUID cliente_id;

    @NotNull
    private UUID product_id;

    private UUID admin_id;

    public UUID getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(UUID cliente_id) {
        this.cliente_id = cliente_id;
    }

    public UUID getProduct_id() {
        return product_id;
    }

    public void setProduct_id(UUID product_id) {
        this.product_id = product_id;
    }

    public UUID getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(UUID admin_id) {
        this.admin_id = admin_id;
    }

    public RequestsModel convert(ClientsService clientsService, ProductsService productsService, AdminsService adminsService){
        ClientsModel clientsModel = clientsService.findById(cliente_id).get();
        ProductsModel productsModel = productsService.findById(product_id).get();
        AdminsModel admin = adminsService.findById(admin_id).get();

        return new RequestsModel(clientsModel, productsModel, admin);
    }

}
