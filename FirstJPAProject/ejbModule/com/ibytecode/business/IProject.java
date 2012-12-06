package com.ibytecode.business;

import java.util.List;

import javax.ejb.Remote;

import com.ibytecode.entities.Project;

@Remote
public interface IProject 
{
   Project saveProject(Project project);
   Project findProject(int pNumber);
   List<Project> retrieveAllProjects();

   Project deleteProject(Project project);
   
   Project updateProject(Project project);


}
