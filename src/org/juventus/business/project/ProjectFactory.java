package org.juventus.business.project;

import org.juventus.exceptions.NotFoundException;
import org.juventus.persistence.dataaccess.DAOFactory;
import org.juventus.persistence.dataaccess.project.ProjectDAO;

public class ProjectFactory {

    private static ProjectFactory instance;

    private ProjectDAO dao;

    private ProjectFactory() {
        ProjectFactory.instance = this;
        this.dao = DAOFactory.getInstance().getProjectDAO();
    }

    public static ProjectFactory getInstance() {
        if(ProjectFactory.instance == null) {
            new ProjectFactory();
        }
        return ProjectFactory.instance;
    }

    public Project[] getAllProjects() {
        return this.dao.selectAllProjects();
    }

    public Project getProjectByName(String name) throws NotFoundException {
        return this.dao.selectProject(name);
    }

    public Project createProject(String name, String description) {
        return new Project(name, description);
    }

    public void saveProject(Project project) {
        this.dao.insertProject(project);
    }

}
