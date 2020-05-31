package org.juventus.persistence.dataaccess.project;

import org.juventus.business.project.Project;
import org.juventus.exceptions.NotFoundException;

public interface ProjectDAO {

    Project[] selectAllProjects();

    Project selectProject(String name) throws NotFoundException;

    void insertProject(Project project);

}
