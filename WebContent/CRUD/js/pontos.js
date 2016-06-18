        function carregarPontos() {
        	//$.getJSON('EventoPontos.json', function(eventos) {
        	$.getJSON('http://localhost:8080/HurryBus/rest/eventos', function(eventos) {
        		$.each(eventos, function(index, evento) {  
        			 var marker=new google.maps.Marker({
        				 		position: new google.maps.LatLng(evento.embarquelatitude, evento.embarquelongitude),
        				 		title: evento.tag,
        				 		icon: 'imagem/Marcador2.png',
        				 map: map
                     });
        			 var infowindow = new google.maps.InfoWindow(), marker;
        			 
        			 google.maps.event.addListener(marker, 'click', (function(marker, i) {
        			     return function() {
        			         infowindow.setContent(evento.name);
        			         infowindow.open(map, marker);
        			     }
        			 })(marker))
                  });
        	 });
        };
        carregarPontos();