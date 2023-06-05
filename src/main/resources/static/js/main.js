
function clickSit(element){
    var sitInput = document.getElementById('sitInput');

    if(sitInput.value != null){
        sitInput.value = "";
        sitInput.value = element
        // console.log(element);
    }else{
        sitInput.value = element;
        // console.log(element);
    }
    
    
}

function clickMenue(){

    var selectChecked = document.querySelectorAll("input[type='checkbox']:checked");
    const textIn = document.getElementById('menueName');
    var arr=[];
    if(textIn.value != null){
        textIn.value ="";
        textIn.value = selectChecked[0].value;
        console.log(selectChecked[0].value);
    }else{
        textIn.value = selectChecked[0].value;
        console.log(selectChecked[0].value);
    }
}
