<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List"%>
<%@page import="com.chainsys.trainingacademy.model.Videos"%>
<%@page import="com.chainsys.trainingacademy.model.Users"%>
<%@page import="com.chainsys.trainingacademy.model.Course"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Videos</title>
    <style>
    .navbar {
    display: flex;
    justify-content: space-between; 
    align-items: center;
    background-color: #0056b3;
    padding: 10px 20px;
    color: white;
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
}

.navbar span {
    font-size: 18px;
    margin-right: 10px;
}

.navbar .profile-section {
    display: flex;
    align-items: center;
    cursor: pointer; 
    position: relative; 
}

.navbar img {
    width: 30px;
    height: 30px;
    margin-right: 10px;
    border-radius: 50%; 
}
        .module {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top:150px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        iframe {
            width: 80%; 
            display: block; 
            margin: 0 auto;            
            height: auto; 
        }

        .take-test-button {
            display: inline-block;
            padding: 8px 16px;
            background-color: #2A73CC;
            color: white;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-size: 14px;
            margin-top: 20px;
        }
         .navbar {
        display: flex;
        justify-content: space-between; 
        align-items: center;
        background-color: #0056b3;
        padding: 10px 20px;
        color: white;
        position: fixed;
        top: 0;
        left: 0;
        right: 0;
    }

    .navbar span {
        font-size: 18px;
        margin-right: 10px;
    }

    .navbar .profile-section {
        display: flex;
        align-items: center;
        cursor: pointer; 
        position: relative; 
    }

    .navbar img {
        width: 30px;
        height: 30px;
        margin-right: 10px;
        border-radius: 50%; 
    }

    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #fff;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
        right: 0;
        top: 40px;
        min-width: 160px;
        border-radius: 8px;
    }

    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    .dropdown-content a:hover {
        background-color: #f1f1f1;
    }

    .profile-section:hover .dropdown-content {
        display: block;
    }
    .name
    {
     margin-left:450px;
    }
    </style>
</head>
<body>
 <% Users getName = (Users) session.getAttribute("userId"); %> 
 <%Videos getuser=(Videos)session.getAttribute("courseFreeVideos"); %>
 <%Course getCourseName=(Course)session.getAttribute("course"); %>
 
 <div class="navbar">
    <span>Course Dashboard</span>
    <div class="profile-section">
        <img src="image/profile.png" alt="User Symbol">
        <span class="username" id="username"><%= getName.getName()%></span>
        <div class="dropdown-content">
            <a href="#">Profile</a>
            <a href="#">Logout</a>
           
        </div>
    </div>
</div> 
<br>
<br>
<br>
<br>
<h1 class="name">Welcome to <%=getCourseName.getCourseName() %> course</h1>
<form action="payment.jsp">
    <div class="module">
        
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Video</th>
                </tr>
            </thead>
            <tbody>
               
                <%
               
                List<Videos> demoVideos = (List<Videos>) request.getAttribute("courseFreeVideos"); 
                for (Videos video : demoVideos) { 
                %>
                    <tr>
                        <td><%= video.getTitle()%></td>
                        <td><iframe src="<%=video.getLink()%>" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <button class="take-test-button" type="submit">More Videos</button>
    </div>
    </form>
</body>
</html>
