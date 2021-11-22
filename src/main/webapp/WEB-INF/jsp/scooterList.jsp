<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

 	
	<h1>Dear ${landlord} you're now on our Scooters page</h1>
	

	<a href="/add-scooter"> <b>Add new Scooter</b></a>
	<hr>
		
		<table class="table table-hover table-dark">
			<thead>
					<tr>
						<th scope="col">Image</b></th>
						<th scope="col">Year</b></th>
						<th scope="col">Make</b></th>
						<th scope="col">Model</b></th>
						<th scope="col">Update</b></th>
						<th scope="col">Remove Scooter</b></th>
					</tr>
			</thead>
			<tbody>
			<c:forEach items="${scooters}" var="scooter">
				<tr>
					<td  ><img src = "${scooter.image}" width="100" height="100" /></td>
					<td  >${scooter.year}</td>
					<td  >${scooter.make}</td>
					<td  >${scooter.model}</td>
					<td><b>&nbsp; &nbsp;
     <a href="/update-scooter?id=${scooter.id}">Update</a>&nbsp;</b></td>
					<td><b>&nbsp; &nbsp;
     <a href="/delete-scooter?id=${scooter.id}">Delete</a></b></td>
				</tr>
			</c:forEach>	
			</tbody>
			
			
		</table>
		
<%@ include file="common/footer.jspf"%>
