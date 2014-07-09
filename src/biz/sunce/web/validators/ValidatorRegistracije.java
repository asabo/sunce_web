package biz.sunce.web.validators;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import biz.sunce.web.dto.Registracija;

@Component("validatorRegistracije")
public class ValidatorRegistracije {
  public boolean supports(Class<?> klass) {
    return Registracija.class.isAssignableFrom(klass);
  }

  public void validate(Object target, Errors errors) {
    Registracija reg = (Registracija) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "naziv",
        "NotEmpty.registration.naziv",
        "Naziv ne može biti prazan.");
    
    String naziv = reg.getNaziv();
    if ((naziv.length()) > 50) {
      errors.rejectValue("naziv",
          "lengthOfUser.registration.naziv",
          "Naziv tvrtke ne može biti duži od 50 znakova.");
    }

  }
}
