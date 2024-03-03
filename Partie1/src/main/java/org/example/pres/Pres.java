package org.example.pres;

import org.example.dao.DaoImpl;
import org.example.metier.MetierImpl;

public class Pres {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl(dao);
        metier.setDao(dao);
        System.out.println(metier.calcul());
    }
}
