package model;

public class Clients
{
    private int id;
    private String nume;
    private String email;
    private int varsta;
    public Clients()
    {

    }
    /**
     * Constructs a Clients object with the specified id, name, email, and age.
     *
     * @param id     the id of the client
     * @param nume   the name of the client
     * @param email  the email of the client
     * @param varsta the age of the client
     */
    public Clients(int id,String nume,String email,int varsta)
    {
        this.setId(id);
        this.setNume(nume);
        this.setEmail(email);
        this.setVarsta(varsta);
    }
    /**
     * Constructs a Clients object with the specified name, email, and age.
     *
     * @param nume   the name of the client
     * @param email  the email of the client
     * @param varsta the age of the client
     */
    public Clients(String nume,String email,int varsta)
    {
        this.nume=nume;
        this.email=email;
        this.varsta=varsta;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Client: " +
                "[ id=" + id +
                ", name=" + nume;
    }

    public String getClientEmail() {
        return email;
    }
}
