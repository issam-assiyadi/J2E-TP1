package org.example.metier;

import org.example.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("metier")
public class MetierImpl implements IMetier {
    private IDao dao;
    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 23;
        return res;
    }
    public MetierImpl(@Qualifier("dao") IDao dao) {
        this.dao = dao;
    }
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
