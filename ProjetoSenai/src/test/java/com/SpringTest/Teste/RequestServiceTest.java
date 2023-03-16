package com.SpringTest.Teste;

import com.SpringTest.Teste.models.*;
import com.SpringTest.Teste.repositories.CultureRepository;
import com.SpringTest.Teste.repositories.RequestsRepository;
import com.SpringTest.Teste.services.AdminsService;
import com.SpringTest.Teste.services.CultureService;
import com.SpringTest.Teste.services.RequestsService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class RequestServiceTest {
    @TestConfiguration
    static class RequestServiceConfig{
        @Bean
        public RequestsService requestservice(){
            return new RequestsService();
        }
    }
    @Autowired
    RequestsService requestsService;

    @MockBean
    RequestsRepository requestsRepository;




    @Test
    public void whenGetAllThenReturnGotAll(){
        List<RequestsModel> requestsModels = requestsService.findAll();
        List<RequestsModel> requestsModels2 = requestsRepository.findAll();

        Assertions.assertEquals(requestsModels,requestsModels2);
    }

    @Test
    public void whenGetOneThenReturnGotOne(){
        UUID id = UUID.fromString("f3de05c6-c395-11ed-afa1-0242ac120002");
        Optional<RequestsModel> requestsModelOptional = requestsService.findById(id);
        Optional<RequestsModel> requestsModelOptional2 = requestsRepository.findById(id);

        Assertions.assertEquals(requestsModelOptional,requestsModelOptional2);
    }

    /*@Test
    public void whenSaveThenReturnSaved(){
        UUID id = UUID.fromString("f3de05c6-c395-11ed-afa1-0242ac120002");
        Optional<RequestsModel> requestsModelOp = requestsService.findById(id);

        RequestsModel requestsModel = requestsModelOp.get();

        Optional<RequestsModel> requestsModelOptional = Optional.ofNullable(requestsService.save(requestsModel));
        Optional<RequestsModel> requestsModelOptional2 = Optional.of(requestsRepository.save(requestsModel));

        Assertions.assertEquals(requestsModelOptional,requestsModelOptional2);
    }

    @Test
    public void whenDeleteThenReturnDeleted(){
        UUID id = UUID.fromString("f3de05c6-c395-11ed-afa1-0242ac120002");
        Optional<RequestsModel> requestsModelOptional = requestsService.findById(id);

        RequestsModel requestsModel = requestsModelOptional.get();

        requestsService.delete(requestsModel);

        verify(requestsRepository, times(1)).delete(Mockito.any());
    }*/



    @Before
    public void setup(){
        List<RequestsModel> requestsModelList = new ArrayList<RequestsModel>();

        AdminsModel adminsModel = new AdminsModel("Mateus","mateus@gmail.com.br","mateus123");
        adminsModel.setId(UUID.fromString("bbce4b9b-8faa-41fb-89a8-7a5baf5b5263"));

        CultureModel cultureModel = new CultureModel("CEREAIS");
        cultureModel.setId(UUID.fromString("ada4d564-d3a5-4d70-92f8-07ee640c7b18"));

        ClientsModel clientsModel = new ClientsModel("Pablo","14997673435","pablo@outlook.com");
        clientsModel.setId(UUID.fromString("7ec2f93f-a918-4126-a2bf-a86ea58e82a8"));

        ClientsModel clientsModel1 = new ClientsModel("Pedro","14997673435","pablo@outlook.com");
        clientsModel1.setId(UUID.fromString("7198b172-c397-11ed-afa1-0242ac120002"));

        ProductsModel productsModel = new ProductsModel(adminsModel, "pulvilhadeira", true, cultureModel,120.20, "Lorem lorem lorem");
        productsModel.setId(UUID.fromString("75672a88-c395-11ed-afa1-0242ac120002"));

        RequestsModel requestsModelTest = new RequestsModel(clientsModel, productsModel, adminsModel);
        requestsModelTest.setId(UUID.fromString("f3de05c6-c395-11ed-afa1-0242ac120002"));
        requestsModelList.add(requestsModelTest);

        RequestsModel requestsModelTest2 = new RequestsModel(clientsModel1, productsModel, adminsModel);
        requestsModelTest.setId(UUID.fromString("9693ec8a-c397-11ed-afa1-0242ac120002"));
        requestsModelList.add(requestsModelTest);


        Mockito.when(requestsRepository.findAll()).thenReturn(requestsModelList);
        Mockito.when(requestsRepository.findById(requestsModelTest.getId())).thenReturn(java.util.Optional.of(requestsModelTest));
        Mockito.when(requestsRepository.save(Mockito.any())).thenReturn(requestsModelList);
        doNothing().when(requestsRepository).delete(Mockito.any());
    }
}
