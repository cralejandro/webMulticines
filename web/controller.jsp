<%-- 
    Document   : controller
    Created on : 30-ene-2018, 8:46:33
    Author     : Alejandro
--%>
<%@page import="jpautil.JPAUtil"%>
<%@page import="javax.persistence.EntityManager"%>

<%
    
EntityManager em=null;
              
              em=(EntityManager) session.getAttribute("em");
            if (em==null) {
               em=  JPAUtil.getEntityManagerFactory().createEntityManager();
               session.setAttribute("em", em);
 
            }
            String op;
            op=request.getParameter("op");










%>
