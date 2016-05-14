        function carregarPontos() {
        	
        	//$.getJSON('EventoPontos.json', function(pontos) {
        	$.getJSON('http://localhost:8080/HurryBus/rest/eventos', function(eventos) {
        		 $.each(eventos, function(index, Evento) {  
        			 var marker=new google.maps.Marker({
        				 		position: new google.maps.LatLng(Evento.embarqueLatitude, Evento.embarqueLongitude),
        				 		//position: new google.maps.LatLng(ponto.Latitude, ponto.Longitude),
        				 		title: "Meu ponto",
        				 map: map
                     });
                  });
        	 });
        };
        carregarPontos();