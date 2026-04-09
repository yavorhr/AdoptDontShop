package softuni.adoptdontshop.Web;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import softuni.adoptdontshop.Model.Model.BindingModel.CommentBindingModel;
import softuni.adoptdontshop.Model.Model.ServiceModel.CommentServiceModel;
import softuni.adoptdontshop.Model.Model.ViewModel.CommentViewModel;
import softuni.adoptdontshop.Model.Validator.APIError;
import softuni.adoptdontshop.Service.CommentService;

import jakarta.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
public class CommentsRestController {

    private final CommentService commentService;
    private final ModelMapper modelMapper;

    public CommentsRestController(CommentService commentService, ModelMapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/{dogId}/comments")
    public ResponseEntity<List<CommentViewModel>> getComments(
            @PathVariable Long dogId,
            Principal principal) {

        return ResponseEntity.ok(commentService.getComments(dogId));
    }

    @PostMapping("/api/{dogId}/comments")
    public ResponseEntity<CommentViewModel> newComment(
            @AuthenticationPrincipal UserDetails principal,
            @PathVariable Long dogId,
            @RequestBody @Valid CommentBindingModel commentBindingModel) {

        CommentServiceModel commentServiceModel = modelMapper.map(commentBindingModel, CommentServiceModel.class);
        commentServiceModel.setCreator(principal.getUsername());
        commentServiceModel.setDogId(dogId);

        CommentViewModel newComment = commentService.createComment(commentServiceModel);
        //creating the URI of the new comment;
        URI locationOfNewComment = URI.create(String.format("/api/%s/comments/%s", dogId, newComment.getId()));

        return ResponseEntity
                .created(locationOfNewComment)
                .body(newComment);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIError> onValidationFailure(MethodArgumentNotValidException ex) {
        APIError apiError = new APIError(HttpStatus.BAD_REQUEST);
        ex.getFieldErrors().forEach(fe -> {
            apiError.addFieldWithError(fe.getField());
        });
        return ResponseEntity.badRequest().body(apiError);
    }


}
