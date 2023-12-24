<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/Style.css">
</head>
<body>
<div class="particle"  id="particles-js">

  <div class="container" id="container">
    <div class="form-container sign-up">
      <form action="${pageContext.request.contextPath}/register" method="POST">
        <h1>Create Account</h1>
        <div class="social-icons">
          <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
          <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
          <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
          <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
        </div>
        <span>or use your email for registeration</span>
        <input type="text" name="name" class="morph_input" placeholder="Name">
        <input type="email" name="email" class="morph_input" placeholder="Email">
        <input type="password" name="password" class="morph_input" placeholder="Password">
        <button class="morph_button">Sign Up</button>
      </form>
    </div>
    <div class="form-container sign-in">
      <form action="${pageContext.request.contextPath}/auth/login" method="POST">
        <h1>Sign In</h1>
        <div class="social-icons">
          <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
          <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
          <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
          <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
        </div>
        <span class="details">or use your email password</span>
        <input class="morph_input" type="email" name="email" placeholder="Email">
        <input class="morph_input" type="password" name="password" placeholder="Password">
        <a href="#" class="for_get">Forget Your Password?</a>

        <button >Sign In</button>
      </form>
    </div>
    <div class=" main_toggle morph">

      <div class="toggle-container">

        <div class="toggle">
          <div class="toggle-panel toggle-left">
            <h1>Welcome Back!</h1>
            <p>Enter your personal details to use all of site features</p>
            <button class="hidden" id="login">Sign In</button>
          </div>
          <div class="toggle-panel toggle-right">
            <h1>Hello, Friend!</h1>
            <p>Register with your personal details to use all of site features</p>
            <button class="hidden" id="register">Sign Up</button>
          </div>
        </div>

      </div>

    </div>

  </div>

</div>

<script src="http://cdn.jsdelivr.net/particles.js/2.0.0/particles.min.js"></script>
<script src="${pageContext.request.contextPath}/Js/Jsfile.js"></script>
</body>
</html>
