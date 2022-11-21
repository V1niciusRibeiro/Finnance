<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
		 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>

	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript" src="./Resources/JS/InvestimentoApp.js"></script>	
	
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
  	<link rel="stylesheet" href="./Resources/CSS/reset.css">
	<link rel="stylesheet" href="./Resources/CSS/MessagesStyle.css">
    <link rel="stylesheet" href="./Resources/CSS/investimentos.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="./Resources/CSS/TopBarStyle.css">
	<link rel="stylesheet" href="./Resources/CSS/SidebarStyle.css">
	<link rel="stylesheet" href="./Resources/CSS/FluxoCaixa_Style.css">
	<link rel="stylesheet" href="./Resources/CSS/MovimentacaoTRN_Style.css">
  	<link rel="stylesheet" href="./Resources/CSS/limitacao.css">
	
	<script src="https://kit.fontawesome.com/7e3ab3f2af.js" crossorigin="anonymous"></script>
	
	<title>Finnance - Home</title>

</head>
<body>

	<main>

		<%@ include file="Top&SideBar.jsp" %>
		
		<%@ include file="ExibeMensagem.jsp" %>
	
		<%@ include file="FluxoCaixa.jsp" %>
	
		<%@ include file="index.jsp" %>
	 	
	</main>

<script type="text/javascript" src="./Resources/JS/card.js"></script>
<script type="text/javascript" src="./Resources/JS/MessagesApp.js"></script>
<script type="text/javascript" src="./Resources/JS/FluxoCaixaApp.js"></script>
<script type="text/javascript" src="./Resources/JS/Top&SideBarApp.js"></script>

<script type="text/javascript" src="./Resources/JS/MovimentacaoPopupApp.js"></script>

</body>
</html>