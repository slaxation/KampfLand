package slaxation.KampfLand.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import slaxation.KampfLand.commands.TovarCommand;
import slaxation.KampfLand.domain.Tovar;

import java.util.Set;

public interface TovarRepository extends JpaRepository<Tovar, Integer> {



}
