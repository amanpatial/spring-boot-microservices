	$(document).ready(function() {
	    userList();
	});
	/* $.ajax({
        url: "http://localhost:8080/users"
    }).then(function(data) {
	    console.log(data);
		// Iterate over the collection of data
		var users = data;
		$.each(users, function (index, user) {
			// Add a row to the user table
			//console.log(users);
			//console.log(user);
			userAddRow(user);
		});
    
	}); */

	var User = {
	    id: 0,
	    name: "",
	    email: "",
	}

	function userList() {
	    // Call Rest API to get a list of users
	    $.ajax({
	        url: 'http://localhost:8080/users',
	        type: 'GET',
	        dataType: 'json',
	        success: function(users) {
	            userListSuccess(users);
	        },
	        error: function(request, message, error) {
	            handleException(request, message, error);
	        }
	    });
	}

	function userListSuccess(users) {
	    $.each(users, function(index, user) {
	        // Add a row to the user table
	        userAddRow(user);
	    });
	}

	function userAddRow(user) {
	    console.log('inside userAddRow');
	    console.log(user);
	    // Check if <tbody> tag exists, add one if not
	    if ($("#userTable tbody").length == 0) {
	        $("#userTable").append("<tbody></tbody>");
	    }
	    // Append row to <table>
	    $("#userTable tbody").append(userBuildTableRow(user));
	}

	function userBuildTableRow(user) {
	    console.log(user);
	    var ret =
	        "<tr>" +
	        "<td>" +
	        "<button type='button' " +
	        "onclick='userGet(this);' " +
	        "class='btn btn-default' " +
	        "data-id='" + user.id + "'>" +
	        "<span class='glyphicon glyphicon-edit' />" +
	        "</button>" +
	        "</td >" +
	        "<td>" + user.id + "</td>" +
	        "<td>" + user.name + "</td>" +
	        "<td>" + user.email + "</td>" +
	        "<td>" +
	        "<button type='button' " +
	        "onclick='userDelete(this);' " +
	        "class='btn btn-default' " +
	        "data-id='" + user.id + "'>" +
	        "<span class='glyphicon glyphicon-remove' />" +
	        "</button>" +
	        "</td>" +
	        "</tr>";
	    return ret;
	}

	function handleException(request, message, error) {
	    var msg = "";
	    msg += "Code: " + request.status + "\n";
	    msg += "Text: " + request.statusText + "\n";
	    if (request.responseJSON != null) {
	        msg += "Message" + request.responseJSON.Message + "\n";
	    }
	    alert(msg);
	}

	// Handle click event on Update button
	function userUpdate(user) {
	    $.ajax({
	        url: "http://localhost:8080/users/" + user.id,
	        type: 'PUT',
	        contentType: "application/json;charset=utf-8",
	        data: JSON.stringify(user),
	        success: function(user) {
	            userUpdateSuccess(user);
	        },
	        error: function(request, message, error) {
	            handleException(request, message, error);
	        }
	    });
	}

	function userUpdateSuccess(user) {
	    userUpdateInTable(user);
	    //$("#userTable tbody").remove();
	    //formClear();
	    //userList();
	}

	function userUpdateInTable(user) {

	    User = new Object();
	    User.id = $("#userid").val();
	    User.name = $("#username").val();
	    User.email = $("#email").val();

	    // Find user in <table>
	    var row = $("#userTable button[data-id='" + User.id + "']").parents("tr")[0];
	    // Add changed user to table
	    $(row).after(userBuildTableRow(User));
	    // Remove original user
	    $(row).remove();
	    formClear(); // Clear form fields
	    // Change Update Button Text
	    $("#updateButton").text("Add");
	}

	// Handle click event on Add button
	function userAdd(user) {
	    $.ajax({
	        url: "http://localhost:8080/users",
	        type: 'POST',
	        contentType: "application/json;charset=utf-8",
	        data: JSON.stringify(user),
	        success: function(user) {
	            userAddSuccess(user);
	        },
	        error: function(request, message, error) {
	            handleException(request, message, error);
	        }
	    });
	}

	function userAddSuccess(user) {
	    $("#userTable tbody").remove();
	    formClear();
	    userList();
	}

	function formClear() {
	    $("#userid").val("");
	    $("#username").val("");
	    $("#email").val("");
	}

	function addClick() {
	    formClear();
	}

	function updateClick() {
	    // Build User object from inputs
	    User = new Object();
	    User.name = $("#username").val();
	    User.email = $("#email").val();
	    if ($("#updateButton").text().trim() == "Add") {
	        //console.log(User);
	        userAdd(User);
	    } else {
	        User.id = $("#userid").val();
	        userUpdate(User);
	    }
	}

	function userToFields(user) {
	    $("#userid").val(user.id);
	    $("#username").val(user.name);
	    $("#email").val(user.email);
	}

	function userGet(ctl) {
	    // Get user id from data- attribute
	    var id = $(ctl).data("id");

	    // Store user id in hidden field
	    $("#userid").val(id);

	    // Call REST API to get a list of User
	    $.ajax({
	        url: "http://localhost:8080/users/" + id,
	        type: 'GET',
	        dataType: 'json',
	        success: function(user) {
	            userToFields(user);

	            // Change Update Button Text
	            $("#updateButton").text("Update");
	        },
	        error: function(request, message, error) {
	            handleException(request, message, error);
	        }
	    });
	}

	function userDelete(ctl) {
	    var id = $(ctl).data("id");

	    $.ajax({
	        url: "http://localhost:8080/users/" + id,
	        type: 'DELETE',
	        success: function(user) {
	            $(ctl).parents("tr").remove();
	        },
	        error: function(request, message, error) {
	            handleException(request, message, error);
	        }
	    });
	}