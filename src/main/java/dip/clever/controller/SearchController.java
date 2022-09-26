package dip.clever.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dip.clever.model.SearchCondition;
import dip.clever.service.TestService;
import dip.clever.web.Div;
import dip.clever.web.H2;
import dip.clever.web.Option;
import dip.clever.web.Tag;

@Controller
@RequestMapping("search")
public class SearchController {
	@Autowired
	private TestService testService;
	
	//검색 결과 반환
	@PostMapping("")
	public ResponseEntity<Map<SearchCondition, List>> searchResult(SearchCondition where, String query){
		Map<SearchCondition, List> resultMap = new HashMap<>();		
		SearchCondition[] searchConditions;

		if (where == SearchCondition.ALL) {
			searchConditions = SearchCondition.values();
			for(int a = 1; a < searchConditions.length; a++) {
				resultMap.put(searchConditions[a], testService.getResultList(searchConditions[a], query));
			}
		}
		else {
			resultMap.put(where, testService.getResultList(where, query));
		}
		System.out.println(resultMap);
		return new ResponseEntity<Map<SearchCondition,List>> (resultMap, HttpStatus.OK);
	}
	
	//검색 조건 목록 설정
	@PostMapping("/conditionList")
	public ResponseEntity<String[]> searchConditions(){
		return new ResponseEntity<String[]>(getSearchConditionOption() ,HttpStatus.OK);
	}
	
	@PostMapping("/condition")
	public ResponseEntity<String> searchCondition(SearchCondition where, int count){
		Div div = new Div();
		H2 h2 = new H2();
		
		h2.append(where.name + " 검색 결과(" + count + ")");
		
		return new ResponseEntity<String> (h2.toString() + Tag.BR, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public String searchUser(String query){
		System.out.println(query);
		return "";
	}
	
	//검색 조건 목록 반환
	private String[] getSearchConditionOption() {
		final int C = SearchCondition.values().length;
		SearchCondition[] searchConditions = SearchCondition.values();
		Option option;
		String[] str = new String[C];
		
		for(int a = 0; a < C; a++) {
			option = new Option();
			option.head.value = searchConditions[a].toString();
			option.body = searchConditions[a].name;
			
			str[a] = option.toString();
		}		
		return str;
	}
}
