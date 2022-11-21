<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>Adicionar Investimento</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' type='text/css' media='screen' href='./Resources/CSS/add.css'>
	<style>
	:root{
    --accent: white;
    --bg: #e6ecec;
}

@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500&display=swap');

*{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}

body{
     font-family: 'Glegoo', serif;
    background-color: var(--bg);
}

.card-holder{
  display: flex;
  align-items: flex-start;
  gap: 1rem;
  flex-wrap: wrap;
}

.card{
  width: 22rem;
  background-color: var(--accent);
  color: black;
  margin: 2rem auto;
  border-radius: 50px;
  border: none;
 box-shadow: 5px 10px 15px #c4c5c7;
     
}

.card__name{
  font-family: 'Glory';
font-style: normal;
font-weight: 400;
font-size: 25px;
line-height: 28px;
text-align: center;
}

.card__img{
  width: 100%;
  height: 12rem;
  object-fit: cover;
}

.card-contents{
  padding: 1rem;
}

h1{
  margin-bottom: 1rem;
  letter-spacing: 1px;
}

p{
  font-size: 1.em;
  margin-bottom: 1rem;
  color: #000000;
}



#add{
    border-radius: 50px;
    padding: 0.5rem 1rem;
    text-transform: uppercase;
    border-radius: 32px;
    border: 0;
    cursor: pointer;
    font-size: 80%;
    font-weight: 500;
    color: #fff;
    margin-bottom: 16px 0;
    /*background-image: url(download.png);*/
    

}
.c4{
    padding-left: 50px;
}

#historico{
    border-radius: 20px;
    padding: 0.5rem 1rem;
    text-transform: uppercase;
    border-radius: 32px;
    border: 0;
    cursor: pointer;
    font-size: 80%;
    font-weight: 500;
    color: #fff;
    margin-bottom: 16px 0;
    background: linear-gradient(to right, #4D84B6, #4EEAE0);

    width: 164px;

    margin-top: 25px;
   

}

#data{
  padding-left: 60px;
  text-align: center;
  
}

#centraliza2
{
   
    padding-left: 85px;
}

.vlr{
  font-family: 'Glegoo';
font-style: normal;
font-weight: 700;
font-size: 13px;
line-height: 23px;
color: rgba(0, 0, 0, 0.61);

text-shadow: 2px 4px 4px rgba(0, 0, 0, 0.15);
}

#legenda{
  font-family: 'Glory';
font-style: normal;
font-weight: 400;
font-size: 18px;
line-height: 20px;
}


input{
  box-shadow: 5px 10px 15px #c4c5c7;
  
}

.form-control{
  border: 0;
}

hr{
  width: 100%;
height: 1px;
background-color: black;
margin-right: auto;
margin-left: auto;
margin-top: 10px;
margin-bottom: 5px;
border-width: 2px;
border-color: black;
}

#nome{
  margin-bottom: 15px;
}
	</style>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
  <link rel="stylesheet" href="style.css">
</head>

<body>

  <div class="card-holder">

    <div class="card" style="border-radius: 50px; border: 0;">  

      <div class="card-contents">
        <h1 class="card__name">Investimentos</h1>
        <p>

          <span class="card__read-more">
            <div class="row">
            
              <div class="col-6 ">
                      <label>Nome Investimento</label>
                      <input id ="nome" type="text" class="form-control" id="exampleInputPassword1" placeholder="Nome Investimento" style="border-radius: 50px">
              </div>
       
              <div class="col-6 md-6">
                     <label id="cpf">Tipo Investimento:</label>
                      <input id ="nome" type="text" class="form-control" id="exampleInputPassword1" placeholder="Tipo" style="border-radius: 50px;">
              </div>
      

         <div id="centraliza">
              <div class="col-12" id="data">  
               <div>                         
                      <label id="endereço">Data Vencimento:</label>
                      <input id ="nome" type="date" class="form-control" id="exampleInputPassword1" placeholder="Data" style="width:240px; border-radius: 50px;">                        
              </div>
          </div>
        </div>


          <div class="col-6 md-6">
                     <label id="cpf">Tipo Investimento:</label>
                      <input id ="nome" type="text" class="form-control" id="exampleInputPassword1" placeholder="Tipo" style="border-radius: 50px;">
              </div>
  

   <div class="col-6 md-6">
                     <label id="cpf">IOF:</label>
                      <input id ="nome" type="text" class="form-control" id="exampleInputPassword1" placeholder="Tipo" style="border-radius: 50px;">
              </div>


             

               <div class="col-6 md-6">
                     <label id="cpf">IR:</label>
                      <input id ="nome" type="text" class="form-control" id="exampleInputPassword1" placeholder="Tipo" style="border-radius: 50px;">
              </div>


               <div class="col-6 md-6">
                     <label id="cpf">Imposto de Renda:</label>
                      <input id ="nome" type="text" class="form-control" id="exampleInputPassword1" placeholder="Tipo" style="border-radius: 50px;">
              </div>

        
              
        
     </div>  
                    
     <hr>
     
     <h1 class="card__name">Aplicação</h1>
     <div class="row">
     <div class="col-6 md-6">
      <label id="cpf">Valor:</label>
       <input id ="nome" type="text" class="form-control" id="exampleInputPassword1" placeholder="Tipo" style="border-radius: 50px;">
      </div>

      <div class="col-6 ">  
        <div>                         
               <label id="endereço">Data:</label>
               <input id ="nome" type="date" class="form-control" id="exampleInputPassword1" placeholder="Data" style=" border-radius: 50px;">                        
       </div>
   </div>
    </div>

      

     
                                        <div id="centraliza2">
                                          
                                        <div class="row">
                                      <a href=""><button id="historico">Adicionar</button></a>
                                       </div> 
                                    </div>
          </span>
        </p>


      </div>


    </div>

    

    

  </div>

  <script src="script.js"></script>

</body>

</html>