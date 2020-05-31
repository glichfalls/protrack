package org.juventus.persistence.dataaccess.project;

import org.juventus.business.project.Project;
import org.juventus.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ProjectDAOMock implements ProjectDAO {

    private List<Project> projects = new ArrayList<>();

    public Project[] selectAllProjects() {
        Project[] projects = new Project[this.projects.size()];
        return this.projects.toArray(projects);
    }

    public Project selectProject(String name) throws NotFoundException {
        for(Project project : this.projects) {
            if(project.getName().equals(name)) {
                return project;
            }
        }
        throw new NotFoundException("The project " + name + " does not exist.");
    }

    public void insertProject(Project project) {
        this.projects.add(project);
    }

}
