// FormObj is a object of full form(medical form) which is setted in form-builder js file.

function checkboxClick(panelIndex, elementIndex, subElementIndex){
	console.log("panel index: "+panelIndex +" element index: "+elementIndex +" subElement index: "+ subElementIndex);
	if(subElementIndex == null){
		formObj.panels[panelIndex].elements[elementIndex].checked = !formObj.panels[panelIndex].elements[elementIndex].checked;
		checkPanelForUnDisable(panelIndex);
		changeTitleColor(panelIndex);
		disableField(formObj.panels[panelIndex].elements[elementIndex],panelIndex, elementIndex, subElementIndex );
	}else{
		formObj.panels[panelIndex].elements[elementIndex].elements[subElementIndex].checked =
			!formObj.panels[panelIndex].elements[elementIndex].elements[subElementIndex].checked;
		checkPanelForUnDisable(panelIndex);
		changeTitleColor(panelIndex);
		disableField(formObj.panels[panelIndex].elements[elementIndex].elements[subElementIndex],panelIndex, elementIndex, subElementIndex );
	}
}
function disableField(element, panelIndex, elementIndex, subElementIndex){
	if(element.objectType == "DropDown"){
		disableInput(panelIndex,elementIndex, subElementIndex, element.checked);
		disableDropDown(panelIndex,elementIndex, subElementIndex, element.checked);
		
	}else {
		disableInput(panelIndex,elementIndex, subElementIndex, element.checked);
	}
	
}
function disableInput(panelIndex,elementIndex, subElementIndex, undisableBoolean){
	var elementId = "#panel_"+panelIndex+"_element_"+elementIndex+"_"+ subElementIndex;
	if(undisableBoolean){
		$(elementId).prop('disabled', false);
	}else{
		$(elementId).prop('disabled', true);
	}
	
	
}
function disableDropDown(panelIndex,elementIndex, subElementIndex, undisableBoolean){
	var elementId = "#panel_"+panelIndex+"_dropDownElement_"+elementIndex+"_"+ subElementIndex;
	if(undisableBoolean){
		$(elementId).prop('disabled', false);
	}else{
		$(elementId).prop('disabled', true);
	}
	
	
}

function storeMedCardDetailValue(){
	formObj.additionInfo = $('#additionInfo').val();
}

function storeValue(panelIndex,elementIndex,subElemIndex){
	var elementId = "#panel_"+panelIndex+"_element_"+elementIndex +"_"+ subElemIndex;
	console.log($(elementId));
	if(subElemIndex == null){
		formObj.panels[panelIndex].elements[elementIndex].text = $(elementId).val();
	}else{
		formObj.panels[panelIndex].elements[elementIndex].elements[subElemIndex].text = $(elementId).val();
	}
	
}
function storeDropDownValue(panelIndex,elementIndex,subElemIndex){
	var elementId = "#panel_"+panelIndex+"_dropDownElement_"+elementIndex +"_"+ subElemIndex;
	if(subElemIndex == null){
		formObj.panels[panelIndex].elements[elementIndex].choosed = $(elementId).val();
	}else{
		formObj.panels[panelIndex].elements[elementIndex].elements[subElemIndex].choosed = $(elementId).val();
	}
	console.log($(elementId).val());
}

function changeTitleColor(panelIndex){
	panelId = "#panel_"+panelIndex;
	if(formObj.panels[panelIndex].checked){
		$(panelId).css("background-color","rgb(255, 135, 50)");	
	}else{
		$(panelId).css("background-color","rgb(33, 145, 192)");	
	}
}

function checkPanelForUnDisable(panelIndex){
	formObj.panels[panelIndex].checked = false;
	for ( var i = 0; i < formObj.panels[panelIndex].elements.length; i++ ) {
	    if(formObj.panels[panelIndex].elements[i].checked){
	    	formObj.panels[panelIndex].checked = true;
	    	break;
	    }else{
	    	if(formObj.panels[panelIndex].elements[i].objectType == "Panel"){
	    	console.log(formObj.panels[panelIndex].elements[i]);
		    	for( var j = 0; j < formObj.panels[panelIndex].elements[i].elements.length; j++ ){
		    		if(formObj.panels[panelIndex].elements[i].elements[j].checked){
		    			formObj.panels[panelIndex].checked = true;
		    			break;
		    		}
		    		
		    	}
	    	}
	    }
	    
	  
	}
}
function prepareForm(){
	for(var panIndex = 0; panIndex < formObj.panels.length; panIndex++ ){
		checkPanelForUnDisable(panIndex);
		changeTitleColor(panIndex);
		for(var elemIndex = 0; elemIndex < formObj.panels[panIndex].elements.length; elemIndex++ ){
			
			if(formObj.panels[panIndex].elements[elemIndex].objectType == "Panel"){
				for(var subElemIndex = 0; subElemIndex < formObj.panels[panIndex].elements[elemIndex].elements.length; subElemIndex++ ){
					disableField(formObj.panels[panIndex].elements[elemIndex].elements[subElemIndex],panIndex, elemIndex, subElemIndex );
				}
			}else{
				disableField(formObj.panels[panIndex].elements[elemIndex],panIndex, elemIndex, null );
			}
		}
		
	}
}
