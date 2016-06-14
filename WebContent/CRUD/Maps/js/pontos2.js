        function carregarPontos() {
        	$.getJSON('EventoPontos.json', function(eventos) {
        	//$.getJSON('http://localhost:8080/HurryBus/rest/eventos', function(eventos) {
        		
        		$.each(eventos, function(index, json_obj) {  
        			 var marker=new google.maps.Marker({
        			 position: new google.maps.LatLng(json_obj.Latitude, json_obj.Longitude),
        			 title: "ponto",
        			 //icon: 'marker.png',
        			 map: map
                     });
                  });
        	 });
        };
        carregarPontos();