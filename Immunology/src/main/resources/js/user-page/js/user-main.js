$( document ).ready(function() {
	  doAjaxGet("patients/my");
	});
function doAjaxGet(pageName) {
    $.ajax({
        type: "GET",
        url: "/" + pageName,
        success: function(response) {
            $("#content").html(response);
        }
    });
}
function doAjaxPost(pageName) {
	console.info('doAjaxPost()');
    $.ajax({
        type: "POST",
        url: "/" + pageName,
        success: function(response) {
            $("#content").html(response);
        }
    });
}