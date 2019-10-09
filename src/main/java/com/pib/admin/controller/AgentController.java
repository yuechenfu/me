package com.pib.admin.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.pib.admin.entity.Agent;
import com.pib.admin.model.Const;
import com.pib.admin.service.AgentService;
import com.pib.admin.util.FileUtils;
import com.pib.admin.util.PageUtils;


@Controller(value = "AgentController")
@RequestMapping({"/agent"})
public class AgentController {
	
	@Autowired
	private AgentService service;

	
   @GetMapping("/list")
   public ModelAndView list(HttpServletRequest request,@RequestParam(value = "currentPage",required = false,defaultValue = "1") int currentPage,
		   					@RequestParam(value = "rows",required = false,defaultValue = Const.ROWS) int rows) throws Exception{
	   ModelAndView mode = new ModelAndView();
	   List<Agent> list = service.find((currentPage-1) * rows ,rows);
	   putImageToLocal(list,request);
	   mode.addObject("Pagination", PageUtils.createPagination(currentPage,rows, service.count()));
	   mode.addObject("agentList", list);
	   mode.setViewName("pages/agent_list");
       return mode;
   }
   
   public void putImageToLocal(List<Agent> list,HttpServletRequest request) throws Exception {
	   for (Agent e : list) {
		   String destFileName = request.getServletContext().getRealPath("") + e.getPhotoUrl();
		   OutputStream out = new FileOutputStream(new File(destFileName));
		   out.write(e.getPhoto());
	       out.flush();
	       out.close();
	   } 
   }
   
   @GetMapping("/detail")
   public ModelAndView detail(Agent e) {
	   ModelAndView mode = new ModelAndView();
	   Agent agent = service.findById(e);
	   mode.addObject("Agent", agent);
	   System.out.println("agent="+e);
	   mode.setViewName("pages/agent_detail");
       return mode;
   }
   
   @GetMapping("/management")
   public ModelAndView management() {
       return new ModelAndView("pages/agent_management");
   }
   
   @GetMapping("/add")
   public ModelAndView add() {
       return new ModelAndView("pages/agent_new_1");
   }
   
   
   
 
   @PostMapping("/insert")
   public ModelAndView insert(HttpServletRequest request,Agent agent,@RequestParam("imgsrc") MultipartFile imgsrc) throws Exception{
	   ModelAndView mode = new ModelAndView();
	   agent.setPhoto(FileUtils.fileStream(imgsrc));
	   agent.setPhotoUrl("img/"+Long.toString(System.currentTimeMillis())+"."+FileUtils.getTypeByStream(agent.getPhoto()));
	   Agent tAgent =  service.findByEmail(agent);
	   if (tAgent.isNull()) service.save(agent);
	   else {
		   agent.setId(tAgent.getId());
		   service.update(agent);
	   }
	   //System.out.println("agent="+agent);
	   mode.addObject("Agent", tAgent);
	   mode.setViewName("pages/agent_new_2");
	   return mode;
        
   }
   
  
   @PostMapping("/save")
   public ModelAndView save(Agent agent) throws Exception{
	   service.update(agent);
	   return new ModelAndView("redirect:/agent/list");
        
   }
   
   @GetMapping("/edit")
   public ModelAndView edit(@RequestParam(value = "currentPage",required = false,defaultValue = "1") int currentPage,
				@RequestParam(value = "rows",required = false,defaultValue = Const.ROWS) int rows) {
	   ModelAndView mode = new ModelAndView();
	   List<Agent> list = service.find((currentPage-1) * rows ,rows);
	   mode.addObject("Pagination", PageUtils.createPagination(currentPage,rows, service.count()));
	   mode.addObject("agentList", list);
	   mode.setViewName("pages/agent_edit");
       return mode;
   }

   @GetMapping("/update")
   public ModelAndView update(Agent e) throws Exception{
	   ModelAndView mode = new ModelAndView();
	   Agent agent = service.findById(e);
	   mode.addObject("Agent", agent);
	   mode.setViewName("/pages/agent_new_1");
	   return mode;
        
   }
   
   @GetMapping("/delete")
   public ModelAndView delete(@RequestParam(value = "currentPage",required = false,defaultValue = "1") int currentPage,
				@RequestParam(value = "rows",required = false,defaultValue = Const.ROWS) int rows) {
	   ModelAndView mode = new ModelAndView();
	   List<Agent> list = service.find((currentPage-1) * rows ,rows);
	   mode.addObject("Pagination", PageUtils.createPagination(currentPage,rows, service.count()));
	   mode.addObject("agentList", list);
	   mode.setViewName("pages/agent_delete");
       return mode;
   }
   @GetMapping("/delete/{id}")
   public ModelAndView deleteById(Agent e) {
	   ModelAndView mode = new ModelAndView();
	   service.delete(e);
	   return new ModelAndView("redirect:/agent/list");
   }
   
}
