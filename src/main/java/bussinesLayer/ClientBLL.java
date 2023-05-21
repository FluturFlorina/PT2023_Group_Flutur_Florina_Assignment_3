package bussinesLayer;

import bussinesLayer.Validators.ValidareEmail;
import bussinesLayer.Validators.Validator;
import dao.ClientDAO;
import model.Clients;

import java.util.ArrayList;
import java.util.List;
/**
 * Clasa ClientBLL reprezintă nivelul de logică de afaceri pentru gestionarea clienților.
 * Oferă metode pentru inserarea, actualizarea și ștergerea clienților, precum și pentru ștergerea comenzilor clienților.
 */

public class ClientBLL {
    private dao.ClientDAO clientDAO;
    private List<Validator<Clients>> validators;
    /**
     * Construiește un nou obiect ClientBLL.
     * Inițializează lista de validatori și creează o nouă instanță ClientDAO.
     */

    public ClientBLL() {
        validators = new ArrayList<Validator<Clients>>();
        validators.add(new ValidareEmail());
        clientDAO = new dao.ClientDAO();
    }
    /**
     * Inserează un nou client în sursa de date.
     * Validează clientul folosind validatorii înregistrați înainte de inserare.
     *
     * @param x Clientul care urmează să fie inserat.
     * @return Clientul inserat.
     */
    public Clients insertClient(Clients x) {
        for (Validator<Clients> v : validators) {
            v.validate(x);
        }
        return clientDAO.insert(x);
    }
    public Clients updateClient(Clients clients,String nume)
    {
        return clientDAO.update(clients,nume);
    }
    /**
     * Actualizează un client existent în sursa de date.
     *
     * @param nume    Numele clientului care urmează să fie actualizat.
     * @return Clientul actualizat.
     */

    /**
     * Șterge un client din sursa de date după nume.
     *
     * @param nume Numele clientului care urmează să fie șters.
     */
    public void deleteClient(String nume) {
        clientDAO.delete(nume);
    }
    /**
     * Șterge un client și comenzile asociate din sursa de date.
     * Șterge toate comenzile pentru client și apoi șterge clientul însuși.
     *
     * @param clientName Numele clientului care urmează să fie șters.
     */
    public void deleteClientOrders(String clientName) {
        ClientDAO clientDAO = new ClientDAO();
        OrdersBLL ordersBLL = new OrdersBLL();
        ordersBLL.deleteOrdersByClient(clientName);
        clientDAO.delete(clientName);

        System.out.println("Client and associated orders deleted successfully: " + clientName);
    }

}
