package org.juventus.controller;

import org.juventus.domain.Project;
import org.juventus.exceptions.NotFoundException;
import org.juventus.persistence.InMemoryDB;

public class MainController {

    public static void main(String[] args)
    {
        MainController controller = new MainController();

        InMemoryDB<Project> projects = new InMemoryDB<>();

        try {
            System.out.println(projects.getById(1).getName());
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
