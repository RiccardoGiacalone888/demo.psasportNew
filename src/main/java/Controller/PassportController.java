package Controller;


import Models.Passport;
import Service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PassportController {
    @Autowired
    private PassportService passportService;

    @GetMapping("/passport")
    public List<Passport> getAllPassport(){
        return passportService.getAllPassport();
    }

    @GetMapping("/passport/id")
    public Passport getPassportById(@PathVariable long id){
        return passportService.getPassport(id);
    }

    @PostMapping("/passport")
    public void addPassport(@RequestBody Passport passport){
        passportService.addPassport(passport);
    }

    @RequestMapping("/passport/id")
    public void updatePassport(@PathVariable long id, @RequestBody Passport passport){
        passportService.updatePassport(id,passport);
    }

    @DeleteMapping("/passport/id")
    public void deletePassport(@PathVariable long id){
        passportService.deletePassport(id);
    }
}
