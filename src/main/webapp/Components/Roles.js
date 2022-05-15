$(document).ready(function()
{
	 $("#alertSuccess").hide();
 	 $("#alertError").hide();
});

// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
 	$("#alertSuccess").hide();
 	$("#alertError").text("");
 	$("#alertError").hide();

	// Form validation-------------------
	var status = validateRolesForm();
	if (status != true)
	{
		 $("#alertError").text(status);
 		 $("#alertError").show();
 		 return;
 	}
 	
	// If valid-------------------------
 	var type = ($("#hidRolesIDSave").val() == "") ? "POST" : "PUT";

	$.ajax(
 	{
 		url : "RolesAPI",
 		type : type,
 		data : $("#formRoles").serialize(),
 		dataType : "text",
 		complete : function(response, status)
 		{
 			onRolesSaveComplete(response.responseText, status);
 		}
 	}); 
 });

function onRolesSaveComplete(response, status)
	{
		if (status == "success")
		{
			 var resultSet = JSON.parse(response);
 			 if (resultSet.status.trim() == "success")
			 {
 				$("#alertSuccess").text("Successfully saved.");
 				$("#alertSuccess").show();
 				$("#divRolesGrid").html(resultSet.data);
 			 } 
 			 else if (resultSet.status.trim() == "error")
			 {
 				$("#alertError").text(resultSet.data);
 				$("#alertError").show();
 			 }
 		} 
 		else if (status == "error")
 		{
 			$("#alertError").text("Error while saving.");
 			$("#alertError").show();
 		} 
 		else
 		{
 			$("#alertError").text("Unknown error while saving..");
 			$("#alertError").show();
 		}
		$("#hidRolesIDSave").val("");
 		$("#formRoles")[0].reset();
}

	// UPDATE==========================================
	$(document).on("click", ".btnUpdate", function(event)
	{
		 $("#hidroleIDSave").val($(this).data("roleID"));
		 $("#roleName").val($(this).closest("tr").find('td:eq(1)').text());
 		 $("#roleDescription").val($(this).closest("tr").find('td:eq(3)').text());
	});
	
	
	
	$(document).on("click", ".btnRemove", function(event)
	{
 		$.ajax(
 		{
 			url : "RolesAPI",
 			type : "DELETE",
 			data : "roleID=" + $(this).data("roleID"),
 			dataType : "text",
 			complete : function(response, status)
 			{
 				onRolesDeleteComplete(response.responseText, status);
 			}
 		});
	});


	function onRolesDeleteComplete(response, status)
	{
		if (status == "success")
 		{
 			var resultSet = JSON.parse(response);
 			if (resultSet.status.trim() == "success")
 			{
 				$("#alertSuccess").text("Successfully deleted.");
 				$("#alertSuccess").show();
 				$("#divRulesGrid").html(resultSet.data);
 			} 
 			else if (resultSet.status.trim() == "error")
 			{
 				$("#alertError").text(resultSet.data);
 				$("#alertError").show();
 			}
 		} 
 		else if (status == "error")
 		{
 				$("#alertError").text("Error while deleting.");
 				$("#alertError").show();
 		} 
 		else
 		{
 				$("#alertError").text("Unknown error while deleting..");
 				$("#alertError").show();
 		}
}
	

	// CLIENT-MODEL================================================================
	function validateRoleForm()
	{
		// CODE
		if ($("#roleID").val().trim() == "")
		{
 			return "Insert Role ID.";
 		}

		// NAME
		if ($("#roleName").val().trim() == "")
 		{
 			return "Insert Role Name.";
 		}

 		 		

		// DESCRIPTION------------------------
		if ($("#roleDescription").val().trim() == "")
		{
 			return "Insert Roles Description.";
 		}

		return true;
	}
	
	
	
	
