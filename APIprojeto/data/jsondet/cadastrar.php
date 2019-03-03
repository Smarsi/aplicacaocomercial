<?php
//Vamos definir os cabeçalhos para podermos receber 
//as informações no formato de json de diversas origens.
//(Para que vários tipos de protocolos ou aplicações se comuniquem).

header("Access-Coontrol-Allow-Origin:*");
header("Content-Type: application/json; charset=UTF-8;");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");

// Abaixo o "Authorization" serve para bloquear algumas páginas da aplicação, isso depende de login
// e nível de acesso. Caso você queira limitar o acesso a algumas funcionalidades 
// usuario : Authorization: digite aqui o que será autorizado.
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

// Vamos importar a conexao com o banco de dados (nosso arquivo database).
include_once "../../conexao/database.php";

// Vamos importar a classe produtos
include_once "../../objects/detalhes.php";

//Instância da classe database
$database = new Database();
$db = $database->getConnection();

//Instância da classe de produtos
$detalhes = new Detalhes($db);
$valor["dados"]=array();
//Vamos pegar os dados postados
//Para pegarmos os dados que o usuário envia
//usamos o file_get_contents no PHP.
$data = json_decode(file_get_contents("php://input"));

// Abaixo iremos efetuar uma verificação para saber se 
// o usuário do sistema preencheu todos os dados necessários.
// Caso ele tenha preenchido todos os campos vamos cadastrar,
// caso contrário iremos exibir uma mensagem de erro.

if(
    !empty($data->idpedido)&&
    !empty($data->idproduto)&&
    !empty($data->quantidade)    
){
    //Se os dados estão preenchidos entao iremos passar para API
    //efeturar o cadastro no banco.
    
    http_response_code(200);
    echo json_encode(array($valor));
}
http_response_code(200);

array_push($valor["dados"],$data);
for($i = 0; $i < sizeof($data); $i++){
     echo json_encode($valor['dados'][0][$i]);
   
}
//echo json_encode($valor['dados'][0]);
//echo json_encode($valor['dados'][0][0]);
//echo json_encode(array("mensagem"=>sizeof($data)));
return $valor;
?>