/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

  var showPeliculas = function (){
                    
                 var sesion =    document.getElementById("sesionSelect");
                  var fecha =    document.getElementById("fechaSelect");
                  
                  if(sesion.value!='' && fecha.value!=''){
                    
                                $.ajax({
					type: "POST",
					url: "mostrarPelis.jsp?sesion="+sesion.value+"&fecha="+fecha.value,
					success : function(info) {
						$('#content').html(info);
                                             
					}
				})
                            }
                    
                }


















//guarreria


    $(document).ready(function(){
              
             $(".button-collapse").sideNav();  
              $('select').material_select();
              
              $('.datepicker').pickadate({
        selectMonths: true,//Creates a dropdown to control month
        selectYears: 15,//Creates a dropdown of 15 years to control year
        //The title label to use for the month nav buttons
        labelMonthNext: 'Mes Siguiente',
        labelMonthPrev: 'Mes Anterior',
        //The title label to use for the dropdown selectors
        labelMonthSelect: 'Select Mes',
        labelYearSelect: 'Select Año',
        //Months and weekdays
        monthsFull: [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre' ],
        monthsShort: [ 'Ene', 'Feb', 'Mar', 'Abr', 'Mar', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic' ],
        weekdaysFull: [ 'Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado' ],
        weekdaysShort: [ 'Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab' ],
        //Materialize modified
        weekdaysLetter: [ 'D', 'L', 'M', 'X', 'J', 'V', 'S' ],
        //Today and clear
        today: 'Hoy',
        clear: 'Clear',
        close: 'Ok',
        closeOnSelect: false, // Close upon selecting a date,
        //The format to show on the `input` element
        firstDay: 1 
        });
              
              
              
          });