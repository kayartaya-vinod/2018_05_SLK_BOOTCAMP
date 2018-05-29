<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<c:if test="${fn:length(sessionScope.friendNames)>0}">
	<h3>Here are your friend...</h3>
	<ol type="A">
		<c:forEach items="${sessionScope.friendNames}" var="fname">
		<li>${fname}</li>
		</c:forEach>
	</ol>
</c:if>