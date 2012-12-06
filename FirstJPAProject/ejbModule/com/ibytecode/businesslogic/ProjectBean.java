package com.ibytecode.businesslogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.ibytecode.business.IProject;
import com.ibytecode.entities.Project;

/**
 * Session Bean implementation class ProjectBean
 */
@Stateless
public class ProjectBean implements IProject
{

   @PersistenceContext(unitName = "JPADB")
   private EntityManager entityManager;

   public ProjectBean()
   {
   }

   @Override
   public Project saveProject(Project project)
   {
      entityManager.persist(project);
      
      return project;
   }

   @Override
   public Project findProject(Project project)
   {
      Project p = entityManager.find(Project.class, project.getPnumber());
      return p;
   }

   @Override
   public List<Project> retrieveAllProjects()
   {

      String q = "SELECT p from " + Project.class.getName() + " p";
      Query query = entityManager.createQuery(q);
      List<Project> projects = query.getResultList();
      return projects;
   }

   @Override
   public Project deleteProject(Project project)
   {
      entityManager.remove(project);
      
      return project;
   }

   @Override
   public Project updateProject(Project project)
   {
      entityManager.merge(project);
      
      return project;
   }


   
}
