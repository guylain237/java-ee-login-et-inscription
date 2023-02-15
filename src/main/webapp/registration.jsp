 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<input type="hidden" id="status" value=<%=request.getAttribute("status") %> >
	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">S'inscrire</h2>
					
						<form method="POST" action="inscription" class="register-form"
							id="register-form">
							 <div class="form-group">
      <label for="disabledTextInput"></label>
      <input type="text" id="disabledTextInput" name="date" class="form-control" placeholder="Date creation Automatique">
    </div>
														
 <div class="form-group">
    <label for="genre"></label>
    <select class="form-control"  id="genre" name="genre" value="<c:out value="${genre}"/>" >
      <option  name="genre">Monsieur</option>
      <option name="genre">Madame</option>
      
    </select>
  </div>
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="votre nom" value="<c:out value="${name}"/>"   />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="votre mail"  value="<c:out value="${email}"/>" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="pass" placeholder="mot de passe"  />
									<small id="passwordHelpInline" class="text-muted">
      Doit contenir entre 8 et 20 caractères.
    </small>
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_password" id="re_pass"
									placeholder="repetez le mot de passe" required="" />
									<small id="passwordHelpInline" class="text-muted">
      Doit contenir entre 8 et 20 caractères.
    </small>
							</div>

							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="contact" id="contact"
									placeholder="numero de telephone" value="<c:out value="${contact}"/>"  />
							</div>
							<div class="form-group">
								<input type="checkbox" name="term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									accepter toutes les déclarations dans  <a href="#" class="term-service">les conditions
                                  de services
										</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="inscription" id="signup"
									class="form-submit" value="inscription" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signin-image.jpg" alt="sing up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">j'ai deja un compte
							</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
<script type="text/javascript">
var status =document.getElementById("status").value;
if(status=="success"){
swal("congrats","compte creer avec success","success");
}
if(status=="invalidEmail"){
	swal("oups","entrez un email valide","error");
	}
if(status=="invalidNom"){
	swal("oups","entrez un nom ","error");
	}
if(status=="invalidMobile"){
	swal("oups","veuillez entrer un numero de telephone","error");
	}
if(status=="invalidMobileLength"){
	swal("oups","entrer un numero a 10 chiffres s'il vous plait","error");
	}
if(status=="invalidPwd"){
	swal("oups","mot de passe invalide","error");
	}
if(status=="invalidPwdConf"){
	swal("oups","mot de passe different","error");
	}
if(status=="invalidGenre"){
	swal("oups","mentionne votre civilite","error");
	}
if(status=="invalidTerm"){
	swal("oups","accepte les termes et conditions d'utilisation","error");
	}
</script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>