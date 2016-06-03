        function carregarPontos() {
        	$.getJSON('EventoPontos.json', function(eventos) {
        	//$.getJSON('http://localhost:8080/HurryBus/rest/eventos/20', function(eventos) {
        		$.each(eventos, function(index, evento) {  
        			 var marker=new google.maps.Marker({
        				 		position: new google.maps.LatLng(evento.embarqueLatitude, evento.embarqueLongitude),
        				 		title: evento.TAG,
        				 		icon: 'img/marcador.png',
        				 map: map
                     });
                  });
        	 });
        };
        carregarPontos();