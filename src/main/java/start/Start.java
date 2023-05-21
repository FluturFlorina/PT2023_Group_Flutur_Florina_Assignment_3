package start;

import dao.ClientDAO;
import presentation.Controller;
import presentation.*;

public class Start {
        public static void main(String[] args) {
            Controller cont=new Controller(new ViewLogare(),new ViewMeniu(),new ViewClienti(),new ViewProduse(),new ViewComenzi(),new ViewListe(),new ViewUtile(),new ClientDAO());
        }
    }

