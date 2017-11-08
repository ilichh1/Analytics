/* 
 * Licencia pendiente, para cambiar la licencia ir a -> Tools | Templates
 */
document.addEventListener("click", registrarClick);

function registrarClick(e) {
    console.log(e);
    var clickLog = e;
    $.post(
            "registrarclick",
            {data:2},
            function(data) {
                console.log(data);
            }
            );
}