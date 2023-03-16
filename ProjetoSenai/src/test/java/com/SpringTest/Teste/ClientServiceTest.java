package com.SpringTest.Teste;

import com.SpringTest.Teste.models.AdminsModel;
import com.SpringTest.Teste.models.ClientsModel;
import com.SpringTest.Teste.repositories.ClientsRepository;
import com.SpringTest.Teste.services.ClientsService;
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
public class ClientServiceTest {
    @TestConfiguration
    static class ClientServiceConfig{
        @Bean
        public ClientsService clientsservice(){
            return new ClientsService();
        }
    }
    @Autowired
    ClientsService clientsService;

    @MockBean
    ClientsRepository clientsRepository;




    @Test
    public void whenGetAllThenReturnGotAll(){
        List<ClientsModel> clientsModels = clientsService.findAll();
        List<ClientsModel> clientsModels2 = clientsRepository.findAll();

        Assertions.assertEquals(clientsModels,clientsModels2);
    }

    @Test
    public void whenGetOneThenReturnGotOne(){
        UUID id = UUID.fromString("ada4d564-d3a5-4d70-92f8-07ee640c7b18");
        Optional<ClientsModel> clientsModel = clientsService.findById(id);
        Optional<ClientsModel> clientsModel2 = clientsRepository.findById(id);

        Assertions.assertEquals(clientsModel,clientsModel2);
    }

    @Test
    public void whenSaveThenReturnSaved(){
        ClientsModel clientsModel = new ClientsModel("Pablo","14997673435","pablo@outlook.com");
        clientsModel.setId(UUID.fromString("bbce4b9b-8faa-41fb-89a8-7a5baf5b5263"));

        Optional<ClientsModel> clientsModelOptional = Optional.ofNullable(clientsService.save(clientsModel));
        Optional<ClientsModel> clientsModelOptional2 = Optional.of(clientsRepository.save(clientsModel));

        Assertions.assertEquals(clientsModelOptional,clientsModelOptional);
    }

    @Test
    public void whenDeleteThenReturnDeleted(){
        UUID id = UUID.fromString("ada4d564-d3a5-4d70-92f8-07ee640c7b18");
        Optional<ClientsModel> clientsModelOptional = clientsService.findById(id);

        ClientsModel clientsModel = clientsModelOptional.get();

        clientsService.delete(clientsModel);

        verify(clientsRepository, times(1)).delete(Mockito.any());
    }



    @Before
    public void setup(){
        List<ClientsModel> clientsModelList = new ArrayList<ClientsModel>();


        ClientsModel clientsModelTest = new ClientsModel("Pablo","14997673435","pablo@outlook.com");
        clientsModelTest.setId(UUID.fromString("bbce4b9b-8faa-41fb-89a8-7a5baf5b5263"));
        clientsModelList.add(clientsModelTest);

        ClientsModel clientsModelTest2 = new ClientsModel("Pietro","14997259486","pietro@outlook.com");
        clientsModelTest2.setId(UUID.fromString("ada4d564-d3a5-4d70-92f8-07ee640c7b18"));
        clientsModelList.add(clientsModelTest2);

        ClientsModel clientsModelTest3 = new ClientsModel("Paulo","15978469137","paulo@gmail.com");
        clientsModelTest3.setId(UUID.fromString("7ec2f93f-a918-4126-a2bf-a86ea58e82a8"));
        clientsModelList.add(clientsModelTest3);


        Mockito.when(clientsRepository.findAll()).thenReturn(clientsModelList);
        Mockito.when(clientsRepository.findById(clientsModelTest2.getId())).thenReturn(java.util.Optional.of(clientsModelTest2));
        Mockito.when(clientsRepository.save(Mockito.any())).thenReturn(clientsModelTest);
        doNothing().when(clientsRepository).delete(Mockito.any());
    }
}
