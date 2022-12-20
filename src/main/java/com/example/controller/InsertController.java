package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
@RequestMapping("/")
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
	
//	@GetMapping("/copy")
//	public void copy() {
//		insertRepository.;
//	}
	
}
