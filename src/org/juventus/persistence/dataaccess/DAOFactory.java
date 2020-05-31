package org.juventus.persistence.dataaccess;

import org.juventus.persistence.dataaccess.project.ProjectDAO;
import org.juventus.persistence.dataaccess.project.ProjectDAOMock;

public class DAOFactory {

    protected static DAOFactory instance;

    protected DAOFactory() {
        DAOFactory.instance = this;
    }

    public static DAOFactory getInstance() {
        if(DAOFactory.instance == null) {
            new DAOFactory();
        }
        return DAOFactory.instance;
    }

    public ProjectDAO getProjectDAO() {
        return new ProjectDAOMock();
    }

}
