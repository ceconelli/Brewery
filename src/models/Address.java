package models;

/**
 *
 * @author gceconelli
 */
public class Address {
    
    private String cep;
    private String addressNumber;
    private String complement;
    private Client client;

    public Address(String cep, String addressNumber, String complement, Client client) {
        this.cep = cep;
        this.addressNumber = addressNumber;
        this.complement = complement;
        this.client = client;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
}
