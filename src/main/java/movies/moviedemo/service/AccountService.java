package movies.moviedemo.service;

import movies.moviedemo.domain.Accounts;
import movies.moviedemo.domain.Movie;
import movies.moviedemo.exceptions.ResourceNotFoundException;
import movies.moviedemo.repository.AccountRepository;
import movies.moviedemo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    private MovieRepository movieRepository;

    protected void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Optional<Accounts> accounts = accountRepository.findById(accountId);
        if (accounts.isEmpty()){
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
        }
    }

    public void createAccount(Accounts accounts){
        accountRepository.save(accounts);
    }

    public List<Accounts> getAllAccounts(){
        List<Accounts> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts :: add);
        return accounts;
    }

    public Optional<Accounts> getAccountById(Long accountId){
        return accountRepository.findById(accountId);
    }

    public void updateAccount(Accounts account, Long accountId){
        for (Accounts accounts1 : accountRepository.findAll()){
            if (accounts1.getUserId().equals(accountId)){
                accountRepository.save(account);
            }
        }
    }

    public void deleteAccountById(Long accountId){
        accountRepository.deleteById(accountId);
    }

}
