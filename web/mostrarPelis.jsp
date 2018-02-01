<%-- 
    Document   : mostrarPelis
    Created on : 31-ene-2018, 12:57:25
    Author     : Alejandro
--%>

<%@page import="entities.Rating"%>
<%@page import="java.util.List"%>
<%@page import="entities.Pelicula"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%
    int sesion = Integer.parseInt(request.getParameter("sesion"));
    String fecha = (request.getParameter("fecha"));
    
    EntityManager em=(EntityManager) session.getAttribute("em");
    
    Query query= em.createQuery("select p.idpelicula from Proyeccion p where p.proyeccionPK.fecha='"+fecha+"' and p.proyeccionPK.idsesion="+sesion);
    List<Pelicula> peliculas= query.getResultList();
   int puntuacion;
   double aux;
    for(Pelicula peli:peliculas){
        query=em.createQuery("select avg(r.puntos) from Rating r where r.idpelicula.idpelicula="+peli.getIdpelicula());
      aux  =  Double.parseDouble( String.valueOf(query.getSingleResult()));
      puntuacion= (int) aux;
        
        out.print(" <div class=\"col s12 m7\">"+
    "<h2 class=\"header\">"+peli.getTitulo()+"</h2>"+
    "<div class=\"card horizontal\"> "+
      "<div class=\"card-image\">"+
       " <a href=\"controller.jsp?op=reserva&peli="+peli.getIdpelicula()+"\">  <img src=\""+  peli.getPoster()  +"\"/> </a>"+
      "</div>"+
     " <div class=\"card-stacked\">"+
      "  <div class=\"card-content\">"+
          "  <h5>"+peli.getDirector() +"</h5>"+
           " <p>"+ peli.getTrama() +"</p>"+
           " <p>");
        for(int i=0;i<puntuacion;i++){
        
            out.print("   <img class=\"responsive-img\" src=\"img/star.png\"/>");    
                 
                 }   
                 
               out.print("</p>"+
      " </div>"+
       " <div>"+
            "<div class=\"center-align\">"+
        
            "   </div>"+
     "   </div>"+
    "  </div>"+
  "  </div>"+
 " </div>"
         
           
               );
        
        
        
        
    }
    


%>
