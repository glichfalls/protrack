package org.juventus.presentation;

import org.juventus.business.project.Project;
import org.juventus.business.project.ProjectFactory;
import org.juventus.exceptions.NotFoundException;
import java.util.Scanner;

public class ConsoleClient {

    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ConsoleClient client = new ConsoleClient();
        client.startUp();
    }

    private void startUp() {
        System.out.println("Welcome to ProTrack");
        this.createInitialData();
        int option = 1;
        while (option != 0) {
            option = this.getMenuOption();
            this.handleMenuSelection(option);
            System.out.println("Press any key to continue");
            this.input.next();
            System.out.println("\n\n");
        }
    }

    private void createInitialData() {
        ProjectFactory factory = ProjectFactory.getInstance();
        factory.saveProject(factory.createProject("Project A", "This is the first Project."));
        factory.saveProject(factory.createProject("Project B", "This is the second Project."));
        factory.saveProject(factory.createProject("Project C", "This is the third Project."));
    }

    private int getMenuOption() {
        System.out.println("Please chose from following options");
        System.out.println("-----------------------------------");
        System.out.println("1 - Create a new project");
        System.out.println("2 - Display all available projects");
        System.out.println("3 - select a specific project");
        System.out.println("0 - Quit");
        int selection;
        do {
            while (!this.input.hasNextInt()) {
                System.out.println("Please enter a valid option (0 - 3)");
                this.input.next();
            }
            selection = this.input.nextInt();
            if(selection < 0 || selection > 3) {
                System.out.println("Invalid option");
            }
        } while (selection < 0 || selection > 3);
        return selection;
    }

    private void handleMenuSelection(int option) {
        switch (option) {
            case 0: System.out.println("Bye."); break;
            case 1: this.createProject(); break;
            case 2: this.listProjects(); break;
            case 3: this.displayProject(); break;
            default: System.out.printf("%d is an invalid option.\n", option); break;
        }
    }

    private void createProject() {
        String name, description;
        System.out.println("Selection: Create a new project");
        System.out.println("--------------------------------\n");
        System.out.println("Please enter the project name:");
        name = this.input.next();
        System.out.println("Please add a description:");
        description = this.input.next();
        ProjectFactory.getInstance().saveProject(ProjectFactory.getInstance().createProject(name, description));
        System.out.println("The project " + name + " was created successfully.");
    }

    private void listProjects() {
        System.out.println("Selection: list all projects");
        System.out.println("--------------------------------\n");
        Project[] projects = ProjectFactory.getInstance().getAllProjects();
        for (Project project : projects) {
            System.out.println(project.getName() + ": " + project.getDescription());
        }
    }

    private void displayProject() {
        System.out.println("Selection: get a single project by name");
        System.out.println("--------------------------------\n");
        System.out.println("Please enter the project name:");
        try {
            Project project = ProjectFactory.getInstance().getProjectByName(this.input.next());
            System.out.println("Name: " + project.getName());
            System.out.println("Description: " + project.getDescription());
            System.out.println("Status: " + project.getStatus());
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
