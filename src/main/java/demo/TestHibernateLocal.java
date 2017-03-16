package demo;

/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The simplest possible servlet.
 *
 * @author James Duncan Davidson
 */

public class TestHibernateLocal extends HttpServlet {

	
	
	 
	
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        /*ResourceBundle rb =
            ResourceBundle.getBundle("LocalStrings",request.getLocale());*/
    	//List<SoCity> l = new ArrayList<SoCity>();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        
	    String title = "I am inside JPA Call";
	    TestJPARead testJpaMyRead = new TestJPARead();
	    //List<SoCity> soCities = testJpaMyRead.GetCitiesBySQL();
	    SoCity soCity = new SoCity();
	    soCity.setSoCityId(1);
	    //testJpaMyRead.findBook();
	    List<SoLocation> soLocations = testJpaMyRead.GetLocationsByCity();

/*	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         
        SoCountry soCon = new SoCountry();
        soCon.setSoCountryName("Australia");
         
        session.save(soCon);
        session.getTransaction().commit();
         
        session.close();*/
/*	    Query query=session.createQuery("from SoCity");//here persistent class name is Emp  
	    List list=query.list();  */

	    out.println("<title>" + "Call Success" + "</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");

	// note that all links are created to be relative. this
	// ensures that we can move the web application that this
	// servlet belongs to to a different place in the url
	// tree and not have any harmful side effects.

        // XXX
        // making these absolute till we work out the
        // addition of a PathInfo issue

	    out.println("<a href=\"../helloworld.html\">");
        out.println("<img src=\"../images/code.gif\" height=24 " +
                    "width=24 align=right border=0 alt=\"view code\"></a>");
        out.println("<a href=\"../index.html\">");
        out.println("<img src=\"../images/return.gif\" height=24 " +
                    "width=24 align=right border=0 alt=\"return\"></a>");
	    /*for (SoCity soCity : soCities) {
		      System.out.println("Book id is " + soCity.getSoCityId());
		      System.out.println("Book name is " + soCity.getSoCityName());
		      out.println("<h1>" + "City id is " + soCity.getSoCityId() +">>>" + 
		      "City name is " + soCity.getSoCityName()+ "</h1>");
		      System.out.println("---------------------------------------------------------------");
	    } */
        for (SoLocation soLocation : soLocations) {
        	/*		      System.out.println("Book id is " + soCity.getSoCityId());
        			      System.out.println("Book name is " + soCity.getSoCityName());*/
        			      out.println("<h1>" + "Location id is " + soLocation.getSoLocationId() +">>>" + 
        			      "City name is " + soLocation.getSoLocationName()+ "</h1>");
        			      System.out.println("---------------------------------------------------------------");
        		    }         
        out.println("</body>");
        out.println("</html>");
    }
}

