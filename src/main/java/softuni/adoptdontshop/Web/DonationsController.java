package softuni.adoptdontshop.Web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.adoptdontshop.Model.Model.BindingModel.DonationBindingModel;
import softuni.adoptdontshop.Model.Model.ServiceModel.DonationServiceModel;
import softuni.adoptdontshop.Service.DonationService;

import jakarta.validation.Valid;

@Controller
public class DonationsController {

    private final DonationService donationService;

    public DonationsController(DonationService donationService) {
        this.donationService = donationService;
    }


    @ModelAttribute
    public DonationBindingModel donationBindingModel() {
        return new DonationBindingModel();
    }

    @GetMapping("/donations")
    public String getDonationsPage() {
        return "donation-form";
    }

    @PostMapping("/donations")
    public String donationForm(@Valid DonationBindingModel donationBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("donationBindingModel", donationBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.donationBindingModel", bindingResult);

            return "redirect:donations";
        }

        donationService.addContribution(donationBindingModel);

        return "redirect:/";
    }
}


