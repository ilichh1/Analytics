/* 
 * Licencia pendiente, para cambiar la licencia ir a -> Tools | Templates
 */
document.addEventListener("click", registrarClick);

function registrarClick(evento) {
    var data = {};
    
    data.timeStamp = new Date().getTime();
    data.coordX = evento.x;
    data.coordY = evento.y;
    data.sizeX = window.innerWidth;
    data.sizeY = window.innerHeight;
    data.userAgent = navigator.userAgent;
    data.classListTarget = evento.target.classList;
    data.idTarget = evento.target.id;
    data.outerHTMLTarget = evento.target.outerHTML;
    data.target = evento.target.tagName;
    //window.console.log(data);
    $.post(
            "registrarclick",
            {data:JSON.stringify(data)},
            function(respuestaServidor) {
                window.console.log(respuestaServidor.success);
            },
            "application/json"
            );
}