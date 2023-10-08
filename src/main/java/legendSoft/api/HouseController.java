package legendSoft.api;

import legendSoft.model.House;
import legendSoft.service.CommentService;
import legendSoft.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class HouseController {

    private final HouseService houseService;
    private final CommentService commentService;

    @Autowired
    public HouseController(HouseService houseService, CommentService commentService) {
        this.houseService = houseService;
        this.commentService = commentService;
    }
    @GetMapping("/allHouses")
    private String getAllHouse(Model model){
        model.addAttribute("allHouses", houseService.getAllHouse());
        return "/mainPage";
    }
    @GetMapping("/getHouse/{houseId}")
    private String getHouseById(@PathVariable("houseId") Long id, Model model){
        model.addAttribute("house", houseService.getHouseById(id));
        model.addAttribute("comments", commentService.getCommentByHouseId(id));
        return "/innerPage";
    }
    @GetMapping("/new")
    private String  newHouse(Model model){
        model.addAttribute("newHouse", new House());
        return "/newHouse";
    }
    @PostMapping("/save")
    private String saveHouse(@ModelAttribute("newHouse") House house){
        houseService.saveHouse(house);
        return "redirect:/allHouses";
    }

}
