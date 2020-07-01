package movies.moviedemo.controller;

import movies.moviedemo.domain.Accounts;
import movies.moviedemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

//    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
//    public ResponseEntity<Iterable<Accounts>> getAllAccounts(){
//
//    }
}
