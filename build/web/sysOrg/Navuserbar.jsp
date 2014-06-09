<%@page import="dbentities.UserEntity"%>
<div class="member-box round-all">
    <%
        UserEntity user = (UserEntity) request.getSession().getAttribute("UserEntity");
    %>
    <a><img src="../images/member_ph.png" class="member-box-avatar" /></a>
    <div>
        <strong><%=user.getDescription()%></strong><br />
        <%=user.getName()%><br />
        <div class="member-box-links"><a href="../Logout" >Logout</a></div>
    </div>
</div>