package com.bugtrackertool.bugtrackertool.models.dto;

import com.bugtrackertool.bugtrackertool.models.Project;
import com.bugtrackertool.bugtrackertool.models.User;

public class TicketDTO extends FormDTO {

    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
