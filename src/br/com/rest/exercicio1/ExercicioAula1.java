package br.com.rest.exercicio1;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

//"API Rest para retornar as seguintes informações: "Eu ... , trabalho e estudo, tenho ..., e adoro programar em ..."
//http://localhost:8080/RestExemplo1/rest/ExercicioA/show=

@Path("/ExercicioAula1")
public class ExercicioAula1 {
	
	// http://localhost:8080/RestExercicio1/rest/ExercicioAula1/frase/Eu/2/COBOL
	//Path é o caminho da URL que ele vai receber e quais são parâmetros, ex: {nome}/{idade/etc}.
	@GET
	@Path("frase/{nome}/{idade}/{linguagemProg}")
	public String juntarFrase(@PathParam("nome") String nome, @PathParam("idade") int idade, @PathParam ("linguagemProg") String linguagemProg, @Context HttpServletRequest request) {
		String ip = request.getLocalAddr();
		String params = "nome: " + nome + ", idade: " + String.valueOf(idade) + ", linguagem: " + linguagemProg;
		//this.log(params, ip);
		
		String out = "Eu sou " + nome + ", trabalho e estudo, tenho " + String.valueOf(idade) + " anos e adoro programar em " + linguagemProg;
		return out;
		
	}
	
	// http://localhost:8080/RestExercicio1/rest/ExercicioAula1/IMC/70/160
	
	@GET
	@Path("IMC/{peso}/{altura}")
	public String juntarFrase(@PathParam("peso") double peso, @PathParam("altura") double altura, @Context HttpServletRequest request){
		//String ip = request.getLocalAddr();
		//String params = "Peso: " + String.valueOf(peso) + ", altura: " + String.valueOf(altura) + ", IMC: " + String.valueOf(calcIMC + ", Frase IMC: " + fraseIMC);
		//this.log(params, ip);
		
		double imc = this.calculoIMC(altura / 100, peso);
		String fraseIMC = this.resultIMC(imc);
		String out = "Eu tenho " + altura + "centímetros de altura e " + peso + "kg, segundo meu IMC: " + imc + " eu estou " + fraseIMC;
		return out;
	}
	
	/* Fórmula para calcular o IMC: IMC = Peso / Altura² = Exemplo: 73(Peso) / (166)² (Altura ao quadrado) */
	/* Tabela IMC: Muito abaixo do peso = 16 a 16,9 / Abaixo do peso = 17 a 18,4 / Peso normal 18,5 a 24,9 / Acima do peso = 25 a 29,9 */
	/* Obesidade grau I = 30 a 34,9 / Obesidade grau II = 35 a 40 / Obesidade grau III = Maior que 40 */
	
	public double calculoIMC (double altura, double peso) {
		double calcIMC = 0;
		calcIMC = (peso / (altura * altura));
		return (calcIMC);
	}
	
	public String resultIMC (double calcIMC)
	{
		String fraseIMC = "";
		if (calcIMC <= 16.9)
		{
			fraseIMC = "Muito abaixo do peso";
		}
		if (calcIMC >= 17 && calcIMC <= 18.4)
		{
			fraseIMC = "Abaixo do peso";
		}
		if (calcIMC >= 18.5 && calcIMC <= 24.9)
		{
			fraseIMC = "Normal em relaï¿½ï¿½o ao peso";
		}
		if (calcIMC >= 25 && calcIMC <= 29.9)
		{
			fraseIMC = "Acima do peso";
		}
		if (calcIMC >= 30 && calcIMC <= 34.9)
		{
			fraseIMC = "em Obesidade grau I";
		}
		if (calcIMC >= 35 && calcIMC <= 40)
		{
			fraseIMC = "em Obesidade grau II";
		}
		if (calcIMC >= 41)
		{
			fraseIMC = "em Obesidade grau III";
		}
		return (fraseIMC);
	}
	
}
