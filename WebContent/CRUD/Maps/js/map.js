var map;
function initialize() {
    var latlng = new google.maps.LatLng(-30.028169, -51.218187);
 
    var options = {
        zoom: 11,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
 
    map = new google.maps.Map(document.getElementById("mapa"), options);
}


initialize();