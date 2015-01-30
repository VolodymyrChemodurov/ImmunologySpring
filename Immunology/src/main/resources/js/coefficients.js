
function initCoefficientEvents(){
	$(".element_row").mouseout(function(){
		$(this).css("outline","0px solid");
		});
	$(".element_row").mouseover(function(){
		$(this).css("outline","1px solid");
		$(this).css("outline-color","rgb(33, 145, 192)");
		});
	$(".element_row").click(function(e){
		e.preventDefault();
		getObject($(this));
		$('#coeficient-modal').modal('show');
	});
}

function getObject(element){
	var element = element;
	var panel = $(element).parents(".panel-fieldset");
	var subPanelBlock = $(element).parents(".sub-panel");
	var container = $(element).parents(".form-container");
	var obj =window[container.attr("object")];
	var coeficient;
	if(subPanelBlock.attr("index") == undefined){
		if (this.formObject.panels[$(panel).attr("index")].elements[$(element).attr("index")].multiplier != undefined){
			coeficient = this.formObject.panels[$(panel).attr("index")].elements[$(element).attr("index")].multiplier;
		}else{
			this.formObject.panels[$(panel).attr("index")].elements[$(element).attr("index")]["multiplier"] = 0;
			coeficient = 0;
		}
	}else{
		
		if (this.formObject.panels[$(panel).attr("index")].elements[subPanelBlock.attr("index")].elements[$(element).attr("index")].multiplier == undefined){
			this.formObject.panels[$(panel).attr("index")].elements[subPanelBlock.attr("index")].elements[$(element).attr("index")].multiplier = 0;
			coeficient = 0;
		}else{
			coeficient = this.formObject.panels[$(panel).attr("index")].elements[$(subPanelBlock).attr("index")].elements[$(element).attr("index")].multiplier;
		}
	}
	var modalBody = $("#coeficient-modal").find(".modal-body");
	modalBody.html("");
	var fieldset = $("<fieldset/>");
	var row = $('<div class="col-sm-6">');
	row.append('<input type="text" class="form-control" value="'+coeficient+'"/>');
	fieldset.append('<label class="col-sm-6 control-label">Задати значення коефіцієнта:</label>');
	fieldset.append(row);
	modalBody.append(fieldset);
	if(subPanelBlock.attr("index") == undefined){
		var clickFunction = 'formObject.panels['+$(panel).attr("index")+'].elements['+$(element).attr("index")+'].multiplier = $("#coeficient-modal").find("input").val();';
		$("#coeficient-modal").find("#save-textBox-button").attr("onclick", clickFunction);
	}else{
		var clickFunction = 'formObject.panels['+$(panel).attr("index")+'].elements['+subPanelBlock.attr("index")+'].elements['+$(element).attr("index")+'].multiplier = $("#coeficient-modal").find("input").val();'; 
		$("#coeficient-modal").find("#save-textBox-button").attr("onclick", clickFunction);
	}
}


