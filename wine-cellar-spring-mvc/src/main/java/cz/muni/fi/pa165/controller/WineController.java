package cz.muni.fi.pa165.controller;

import cz.muni.fi.pa165.dto.WineDto;
import cz.muni.fi.pa165.facade.WineFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MarekScholtz
 * @version 2016.12.10
 */
@Controller
@RequestMapping("/wines")
public class WineController {

    @Inject
    private WineFacade wineFacade;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {

        List<WineDto> wines = new ArrayList<>();

        WineDto wineDto = new WineDto();
        wineDto.setId(1L);
        wineDto.setDescription("rgrhrh");
        wineDto.setAcidity(new BigDecimal(1));
        wineDto.setAlcoholVolume(new BigDecimal(2));
        wineDto.setGrapeSugarContent(new BigDecimal(3));
        wineDto.setBatch("hovno");
        wineDto.setPredicate("hovno");
        wineDto.setName("hovefef");
        wineDto.setVintage(12);
        wineDto.setResidualSugar(new BigDecimal(45));
        wineDto.setNotes("joejfie");
        wineDto.setPredicateEquivalent("efefef");

        wines.add(wineDto);

        model.addAttribute("wines", wines);


        return "wines/index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, UriComponentsBuilder uriBuilder, RedirectAttributes redirectAttributes) {
        WineDto wineDto = wineFacade.findWineById(id);
        wineFacade.deleteWine(wineDto);
        redirectAttributes.addFlashAttribute("alert_success", "Wine \"" + wineDto.getName() + "\" was deleted.");
        return "redirect:" + uriBuilder.path("/wine/list").toUriString();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("wineCreate") WineDto formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        //log.debug("create(productCreate={})", formBean);
        //in case of validation error forward back to the the form
        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                //      log.trace("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
                //    log.trace("FieldError: {}", fe);
            }
            return "product/new";
        }
        //create product
        Long id = wineFacade.createWine(formBean);
        //report success
        redirectAttributes.addFlashAttribute("alert_success", "Wine " + id + " was created");
        return "redirect:" + uriBuilder.path("/wines/index").buildAndExpand(id).encode().toUriString();
    }

}