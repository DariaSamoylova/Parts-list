package com.study.controller;


import com.study.model.Part;
import com.study.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PartController {
    @Autowired
    private PartService partService;
    private int page = 1;
    private String filterValue = "All";
    private List<Part> searchPart;

    @RequestMapping({"/partslist"})
    public ModelAndView listPart(ModelAndView model) throws Exception {
        if (searchPart==null){
            List<Part> allParts = this.partService.getAllParts(filterValue, page);

            model.addObject("allParts", allParts);
            model.addObject("amount", this.partService.getCompsCount());
            model.addObject("currentPage", page);
             model.addObject("detail", new Part().getDetail());
            model.addObject("count", partService.getCount());    }
        else {
            model.addObject("allParts", searchPart);
        }
        model.setViewName("home");
        return model;
    }

    @RequestMapping(
            value = {"/partslist/paging"},
            method = {RequestMethod.GET}
    )
    public ModelAndView paging(HttpServletRequest request) {
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        page = pageNum;
        return new ModelAndView("redirect:/partslist");
    }
    @RequestMapping(
            value = {"/partslist/deletePart"},
            method = {RequestMethod.GET}
    )
    public ModelAndView deletePart(HttpServletRequest request) {
        int partId = Integer.parseInt(request.getParameter("id"));
        this.partService.deletePart(partId);
        return new ModelAndView("redirect:/partslist");
    }

    @RequestMapping(
            value = {"/partslist/editPart"},
            method = {RequestMethod.GET}
    )
    public ModelAndView editPart(HttpServletRequest request) {
        int partId = Integer.parseInt(request.getParameter("id"));
        Part part = this.partService.getPart(partId);
        ModelAndView model = new ModelAndView("PartForm");
        model.addObject("Part", part);
        return model;
    }

    @RequestMapping(
            value = {"/partslist/savePart"},
            method = {RequestMethod.POST}
    )
    public ModelAndView savePart(@ModelAttribute Part part) {
        if (part.getId() == 0) {
            this.partService.addPart(part);
        } else {
            this.partService.updatePart(part);
        }

        return new ModelAndView("redirect:/partslist");
    }
    @RequestMapping(
            value = {"/partslist/newPart"},
            method = {RequestMethod.GET}
    )
    public ModelAndView newPart(ModelAndView model) {
        Part part = new Part();
        model.addObject("Part", part);
        model.setViewName("PartForm");
        return model;
    }

    @RequestMapping(
            value = {"/partslist/cancel"},
            method = {RequestMethod.POST}
    )
    public ModelAndView cancelPart() {
        return new ModelAndView("redirect:/partslist");
    }



    @RequestMapping(
            value = {"/partslist/filter"},
            method = {RequestMethod.GET}
    )
    public ModelAndView filter(HttpServletRequest request) {
        String filter = request.getParameter("filter");
        filterValue = filter;
        page = 1;
        searchPart=null;
        return new ModelAndView("redirect:/partslist");
    }



    @RequestMapping(
            value="/searchId",
            method=RequestMethod.GET)
    public ModelAndView searchId(HttpServletRequest request){
         System.out.println("part.getDetail="+request.getParameter("detail"));
        searchPart = this.partService.getPart(request.getParameter("detail")) ;
          return new ModelAndView("redirect:/partslist");
    }
}