package com.SpringTest.Teste.controller.forms;

import com.SpringTest.Teste.models.AdminsModel;
import com.SpringTest.Teste.models.ClientsModel;
import com.SpringTest.Teste.models.ProductsModel;
import com.SpringTest.Teste.models.RequestsModel;
import com.SpringTest.Teste.services.AdminsService;
import com.SpringTest.Teste.services.ClientsService;
import com.SpringTest.Teste.services.ProductsService;
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
