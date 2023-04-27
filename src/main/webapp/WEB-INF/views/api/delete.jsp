<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script
  src="https://code.jquery.com/jquery-3.6.4.js"
  integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
  crossorigin="anonymous">
</script>
<script src="/resources/js/api/delete.js"></script>
<div>
<h2>DELETE</h2>
	<form id="delete" action="/api/delete" method="post">
		<table class="table">
			<thead>
				<tr>
					<th>elementid</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" id="delElementId" name="delElementId"></td>
					<td><button type="button" id="delButton" name="delButton">DELETE</button></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>