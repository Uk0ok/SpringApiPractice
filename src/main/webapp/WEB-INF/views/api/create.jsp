<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script
  src="https://code.jquery.com/jquery-3.6.4.js"
  integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
  crossorigin="anonymous">
</script>
<script src="/resources/js/api/create.js"></script>
<div>
<h2>CREATE</h2>
	<form id="create" action="/api/create" method="post" enctype="multipart/form-data">
		<table class="table">
			<thead>
				<tr>
					<th>file</th>
					<th>description</th>
					<th>c-classid</th>
					<th>user-class</th>
					<th>e-classid</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="file" id="createFile" name="createFile"></td>
					<td><input type="text" id="createDescription" name="createDescription"placeholder="TEST"></td>
					<td><input type="text" id="createcClassId" name="createcClassId" placeholder="BASIC"></td>
					<td><input type="text" id="createUserClass" name="createUserClass" placeholder="SUPER"></td>
					<td><input type="text" id="createeClassId" name="createeClassId" placeholder="IMAGE"></td>
				</tr>
			</tbody>
		</table><br>
		count : <input type="number" id="createNumber" name="createNumber" min="1" value="1" style="font-weight: bolder;"> 
		<button type="button" id="createButton" name="createButton">CREATE</button>
	</form>
</div>


