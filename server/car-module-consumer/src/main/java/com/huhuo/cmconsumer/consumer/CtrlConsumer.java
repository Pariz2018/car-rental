package com.huhuo.cmconsumer.consumer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huhuo.carservicecore.csm.consumer.ModelConsumer;
import com.huhuo.integration.base.BaseCtrl;
import com.huhuo.integration.db.mysql.Condition;
import com.huhuo.integration.db.mysql.Dir;
import com.huhuo.integration.db.mysql.Order;
import com.huhuo.integration.db.mysql.Page;
import com.huhuo.integration.web.Message;
import com.huhuo.integration.web.Message.Status;


@Controller("cmconsumerCtrlConsumer")
@RequestMapping(value="/cmconsumer/consumer")
public class CtrlConsumer extends BaseCtrl {
	
	protected String basePath = "/car-module-consumer";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Resource(name = "cmconsumerServConsumer")
	private IServConsumer iservConsumer;
	
	/*************************************************************
	 * consumer management
	 *************************************************************/
	
	@RequestMapping(value="/index.do")
	public String consumerIndex(Model model) {
		logger.debug("access consumer management page");
//		Condition<ModelConsumer> condition = new Condition<ModelConsumer>();
//		condition.setOrderList(new Order("createTime", Dir.DESC), new Order("updateTime", Dir.DESC));
//		condition.setPage(new Page<ModelConsumer>(0L, 10L));
//		List<ModelConsumer> list = iservConsumer.findByCondition(condition, true);
//		model.addAttribute("list", list);
		return basePath + "/consumer/index";
	}
	
	@RequestMapping(value="/condition/get.do")
	public String get(Model model, Condition<ModelConsumer> condition, ModelConsumer t){
		t.setStatus(1);
		condition.setT(t);
		logger.debug("---> server receive: condition={}", condition);
		Page<ModelConsumer> page = condition.getPage();
		if(page == null) {
			page = new Page<ModelConsumer>();
		}
		condition.setOrderList(new Order("createTime", Dir.DESC), new Order("updateTime", Dir.DESC));
		List<ModelConsumer> records = iservConsumer.findByCondition(condition,true);
		model.addAttribute("records", records);
		page.setTotal(iservConsumer.countByCondition(condition));
//		page.setTotal(iservConsumer.countByCondition(condition));
		model.addAttribute("page", page);
		model.addAttribute("t", t);
		
		return basePath + "/consumer/page-grid";
	}
	
	@RequestMapping(value="/add.do")
	public void add(HttpServletResponse resp, ModelConsumer consumer,String xbirthday) {
		logger.debug("---> server receive: carType={}, chargeStandard={}", consumer);
		// add car type
		Date date = null;
		if (xbirthday != null && !"".equals(xbirthday)) {
			try {
				date = sdf.parse(xbirthday);
			} catch (ParseException e) {
				logger.error(e.getStackTrace().toString());
			}
		}
		consumer.setBirthday(date);
		iservConsumer.add(consumer);
		Message<ModelConsumer> msg = new Message<ModelConsumer>(Status.SUCCESS, "add new consumer success!", consumer);
		write(msg, resp);
	}
	
	@RequestMapping(value="/add-ui.do")
	public String addUI(Model model) {
		logger.debug("==> access add ui");
		return basePath + "/consumer/add-ui";
	}
	
	@RequestMapping(value="/detail.do")
	public String detail(Model model, ModelConsumer t) {
		logger.debug("==> edit ModelConsumer with id --> {}", t.getId());
		Condition<ModelConsumer> condition = new Condition<ModelConsumer>(t, null, null, null);
		ModelConsumer consumer =  iservConsumer.findByCondition(condition, true).get(0);
		model.addAttribute("consumer", consumer);
		Date date = consumer.getBirthday();
		logger.debug("birthday date:" + date);
		String birthday = null;
		if (date != null) {
			birthday = sdf.format(date);
		}
		logger.debug("SimpleDateFormat:" + sdf);
		model.addAttribute("xbirthday", birthday);
		return basePath + "/consumer/detail";
	}
	
	@RequestMapping(value="/edit-ui.do")
	public String editUI(Model model, ModelConsumer t) {
		logger.debug("==> edit ModelConsumer with id --> {}", t.getId());
		Condition<ModelConsumer> condition = new Condition<ModelConsumer>(t, null, null, null);
		ModelConsumer consumer =  iservConsumer.findByCondition(condition, true).get(0);
		Date date = consumer.getBirthday();
		logger.debug("birthday date:" + date);
		String birthday = null;
		if (date != null) {
			birthday = sdf.format(date);
		}
		model.addAttribute("xbirthday", birthday);
		model.addAttribute("consumer", iservConsumer.findByCondition(condition, true).get(0));
		return basePath + "/consumer/edit-ui";
	}
	
	@RequestMapping(value="/update.do")
	public void update(HttpServletResponse resp, ModelConsumer t,String xbirthday) throws Exception {
		// retrieve model form DB
		Date date = null;
		if (xbirthday != null && !"".equals(xbirthday)) {
			try {
				date = sdf.parse(xbirthday);
			} catch (ParseException e) {
				logger.error(e.getStackTrace().toString());
			}
		}
		t.setBirthday(date);
		iservConsumer.update(t);
		Message<ModelConsumer> msg = new Message<ModelConsumer>(Status.SUCCESS, "????????????", t);
		write(msg, resp);
	}
	
	@RequestMapping(value="/delete.do")
	public void delete(HttpServletResponse resp, ModelConsumer t, @RequestParam(value="ids[]") List<Long> ids) {
		// receive data
		logger.debug("==> batch delete -->{}", ids);
		// retrieve model form DB
		iservConsumer.deleteBatch(ids);
		write(new Message<ModelConsumer>(Status.SUCCESS, "????????????", t), resp);
	}
	/**
	 * register customer
	 * @param condition
	 * @param out
	 */
	@RequestMapping(value="/register.do")
	public void registerCustomer(String username) {
		logger.debug("--->");
		logger.debug("username:" + username);
		logger.debug("<---");
		
	}
	
	/*************************************************************
	 * loyalty point management
	 *************************************************************/
	
	@RequestMapping(value="/points.do")
	public String pointsIndex() {
		logger.debug("access consumer points management page");
		return basePath + "/points/index";
	}
	@RequestMapping(value="/sms_index.do")
	public String smsIndex() {
		return basePath + "/points/sms_index";
	}
	@RequestMapping(value="/mobile_index.do")
	public String mobileIndex() {
		return basePath + "/points/mobile_index";
	}
	@RequestMapping(value="/stat_index.do")
	public String statIndex() {
		return basePath + "/points/stat_index";
	}
	@RequestMapping(value="/cusomer_stat_index.do")
	public String cusomerStatIndex() {
		return basePath + "/points/cusomer_stat_index";
	}
	
}
