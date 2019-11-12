package ClientsSystem.Domain.Service.Validator;

import ClientsSystem.Domain.Model.Client;

import java.util.stream.IntStream;

public class ClientValidator {

    public static void validateClient(Client client) {


        if (client.getRegon() == null && client.getPesel() == null){
            throw new ClientValidationException(client, "No pesel or regon inserted.");
        }
        if (client.getRegon() != null && client.getPesel() != null) {
            throw new ClientValidationException(client, "You should insert pesel OR regon");
        }
        if (client.getPesel() != null && isPeselValid(client.getPesel())) {
            throw new ClientValidationException(client, "The PESEL number is incorrect");
        }
        if (client.getRegon() != null && (client.getRegon().toString().length() != 9 || client.getRegon().toString().length() != 14)) {
            throw new ClientValidationException(client, "The REGON number is incorrect");
        }

    }

    private static boolean isPeselValid(Long pesel) {
        String peselSting= pesel.toString();
        if(peselSting.length() != 11){
            return false;
        }
        int[] weights = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3, 1};
        int sum = IntStream.range(0,11)
                .map(idx -> Integer.parseInt(peselSting.substring(idx,idx+1))*weights[idx])
                .sum();
        return sum%10 == 0;
    }
}
