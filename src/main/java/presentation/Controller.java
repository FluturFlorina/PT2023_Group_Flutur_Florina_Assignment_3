package presentation;

import bussinesLayer.ClientBLL;
import bussinesLayer.OrdersBLL;
import bussinesLayer.ProductBLL;
import dao.ClientDAO;
import model.Clients;
import model.Orders;
import model.Products;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    public ViewLogare logare;
    public ViewMeniu menu;
    public ViewClienti ac;
    public ViewProduse ap;
    public ViewComenzi ab;
    public ViewListe listare;
    public ViewUtile met;
    public ClientDAO client;
    public boolean acok=false;
    public boolean apok=false;
    public boolean abok=false;
    public boolean alok=false;
    /**
     * Constructorul clasei Controller.
     * @param logare Obiectul ViewLogare asociat.
     * @param menu Obiectul ViewMeniu asociat.
     * @param ac Obiectul ViewClienti asociat.
     * @param ap Obiectul ViewProduse asociat.
     * @param ab Obiectul ViewComenzi asociat.
     * @param listare Obiectul ViewListe asociat.
     * @param met Obiectul ViewUtile asociat.
     * @param client Obiectul ClientDAO asociat.
     */
    public Controller(ViewLogare logare,ViewMeniu menu,ViewClienti ac,ViewProduse ap,ViewComenzi ab,ViewListe listare,ViewUtile met,ClientDAO client)
    {
        this.logare=logare;
        this.menu=menu;
        this.ac=ac;
        this.ap=ap;
        this.ab=ab;
        this.listare=listare;
        this.met=met;
        this.client=client;

        this.logare.frame.setVisible(true);
        this.menu.frame.setVisible(false);
        this.ac.frame.setVisible(false);
        this.ap.frame.setVisible(false);
        this.ab.frame.setVisible(false);
        this.listare.frame.setVisible(false);

        this.logare.butonf1(new presentation.Controller.ActiuneButon1());

        this.menu.butonf1(new presentation.Controller.ActiuneButon2());
        this.menu.butonf2(new presentation.Controller.ActiuneButon3());
        this.menu.butonf3(new presentation.Controller.ActiuneButon4());
        this.menu.butonf4(new presentation.Controller.ActiuneButon5());
        this.menu.butonf5(new presentation.Controller.ActiuneButon6());

        this.ac.butonf1(new presentation.Controller.ActiuneButon7());

        this.ap.butonf1(new presentation.Controller.ActiuneButon8());

        this.ab.butonf1(new presentation.Controller.ActiuneButon9());
        met.incarcare(ab.clientif, ab.produsef);
        listare.tabel1.setModel(met.generareTabel(met.generarelista(new Clients(0, null,null,0).getClass()), new Clients(0,null, null,0).getClass()).getModel());
        listare.tabel2.setModel(met.generareTabel(met.generarelista(new Products(0, null, 0, 0).getClass()), new Products(0, null, 0, 0).getClass()).getModel());
        listare.tabel3.setModel(met.generareTabel(met.generarelista(new Orders(0,null, null,0,0).getClass()), new Orders(0,null, null,0,0).getClass()).getModel());
    }
    class ActiuneButon1 implements ActionListener
    {
        /**
         * Metoda actionPerformed.
         * @param e Evenimentul de acțiune.
         */
        public void actionPerformed(ActionEvent e)
        {
            if(met.logareMet(logare.userf.getText(), logare.passf.getText()))
            {
                menu.frame.setVisible(true);
                logare.frame.setVisible(false);
                logare.userf.setText("");
                logare.passf.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "DateIncorecte");
            }
        }

    }

    class ActiuneButon2 implements ActionListener
    {
        /**
         * Metoda actionPerformed.
         * @param e Evenimentul de acțiune.
         */
        public void actionPerformed(ActionEvent e)
        {
            if(acok)
            {
                ac.frame.setVisible(false);
                acok=false;
            }
            else
            {
                ac.frame.setVisible(true);
                acok=true;
            }
        }

    }

    class ActiuneButon3 implements ActionListener
    {
        /**
         * Metoda actionPerformed.
         * @param e Evenimentul de acțiune.
         */
        public void actionPerformed(ActionEvent e)
        {
            if(apok)
            {
                ap.frame.setVisible(false);
                apok=false;
            }
            else
            {
                ap.frame.setVisible(true);
                apok=true;
            }
        }

    }

    class ActiuneButon4 implements ActionListener
    {
        /**
         * Metoda actionPerformed.
         * @param e Evenimentul de acțiune.
         */
        public void actionPerformed(ActionEvent e)
        {
            if(abok)
            {
                ab.frame.setVisible(false);
                abok=false;
            }
            else
            {
                ab.frame.setVisible(true);
                abok=true;
            }
        }

    }

    class ActiuneButon5 implements ActionListener
    {
        /**
         * Metoda actionPerformed.
         * @param e Evenimentul de acțiune.
         */
        public void actionPerformed(ActionEvent e)
        {
            if(alok)
            {
                listare.frame.setVisible(false);
                alok=false;
            }
            else
            {
                listare.frame.setVisible(true);
                alok=true;
            }
        }
    }

    class ActiuneButon6 implements ActionListener
    {
        /**
         * Metoda actionPerformed.
         * @param e Evenimentul de acțiune.
         */
        public void actionPerformed(ActionEvent e)
        {
            logare.frame.setVisible(true);
            menu.frame.setVisible(false);
            ac.frame.setVisible(false);
            ap.frame.setVisible(false);
            ab.frame.setVisible(false);
            listare.frame.setVisible(false);
        }
    }
    class ActiuneButon7 implements ActionListener {
        /**
         * Metoda actionPerformed.
         * @param e Evenimentul de acțiune.
         */
        public void actionPerformed(ActionEvent e) {
            String selectedOperation = (String) ac.operatii.getSelectedItem();
            String numevfText = ac.numevf.getText();
            String numenfText = ac.numenf.getText();
            Clients client = new Clients(ac.numevf.getText(),ac.emailf.getText(),Integer.parseInt(ac.agef.getText()));
            ClientBLL clientBLL = new ClientBLL();

            boolean ok = false;
            if (selectedOperation.equals("new") && !numevfText.equals("")) {
                clientBLL.insertClient(client);
                ok=true;
            } else if (selectedOperation.equals("edit") && !numevfText.equals("") && !numenfText.equals("")) {
                ClientBLL clientBLL1 = new ClientBLL();
              Clients client1=new Clients();
              client1.setNume(ac.numenf.getText());
              client1.setEmail(ac.emailnouf.getText());
              client1.setVarsta(Integer.parseInt(ac.agenouf.getText()));
                System.out.println(ac.numenf.getText());
                System.out.println(Integer.parseInt(ac.agenouf.getText()));
               clientBLL1.updateClient(client1,ac.numevf.getText());
                ok=true;
            } else if (selectedOperation.equals("delete") && !numevfText.equals("")) {
                ClientBLL clientBLL2 = new ClientBLL();
                String selectedClient=ac.numevf.getText();
                clientBLL2.deleteClient((ac.numevf.getText()));
                clientBLL2.deleteClientOrders(selectedClient);
                ok=true;
            }
            if (ok) {
                JOptionPane.showMessageDialog(null, "Operatia a reusit");
                ac.numenf.setText("");
                ac.numevf.setText("");
                ac.emailnouf.setText("");
                ac.emailf.setText("");
                ac.agef.setText("");
                ac.agenouf.setText("");
                met.incarcare(ab.clientif, ab.produsef);
            } else {
                JOptionPane.showMessageDialog(null, "Operatia nu a reusit");
            }
            listare.tabel1.setModel(met.generareTabel(met.generarelista(new Clients(0, null,null,0).getClass()), new Clients(0,null, null,0).getClass()).getModel());
                listare.tabel2.setModel(met.generareTabel(met.generarelista(new Products(0, null, 0, 0).getClass()), new Products(0, null, 0, 0).getClass()).getModel());
            listare.tabel3.setModel(met.generareTabel(met.generarelista(new Orders(0,null, null,0,0).getClass()), new Orders(0,null, null,0,0).getClass()).getModel());
        }
    }

    class ActiuneButon8 implements ActionListener {
        /**
         * Metoda actionPerformed.
         * @param e Evenimentul de acțiune.
         */
        public void actionPerformed(ActionEvent e) {
            boolean ok=false;
            String selectedOperation = (String) ap.operatii.getSelectedItem();
            int cantitate = Integer.parseInt(ap.cantf.getText());
            int pret = Integer.parseInt(ap.pretf.getText());

            if (selectedOperation.equals("new") && !ap.numevf.getText().equals("")) {
                Products product = new Products(ap.numevf.getText(), pret, cantitate);
                ProductBLL productBLL = new ProductBLL();
                productBLL.insertProduct(product);
                ok=true;
            } else if (selectedOperation.equals("edit") && !ap.numevf.getText().equals("") && ! ap.numenf.getText().equals("")) {
                ProductBLL productBLL1 = new ProductBLL();
                Products p = new Products();
                p.setNume(ap.numenf.getText());
                p.setPret(Integer.parseInt(ap.pretnou.getText()));
                p.setCantitate(Integer.parseInt(ap.cantnou.getText()));
                productBLL1.updateProduct(p,ap.numevf.getText());
                ok=true;
            }
            else if (selectedOperation.equals("delete") && !ap.numevf.getText().equals("")) {
                ProductBLL clientBLL2 = new ProductBLL();
                String selectedProduct=ap.numevf.getText();
                clientBLL2.deleteProduct((ap.numevf.getText()));
                OrdersBLL ordersBLL = new OrdersBLL();
                ProductBLL productBLL = new ProductBLL();
                ordersBLL.deleteOrder(selectedProduct);
                 productBLL.deleteProduct(selectedProduct);
                ok=true;
            }
            if (ok) {
                    JOptionPane.showMessageDialog(null, "Operația a reușit");
                    ap.numenf.setText("");
                    ap.numevf.setText("");
                    ap.cantf.setText("");
                    ap.pretf.setText("");
                    met.incarcare(ab.clientif, ab.produsef);
               } else {
                    JOptionPane.showMessageDialog(null, "Operația nu a reușit");
                }
            listare.tabel1.setModel(met.generareTabel(met.generarelista(new Clients(0, null,null,0).getClass()), new Clients(0,null, null,0).getClass()).getModel());
              listare.tabel2.setModel(met.generareTabel(met.generarelista(Products.class), Products.class).getModel());
            listare.tabel3.setModel(met.generareTabel(met.generarelista(new Orders(0,null, null,0,0).getClass()), new Orders(0,null, null,0,0).getClass()).getModel());
        }
    }

    class ActiuneButon9 implements ActionListener {
        /**
         * Metoda actionPerformed.
         * @param e Evenimentul de acțiune.
         */
        public void actionPerformed(ActionEvent e) {
            boolean ok=false;
            if (ab.cantitatef.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Completați toate câmpurile.");
            } else {
                String selectedClient = (String) ab.clientif.getSelectedItem();
                String selectedProduct = (String) ab.produsef.getSelectedItem();
                OrdersBLL ordersBLL = new OrdersBLL();
                Orders order = new Orders(selectedClient, selectedProduct, Integer.parseInt(ab.cantitatef.getText()));
                ProductBLL product=new ProductBLL();
                Products pro=product.findProductByNume(order.getNume_produse());
                //if(selectedProduct==)
                if ( order.getCantitate()> pro.getCantitate()) {
                    JOptionPane.showMessageDialog(null, "Stoc insuficient!");
                }
                else {
                    pro.setCantitate(pro.getCantitate()-order.getCantitate());
                     order.setPret(Integer.parseInt(ab.pretf.getText()));
                     product.updateProduct(pro,order.getNume_produse());
                    ordersBLL.insertOrders(order);
                    ok=true;
                }
                if (ok) {
                    JOptionPane.showMessageDialog(null, "Operația a reușit.");
                    ab.cantitatef.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Operația nu a reușit.");
                }
            }
            listare.tabel1.setModel(met.generareTabel(met.generarelista(new Clients(0, null,null,0).getClass()), new Clients(0,null, null,0).getClass()).getModel());
              listare.tabel2.setModel(met.generareTabel(met.generarelista(Products.class), Products.class).getModel());
            listare.tabel3.setModel(met.generareTabel(met.generarelista(new Orders(0,null, null,0,0).getClass()), new Orders(0,null, null,0,0).getClass()).getModel());
        }
    }

}
