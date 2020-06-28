<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<title>Activities</title>
</head>
<body>
	<div class="container-fluid tl-3">
		<h1 class="display-4 text-primary">Favourite activity.</h1>
		<form action="activity" method="post">
			<div class="form-group">
				<label class="lead" for="firstNameInput">Give your name:</label>
				<input type="text" class="form-control" id="firstNameInput" placeholder="First name" style="width: 200px;" name = "firstName" required>
			</div>
			<div class="form-group">
			 	<label class="lead" for="activitySelect">Choose your favourite activity from available:</label>
				<select class="form-control" id="activitySelect" style="width: 150px;" name="activity">
					<option value="gym">Gym</option>
					<option value="dance">Dance</option>
					<option value="yoga">Yoga</option>
					<option value="swimming">Swimming</option>
					<option value="bike">Bike ride</option>
					<option value="running">Running</option>
					<option value="badminton">Badminton</option>
					<option value="squash">Squash</option>
				</select>
			</div>
			<p>
				<button class="btn btn-primary my-1" type="submit" value="Confirm">Confirm</button>
			</p>
		</form>
	</div>
</body>
</html>