
function addResource(){

		var text=$("#resourceid :selected").text();

		var row="<tr><td>"+text+"</td><td><input type=text /></td><td></td><td></td></tr>";
		$("#tblData tbody").append(row);
		
		

	}
	
//function calculate(x,y){
	function calculate(y){
	console.log(y);
	
		var resource=[];
		var table = document.getElementById("tblData");
		for (var i = 1; i < table.rows.length; i++) {
var firstCol = table.rows[i].cells[0].innerText;
console.log(firstCol); //first column
var secondCol= table.rows[i].cells[1].children[0].value;
var data={'resource':firstCol,'quantity':secondCol};
resource.push(data);
   
console.log(resource);
}
//calculation logic

		$.ajax({
			        url: "calculate",
        type: "POST",
        dataType: 'json',
        contentType: "application/json",
        data: JSON.stringify(resource),
        success: function(response){
	console.log(response);
	            for (j in response) {
		var resourcename=response[j].resName;
                console.log(response[j].resName);
        var table = document.getElementById("tblData");
		for (var i = 1; i < table.rows.length; i++) {
			var firstCol = table.rows[i].cells[0].innerText;
			if(resourcename==firstCol){
				var row1='<td>'+response[j].co2e+'</td>';
				var row2="<td>"+response[j].so2e+"</td>";
				table.rows[i].cells[2].innerText="";
				table.rows[i].cells[2].append(response[j].co2e);
				table.rows[i].cells[3].innerText="";
				table.rows[i].cells[3].append(response[j].so2e);
				
				
			}
			
            }


	}
		//var total=x;
		var total=0.0;
		
		for(var k=1;k<table.rows.length;k++){	
			const frow=table.rows[k].cells[2].innerText;
			const srow=table.rows[k].cells[3].innerText;
			total=parseFloat(total)+parseFloat(frow)+parseFloat(srow);
			console.log(total);
			
		}
		$('#totalimpact').prop('readonly',false);
		$('#totalimpact').val(total);
		$('#totalimpact').prop('readonly',true);
		
		
		//for publishing to db
		var resourcePublishDB=[];
		 var table = document.getElementById("tblData");
		for (var r = 1; r < table.rows.length; r++) {
var firstCol = table.rows[r].cells[0].innerText;

var secondCol= table.rows[r].cells[1].children[0].value;
var co2e=table.rows[r].cells[2].innerText;
console.log(co2e);
var so2e=table.rows[r].cells[3].innerText;
var dataDb={'resource':firstCol,'quantity':parseInt(secondCol),'CO2e':parseFloat(co2e) ,'SO2e':parseFloat(so2e)};
resourcePublishDB.push(dataDb);
}
		var resourceData={'calculateDto':resourcePublishDB};
		console.log(resourceData)
			$.ajax({
				url: "impact/"+y,
        type: "PATCH",
        dataType: 'json',
contentType: "application/json",
        data: JSON.stringify(resourceData),
        success: function(response){
	}
			}) ;
		}
		
		   
		});
		
		
	
}