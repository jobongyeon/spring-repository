<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div>전체행의 수 : ${totalRowCount}/${list.size()}</div>
	<table border="1">
		<thead>
			<tr>
				<th>boardTitle</th>
				<th>boardUser</th>
				<th>boardDate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items="${list}">
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/board/boardView?boardNo=${b.boardNo}">
							${b.boardTitle}
						</a>
					</td>
					<td>${b.boardUser}</td>
					<td>${b.boardDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>
		<a href="<%=request.getContextPath()%>/board/boardAdd">게시글 입력</a>
	</div>
	<div>
		<c:if test="${currentPage>1}">
			<a href="<c:url value='/board/boardList?currentPage=${currentPage-1}'/>">이전</a>
		</c:if>
		<c:if test="${currentPage < lastPage}">
			<a href="<c:url value='/board/boardList?currentPage=${currentPage+1}'/>">다음</a>
		</c:if>
	</div>
</body>
</html>
