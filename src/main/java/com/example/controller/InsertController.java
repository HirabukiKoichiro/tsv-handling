package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Original;
import com.example.repository.InsertRepository;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Controller
@RequestMapping("/test")
public class InsertController {

	@Autowired
	private InsertRepository insertRepository;

	@GetMapping("")
	public void insert() throws IOException {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(Original.class).withHeader().withColumnSeparator('\t');
		Path path = Paths.get("/Users/satofuyuko/springworkspace/train.tsv");
		try (BufferedReader br = Files.newBufferedReader(path)) {
			MappingIterator<Original> it = mapper.readerFor(Original.class).with(schema).readValues(br);

			List<Original> originalList = it.readAll();
			for (Original original : originalList) {
				insertRepository.insert(original);
			}
		}
	}
	
	
	@GetMapping("/category")
	public void category() {
		List<Original> originalList = insertRepository.category();
		List<String> distinctOriginalListA = new ArrayList<>();
		List<String> distinctOriginalListB = new ArrayList<>();
		for(Original original: originalList) {
			distinctOriginalListA.add(original.getCategoryName());
		}
		System.out.println("重複削除前のリスト" + distinctOriginalListA.size());
		distinctOriginalListB = distinctOriginalListA.stream().distinct().collect(Collectors.toList());
		System.out.println("重複削除したリスト" + distinctOriginalListB.size());
		
		
		
//		System.out.println("開始");
//		for(int i = 0; i < 5; i++) {
//			System.out.println(i);
//			String categoryName = originalList.get(i).getCategoryName();
//			String[] categoryArray = categoryName.split("/", 0);
//			for(String ct : categoryArray) {
//				System.out.println(ct);
//			}
//		}
		
//		
//		for(Original original: originalList) {
//			String categoryName = original.getName();
//			String[] categoryArray = categoryName.split("/", 3);
//			for(String cate : categoryArray) {
//				System.out.println(cate);
//			}
//		}
		
		
		
	}

//	@GetMapping("/copy")
//	public void copy() {
//		insertRepository.;
//	}

}
