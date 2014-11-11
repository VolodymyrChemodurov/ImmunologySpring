
function initCoefficientEvents(){
	$(".element_row").mouseout(function(){
		$(this).css("outline","0px solid");
		});
	$(".element_row").mouseover(function(){
		$(this).css("outline","1px solid");
		$(this).css("outline-color","rgb(33, 145, 192)");
		});
	$(".element_row").click(function(){
		 $('#coeficient-modal').modal('show');
	})
}