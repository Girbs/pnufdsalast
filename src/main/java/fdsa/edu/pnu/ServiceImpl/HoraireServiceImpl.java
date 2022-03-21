/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Horaire;
import fdsa.edu.pnu.Repository.HoraireDAO;
import fdsa.edu.pnu.Service.IHoraireService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class HoraireServiceImpl implements IHoraireService {

    @Autowired

    private HoraireDAO horaireDAO;

    @Override
    public List<Horaire> findAll() {
        return horaireDAO.findAll();
    }

    @Override
    public Optional<Horaire> findById(Integer id) {
        return horaireDAO.findById(id);
    }

    @Override
    public Horaire save(Horaire horaire) {
        return horaireDAO.save(horaire);
    }

    @Override
    public void delete(Integer id) {
        horaireDAO.deleteById(id);
    }
}
