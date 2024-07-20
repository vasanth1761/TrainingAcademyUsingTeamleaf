<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.trainingacademy.model.Result" %>
<%@ page import="com.chainsys.trainingacademy.dao.UserDAO" %>
<%@ page import="com.chainsys.trainingacademy.dao.UserImpl" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Learner Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 70%; 
            margin: 0 auto; 
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #0056b3;
            color: #fff;
        }
        tr:hover {
            background-color: #f2f2f2;
        }
        td {
            vertical-align: middle;
        }
    </style>
</head>
<body>
    <h2>Learner Results</h2>
    <table>
        <thead>
            <tr>
                <th>Learner ID</th>
                <th>Learner Name</th>
                <th>Course Name</th>
                <th>Correct Answers</th>
                <th>Percentage</th>
            </tr>
        </thead>
        <tbody>
            <%-- Replace this part with your Java logic to fetch results from the backend --%>
            <%
            
             /* UserImpl user = new UserImpl();
                           List<Result> resultOutput = user.getAllResults(); */
                    List<Result> resultOutput = (List<Result>) request.getAttribute("viewResult");          
            %>
            
            <% for (Result result : resultOutput) { %>
                <tr>
                    <td><%= result.getId() %></td>
                    <td><%= result.getName() %></td>
                    <td><%= result.getCourse()%></td>
                    <td><%= result.getScore() %></td>
                    <td><%= result.getPercentage() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
