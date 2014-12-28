package com.immunology.logic.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.immunology.logic.dao.CrudDao;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private CrudDao dao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
/*		Syndrome syndrome = new Syndrome();
		List<Survey> surveys = new ArrayList<Survey>();
		Survey survey = new Survey();
		
		ClinicalManifestationsForm clinicalManifestationsForm = new ClinicalManifestationsForm();
		ComplaintsForm complaintsForm = new ComplaintsForm();
		LaboratoryDataForm laboratoryDataForm = new LaboratoryDataForm();
		List<Panel> panels = new ArrayList<Panel>();
		Panel panel = new Panel();
		Set<Element> elements = new HashSet<Element>();
		TextBox tb = new TextBox();
		tb.setMultiplier(2.0);
		elements.add(tb);
		panel.setElements(elements);
		panels.add(panel);
		clinicalManifestationsForm.setPanels(panels);
		survey.setLaboratoryDataForm(laboratoryDataForm);
		survey.setComplaintsForm(complaintsForm);
		survey.setClinicalManifestationsForm(clinicalManifestationsForm);
		
		surveys.add(survey);
		syndrome.setSurveys(surveys);
		
		EfficacyData test = new EfficacyData();
		test.setCancel(false);
		test.setDrugTolerance(DrugTolerance.GOOD);
		test.setEfficacyEvaluation(EfficacyEvaluation.HIGH);
		test.setSideEffectDescription("description text");
		test.setSideEffectsSeverityDegree(SideEffectsSeverityDegree.LIGHT);
		List<Formula> formulas = new ArrayList<Formula>();
		Formula formula = new Formula();
		formula.setFormulaExpression("x^2");
		formula.setType(FormulaType.INSUFFICIENCY_LEVEL);
		formulas.add(formula);
		syndrome.setFormulas(formulas);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String result = mapper.writeValueAsString(syndrome);
			LOG.info(result);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return "login";
	}
	
}