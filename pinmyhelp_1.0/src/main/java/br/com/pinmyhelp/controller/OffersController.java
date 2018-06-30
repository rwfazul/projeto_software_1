package br.com.pinmyhelp.controller;

import br.com.pinmyhelp.model.Entity;
import br.com.pinmyhelp.model.HelpOffer;
import br.com.pinmyhelp.model.HelpSolicitation;
import br.com.pinmyhelp.model.Person;
import br.com.pinmyhelp.model.Voluntary;
import br.com.pinmyhelp.model.dao.HelpOfferDAO;
import br.com.pinmyhelp.model.dao.HelpSolicitationDAO;
import br.com.pinmyhelp.model.types.OfferStatus;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author adriano
 */
@Controller
public class OffersController {

    @Autowired
    HelpSolicitationDAO helpSolicitationDAO;

    @Autowired
    HelpOfferDAO helpOfferDAO;

    @RequestMapping("/offers")
    public String index(Model model) {
        model.addAttribute("title", "Ofertas");
        model.addAttribute("page", "offers/index");
        return "app";
    }

    @RequestMapping("/offers/my")
    public String my(Model model) {
        model.addAttribute("title", "Minhas ofertas");
        model.addAttribute("page", "offers/my");
        return "app";
    }

    @RequestMapping("/offers/help/{solicitation_id}")
    public ModelAndView help(HttpSession session, @PathVariable(value = "solicitation_id") int solicitation_id) {
        ModelAndView mav = new ModelAndView("app");
        mav.addObject("title", "Solicitações - Oferecer ajuda");
        mav.addObject("page", "offers/help");
        mav.addObject("solicitation", helpSolicitationDAO.findOne(solicitation_id));
        return mav;
    }

    @RequestMapping(value = "/offers/store/{solicitation_id}", method = POST)
    public ModelAndView store(@Valid HelpOffer helpOffer, BindingResult result, HttpSession session, @PathVariable(value = "solicitation_id") int solicitation_id, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("msg_error", "Opa, ocorreu algum problema...");
            return new ModelAndView("redirect:/offers/help/" + solicitation_id);
        }
        if (session.getAttribute("type").equals(Person.TYPE_VOLUNTARY)) {
            helpOffer.setVoluntary((Voluntary) session.getAttribute("person"));
        } else if (session.getAttribute("type").equals("Entity")) {
            helpOffer.setEntity((Entity) session.getAttribute("entity"));
        }
        helpOffer.setStatus(OfferStatus.S1);
        helpOffer.setHelpSolicitation(new HelpSolicitation(solicitation_id));
        helpOfferDAO.create(helpOffer);
        redirectAttrs.addFlashAttribute("msg_success", "Oferta realizada com sucesso!");
        return new ModelAndView("redirect:/offers/my");
    }

    @RequestMapping(value = "/offers/edit/{idOffer}", method = GET)
    public String edit(Model model) {
        return "";
    }

    @RequestMapping(value = "/offers/update", method = POST)
    public String update(Model model) {
        return "";
    }

    @RequestMapping(value = "/offers/delete/{idOffer}", method = GET)
    public String delete(Model model) {
        return "";
    }
}
