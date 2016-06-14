var map;
function initialize() {
    var latlng = new google.maps.LatLng(-30.028169, -51.218187);
 
    var options = {
        zoom: 13,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
 
    map = new google.maps.Map(document.getElementById("mapa"), options);
    
    //troca a cor do mapa
    var cinza_parks = [ 
              			{
              			elementType: "labels.text", //Cor dos textos do mapa
                          stylers: [
              				{ color: "#ffffff" }
              				]
              			},{
              			elementType: "labels.text.stroke",//Cor da Borda dos textos do mapa
              			stylers: [ 
                              { visibility:"off" }//Oculta a Borda 
              				]          
              			}, {
              			"elementType": "geometry.fill",//Cor do mapa
                          "stylers": [
              				{ "color": "#4F4F4F" }
              				]       
              			}, { 
                          "elementType": "geometry.stroke",//Cor das Bordas do mapa
              			"stylers": [
              				{ "color": "#558090" } 
              				]        
              			}, {
              			"featureType": "road", //Cor das Ruas   
              			"elementType": "geometry.fill", 
                          "stylers": [      
              				{ "color": "#000000" }
              				]         
              			}    
              		]; map.setOptions({styles: cinza_parks});
}


initialize();