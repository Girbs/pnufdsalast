package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.ProfesseurDTO;

import java.util.List;

public interface IProfesseurService {

    public List<ProfesseurDTO> findAll();
    public ProfesseurDTO findById(Integer id);
    public ProfesseurDTO save(ProfesseurDTO dto);
    public ProfesseurDTO update(Integer id, ProfesseurDTO dto);
    public void delete(Integer id);
}
