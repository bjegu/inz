package ClientsSystem.Domain.Service.Validator;

import ClientsSystem.Domain.Model.Agreement;
import java.time.LocalDate;


public class AgreementValidator {

    public static void isActive(Agreement agreement){
        LocalDate today =LocalDate.now();

        LocalDate start = agreement.getStart();
        LocalDate end = agreement.getEnd();

        if((start.isBefore(today)||start.isEqual(today))&&(end.isAfter(today)||end.isEqual(today))){
            agreement.setActive(true);
        }
        else agreement.setActive(false);
    }
}
