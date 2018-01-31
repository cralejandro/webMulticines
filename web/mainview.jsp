<%-- 
    Document   : mainview
    Created on : 30-ene-2018, 8:46:45
    Author     : Alejandro
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entities.Proyeccion"%>
<%@page import="entities.Tarifa"%>
<%@page import="entities.Sesion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="css/mystyle.css"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

    <body>
      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
      <script type="text/javascript" src="js/myjs.js"></script>
      
      <div class="container">
        
          <!--Header!-->
          <div class="row">
            <div class="col s12">
                <img class="responsive-img" src="img/header.png"/>
            </div>
     
    </div>
          <!--Menu!-->
          
          <div class="row">
              <div class="col s4">
                 <div class="input-field col s12">
                     <select onchange="showPeliculas()" id="fechaSelect">
                <option value="" disabled selected>Elija Fecha</option>
                <%
                    List<Proyeccion> proyecciones= (List<Proyeccion>) session.getAttribute("proyecciones");
                        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                        for(int i=0;i<proyecciones.size();i++){
                           
                    %>
                    <option value="<%=format.format(proyecciones.get(i).getProyeccionPK().getFecha())%>"><%=format.format(proyecciones.get(i).getProyeccionPK().getFecha())  %></option>
            <%}%>
            </select>
    <label>Sesion</label>
  </div>
                  
              </div>
              <div class="col s4">
                   <div class="input-field col s12">
                       <select onchange="showPeliculas()" id="sesionSelect">
                <option value="" disabled selected>Elija Sesión</option>
                <%
                    List<Sesion> sesiones= (List<Sesion>) session.getAttribute("sesiones");
                    
                        for(int i=0;i<sesiones.size();i++){
                           
                    %>
                    <option value="<%=sesiones.get(i).getIdsesion() %>"><%=sesiones.get(i).getHora()%></option>
            <%}%>
            </select>
    <label>Sesion</label>
  </div>
                  
              </div>
              <div class="col s4">
                   <div class="input-field col s12">
                <select>
                <option value="" disabled selected>Elija Tarifa</option>
            <%
                    List<Tarifa> tarifas= (List<Tarifa>) session.getAttribute("tarifas");
                    
                        for(int i=0;i<tarifas.size();i++){
                           
                    %>
                    <option value="<%=tarifas.get(i).getIdtarifa() %>"><%=tarifas.get(i).getDescripcion()%></option>
            <%}%>
             
            </select>
    <label>Tarifa</label>
  </div>
                  
              </div>
              
              
              
              
          </div>  
          
          <!--Content!-->
          
          <div id="content">
          
          <div class="col s12 m7">
    <h2 class="header">Deadpool</h2>
    <div class="card horizontal">
      <div class="card-image">
        <img src="https://lorempixel.com/100/190/nature/6">
      </div>
      <div class="card-stacked">
        <div class="card-content">
            <h5> Director</h5>
            <p>I am a very simple card. I am good at containing small bits of information.</p>
            <p>
            <img class="responsive-img" src="img/star.png"/>
            <img class="responsive-img" src="img/star.png"/>
                 </p>
        </div>
        <div>
            <div class="center-align">
            <span class="rating">
            <a href="controller.jsp?op=rating&rating=1">&#9733;</a>
            <a href="controller.jsp?op=rating&rating=2">&#9733;</a>
            <a href="controller.jsp?op=rating&rating=3">&#9733;</a>
            <a href="controller.jsp?op=rating&rating=4">&#9733;</a>
            <a href="controller.jsp?op=rating&rating=5">&#9733;</a>
        </span>
               </div>
        </div>
      </div>
    </div>
  </div>
          <div class="row">
              <div class="col s4 offset-s4">
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  <img class="responsive-img" src="img/butacalibre.png"/>
                  
                  
                  
              </div> 
              
              
              
          </div>
            
                   </div>   

          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
      </div>
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
           
      
      
      
    </body>
  </html>
