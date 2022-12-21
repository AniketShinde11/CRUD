package com.spring.ormfirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ormfirst.dao.StudentDao;
import com.spring.ormfirst.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
       
        
        ApplicationContext context=new ClassPathXmlApplicationContext("configf.xml");
        
       StudentDao studentDao =context.getBean("studentDao",StudentDao.class);
       
//       Student student=new Student(2313,"Akash","Kolhapur");        
//            int r= studentDao.insert(student); 
//            System.out.println( "done"  +r );
       
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      
       
       boolean go=true;
       while(go)
       {
       System.out.println("PRESS 1 FOR ADD NEW STUDENT RECORD");
       System.out.println("PRESS 2 FOR DISPLAY ALL STUDENT RECORD");
       System.out.println("PRESS 3 FOR DISPLAY SINGLE STUDENT RECORD");
       System.out.println("PRESS 4 FOR DELETE STUDENT RECORD");
       System.out.println("PRESS 5 FOR UPDATE STUDENT RECORD");
       System.out.println("PRESS 6 FOR EXIT");
       
       try {
    	  int choice= Integer.parseInt(br.readLine());
    	   
    	  switch (choice) 
	  {
		case 1:
			   
			System.out.println("Enter Student Id");
			int id=Integer.parseInt(br.readLine());
			
			System.out.println("Enter Student Name");
			String name=br.readLine();
			
			System.out.println("Enter Student City");
			String city=br.readLine();
			
			Student s=new Student();
			s.setStudentId(id);
			s.setStudentName(name);
            s.setStudentCity(city);
            
            int r=studentDao.insert(s);
            System.out.println(r+"Record Added Successful");
            System.out.println("____________________________________________");
			
					break;
		case 2:
			
			       List<Student> allStudent = studentDao.getAllStudent();
			       for(Student st:allStudent)
			       {
			    	   System.out.println("Id : "+st.getStudentId());
			    	   System.out.println("Name : "+st.getStudentName());
			    	   System.out.println("City : "+st.getStudentCity());
			    	   System.out.println("____________________________________________");
			    	   System.out.println("");
			       }
					break;
		case 3:
			
			System.out.println("Enter Student Id");
			int sid=Integer.parseInt(br.readLine());
			Student student=studentDao.getStudent(sid);
			System.out.println("Id : "+student.getStudentId());
    	    System.out.println("Name : "+student.getStudentName());
    	    System.out.println("City : "+student.getStudentCity());
    	   	System.out.println("____________________________________________");
    	    System.out.println("");	
	        
    	    break;
	        	        
		case 4:
			
			System.out.println("Enter Student Id");
			int std=Integer.parseInt(br.readLine());
			studentDao.delete(std);
			System.out.println("Student Record Deleted....!");
			System.out.println("____________________________________________");
	   		System.out.println("");
			
	   		break;
			
			
		case 5:
		
			Student st=new Student();
			
			
	    	System.out.println("enetr Update studentId");
			int sstd=Integer.parseInt(br.readLine());
			
			Student std1=studentDao.getStudent(sstd);

			System.out.println("Enter Student Name");
			String na=br.readLine();
			
			System.out.println("Enter Student City");
			String ci=br.readLine();
			
			Student stu=new Student(sstd,na,ci);
			
			//std1.setStudentName(na);
			//std1.setStudentCity(ci);
			
			studentDao.updateStudent(stu);
		
			
			
						
			
					break;
		case 6:
			        go=false;
					break;

		}
    	   
    	   
       }catch (Exception e) {
    	   System.out.println("ENVALID INPUT TRY WITH ANOTHER ONE !!");
    	   System.out.println(e.getMessage());
	}
       
       
       }
       
       
     System.out.println("Thankyou for using my application");
       
       
    }
}
