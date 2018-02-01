<%-- 
    Document   : controller
    Created on : 30-ene-2018, 8:46:33
    Author     : Alejandro
--%>
<%@page import="entities.Pelicula"%>
<%@page import="entities.Proyeccion"%>
<%@page import="entities.Tarifa"%>
<%@page import="entities.Sesion"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
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

            if(op.equals("inicio")){
              Query query = em.createQuery("SELECT s FROM Sesion s order by s.hora");
              
               List<Sesion> sesiones= query.getResultList();
               
               session.setAttribute("sesiones", sesiones);
               query= em.createQuery("select t from Tarifa t");
               List<Tarifa> tarifas= query.getResultList();
               session.setAttribute("tarifas", tarifas);
                query= em.createQuery("select t from Proyeccion t");
                  List<Proyeccion> proyecciones= query.getResultList();
                  session.setAttribute("proyecciones", proyecciones);
                %>
                 <jsp:forward page="mainview.jsp"/>
                 <%  }else if(op.equals("reserva")){

                 Short idPeli = Short.valueOf(request.getParameter("peli"));
                  Pelicula peli =  em.find(Pelicula.class,idPeli);
                  request.setAttribute("pelicula", peli);%>
                  
                  <jsp:forward page="reservarview.jsp"/>
<%}
             
            %>    








%>
