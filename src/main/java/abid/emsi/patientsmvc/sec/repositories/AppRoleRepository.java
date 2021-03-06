package abid.emsi.patientsmvc.sec.repositories;

import abid.emsi.patientsmvc.sec.entities.AppRole;
import abid.emsi.patientsmvc.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);

}
