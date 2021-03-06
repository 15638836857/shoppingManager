package com.palmble.sp.manger.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.palmble.sp.manger.enums.LogEnum;
import com.palmble.sp.manger.model.AdminUser;
import com.palmble.sp.manger.model.Result;
import com.palmble.sp.manger.model.UserPermission;
import com.palmble.sp.manger.service.AdminGroupsService;
import com.palmble.sp.manger.service.AdminUserService;
import com.palmble.sp.manger.service.UserPermissionService;
import com.palmble.sp.manger.web.annotation.CustomLog;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminUserService adminUserService;
	@Autowired
	private UserPermissionService userPermissionService;
	@Autowired
	private AdminGroupsService groupService;
	@RequestMapping("/getAdminList")
	public PageInfo<AdminUser> getAdminList(@RequestParam Map<String, Object> map) {
		PageHelper.startPage(Integer.parseInt(map.get("page").toString()), Integer.parseInt(map.get("rows").toString()));
		//{_search=false, nd=1533289255776, rows=10, page=1, sidx=id, sord=asc}
		//{_search=false, nd=1533289625072, rows=10, page=1, sidx=id, sord=asc}
		List<AdminUser> list = adminUserService.selectBySelective(map);
		PageInfo<AdminUser> page=new PageInfo<AdminUser>(list);
		return page;
	}

	@RequestMapping("/updateAdminStatus")
	public Integer updateAdminList(Integer id, Integer status) {
		if (id == null || status == null) {
			return null;
		}
		AdminUser adminUser = new AdminUser();
		adminUser.setId(id);
		if (status == 0) {
			adminUser.setEnableFlag(1);
		}
		if (status == 1) {
			adminUser.setEnableFlag(0);
		}
		int resultNum = adminUserService.updateByPrimaryKeySelective(adminUser);
		return resultNum;
	}

	@RequestMapping("/delAdmin")
	public Result delAdmin(Integer id) {
		Result result=new Result();
		AdminUser user=adminUserService.selectByPrimaryKey(id);
		if(user.getGroupId()==1) {
			result.setCode(0);
			result.setMsg("超级管理员无法删除");
			return result;
		}
		int resultNum = adminUserService.deleteByPrimaryKey(id);
		if(resultNum==1) {
			result.setCode(1);
			result.setMsg("操作成功");
		}else {
			result.setCode(0);
			result.setMsg("操作失败");
		}
		return result;
	}

	@Transactional
	@RequestMapping("/add")
	public Result add(AdminUser user, String url) {
		Result result = new Result();
		int statusNum = 0;
		if (user == null) {
			result.setCode(0);
			result.setMsg("操作失败!");
			return result;
		}
		String pwd=user.getPwd();
		String username=user.getLoginiNo();
		if(username==null||username.trim().equals("")) {
			result.setCode(0);
			result.setMsg("账号不能为空!");
			return result;
		}
		if(pwd==null||pwd.trim().equals("")) {
			result.setCode(0);
			result.setMsg("密码不能为空!");
			return result;
		}
		String md5Pwd=DigestUtils.md5Hex("palmble"+pwd);
		AdminUser adminTemplate=adminUserService.selectOne("loginiNo", user.getLoginiNo());
		Integer groupId=user.getGroupId();
		if(groupId!=null) {
			String groupName=groupService.getById(groupId).getGroupName();
			user.setGroupName(groupName);
		}
		if(adminTemplate==null) {
			user.setPwd(md5Pwd);
			statusNum = adminUserService.insertSelective(user);
		}else {
			result.setCode(0);
			result.setMsg("账号已存在!");
			return result;
		}
		result.setCode(statusNum);
		if (statusNum == 1) {
			result.setMsg("操作成功");
			result.setUrl(url);
		} else {
			result.setMsg("操作失败");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	
	@Transactional
	@RequestMapping("/edit")
	public Result edit(AdminUser user, String url) {
		Result result = new Result();
		int statusNum = 0;
		if (user == null) {
			result.setCode(0);
			result.setMsg("操作失败!");
			return result;
		}
		String pwd=user.getPwd();
		String username=user.getLoginiNo();
		if(username==null||username.trim().equals("")) {
			result.setCode(0);
			result.setMsg("账号不能为空!");
			return result;
		}
		AdminUser adminTemplate=adminUserService.selectOne("loginiNo", user.getLoginiNo());
			if(adminTemplate!=null&&adminTemplate.getId()!=user.getId()) {
				result.setCode(0);
				result.setMsg("账号已存在!");
				return result;
			}else {
				String md5Pwd=null;
				if(pwd!=null&&!pwd.trim().equals("")) {
					 md5Pwd=DigestUtils.md5Hex("palmble"+pwd);
				}
				user.setPwd(md5Pwd);
			}
			Integer groupId=user.getGroupId();
			if(groupId!=null) {
				String groupName=groupService.getById(groupId).getGroupName();
				user.setGroupName(groupName);
			}
			statusNum = adminUserService.updateByPrimaryKeySelective(user);
		result.setCode(statusNum);
		if (statusNum == 1) {
			result.setMsg("操作成功");
			result.setUrl(url);
		} else {
			result.setMsg("操作失败");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}


	@RequestMapping("/updatePassword")
	@CustomLog(logEnum=LogEnum.PUBLIC,module="管理员管理",desc="修改密码")
	public Result updatePassword(HttpServletRequest request,String old_pass,String password,String password_confirm) {
		Result result=new Result();
		int statusNum=0;
		if(old_pass==null||old_pass.trim().equals("")
		||password_confirm==null||password_confirm.trim().equals("")) {
			result.setCode(0);
			result.setMsg("请将页面信息补充完整");
			return result;
		}
		if(!password.equals(password_confirm)) {
			result.setCode(0);
			result.setMsg("确认密码不一致,请重新输入!");
			return result;
		}
		String username=(String)request.getSession().getAttribute("loginNo");
		AdminUser admin=adminUserService.selectOne("loginiNo", username);
		String md5Pwd=DigestUtils.md5Hex("palmble"+old_pass);
		if(!admin.getPwd().equals(md5Pwd)) {
			result.setCode(0);
			result.setMsg("密码有误,应重新输入!");
			return result;
		}
		admin.setPwd(DigestUtils.md5Hex("palmble"+password));
		statusNum=adminUserService.updateByPrimaryKeySelective(admin);
		if(statusNum!=1) {
			result.setCode(0);
			result.setMsg("操作失败");
			return result;
		}
		result.setCode(statusNum);
		result.setMsg("操作成功");
		result.setUrl("../login.html");
		return result;
	}
//	@RequestMapping("/getPrivilegeList")
//	public List<Integer> getPrivilegeList(String userId) {
//		 List<Integer> list= userPermissionService.selectPrivilegeUrlByGroupOrUserId(Integer.parseInt(userId));
//		return list;
//	}
	@RequestMapping("/addOreditRule")
	@CustomLog(logEnum=LogEnum.PUBLIC,module="权限管理",desc="权限分配")
	public Result addOreditRule(Integer userId,@RequestParam("urids[]")List<Integer> urids) {
		Result result=new Result();
		if(userId==null) {
			result.setCode(0);
			result.setMsg("获取用户信息失败");
			return result;
		}
		List<UserPermission> list=userPermissionService.selectByGroupOrUserId(userId);
		List<Integer> urlList=new ArrayList<Integer>();
		for(UserPermission userPermission:list) {
			Integer privilegeId=userPermission.getPrivilegeId();
			if(!urids.contains(privilegeId)) {
				userPermissionService.deleteByPrimaryKey(userPermission.getId());
			}else {
				urlList.add(userPermission.getPrivilegeId());
			}
		}
		urids.removeAll(urlList);
		for(Integer url:urids) {
				UserPermission userPermission=new UserPermission();
				userPermission.setGroupOrUserId(userId);
				userPermission.setPrivilegeId(url);
				userPermissionService.insertSelective(userPermission);
		}
		result.setCode(1);
		result.setMsg("操作成功");
		return result;
	}
	
	/**
	 * <p>Title: 给制定用户添加权限</p>   
	 * @author WangYanke  
	 * @date 2018年7月10日
	 */
	@RequestMapping("/addRule")
	@ResponseBody
	public void addRule(Integer userId,String urids) {
		System.out.println("权限分配操作成功");

	}
}
