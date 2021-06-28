package com.kabum.adapter.http;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kabum.adapter.web.KabumDto;
import com.kabum.application.KabumServicePort;

@Component
public class KabumServiceAdapter implements KabumServicePort {

	@Override
	public List<KabumResources> listaDeProdutos(KabumDto dto) {
		
		String url = "https://www.kabum.com.br/cgi-local/site/listagem/listagem.cgi?string=" + dto.getChave() + "&btnG=&pagina=1&ordem=3&limite=100&prime=false&marcas=[]&tipo_produto=[]&filtro=[]";
		
		Document document = null;
		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e1) {
			throw new RuntimeException(e1.getMessage());
		}

		String json = document.html();
		json = json.substring(json.indexOf("listagemDados = ") + "listagemDados = ".length(), json.indexOf("const listagemErro")).trim();
		
		JsonNode readTree = null;
		try {
			readTree = new ObjectMapper().readTree(json);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e.getMessage());
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		List<KabumResources> produtos = new ArrayList<>();
		Iterator<JsonNode> iterator = readTree.iterator();
		while (iterator.hasNext()) {
			JsonNode next = iterator.next();
			if (next.findValue("disponibilidade").asBoolean()) {
				produtos.add(new KabumResources(
						next.get("nome").asText(), 
						next.findValue("disponibilidade").asBoolean(), 
						new BigDecimal(next.findValue("preco_desconto").asText()), 
						new String("https://www.kabum.com.br").concat(next.findValue("link_descricao").asText())));
			}
		}
		
		return produtos;
	}

}
