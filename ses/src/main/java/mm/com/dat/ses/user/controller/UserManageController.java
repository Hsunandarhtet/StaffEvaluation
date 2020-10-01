/***************************************************************
 * Author       : Aung Ko Lin						
 * Created Date : 10/01/2020
 * Updated Date : -
 * Version      : 1.0
 * Dev History  : Firstly Created
***************************************************************/
package mm.com.dat.ses.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mm.com.dat.ses.user.entity.UserEntity;
import mm.com.dat.ses.user.entity.UserEntityTest;
import mm.com.dat.ses.user.reqbean.UserManageReqBean;
import mm.com.dat.ses.user.reqdto.UserManageReqDto;
import mm.com.dat.ses.user.resbean.UserManageResBean;
import mm.com.dat.ses.user.services.IUserServiceManager;

@Controller
public class UserManageController {

	@Autowired
	private IUserServiceManager userService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final int ROW_PER_PAGE = 3;

	// transit to student list
	@RequestMapping("/")
	public ModelAndView getUserList() {

		logger.info("Starting the getStudentList() For all searching...");
		ModelAndView model = new ModelAndView();

		List<UserManageResBean> stuList = new ArrayList<UserManageResBean>();
		List<UserEntityTest> usrEnt = new ArrayList<>();
		userService.findAll().forEach(usrEnt::add);

		for (UserEntityTest res : usrEnt) {
			UserManageResBean usrBean = new UserManageResBean();
			usrBean.setId(res.getId());
			usrBean.setName(res.getName());
			usrBean.setAge(res.getAge());
			usrBean.setAddress(res.getAddress());
			stuList.add(usrBean);

		}

		if (stuList.size() > 0) {
			model.addObject("userList", stuList);
			model.setViewName("admin/userlist");
		}
		return model;
	}

	// transit to student registration form
	@RequestMapping("/userForm")
	public ModelAndView userFormPage() {
		logger.info("Starting the studentFormPage() to student registration form...");
		UserManageReqBean stu = new UserManageReqBean();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("usrForm", stu);
		modelAndView.setViewName("admin/user_form");
		return modelAndView;
	}

	// save new student
	@PostMapping("/addUser")
	public ModelAndView addNewUser(@ModelAttribute("stuForm") UserManageReqBean reqBean) {

		logger.info("Starting the addNewStudent() For new student registration ...");

		UserManageReqDto req = new UserManageReqDto();
		req.setId(reqBean.getId());
		req.setName(reqBean.getName());
		req.setAge(reqBean.getAge());
		req.setAddress(reqBean.getAddress());

		userService.saveUser(req);

		logger.info("Successed the new student registration ...");
		return new ModelAndView("redirect:/index");
	}

	// clear text box

	@RequestMapping("/clearReset")
	public ModelAndView clearReset() {
		logger.info("Clear All text Box ...");
		UserManageReqBean stu = new UserManageReqBean();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stuForm", stu);
		modelAndView.setViewName("user_form");
		return modelAndView;
	}

	// update student

	@RequestMapping("/updateUser/{id}")
	public ModelAndView updateUser(@PathVariable("id") long id) {
		logger.info("Starting updateStudent() ...");
		ModelAndView model = new ModelAndView();

		UserEntityTest stu = userService.getUserById(id);
		model.addObject("usrForm", stu);
		model.setViewName("admin/user_form");

		return model;
	}

	// delete student
	@RequestMapping("/deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable("id") long id) {

		ModelAndView model = new ModelAndView();
		userService.deleteUser(id);
		model.addObject("user");
		model.setViewName("redirect:/index");

		return model;
	}

	// transit to student list with pagination
	@RequestMapping(value = "/index")
	public ModelAndView getUserList(@RequestParam(value = "page", defaultValue = "1") int pageNumber) {
		logger.info("Starting the getStudentList() For all searching with laze style...");
		ModelAndView model = new ModelAndView();
		List<UserEntityTest> entityList = userService.findAllUser(pageNumber, ROW_PER_PAGE);
		List<UserManageResBean> usrList = new ArrayList<UserManageResBean>();

		long count = userService.count();
		boolean hasPrev = pageNumber > 1;
		boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;

		for (UserEntityTest res : entityList) {
			UserManageResBean usrBean = new UserManageResBean();
			usrBean.setId(res.getId());
			usrBean.setName(res.getName());
			usrBean.setAge(res.getAge());
			usrBean.setAddress(res.getAddress());
			usrList.add(usrBean);

		}

		model.addObject("userList", usrList);
		model.addObject("hasPrev", hasPrev);
		model.addObject("prev", pageNumber - 1);
		model.addObject("hasNext", hasNext);
		model.addObject("next", pageNumber + 1);
		model.setViewName("admin/userlist");

		return model;

	}
	
	
	//Staff List 
	@RequestMapping("/ses/user")
	public ModelAndView showUserLists() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/user_lists");

		return model;
	}
	
	//Staff Registration Form 
	@RequestMapping("/ses/staffRegister")
	public ModelAndView showStaffRegister() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("admin/user_register");

		return model;
	}
	
	//Staff Registration Form 
	@RequestMapping("/ses/staffEdit")
	public ModelAndView showTemplate() {

		ModelAndView model = new ModelAndView();			
		model.setViewName("redirect:/ses/staffRegister");

		return model;
	}

}
