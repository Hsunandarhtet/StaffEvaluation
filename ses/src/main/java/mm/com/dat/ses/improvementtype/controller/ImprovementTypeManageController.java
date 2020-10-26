/***************************************************************
 * Author       :	Min Arkar Mon					
 * Created Date :	02/10/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/
package mm.com.dat.ses.improvementtype.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mm.com.dat.ses.improvementtype.entity.ImprovementTypeEntity;
import mm.com.dat.ses.improvementtype.reqbean.ImprovementTypeManageReqBean;
import mm.com.dat.ses.improvementtype.reqdto.ImprovementTypeManageReqDto;
import mm.com.dat.ses.improvementtype.resbean.ImprovementTypeManageResBean;
import mm.com.dat.ses.improvementtype.services.IImprovementTypeServiceManager;

@Controller
@RequestMapping("/ses")
public class ImprovementTypeManageController {

	@Autowired
	private IImprovementTypeServiceManager imptTypeService;

	private final int rowPerPage = 5;

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(SLF4JLogger.class);

	// ImprovementType Lists
	@RequestMapping("/impromentType_lists")
	public ModelAndView showimpromentTypeLists(@RequestParam(value = "page", defaultValue = "1") int pageNumber) {

		logger.info("Starting the getStudentList() For all searching...");

		ModelAndView model = new ModelAndView();

		List<ImprovementTypeManageResBean> imptTypeResBeanlist = new ArrayList<ImprovementTypeManageResBean>();
		List<ImprovementTypeEntity> imptTypeList = new ArrayList<ImprovementTypeEntity>();

		imptTypeService.findAll().forEach(imptTypeList::add);

		long count = imptTypeService.count();
		boolean hasPrev = pageNumber > 1;
		boolean hasNext = (pageNumber * rowPerPage) < count;

		for (ImprovementTypeEntity imptType : imptTypeList) {

			ImprovementTypeManageResBean improvementTypeManageResBean = new ImprovementTypeManageResBean();

			improvementTypeManageResBean.setImprovement_type_id(imptType.getImprovement_type_id());
			improvementTypeManageResBean.setImprovementType(imptType.getImprovementType());
			improvementTypeManageResBean.setCreatedBy(imptType.getCreatedBy());
			improvementTypeManageResBean.setUpdatedBy(imptType.getUpdatedBy());

			imptTypeResBeanlist.add(improvementTypeManageResBean);

		}

		model.addObject("imptTypeList", imptTypeResBeanlist);
		model.addObject("hasPrev", hasPrev);
		model.addObject("prev", pageNumber - 1);
		model.addObject("hasNext", hasNext);
		model.addObject("next", pageNumber + 1);

		model.setViewName("admin/improvementtype_lists");

		return model;
	}

	// ImprovementType Register/Update
	@RequestMapping({ "/impromentType_register", "/impromentType_update/{id}" })
	public ModelAndView showImpromentTypeRegister(@PathVariable("id") Optional<Long> improvement_type_id) {

		ModelAndView model = new ModelAndView();

		String titleName = "";

		// For Update Process
		if (improvement_type_id.isPresent()) {

			titleName = "Update Improvement Type Information";
			ImprovementTypeEntity imptType = imptTypeService.getImpTypeById(improvement_type_id.get());
			model.addObject("titleName", titleName);
			model.addObject("imptType", imptType);

		}
		// For Registration Process
		else {

			titleName = "Improvement Type Registration";
			ImprovementTypeManageReqBean improvementTypeManageReqBean = new ImprovementTypeManageReqBean();
			model.addObject("titleName", titleName);
			model.addObject("imptType", improvementTypeManageReqBean);

		}

		model.setViewName("admin/improvementtype_register");

		return model;
	}

	// Improvement Type Registration Form
	@RequestMapping(path = "/improvementType_create", method = RequestMethod.POST)
	public ModelAndView addNewImptType(
			@ModelAttribute("imptType") ImprovementTypeManageReqBean improvementTypeManageReqBean) {

		Long createdBy = (long) 25 - 00001;
		Short delFlag = 0;

		Timestamp createdTime = new Timestamp(System.currentTimeMillis());

		ImprovementTypeManageReqDto improvementTypeManageReqDto = new ImprovementTypeManageReqDto();
		improvementTypeManageReqDto.setImprovement_type_id(improvementTypeManageReqBean.getImprovement_type_id());
		improvementTypeManageReqDto.setImprovementType(improvementTypeManageReqBean.getImprovementType());
		improvementTypeManageReqDto.setDelFlag(delFlag);
		improvementTypeManageReqDto.setCreatedBy(createdBy);
		improvementTypeManageReqDto.setCreatedTime(createdTime);

		imptTypeService.saveImpType(improvementTypeManageReqDto);

		return new ModelAndView("redirect:/ses/impromentType_lists");
	}
	
	// Improvement Type Delete
	@RequestMapping("/improvementType_del/{id}")
	public ModelAndView delImptType(@PathVariable("id") Long improvement_type_id) {

		/* Boolean result = imptTypeService.deleteImpType(improvement_type_id); */
		imptTypeService.deleteImpType(improvement_type_id);
		return new ModelAndView("redirect:/ses/impromentType_lists");
	}

	/*
	 * // ImprovementType Update
	 * 
	 * @RequestMapping("/impromentType_update") public ModelAndView
	 * impromentTypeUpdate() {
	 * 
	 * ModelAndView model = new ModelAndView();
	 * model.setViewName("redirect:/impromentType_register");
	 * 
	 * return model; }
	 */

}
