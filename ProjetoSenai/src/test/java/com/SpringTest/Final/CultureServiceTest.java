package com.SpringTest.Final;

import com.SpringTest.Final.models.CultureModel;
import com.SpringTest.Final.repositories.CultureRepository;
import com.SpringTest.Final.services.CultureService;
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
public class CultureServiceTest {
    @TestConfiguration
    static class CultureServiceConfig{
        @Bean
        public CultureService cultureservice(){
            return new CultureService();
        }
    }
    @Autowired
    CultureService cultureService;

    @MockBean
    CultureRepository cultureRepository;




    @Test
    public void whenGetAllThenReturnGotAll(){
        List<CultureModel> cultureModels = cultureService.findAll();
        List<CultureModel> cultureModels2 = cultureRepository.findAll();

        Assertions.assertEquals(cultureModels,cultureModels2);
    }

    @Test
    public void whenGetOneThenReturnGotOne(){
        UUID id = UUID.fromString("ada4d564-d3a5-4d70-92f8-07ee640c7b18");
        Optional<CultureModel> cultureModel = cultureService.findById(id);
        Optional<CultureModel> cultureModel2 = cultureRepository.findById(id);

        Assertions.assertEquals(cultureModel,cultureModel2);
    }

    @Test
    public void whenSaveThenReturnSaved(){
        CultureModel cultureModel = new CultureModel("VEGETAIS");
        cultureModel.setId(UUID.fromString("bbce4b9b-8faa-41fb-89a8-7a5baf5b5263"));

        Optional<CultureModel> cultureModelOptional = Optional.ofNullable(cultureService.save(cultureModel));
        Optional<CultureModel> cultureModelOptional2 = Optional.of(cultureRepository.save(cultureModel));

        Assertions.assertEquals(cultureModelOptional,cultureModelOptional2);
    }

    @Test
    public void whenDeleteThenReturnDeleted(){
        UUID id = UUID.fromString("ada4d564-d3a5-4d70-92f8-07ee640c7b18");
        Optional<CultureModel> cultureModelOptional = cultureService.findById(id);

        CultureModel clientsModel = cultureModelOptional.get();

        cultureService.delete(clientsModel);

        verify(cultureRepository, times(1)).delete(Mockito.any());
    }



    @Before
    public void setup(){
        List<CultureModel> cultureModelList = new ArrayList<CultureModel>();


        CultureModel cultureModelTest = new CultureModel("VEGETAIS");
        cultureModelTest.setId(UUID.fromString("bbce4b9b-8faa-41fb-89a8-7a5baf5b5263"));
        cultureModelList.add(cultureModelTest);

        CultureModel cultureModelTest2 = new CultureModel("CEREAIS");
        cultureModelTest2.setId(UUID.fromString("ada4d564-d3a5-4d70-92f8-07ee640c7b18"));
        cultureModelList.add(cultureModelTest2);

        CultureModel cultureModelTest3 = new CultureModel("GRAOS");
        cultureModelTest3.setId(UUID.fromString("7ec2f93f-a918-4126-a2bf-a86ea58e82a8"));
        cultureModelList.add(cultureModelTest2);


        Mockito.when(cultureRepository.findAll()).thenReturn(cultureModelList);
        Mockito.when(cultureRepository.findById(cultureModelTest2.getId())).thenReturn(java.util.Optional.of(cultureModelTest2));
        Mockito.when(cultureRepository.save(Mockito.any())).thenReturn(cultureModelTest);
        doNothing().when(cultureRepository).delete(Mockito.any());
    }
}
