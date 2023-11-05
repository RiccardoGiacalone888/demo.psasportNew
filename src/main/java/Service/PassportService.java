package Service;

import Models.Passport;
import Repository.PassportRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Entity
public class PassportService {
    @Autowired
    private PassportRepository passportRepository;
    public List<Passport> getAllPassport() {
        return passportRepository.findAll();
    }

    public Passport getPassport(Long id) {
        Optional<Passport> passport = this.passportRepository.findById(id);
        if (passport.isPresent()) {
            return passport.get();
        } else {
            return null;
        }
    }
    public void addPassport(Passport passport){
        passportRepository.save(passport);
    }
    public void updatePassport(Long id, Passport updatedPassport){
        Optional<Passport> existingPassport = passportRepository.findById(id);
        if (existingPassport.isPresent()) {
            Passport passport = existingPassport.get();
            passport.setPassportNumber(updatedPassport.getPassportNumber());
            passportRepository.save(passport);
        }
    }
    public void deletePassport(Long id){
        passportRepository.deleteById(id);
    }
}
