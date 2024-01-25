/**
 * 
 */



$(document).ready(function() {
	var rowString = $("#row").val();
	var totalString = $("#total").val();
	var row = parseInt(rowString);//4
	var total = parseInt(totalString);//9

	$("#load").click(function() {
		if (row <= total) {
			$.ajax({
				url: "/BookShop/load4",
				type: "GET",
				data: {
					row: row,
					total: total,
				},
				success: function(data) {
					$("#content").append(data);
					row += 4;
					if (row >= total) {
						$("#load").css("display", "none");
					}
				}
			});

		}
	})
});




$(document).ready(function() {
	$("#content").on("click", ".add", function() {
		var bookId = $(this).siblings(".bookId").val();
		var username = $(this).siblings(".username").val();

		$.ajax({
			url: "/BookShop/add_cartt",
			type: "GET",
			data: {
				bookId: bookId,
				userName: username
			},
			success: function(data) {
				alert("Add to cart successfully...");
			}
		});
	})
})



$(document).ready(function() {
	var rowString = $("#row").val();
	var totalString = $("#total").val();
	var row = parseInt(rowString);//4
	var total = parseInt(totalString);//9
	$("#sort").change(function() {
		$.ajax({
			url: "/BookShop/sort",
			type: "GET",
			data: {
				row: row,
				total: total,
			},
			success: function(data) {
				$("#content").html(data);
				row += 4;
			}
		})
	})
});




