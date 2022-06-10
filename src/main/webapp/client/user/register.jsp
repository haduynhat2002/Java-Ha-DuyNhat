<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.baitapcrud.entity.Account" %>
<%
  Account account = (Account) request.getAttribute("account");
  if(account == null){
    account = new Account();
  }
  HashMap<String, String> errors = (HashMap<String, String>)request.getAttribute("errors");
  if(errors == null){
    errors = new HashMap<>();
  }
%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
<form action="/register" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
  <h2 class="w3-center">Register form</h2>

  <div class="w3-row w3-section">
    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="username" type="text" placeholder="Username" value="<%=account.getUsername()%>">
      <%
        if(errors.containsKey("username")){
      %>
      <span class="w3-text-red">* <%=errors.get("username")%></span>
      <%}%>
    </div>
  </div>

  <div class="w3-row w3-section">
    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="password" type="password" placeholder="Password">
      <%
        if(errors.containsKey("password")){
      %>
      <span class="w3-text-red">* <%=errors.get("password")%></span>
      <%}%>
    </div>
  </div>
  <div class="w3-row w3-section">
    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="confirmPassword" type="password" placeholder="Confirm Password">
      <%
        if(errors.containsKey("confirmPassword")){
      %>
      <span class="w3-text-red">* <%=errors.get("confirmPassword")%></span>
      <%}%>
    </div>
  </div>

  <div class="w3-row w3-section">
    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-envelope-o"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="fullName" type="text" placeholder="Full name" value="<%=account.getFullName()%>">
      <%
        if(errors.containsKey("fullName")){
      %>
      <span class="w3-text-red">* <%=errors.get("fullName")%></span>
      <%}%>
    </div>
  </div>
  <div class="w3-row w3-section">
    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-envelope-o"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="email" type="text" placeholder="Email" value="<%=account.getEmail()%>">
      <%
        if(errors.containsKey("email")){
      %>
      <span class="w3-text-red">* <%=errors.get("email")%></span>
      <%}%>
    </div>
  </div>
  <p class="w3-center">
    <button type="submit" class="w3-button w3-section w3-blue w3-ripple"> Save </button>
    <button type="reset" class="w3-button w3-section w3-blue w3-ripple"> Reset </button>
  </p>
</form>

</body>
</html>