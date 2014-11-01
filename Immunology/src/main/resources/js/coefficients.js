
function initCoefficientEvents(){
	$(".element_row").mouseout(function(){
		$(this).css("border","0px solid");
		});
	$(".element_row").mouseover(function(){
		$(this).css("border","1px solid");
		$(this).css("border-color","rgb(33, 145, 192)");
		});
	$(".element_row").click(function(){
		 $('#coeficient-modal').modal('show');
	})
}