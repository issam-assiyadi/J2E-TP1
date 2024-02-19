package presentation;

import dao.DaoImpl;
import dao.IDao;
import ext.DaoImpl2;
import metier.IMetier;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        //DaoImpl dao = new DaoImpl();
        DaoImpl2 dao = new DaoImpl2();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);
        System.out.println("Result = " + metier.calcul());
    }
}
