package com.SpringTest.Teste.controller.forms;

import com.SpringTest.Teste.models.Admins;
import com.SpringTest.Teste.models.Clients;
import com.SpringTest.Teste.models.Products;
import com.SpringTest.Teste.models.Requests;
import com.SpringTest.Teste.services.AdminsService;
import com.SpringTest.Teste.services.ClientsService;
import com.SpringTest.Teste.services.ProductsService;
import jakarta.validation.constraints.NotNull;

public class RequestsForm {
    @NotNull
    private long cliente_id;

    @NotNull
    private long product_id;

    private long admin_id;

    public long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
        this.admin_id = admin_id;
    }

    public Requests convert(ClientsService clientsService, ProductsService productsService, AdminsService adminsService){
        Clients clients = clientsService.findById(cliente_id);
        Products products = productsService.findById(product_id);
        Admins admin = adminsService.findById(admin_id);

        return new Requests(clients, products, admin);
    }

}
