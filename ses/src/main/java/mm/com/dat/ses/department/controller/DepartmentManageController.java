/***************************************************************
 * Author       : Aung Ko Lin						
 * Created Date : 10/01/2020
 * Updated Date : -
 * Version      : 1.0
 * Dev History  : Firstly Created
***************************************************************/

package mm.com.dat.ses.department.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.descriptor.sql.SmallIntTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mm.com.dat.ses.department.entity.DepartmentEntity;
import mm.com.dat.ses.department.reqbean.DepartmentManageReqBean;
import mm.com.dat.ses.department.reqdto.DepartmentManageReqDto;
import mm.com.dat.ses.department.resbean.DepartmentManageResbean;
import mm.com.dat.ses.department.services.IDepartmentServiceManager;

@Controller
@RequestMapping("/ses")
public class DepartmentManageController {

	@Autowired
	private IDepartmentServiceManager deptService;

	private final int rowPerPage = 5;

	// Department Lists
	@RequestMapping("/dept_lists")
	public ModelAndView showDeptLists(@RequestParam(value = "page", defaultValue = "1") int pageNumber) {

		ModelAndView model = new ModelAndView();

		List<DepartmentManageResbean> deptreslist = new ArrayList<DepartmentManageResbean>();
		List<DepartmentEntity> deptlist = new ArrayList<DepartmentEntity>();

		deptService.findAll().forEach(deptlist::add);

		long count = deptService.count();
		boolean hasPrev = pageNumber > 1;
		boolean hasNext = (pageNumber * rowPerPage) < count;

		for (DepartmentEntity deptres : deptlist) {

			DepartmentManageResbean deptResBean = new DepartmentManageResbean();

			deptResBean.setDeptId(deptres.getDept_id());
			deptResBean.setDeptName(deptres.getDeptName());
			deptResBean.setCreatedBy(deptres.getCreatedBy());
			deptResBean.setUpdatedBy(deptres.getUpdatedBy());

			deptreslist.add(deptResBean);

		}

		model.addObject("deptList", deptreslist);

		model.addObject("hasPrev", hasPrev);
		model.addObject("prev", pageNumber - 1);
		model.addObject("hasNext", hasNext);
		model.addObject("next", pageNumber + 1);

		model.setViewName("admin/dept_lists");

		return model;
	}

	// Department Registration Form
	@RequestMapping("/deptRegister")
	public ModelAndView showStaffRegister() {

		ModelAndView model = new ModelAndView();
		
		DepartmentManageReqBean dept=new DepartmentManageReqBean();
		
		model.addObject("dept",dept);
		model.setViewName("admin/dept_register");

		return model;
	}
	
	// Department Registration Form
		@RequestMapping(path="/createDept",method = RequestMethod.POST)
		public ModelAndView addNewDept(@ModelAttribute("dept") DepartmentManageReqBean deptbean) {

			Long createdBy=(long) 1;
			Short delFlag=1;
			
			Timestamp createdTime = new Timestamp(System.currentTimeMillis());
			
			DepartmentManageReqDto dept=new DepartmentManageReqDto();
			dept.setDept_id(deptbean.getDept_id());
			dept.setDeptName(deptbean.getDeptName());
			dept.setDelFlag(delFlag);
			dept.setCreatedBy(createdBy);
			dept.setCreatedTime(createdTime);
			
			deptService.saveDept(dept);

			return new ModelAndView("redirect:/ses/dept_lists");
		}

	// Department Update Form
	@RequestMapping("/deptEdit/{id}")
	public ModelAndView showDeptUpdate(@PathVariable("id") long deptId) {

		ModelAndView model = new ModelAndView();
		
		DepartmentEntity dept=deptService.getDeptById(deptId);
		model.addObject("dept",dept);
		model.setViewName("admin/dept_register");

		return model;
	}

}
