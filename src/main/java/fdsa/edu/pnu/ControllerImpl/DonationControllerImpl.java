package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IDonationController;
import fdsa.edu.pnu.Model.Donation;
import fdsa.edu.pnu.ServiceImpl.DonationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class DonationControllerImpl implements IDonationController {
    @Autowired
    private DonationServiceImpl donationService;

    @Override
    public List<Donation> findAll() {
        return donationService.findAll();
    }

    @Override
    public Optional<Donation> findById(Integer id) {
        return donationService.findById(id);
    }

    @Override
    public Donation save(Donation dto) {
        return donationService.save(dto);
    }

    @Override
    public void delete(Integer id) {
        donationService.delete(id);
    }
}
