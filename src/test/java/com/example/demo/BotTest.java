package com.example.demo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kabum.adapter.http.KabumResources;
import com.kabum.adapter.http.KabumServiceAdapter;
import com.kabum.adapter.web.KabumDto;
import com.kabum.application.Schedule;

@SpringBootTest(classes = Schedule.class)
public class BotTest {
	
//	@Autowired
//	private ObjectMapper mapper;
	
	@Autowired
	private KabumServiceAdapter adapter;
	
	@Autowired
	private Schedule schedule;

	@Test
	public void tessst() throws IOException, InterruptedException {

		String url = "https://www.kabum.com.br/cgi-local/site/listagem/listagem.cgi?string=RTX+3070&btnG=&pagina=1&ordem=3&limite=100&prime=false&marcas=[]&tipo_produto=[]&filtro=[]";

		Document document = Jsoup.connect(url).get();

		String json = document.html();
		json = json.substring(json.indexOf("listagemDados = ") + "listagemDados = ".length(), json.indexOf("const listagemErro")).trim();
		
		JsonNode readTree = new ObjectMapper().readTree(json);
		
		Iterator<JsonNode> iterator = readTree.iterator();
		while (iterator.hasNext()) {
			JsonNode next = iterator.next();
			if (next.findValue("disponibilidade").asBoolean()) {
				System.out.println("################");
				System.out.println("Nome da placa: " + next.get("nome").asText());
				System.out.println("Disponibilidade: " + next.findValue("disponibilidade").asBoolean());
				System.out.println("Preço a vista: " + next.findValue("preco_desconto").asText());
				System.out.println("Link: " + "https://www.kabum.com.br" + next.findValue("link_descricao").asText());
				System.out.println("################");
				System.out.println("\n");
			}
		}
		
	}
	
	@Test
	public void huahauhau() {
		
		List<KabumResources> listaDeProdutos = adapter.listaDeProdutos(new KabumDto("RTX 3090", BigDecimal.valueOf(18000), ""));
		
		listaDeProdutos.forEach(p -> System.out.println(p));
		
	}
	
	@Test
	public void kkkkkkkkkkk() {
		
		schedule.executar();
	}


}
