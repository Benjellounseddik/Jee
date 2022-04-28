package abid.emsi.patientsmvc;

import abid.emsi.patientsmvc.entities.Patient;
import abid.emsi.patientsmvc.repositories.PatientRepository;
import abid.emsi.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Hassan",new Date(),false,121));
            patientRepository.save(new Patient(null,"Mohammed",new Date(),true,122));
            patientRepository.save(new Patient(null,"Yassine",new Date(),false,312));
            patientRepository.save(new Patient(null,"Hanae",new Date(),true,172));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getScore());
            });

        };

    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("yassine","1234","1234");
            securityService.saveNewUser("mohammed","1234","1234");
            securityService.saveNewUser("yasmine","1234","1234");
            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");
            securityService.addRoleToUser("yassine","ADMIN");
            securityService.addRoleToUser("yassine","USER");
            securityService.addRoleToUser("mohammed","USER");
            securityService.addRoleToUser("yasmine","USER");



        };
    }

}
