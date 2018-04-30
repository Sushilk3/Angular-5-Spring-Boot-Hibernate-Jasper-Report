package com.firstapp.service.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.firstapp.service.domain.CurrVitae;
import com.firstapp.service.domain.CurrVitaeRequest;
import com.firstapp.service.entity.Cv;
import com.firstapp.service.repository.CvRepository;
import com.firstapp.service.service.CvService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


@RestController
@RequestMapping("/cv")
@ResponseBody
public class CvController {
	
	private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
	private static final String WELCOME_VIEW = "newuser.page";
		
	@Autowired
	CvService cvService;
	
	@Autowired
	CvRepository cvRepository;
	
	@Autowired
	DataSource db;
	
	@Autowired
	ApplicationContext applicationContext;

	@RequestMapping("/spring")
	public String Hello() {
		return "Selamat Datang di Spring";
	}
	
	
//	GET LIST ALL
	@RequestMapping(path="/list", method= RequestMethod.GET)
	public List<Cv> listAllCv() {
		List<Cv> list = new ArrayList<Cv>();
		System.out.println(list);
		return cvService.listAll();
	}
	
	@RequestMapping(path="/lists", method= RequestMethod.GET)
	public List<Cv> listAlls() {
		List<Cv> allList = new ArrayList<Cv>();
		
		return cvService.listAlls();
	}
	
//------------------------------------------------------------------------------------------------------------------------------------	
//	GET PARAM
	@RequestMapping(path="/getCvId", method= RequestMethod.GET)
	public List findByName(@RequestParam(value = "cvId") Integer cvId) {
		System.out.println("GET cvId = " + cvId);
		return cvService.findByCvId(cvId);
	}
	
	@RequestMapping(path="getAge", method= RequestMethod.GET)
	public List<Cv> findByAge(@RequestParam(value= "age") Integer age) {
		System.out.println("GET age = " + age);
		return cvService.findByAge(age);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------	
//	POST
	@RequestMapping(path="/send", method= RequestMethod.POST)
	public Cv sendCv(@RequestBody Cv cv) {
		System.out.println("POST = " + cv.getName() +", "+ cv.getAge() +", "+ cv.getAddress() +", "+ cv.getUrbanVillage() +", "+ cv.getSubDistrict() +", "+ cv.getDistrict() +", "+ cv.getProvince() +", "+ cv.getPostCode());
		return cvService.sendCV(cv);
	}
	
	@RequestMapping(value="/listgroup", method= RequestMethod.POST)
	public List<Cv> findAlls(@RequestBody Cv cv){
//		System.out.println("age: " + cv.getAge());
//		System.out.println("token: " + token);
		return cvService.findAlls();
	}
	
	@RequestMapping(value="/listget", method= RequestMethod.POST)
		public List<Cv> findByAges(@RequestBody Cv cv,
								   @RequestHeader(value="token") String token){
			System.out.println("age: " + cv.getAge());
			System.out.println("token: " + token);
			return cvService.findByAges(cv.getAge());
	}
		
		
//---------------------------------------------------------------------------------------------------------------------------------------		
//	SHOW REPORT
	@RequestMapping(value="/report", method= RequestMethod.GET)
	public ModelAndView showReport() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Report_CurriculumVitea");
		mav.addObject("format", "pdf");
		mav.addObject("age", 22);
		mav.addObject("datasource", db );
		return mav;
	}
	
	@RequestMapping(value="/reportAgeParam", method= RequestMethod.GET)
	public ModelAndView showReportParamAge() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Report_CurriculumVitea");
		mav.addObject("format", "pdf");
		mav.addObject("datasource", db );
		return mav;
	}
	
	@RequestMapping(value="/reportAgeParams", method= RequestMethod.GET)
	public @ResponseBody void reportPDF(HttpServletResponse response) {
		
		try {
			
			InputStream inputStream = this.getClass().getResourceAsStream("/JasperReport/Report_Param.jrxml");
			JasperDesign design = JRXmlLoader.load(inputStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(design);
			
			List<Cv> cvs = cvService.listAll();
			
			JRDataSource dataSource = new JRBeanCollectionDataSource(cvs);
			
			Map<String, Object> param = new HashMap<>();
			param.put("datasource", dataSource);
			param.put("age", 22);
						
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline: filename=CurriculumVitea.pdf");
			
			final OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
		} catch (JRException e) {
			
			log.info("Tidak Bisa Membaca File JRXML");
		} catch (Exception e) {
			
			log.info("Tidak Bisa Mengambil Ouput Stream dari response");
		}
	}

	@RequestMapping(value="/reportParam", method= RequestMethod.GET)
	public ModelAndView showReportParam(ModelAndView m) {
		
		m.addObject("datasource", db);
//		parameter report
//		m.addObject("age", new Integer(22));
		m.addObject("format", "pdf");
		m.setViewName("Report_Curriculum_Vitea_Param");
		return m;
	}
	
	
				
}
