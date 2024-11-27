package licence.devoir3.controllers;

import licence.devoir3.entities.Action;
import licence.devoir3.entities.Acheter;
import licence.devoir3.services.ActionService;
import licence.devoir3.services.AcheterService;
import licence.devoir3.services.TraderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
public class MainController {
    private final TraderService traderService;
    private final ActionService actionService;
    private final AcheterService acheterService;

    public MainController(TraderService traderService, ActionService actionService, AcheterService acheterService) {
        this.traderService = traderService;
        this.actionService = actionService;
        this.acheterService = acheterService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("traders", traderService.findAll());
        return "index";
    }

    @GetMapping("/actions/{traderId}")
    public String actions(@PathVariable Integer traderId, Model model) {
        model.addAttribute("trader", traderService.findById(traderId));
        model.addAttribute("achats", acheterService.findByTraderId(traderId));
        model.addAttribute("actions", actionService.findAll().stream()
                .collect(Collectors.toMap(Action::getId, action -> action)));
        return "actions";
    }

    @GetMapping("/vendre/{traderId}/{actionId}")
    public String vendreForm(@PathVariable Integer traderId, @PathVariable Integer actionId, Model model) {
        model.addAttribute("achat", acheterService.findByTraderAndAction(traderId, actionId));
        model.addAttribute("trader", traderService.findById(traderId));
        model.addAttribute("action", actionService.findById(actionId));
        return "vendre";
    }

    @PostMapping("/vendre/{traderId}/{actionId}")
    public String vendre(@PathVariable Integer traderId, @PathVariable Integer actionId,
                         @RequestParam Integer quantite, Model model) {
        if (!acheterService.vendreActions(traderId, actionId, quantite)) {
            model.addAttribute("error", "Quantité invalide");
            return vendreForm(traderId, actionId, model);
        }
        return "redirect:/actions/" + traderId;
    }

    @GetMapping("/acheter/{traderId}")
    public String acheterList(@PathVariable Integer traderId, Model model) {
        model.addAttribute("trader", traderService.findById(traderId));
        model.addAttribute("actions", actionService.findActionsNotOwnedByTrader(traderId));
        return "acheter";
    }

    @GetMapping("/acheter/{traderId}/{actionId}")
    public String acheterForm(@PathVariable Integer traderId, @PathVariable Integer actionId, Model model) {
        model.addAttribute("trader", traderService.findById(traderId));
        model.addAttribute("action", actionService.findById(actionId));
        return "acheterAction";
    }

    @PostMapping("/acheter/{traderId}/{actionId}")
    public String acheter(@PathVariable Integer traderId, @PathVariable Integer actionId,
                          @RequestParam Double montantAchat, @RequestParam Integer quantite) {
        acheterService.acheterAction(traderId, actionId, montantAchat, quantite);
        return "redirect:/acheter/" + traderId;
    }
}