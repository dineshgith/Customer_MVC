<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<title>CustomerMVCHibernate</title>
</head>
<body>
	<form:form id="myform" action="addCustomer" method="POST"
		modelAttribute="customer">
		<h3>
			<c:if test="${customer.customerId==0}">
			         Add New Customer
	        </c:if>
			<c:if test="${customer.customerId!=0}">
			         Update customer for Id: <c:out value="${customer.customerId}" />
				<form:hidden path="customerId" />
			</c:if>
		</h3>
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><form:input path="middleName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Suffix:</td>
				<td><form:input path="suffix" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" id="btn-add" />

					<input type="button" value="Update" id="btn-update" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>Customer Id</td>
				<td>First Name</td>
				<td>Middle Name</td>
				<td>Last Name</td>
				<td>Title</td>
				<td>Suffix</td>
				<td colspan="2">City</td>
			</tr>
			<c:forEach var="obj" items="${customers}">
				<tr>
					<td><c:out value="${obj.customerId}" /></td>
					<td><c:out value="${obj.firstName}" /></td>
					<td><c:out value="${obj.middleName}" /></td>
					<td><c:out value="${obj.lastName}" /></td>
					<td><c:out value="${obj.title}" /></td>
					<td><c:out value="${obj.suffix}" /></td>
					<td><a
						href="${pageContext.request.contextPath}/deleteCustomer?customerId=${obj.customerId}">Delete
					</a> | <a
						href="${pageContext.request.contextPath}/customerById?customerId=${obj.customerId}">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>