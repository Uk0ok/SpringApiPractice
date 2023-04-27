<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script
  src="https://code.jquery.com/jquery-3.6.4.js"
  integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
  crossorigin="anonymous">
</script>
<script src="/resources/js/api/download.js"></script>
<div>
<h2>DOWNLOAD</h2>
	<form id="download" action="/api/download" method="post">
		<table class="table">
			<thead>
				<tr>
					<th>elementid</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" id="downElementId" name="downElementId"></td>
					<td><button type="button" id="downButton" name="downButton">DOWNLOAD</button></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>