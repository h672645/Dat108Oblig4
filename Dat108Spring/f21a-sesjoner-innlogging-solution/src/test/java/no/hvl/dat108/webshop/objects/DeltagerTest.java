package no.hvl.dat108.webshop.objects;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import no.hvl.dat108.webshop.interfaces.DeltagerRepo;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import no.hvl.dat108.webshop.objects.Deltager;
import no.hvl.dat108.webshop.services.DeltagerService;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock; 
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class DeltagerTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Mock
    DeltagerRepo mockedDeltagerRepo;

    @InjectMocks
    DeltagerService deltagerService;


    @Test
    void testOmPersonHarPassord(){

        Deltager deltager1 = new Deltager("Juan", "Garcia", "46514040","2trollface21","mann");
        assertTrue(inneholder(deltager1,"passord"));
    }
    @Test
    void testOmPersonHarFornavnOgEtternavn(){
        Deltager deltager2 = new Deltager("Eric","Martinez","65435412","piplup211","mann");
        assertTrue(inneholder(deltager2,"fornavn"));
    }
@Test
    void TestOmFinnerDeltagerMedMobil() {

        when(mockedDeltagerRepo.findAll()).thenReturn(List.of(
                new Deltager("Marco","Guiterrez","75838933","test56","mann"),
                new Deltager("Johanna","Lindgren","65424254","vinkork2377","kvinne"),
                new Deltager("Maria","Sousa","75231254","h24ha","kvinne"),
                new Deltager("Fritz","Grossmann","22355311","schnitzel20","mann")
                ));

                Deltager resultat = deltagerService.finnDeltagerMedMobil("75838933");
                System.out.println(resultat.toString());

                assertTrue(resultat.getPassord()=="test56");
    }



    private boolean inneholder(Deltager deltager, String egenskap) {
        return !validator.validate(deltager).stream().map(v -> v.getPropertyPath().toString()).collect(Collectors.toSet()).contains(egenskap);
    }
}
