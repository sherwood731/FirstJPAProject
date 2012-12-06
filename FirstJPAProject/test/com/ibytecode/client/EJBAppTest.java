package com.ibytecode.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.ibytecode.business.IProject;
import com.ibytecode.clientutility.JNDILookupClass;
import com.ibytecode.entities.Project;

public class EJBAppTest
{
   IProject bean = null;
   private static final String LOOKUP_STRING = "ProjectBean/remote";
   
   @Before
   public void setUp() throws Exception
   {
      Context context = null;
      
      try
      {
         // 1. Obtaining Context
         context = JNDILookupClass.getInitialContext();
         // 2. Lookup and cast
         bean = (IProject) context.lookup(LOOKUP_STRING);

      } 
      catch (NamingException e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void testRead()
   {
      testCreate();
   
      Project project = bean.findProject(1);

      assertNotNull(project);
   }

   @Test
   public void testCreate()
   {
      Project p1 = new Project();
      p1.setPname("Banking App");
      p1.setPlocation("Town City");
      p1.setDeptNo(1);

      bean.saveProject(p1);
   }
   
   @Test
   public void testUpdate()
   {
      testCreate();
      
      Project project = bean.findProject(1);

      project.setPname("Updated Name");
      
      bean.updateProject(project);
      
   }

   @Test
   public void testReadAll()
   {
      List<Project> projectList = bean.retrieveAllProjects();
      
      // Do you tests here...
   }

   @Test
   public void testDelete()
   {
      testCreate();
      
      Project project = bean.findProject(1);

      bean.deleteProject(project);
   
      project = bean.findProject(1);

      assertNull(project);
   }

}
