package models;

/**
 *
 * @author gceconelli
 */
public class Client {
    
    private String cpf;
    private String name;
    private String phoneNumber;
    private String email;

    public Client(String cpf, String name, String phoneNumber, String email) {
        this.cpf = cpf;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" + "cpf=" + cpf + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + '}';
    }
    
    
    
}
