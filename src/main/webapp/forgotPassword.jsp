<!doctype html>
<html>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Snippet - BBBootstrap</title>
<link
	href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'
	rel='stylesheet'>
<link href='' rel='stylesheet'>
<script type='text/javascript'
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<style>
body {
	background-position: center;
	background-color: #eee;
	background-repeat: no-repeat;
	background-size: cover;
	color: #505050;
	font-family: "Rubik", Helvetica, Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	line-height: 1.5;
	text-transform: none
}

.forgot {
	background-color: #fff;
	padding: 12px;
	border: 1px solid #dfdfdf
}

.padding-bottom-3x {
	padding-bottom: 72px !important
}

.card-footer {
	background-color: #fff
}

.btn {
	font-size: 13px
}

.form-control:focus {
	color: #495057;
	background-color: #fff;
	border-color: #76b7e9;
	outline: 0;
	box-shadow: 0 0 0 0px #28a745
}
</style>
</head>
<body oncontextmenu='return false' class='snippet-body'>
	<div class="container padding-bottom-3x mb-2 mt-5">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10">
				<div class="forgot">
					<h2>Mot de passe oubli� ?</h2>
					<p>Changez votre mot de passe en trois �tapes faciles. Cela vous permettra
                         de renforcer votre mot de passe!</p>
					<ol class="list-unstyled">
						<li><span class="text-primary text-medium">1. </span>Entrer
                                 votre adresse e-mail ci-dessous.</li>
						<li><span class="text-primary text-medium">2. </span>Our
							Le syst�me vous enverra un OTP � votre adresse e-mail</li>
						<li><span class="text-primary text-medium">3. </span>Entrez le mot de passe � usage unique sur
                              la page suivante</li>
					</ol>
				</div>
				<form class="card mt-4" action="forgotPassword" method="POST">
					<div class="card-body">
						<div class="form-group">
							<label for="email-for-pass">Entre ton adresse Email </label> <input
								class="form-control" type="text" name="email" id="email-for-pass" required=""><small
								class="form-text text-muted">Entrez l'adresse e-mail enregistr�e. Ensuite, nous allons
                                           envoyer un OTP par e-mail � cette adresse.</small>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn btn-success" type="submit">Obtenir un nouveau
                              Mot de passe</button>
						<button class="btn btn-danger" type="submit"><a href="registration.jsp" class="footer">Se Connecte
							</a></button>
									
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type='text/javascript'
		src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
	<script type='text/javascript' src=''></script>
	<script type='text/javascript' src=''></script>
	<script type='text/Javascript'></script>
</body>
</html>