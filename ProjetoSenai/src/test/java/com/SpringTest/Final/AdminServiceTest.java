package com.SpringTest.Final;

import com.SpringTest.Final.models.AdminsModel;
import com.SpringTest.Final.repositories.AdminsRepository;
import com.SpringTest.Final.services.AdminsService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class AdminServiceTest {
    @TestConfiguration
    static class AdminsServiceConfig{
        @Bean
        public AdminsService adminsservice(){
            return new AdminsService();
        }
    }
    @Autowired
    AdminsService adminsService;

    @MockBean
    AdminsRepository adminsRepository;




    @Test
    public void whenGetAllThenReturnGotAll(){
        List<AdminsModel> adminsModels = adminsService.findAll();
        List<AdminsModel> adminsModels2 = adminsRepository.findAll();

        Assertions.assertEquals(adminsModels,adminsModels2);
    }

    @Test
    public void whenGetOneThenReturnGotOne(){
        UUID id = UUID.fromString("ada4d564-d3a5-4d70-92f8-07ee640c7b18");
        Optional<AdminsModel> adminsModel = adminsService.findById(id);
        Optional<AdminsModel> adminsModel2 = adminsRepository.findById(id);

        Assertions.assertEquals(adminsModel,adminsModel2);
    }

    @Test
    public void whenSaveThenReturnSaved(){
        AdminsModel adminsModelTest1 = new AdminsModel("Mateus","mateus@gmail.com.br","mateus123");
        adminsModelTest1.setId(UUID.fromString("bbce4b9b-8faa-41fb-89a8-7a5baf5b5263"));
        adminsModelTest1.setType_admin(true);

        Optional<AdminsModel> adminsModelOptional = Optional.ofNullable(adminsService.save(adminsModelTest1));
        Optional<AdminsModel> adminsModelOptional2= Optional.of(adminsRepository.save(adminsModelTest1));

        Assertions.assertEquals(adminsModelOptional,adminsModelOptional2);
    }

    @Test
    public void whenDeleteThenReturnDeleted(){
        UUID id = UUID.fromString("ada4d564-d3a5-4d70-92f8-07ee640c7b18");
        Optional<AdminsModel> adminsModelOptional = adminsService.findById(id);

        AdminsModel adminsModel = adminsModelOptional.get();

        adminsService.delete(adminsModel);

        verify(adminsRepository, times(1)).delete(Mockito.any());
    }



    @Before
    public void setup(){
        List<AdminsModel> adminsModelList = new ArrayList<AdminsModel>();

        AdminsModel adminsModelTest1 = new AdminsModel("Mateus","mateus@gmail.com.br","mateus123");
        adminsModelTest1.setId(UUID.fromString("bbce4b9b-8faa-41fb-89a8-7a5baf5b5263"));
        adminsModelTest1.setType_admin(true);
        adminsModelList.add(adminsModelTest1);

        AdminsModel adminsModelTest2 = new AdminsModel("Marcos","marcos@hotmail.com.br","marcos123");
        adminsModelTest2.setId(UUID.fromString("ada4d564-d3a5-4d70-92f8-07ee640c7b18"));
        adminsModelTest2.setType_admin(false);
        adminsModelList.add(adminsModelTest2);

        AdminsModel adminsModelTest3 = new AdminsModel("Marcelo","marcelo@outlook.com","marcelo123");
        adminsModelTest3.setId(UUID.fromString("7ec2f93f-a918-4126-a2bf-a86ea58e82a8"));
        adminsModelTest3.setType_admin(true);
        adminsModelList.add(adminsModelTest3);


        when(adminsRepository.findAll()).thenReturn(adminsModelList);
        when(adminsRepository.findById(adminsModelTest2.getId())).thenReturn(java.util.Optional.of(adminsModelTest2));
        when(adminsRepository.save(Mockito.any())).thenReturn(adminsModelTest1);
        doNothing().when(adminsRepository).delete(Mockito.any());

    }
}
