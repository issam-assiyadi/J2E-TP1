package org.example.ext;

import org.example.dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version web service");
        double tmp = 11;
        return tmp;
    }
}
