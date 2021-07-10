package atividade1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClasseConexaoMySQL {
	
	//declara��o vari�veis
	private static Connection con;		//por meio dessa class qu se faz a conex�o com o BD
	private static String status;
	//define/especifica o construtor
	public ClasseConexaoMySQL() {
		
	}
	
	public static void abrirConexao() {	//metodo est�tico para abrir a conex�o com o BD
		String serverName="localhost";		
		String database = "meuBanco";
		String url="jdbc:mysql://"+serverName+":3306/"+database;	//"?useTimezone=true&serverTimezone=UTC"	caso de erro no horario
		String userName="andreia";
		String password="poo2";
		
		try {
			con=DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//con recebe o retorno do metodo getConnection, com a class driver manager
		
		if(con != null) {			//TESTE DE CONEX�O
			status="STATUS--------> Conectado com sucesso";
		}
		else {
			status="STATUS-----> Conex�o n�o foi bem sucedida";
		}
	}
	
	public static boolean fecharConexao() {		//metodo para encerramento da conex�o
		try {
			con.close();					//fecha a conex�o		
			System.out.println("Conex�o encerrada");		//output teste
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static void exibeStatus() {		//metodo para exibir o status da conex�o
		System.out.println(status); 	//retorna o valor da conexao
	}
	
	public static void main(String[] args) {
		
		ClasseConexaoMySQL.abrirConexao();
		ClasseConexaoMySQL.exibeStatus();
		ClasseConexaoMySQL.fecharConexao();
		
	}
}
