
var contextRoot = "/"+ window.location.pathname.split('/')[1];
var timer;

function makeAjaxBidCall(id){
	alert(id);
	var formId = id;
	var resultId = id+""+id;
	var timerId = id+""+id+""+id; 
	
	var send = JSON.stringify(serializeObject($('#'+formId)));
	alert("JSON data "+ send);
	timer = 10;
	
	startTimer(id, timer,timerId);
	
	$.ajax({
        type: "POST",
        url: contextRoot+"/biddables",
        dataType: 'json',
        data: send,
        contentType: "application/json; charset=utf-8",
        success: function(bid) {
        	alert("success achived "+ bid);
            $('#'+resultId).html("");
            $('#'+resultId).append( '<H3> Live Bid Information <H3>');                
			$('#'+resultId).append("<H4>" +bid.CUSTOMER_ID  + " " +bid.status +"</h4>"  );
			$('#'+resultId).append("<H4>Current Bideer's Total Bidding Price : $" + bid.amount + "</h4>" );
			$('#'+resultId).append("<H4>Current Selling Price : $" + bid.soldPrice + "</h4>" );
			
        },
        error: function() {
            $('#'+resultId).html('Bummer: there was an error!');
        	alert("error ");
        },
    });
}


function startTimer(pid, t, id){
	alert("t = "+t+"     id="+id);
	var tId = id;
	var timerFunc = setInterval(function(){
		      	if(t > -1){ 
					$('#'+tId).html("<H4>Time Remaining : " +  t + "</h4>");
					t --;
				}
		      	else	{
		      		clearInterval(timerFunc);
		    	   		makeItSold(pid);
		    	   	}
		      },1000);

}

function makeItSold(productId){
	alert("in sold func");
	$.ajax({
        type: "GET",
        url: contextRoot+"/biddables/sold",
        async:false,
        data: "id="+productId,
         
        success: function() {
        	alert("FUcK OFF  " );
        	var tt = productId+""+productId;
        	var ttt = productId+""+productId+""+productId;

        		$('#'+tt).html("");
            $('#'+tt).append( '<H3> Status Information <H3>');   
            
            $('#'+ttt).append( '<H3>  SOLDDDDDDDD!!! <H3>'); 

        },
        error: function() {
          //  $('#'+tt).html('Bummer: there was an error!');
            alert("error is here ");
        },
    });
	
}

toggle_visibility = function(id) {
    var element = document.getElementById(id);
    if(element.style.display == 'block')
    	element.style.display = 'none';
    else
    	element.style.display = 'block';
 }	

make_hidden = function(id) {
    var element = document.getElementById(id);
    element.style.display = 'none';
        }	   

make_visible = function(id) {
    var element = document.getElementById(id);
    element.style.display = 'block';
 }	   

resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();

    }	  


// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

}

