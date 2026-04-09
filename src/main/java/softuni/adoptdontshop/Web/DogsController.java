package softuni.adoptdontshop.Web;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.adoptdontshop.Model.Model.BindingModel.DogAddBindingModel;
import softuni.adoptdontshop.Model.Model.BindingModel.DogUpdateBindingModel;
import softuni.adoptdontshop.Model.Model.BindingModel.PictureBindingModel;
import softuni.adoptdontshop.Model.Model.ServiceModel.DogAddServiceModel;
import softuni.adoptdontshop.Model.Model.ServiceModel.DogUpdateServiceModel;
import softuni.adoptdontshop.Model.Model.ViewModel.DogDetailsViewModel;
import softuni.adoptdontshop.Service.*;
import softuni.adoptdontshop.Web.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
public class DogsController {

    private final DogService dogService;
    private final BreedService breedService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;
    private final PictureService pictureService;

    public DogsController(DogService dogService, BreedService breedService, UserService userService, ModelMapper modelMapper, CloudinaryService cloudinaryService, PictureService pictureService) {
        this.dogService = dogService;
        this.breedService = breedService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.cloudinaryService = cloudinaryService;
        this.pictureService = pictureService;
    }

    @ModelAttribute
    public DogAddBindingModel dogAddBindingModel() {
        return new DogAddBindingModel();
    }

    // GET

    @GetMapping("/dogs/all")
    public String allDogs(Model model) {
        model.addAttribute("allDogs", dogService.findAllDogs());
        return "all-dogs";
    }

    @GetMapping("/dogs/{id}/details")
    public String dogDetails(@PathVariable Long id, Model model) {
        model.addAttribute("dog", dogService.findDogById(id));
        return "dog-profile";
    }

    // ADD PICTURE
    @Transactional
    @PostMapping("/dogs/{id}")
    public String addDogPicture(@PathVariable Long id, Model model, PictureBindingModel pictureBindingModel) throws IOException {
        cloudinaryService.saveDogPicture(
                pictureBindingModel.getPicture(),
                pictureBindingModel.getTitle(), id);

        model.addAttribute("dog", dogService.findDogById(id));

        return "dog-profile";
    }

    @GetMapping("/dogs/{id}/inquire")
    public String dogEnquireForm(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetails currentUser) {

        model.addAttribute("user", userService.findUserByUsername(currentUser.getUsername()));
        model.addAttribute("dog", dogService.adoptDogById(id, currentUser.getUsername()));
        return "inquire-form";
    }

    //DELETE PICTURE
    @Transactional
    @DeleteMapping("/dogs/{id}/pic")
    public String deletePicture(@RequestParam("public_id") String publicId, @PathVariable Long id) {
        if (cloudinaryService.delete(publicId)){
            pictureService.deletePicture(publicId);
        }
        return "redirect:/dogs/" + id + "/details" ;
    }


    // DELETE
//    @PreAuthorize("@dogServiceImpl.isAdmin(#principal.name, #id)")
    @DeleteMapping("/dogs/{id}")
    public String deleteDog(@PathVariable Long id,
                              Principal principal) {
        dogService.deleteDog(id);
        return "redirect:/dogs/all";
    }

    // EDIT
//    @PreAuthorize("@dogServiceImpl.isAdmin(#principal.name, #id)")
    @GetMapping("/dogs/{id}/edit")
    public String editDog(@PathVariable Long id,
                            Principal principal, Model model) {

        DogDetailsViewModel dogDetailsViewModel = dogService.findById(id, principal.getName());
        DogUpdateBindingModel dogUpdateBindingModel = modelMapper.map(dogDetailsViewModel, DogUpdateBindingModel.class);

        model.addAttribute("dogUpdateBindingModel", dogUpdateBindingModel);
        model.addAttribute(model.addAttribute("allBreedsNames", breedService.findAllBreedsNames()));

        return "update-dog";
    }

    @GetMapping("/dogs/{id}/edit/errors")
    public String editDogProfileErrors(@PathVariable Long id, Model model) {
        model.addAttribute(model.addAttribute("allBreedsNames", breedService.findAllBreedsNames()));
        return "update-dog";
    }

    @PatchMapping("/dogs/{id}/edit")
    public String editDogProfile(
            @PathVariable Long id,
            @Valid DogUpdateBindingModel dogUpdateBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("dogUpdateBindingModel", dogUpdateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.dogUpdateBindingModel", bindingResult);

            return "redirect:/dogs/" + id + "/edit/errors";
        }

        DogUpdateServiceModel dogUpdateServiceModel = modelMapper.map(dogUpdateBindingModel,
                DogUpdateServiceModel.class);

        dogService.updateDogProfile(dogUpdateServiceModel);

        return "redirect:/dogs/" + id + "/details";
    }

    // ADD
    @GetMapping("/dogs/add")
    public String addDogPage(Model model) {
        if (!model.containsAttribute("dogAlreadyAdded") || !model.containsAttribute("allBreedsNames")) {
            model.addAttribute("allBreedsNames", breedService.findAllBreedsNames());
            model.addAttribute("dogAlreadyAdded", false);
        }
        return "add-dog";
    }

    @PostMapping("/dogs/add")
    public String addDog(@Valid DogAddBindingModel dogAddBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("dogAddBindingModel", dogAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.dogAddBindingModel", bindingResult);

            return "redirect:add";
        }

        boolean dogAlreadyAdded = dogService.doesDogAlreadyExistInDatabase(dogAddBindingModel.getName(), dogAddBindingModel.getBreed(), dogAddBindingModel.getAge());

        if (dogAlreadyAdded) {
            redirectAttributes
                    .addFlashAttribute("dogAddBindingModel", dogAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.dogAddBindingModel", bindingResult)
                    .addFlashAttribute("allBreedsNames", breedService.findAllBreedsNames())
                    .addFlashAttribute("dogAlreadyAdded", "true");
            return "redirect:add";
        }

        DogAddServiceModel dogServiceModel = dogService.addNewDog(dogAddBindingModel);
        return "redirect:/dogs/" + dogServiceModel.getId() + "/details";
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ModelAndView handleDbExceptions(ResourceNotFoundException e, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("not-found");
        modelAndView.addObject("resourceId", e.getResourceId());
        modelAndView.addObject("user", principal.getName());
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return modelAndView;
    }

}