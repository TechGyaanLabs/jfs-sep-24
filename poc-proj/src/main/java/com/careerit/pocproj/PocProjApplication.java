package com.careerit.pocproj;

import com.careerit.pocproj.util.ExcelUtil;
import com.careerit.pocproj.util.PdfService;
import com.careerit.pocproj.util.Player;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class PocProjApplication {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(PocProjApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(){
		return (args)->{

				List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from player_details where team = 'MI'");
				Map<String,Object> map = Map.of("player",list);

				String xslPath  = this.getClass().getResource("/template.xsl").getFile().toString();
				System.out.println(xslPath);

				PdfService pdfService = PdfService.builder()
					.data(map)
					.xsltFilePath(xslPath)
					.rootElement("players")
					.fileName("mi_players.pdf")
					.build();

				File file = pdfService.generateInvoicePdf();

				System.out.println("PDF file generated at : "+file.getAbsolutePath());

				List<Player> players = new ObjectMapper()
						.convertValue(list, new TypeReference<List<Player>>() {
						});

			ExcelUtil obj = new ExcelUtil();
			List<List<Object>> data = new ArrayList<>();
			for(Player player:players){
				data.add(List.of(player.getId(),player.getName(),player.getRole(),player.getTeam(),player.getPrice()));
			}
			data = List.of(List.of("1001","Manoj"),List.of("1002","Charan"),List.of("1003","Krish"));
			File excelFile = obj.writeDataToExcel(List.of("Id","Name"),data,"users.xlsx","user");
			System.out.println("Excel file generated at : "+excelFile.getAbsolutePath());

		};
	}

}
