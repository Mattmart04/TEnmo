package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
public class TransferService {
    private static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();
    private final AccountService accountService;

    private final String baseUrl;
    private List<Transfer> myTransferHistory=new ArrayList<>();

    public TransferService(String baseUrl, AccountService accountService) {
        this.baseUrl = baseUrl;
        this.accountService = accountService;
    }

    //I'm trying to use RestTemplate.Exchange to get a List of Transfer where 'my' user is present
    //going to use later in the bottom method getTransferFromID
    private void setListOfTransfers(AuthenticatedUser user){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(user.getToken());
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        try{
            ResponseEntity<List<Transfer>> response =
                    restTemplate.exchange(API_BASE_URL + "??", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Transfer>>(){} ); //need to get transfers endpoint for "??"

            myTransferHistory = response.getBody();

        }catch (RestClientResponseException | ResourceAccessException e){
            System.out.println(e.getMessage());
        }

    }
    public Transfer[] transfersList() {

        Transfer [] output = null;
        try {
            output = restTemplate.exchange(baseUrl + "/transfers/{id}" + currentUser.getUser().getId(), HttpMethod.GET, makeAuthEntity(), Transfer[].class).getBody();

            StringBuilder line= new StringBuilder("");
            for (int i = 0; i < (52) ; i++) {
                line.append("-");
            }
            line.append("\n");
            String transfers = line + "TRANSFERS\n" +
                    "ID          From/To                 Amount\n" + line;
            System.out.println(transfers);
            String fromOrTo = "";
            String name = "";
            for (Transfer i : output) {
                if (currentUser.getUser().getId() == i.getAccountFrom()) {
                    fromOrTo = "From: ";
                    //need to get
                    //name = i.??();
                } else {
                    fromOrTo = "To: ";
                    //name = i.??();
                }
                System.out.println(i.getTransferId() +"\t\t\t" + fromOrTo + name + "\t\t\t$" + i.getAmount());
            }
            System.out.print("-------------------------------------------\n");
        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }
        return output;
    }

    public String getTransferDetails(AuthenticatedUser user, int transferId){
        StringBuilder line= new StringBuilder("");
        for (int i = 0; i < (52) ; i++) {
            line.append("-");
        }
        line.append("\n");
        String transferDetails = line + "TRANSFER DETAILS \n" + line;

        Transfer t = getTransferFromTransferID(user, transferId);
        if (t == null) {
            return "Invalid Transfer ID";
        } else {
            String format = "\nID: %s " +
                    "\nFROM: %s " +
                    "\nTO: %s" +
                    "\nTYPE: %s" +
                    "\nSTATUS: %s " +
                    "\nAMOUNT: $ %s";

            String string = ((String.format(format,
                    t.getTransferId(),
                    t.getAccountFrom(),
                    t.getAccountTo(),
                    t.getTransferType(),
                    t.getTransferStatus(),
                    t.getAmount())));

            return transferDetails + string;
        }
    }

    //returns a single transfer from list of MyTransfers
    //updates list everytime
    private Transfer getTransferFromTransferID (AuthenticatedUser user,int id){
        try{
            setListOfTransfers(user);
            for (Transfer t : myTransferHistory) {
                if (t.getTransferId() == id) {
                    return t;
                }
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }

    private HttpEntity makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }

}
