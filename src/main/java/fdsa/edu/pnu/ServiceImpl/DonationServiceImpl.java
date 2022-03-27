package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Donation;
import fdsa.edu.pnu.Repository.DonationDAO;
import fdsa.edu.pnu.Service.IDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationServiceImpl implements IDonationService {

    @Autowired
    private DonationDAO donationDAO;

    @Override
    public List<Donation> findAll() {
        return donationDAO.findAll();
    }

    @Override
    public Optional<Donation> findById(Integer id) {
        return donationDAO.findById(id);
    }

    @Override
    public Donation save(Donation donation) {
        return donationDAO.save(donation);
    }

    @Override
    public void delete(Integer id) {
        donationDAO.deleteById(id);
    }
}
